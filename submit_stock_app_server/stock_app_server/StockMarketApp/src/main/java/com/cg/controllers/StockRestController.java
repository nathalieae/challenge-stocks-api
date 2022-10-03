package com.cg.controllers;

import com.cg.pojos.Stock;
import com.cg.services.StockServices;
import com.cg.exceptions.StockDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockRestController {
    @Autowired
    StockServices services;
    //main landing page
    @GetMapping("/")
    public ResponseEntity<String> sayHello(){

        Stock stock = new Stock("AA",1, "2011-01-14", 16,  16, 242963398, 13,-2, -4,239655616, 19, 2);
        return new ResponseEntity<>(
                "<div><h1>Stock Name: " + stock.getTickerName()+"</h1>" +
                        "<ul><li>Open: "+ stock.getOpen()+"</li> <li>close: "+ stock.getClose()+"</li>" +
                        "</ul> More to come... </div>", HttpStatus.OK);
    }

    //endpoint to add new stock to the database
    @PostMapping("/acceptStock")
    public ResponseEntity<String> addStock(@RequestBody Stock stock){
        stock =services.acceptStockDetails(stock);
        return new ResponseEntity<String>("Stock details successfully added Id:- "+ stock.getTickerName(),HttpStatus.OK);
    }

    //endpoint to search for stock in the database
    @GetMapping("/searchStock/{tickerName}")
    public ResponseEntity<Stock> searchStock(@PathVariable String tickerName) throws StockDetailsNotFoundException{
        Stock stock =services.getStockDetails(tickerName);
        return new ResponseEntity<Stock>(stock,HttpStatus.OK);
    }

    //========== Optional Enhancements ==========
    //endpoint to view all stocks details to the database
    @GetMapping("/getAllStock")
    public ResponseEntity<List<Stock>> getAllStock() {
        List<Stock>Stocks = services.getAllStockDetails();
        return new ResponseEntity<List<Stock>>(Stocks,HttpStatus.OK);
    }

}
