package com.cg.services;

import com.cg.doas.StockDAO;
import com.cg.exceptions.StockDetailsNotFoundException;
import com.cg.pojos.Stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServicesImpl implements StockServices{
    /**This class outlines the business logic layer*/
    @Autowired
    private StockDAO stockRepository;
    //========== Method for displaying all stocks ==========
    @Override
    public String displayStocksList(){
        String stocksInfo = "<h1>Here are the details of the first 10 stocks currently in the list</h1>";
        if(stockRepository.count() == 0){
            stocksInfo += "<p>To add a single stock proceed to <b>http://localhost:1111/stockmarket/addStock</b></p> " +
            "<p>To add a multiple stocks proceed to <b>http://localhost:1111/stockmarket/bulkAdd</b></p>\n";
        }else {
            long TOTAL_RECORDS_TO_DISPLAY;
            //set maximum records to display from the stock database
            if(stockRepository.count() < 10){
                TOTAL_RECORDS_TO_DISPLAY = stockRepository.count();
            }else{
                TOTAL_RECORDS_TO_DISPLAY = 10;
            }
            List<Stock> stockList = stockRepository.findAll();
            for (int i = 0; i < TOTAL_RECORDS_TO_DISPLAY; i++) {//display records
                Stock s = stockList.get(i);
                stocksInfo += "<div>" + s.toString() + "</div>\n";
            }
        }
        return stocksInfo;
    }
    //========== Method for adding news stocks to the database ==========
    //------ Add a single stock:
    @Override
    public Stock addStock(Stock stock) {
        stockRepository.save(stock);
        return stock;
    }
    //------ Add a multiple stocks simultaneously:
    public String bulkAdd() {
        String currLine="";
        String result="";
        try{
            //Initializing a BufferedReader to take data from file as input
            BufferedReader reader = Files.newBufferedReader(Paths.get("src/main/resources/data.csv"));
            boolean isFirstLine = true;
            //reading the content of the file line-by-line
            while((currLine = reader.readLine())!= null){
                if(isFirstLine){
                    System.out.println("Skipping headers");
                    isFirstLine = false;
                }else {
                    String[] data = currLine.split(",");
                    Stock newStock = setStockAttributes(data);
                    //add newStock to the database
                    stockRepository.save(newStock);
                }
            }
            result += "Bulk add completed successfully, return to <b>http://localhost:1111/stockmarket/display</b> to view full list of stocks";
        }catch(IOException e){
            System.out.println("Cannot find the file");
            result += "<h1>Bulk add was not successful.</h1>";
        }
        return result;
    }
    //__________ Helper function __________
    public Stock setStockAttributes(String[] data) {
        Stock newStock = new Stock(); //create a stock object to store data for new stock.
        newStock.setQuarter(data[0]);//Integer.parseInt() converts String into int
        newStock.setTickerName(data[1]);
        newStock.setDate(data[2]);
        newStock.setOpen(data[3]);
        newStock.setHigh(data[4]);
        newStock.setLow(data[5]);
        newStock.setClose(data[6]);
        newStock.setVolume(data[7]);
        newStock.setPercent_change_price(data[8]);
        newStock.setPercent_change_volume_over_last_wk(data[9]);
        newStock.setPrevious_weeks_volume(data[10]);
        newStock.setNext_weeks_open(data[11]);
        newStock.setNext_weeks_close(data[12]);
        newStock.setPercent_change_next_weeks_price(data[13]);
        newStock.setDays_to_next_dividend(data[14]);
        newStock.setPercent_return_next_dividend(data[15]);
        return newStock;
    }

    //========== Method to query for data by stock ticker ==========
    @Override
    public Stock getStockDetails(String tickerName) throws StockDetailsNotFoundException {
        Stock query = stockRepository.getDetails(tickerName);
        Optional<Stock> optional = Optional.ofNullable(query);
        Supplier<StockDetailsNotFoundException> exceptionSupplier = () -> new StockDetailsNotFoundException("Stock Details not found for stock ticker name :- "+tickerName);
        return optional.orElseThrow(exceptionSupplier);
    }

    /**========== Optional Enhancements ==========
     *  //Method to remove stock from database
     @Override
     public void removeProductDetails(String tickerName) throws StockDetailsNotFoundException {}
     */

}
