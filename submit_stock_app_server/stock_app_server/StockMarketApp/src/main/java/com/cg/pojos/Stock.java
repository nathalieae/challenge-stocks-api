package com.cg.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /** This class is for the entities that will be stored and queried in the database
     * ALL possible Stock info to collect:
     * quarter: the yearly quarter (1 = Jan-Mar; 2 = Apr=Jun).
     * stock: the stock symbol (see above)
     * date: the last business day of the work (this is typically a Friday)
     * open: the price of the stock at the beginning of the week
     * high: the highest price of the stock during the week
     * low: the lowest price of the stock during the week
     * close: the price of the stock at the end of the week
     * volume: the number of shares of stock that traded hands in the week
     * percent_change_price: the percentage change in price throughout the week
     * percent_chagne_volume_over_last_wek: the percentage change in the number of shares of
     * stock that traded hands for this week compared to the previous week
     * previous_weeks_volume: the number of shares of stock that traded hands in the previous week
     * next_weeks_open: the opening price of the stock in the following week
     * next_weeks_close: the closing price of the stock in the following week
     * percent_change_next_weeks_price: the percentage change in price of the stock in the
     * following week days_to_next_dividend: the number of days until the next dividend
     * percent_return_next_dividend: the percentage of return on the next dividend
     * */
    private String tickerName;
    private int quarter;
    private String date;
    private int open;
    private int high;
    private int low;
    private int close;
    private int percent_change_price;
    private int percent_change_volume_over_last_wk;
    private int days_to_next_dividend;
    private int percent_return_next_dividend;
    private int percent_change_next_weeks_price; //goal is to maximize this value
    //------ Optional attributes to collect ------
    //Constructor
    public Stock(String tickerName, int quarter, String date, int open, int high, int low, int close, int percent_change_next_weeks_price, int percent_change_price, int percent_change_volume_over_last_wk, int days_to_next_dividend, int percent_return_next_dividend){
        this.tickerName = tickerName;
        this.quarter = quarter;
        this.date = date;
        this.open = open;
        this.high =  high;
        this.low = low;
        this.close = close;
        this.percent_change_next_weeks_price = percent_change_next_weeks_price;

        this.percent_change_price = percent_change_price;
        this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
        this.days_to_next_dividend = days_to_next_dividend;
        this.percent_return_next_dividend = percent_return_next_dividend;
    }
    //- add a new record:
    //========== Display Stock info method ==========
    public void display(){
        System.out.printf("Stock Name: %s\t date: $%d\n", this.tickerName, this.date);
        System.out.printf("Open: %s\t Close: $%d\n", this.open, this.close);
        System.out.printf("High: %s\t Low: $%d\n", this.high, this.low);
        System.out.println("% Change Next Weeks Price: " + this.percent_change_next_weeks_price);
    }
    public String getTickerName() {return this.tickerName;}

    public int getClose() {
        return close;
    }

    public int getOpen() {
        return open;
    }

    public int getHigh() {
        return high;
    }

    public int getLow() {
        return low;
    }

    //========== Helper setter methods ==========
    public void update_percent_change_price(int percent_change_price)
    {
        this.percent_change_price = percent_change_price;
    }
    public void percent_change_volume_over_last_wk(int percent_change_volume_over_last_wk)
    {
        this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
    }
    public void days_to_next_dividend(int days_to_next_dividend)
    {
        this.days_to_next_dividend = days_to_next_dividend;
    }
    public void percent_return_next_dividend(int percent_return_next_dividend){
        this.percent_return_next_dividend = percent_return_next_dividend;
    }
    public void update_percent_change_next_weeks_price (int percent_change_next_weeks_price){
        this.percent_change_next_weeks_price = percent_change_next_weeks_price;
    }

}

