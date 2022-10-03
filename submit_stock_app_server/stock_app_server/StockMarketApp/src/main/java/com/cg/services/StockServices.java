package com.cg.services;

import com.cg.exceptions.StockDetailsNotFoundException;
import com.cg.pojos.Stock;

import java.util.List;

public interface StockServices {
    //upload a bulk data set
    public void acceptBulkStocksDetails(List<Stock>Stocks);
    // query for data by stock ticker
    public Stock getStockDetails(String tickerName)throws StockDetailsNotFoundException;
    // add a new record; each record (row) is data for a week
    public Stock acceptStockDetails(Stock Stock);

    //========== Optional Enhancements ==========
    //Method to remove stock from database
    void removeProductDetails(String tickerName)throws StockDetailsNotFoundException;
    //Method to view all the stocks and their details
    List<Stock>  getAllStockDetails();


}
