package com.cg.services;

import com.cg.doas.StockDOA;
import com.cg.exceptions.StockDetailsNotFoundException;
import com.cg.pojos.Stock;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="stockServices")
public class StockServicesImpl implements StockServices{
    /**This class outlines the business logic layer*/
    @Autowired
    private StockDOA stockDao;

    @Override
    public Stock acceptStockDetails(Stock stock) {
        stock = stockDao.save(stock);
        return stock;
    }

    @Override
    public Stock getStockDetails(String tickerName) throws StockDetailsNotFoundException {
        Optional<Stock> optional = stockDao.findById(tickerName);
        Supplier<StockDetailsNotFoundException> exceptionSupplier = () -> new StockDetailsNotFoundException("Stock Details not found for stock ticker name :- "+tickerName);
        return optional.orElseThrow(exceptionSupplier);
    }

    @Override
    public void acceptBulkStocksDetails(List<Stock>Stocks) {
        stockDao.save(null);
    }
    //========== Optional Enhancements ==========
    @Override
    public List<Stock> getAllStockDetails() {
        return stockDao.findAll();
    }
    @Override
    public void removeProductDetails(String tickerName) throws StockDetailsNotFoundException {
    }
}
