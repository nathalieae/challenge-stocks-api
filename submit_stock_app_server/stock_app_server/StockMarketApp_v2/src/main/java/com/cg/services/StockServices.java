package com.cg.services;

import com.cg.exceptions.StockDetailsNotFoundException;
import com.cg.pojos.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface StockServices {

    //========== Method for adding news stocks to the database ==========
    //each record (row) is data for a week
    //------ upload a single new stock:
    public Stock addStock(Stock stock);
    //------ upload a multiple stock records simultaneously:
    public String bulkAdd();

    //========== Method to query for data by stock ticker ==========
    public Stock getStockDetails(String tickerName)throws StockDetailsNotFoundException;

    //========== Method for displaying all stocks ==========
    public String displayStocksList();

    /**========== Optional Enhancements ==========
     *  //Method to remove stock from database
     @Override
     public void removeProductDetails(String tickerName) throws StockDetailsNotFoundException;
     */


}
