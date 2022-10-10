package com.cg.controllers;

import com.cg.doas.StockDAO;
import com.cg.exceptions.StockDetailsNotFoundException;
import com.cg.pojos.Stock;
import com.cg.services.StockServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/")
public class StockRestController {
    @Autowired
    StockDAO stockRepository; //used to perform CRUD operations on Stock data
    @Autowired
    StockServicesImpl stockServices;

    //========== Main Landing Page ==========
    //------ display all stocks stored in the database:
    @GetMapping("/display")
    public String displayStocks(){
        return stockServices.displayStocksList();
    }
    //------ Add new stocks to the database:
    //endpoint to add a single stock
    @GetMapping("/addStock")
    public ResponseEntity<String> addStock(){
        //------ Stock details to be added:
        String quarter = "1";
        String tickerName = "AA";
        String date = "1/7/2011";
        String open = "$15.82";
        String high = "$16.72";
        String low = "$15.78";
        String close = "$16.42";
        String volume = "239655616";
        String percent_change_price = "3.79267";
        String percent_change_volume_over_last_wk = "tba";
        String previous_weeks_volume = "tba";
        String next_weeks_open = "$16.71";
        String next_weeks_close = "$15.97";
        String percent_change_next_weeks_price = "-4.42849";
        String days_to_next_dividend = "26";
        String percent_return_next_dividend = "0.182704";

        Stock stock = new Stock(quarter,tickerName,date,open,high,low,close,volume,percent_change_price,percent_change_volume_over_last_wk,previous_weeks_volume,next_weeks_open,next_weeks_close,percent_change_next_weeks_price,days_to_next_dividend,percent_return_next_dividend);
        //------ adding the Stock details to the database:
        Stock s = stockServices.addStock(stock);
        String returnStr = "The following stock was successfully added to the database "+s.toString();
        return new ResponseEntity<String>(returnStr,HttpStatus.OK);
    }
    //endpoint to add a multiple stocks simultaneously
    @GetMapping("/bulkAdd")
    public String addBulkStocks(){
        String result = stockServices.bulkAdd();
        System.out.println(result);
        return result;
    }
    //------ find a stock in the database:
    //endpoint to search for stock in the database
    @GetMapping("/searchStock/{tickerName}")
    public ResponseEntity<Stock> searchStock(@PathVariable String tickerName) throws StockDetailsNotFoundException {
        Stock stock =stockServices.getStockDetails(tickerName);
        return new ResponseEntity<Stock>(stock,HttpStatus.OK);
    }
}
