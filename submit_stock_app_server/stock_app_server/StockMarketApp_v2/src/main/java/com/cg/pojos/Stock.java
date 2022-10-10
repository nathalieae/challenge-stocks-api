package com.cg.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Stock {
    /**This class is for the entities that will be stored and queried in the database
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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String quarter;
    private String tickerName; //primary id for Stock table
    private String date;
    private String open, high, low, close, volume;
    private String percent_change_price;
    private String percent_change_volume_over_last_wk;
    private String previous_weeks_volume;
    private String next_weeks_open;
    private String next_weeks_close;
    private String percent_change_next_weeks_price; //goal is to maximize this value
    private String days_to_next_dividend;
    private String percent_return_next_dividend;
    //------ Optional attributes to collect ------
    //Default Constructor must be present to avoid org.hibernate.InstantiationException
    public Stock(){}
    public Stock(String quarter, String tickerName, String date, String open, String high, String low, String close, String volume, String percent_change_next_weeks_price){
        this.tickerName = tickerName;
        this.quarter = quarter;
        this.date = date;
        this.open = open;
        this.high =  high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.percent_change_next_weeks_price = percent_change_next_weeks_price;
    }
    /*Secondary Constructor: quarter,stock,date,open,high,low,close,volume,percent_change_price,percent_change_volume_over_last_wk,previous_weeks_volume,next_weeks_open,next_weeks_close,percent_change_next_weeks_price,days_to_next_dividend,percent_return_next_dividend*/
    public Stock(String tickerName, String quarter, String date, String open, String high, String low, String close, String volume, String percent_change_price, String percent_change_volume_over_last_wk, String previous_weeks_volume, String percent_change_next_weeks_price, String days_to_next_dividend, String percent_return_next_dividend){
        this.tickerName = tickerName;
        this.quarter = quarter;
        this.date = date;
        this.open = open;
        this.high =  high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.percent_change_price = percent_change_price;
        this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
        this.previous_weeks_volume = previous_weeks_volume;
        this.percent_change_next_weeks_price = percent_change_next_weeks_price;
        this.days_to_next_dividend = days_to_next_dividend;
        this.percent_return_next_dividend = percent_return_next_dividend;
    }

    public Stock(String quarter, String tickerName, String date, String open, String high, String low, String close, String volume, String percent_change_price, String percent_change_volume_over_last_wk, String previous_weeks_volume, String next_weeks_open, String next_weeks_close, String percent_change_next_weeks_price, String days_to_next_dividend, String percent_return_next_dividend){
        this.tickerName = tickerName;
        this.quarter = quarter;
        this.date = date;
        this.open = open;
        this.high =  high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.percent_change_price = percent_change_price;
        this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
        this.previous_weeks_volume = previous_weeks_volume;
        this.next_weeks_open = next_weeks_open;
        this.next_weeks_close = next_weeks_close;
        this.percent_change_next_weeks_price = percent_change_next_weeks_price;
        this.days_to_next_dividend = days_to_next_dividend;
        this.percent_return_next_dividend = percent_return_next_dividend;
    }

    //========== Display Stock info method ==========
    @Override
    public String toString() {
        //Method to display stock's main details
        String mainStr = String.format(
                "<h1>Stock Name: <em>%s</em></h1><h3>Quarter: <em>%s</em></h3> " +
                        "\n<h3>Open: <em>%s</h3><h3>Close: <em>%s</em></h3> " +
                        "\n<h3>High: <em>%s</em></h3><h3>Low: <em>%s</em></h3> " +
                        "\n<h3>Percent Change Next Weeks Price: <em>%s</em></h3>",
                this.tickerName, this.quarter, this.open, this.close, this.high, this.low, this.percent_change_next_weeks_price);
        String opt = String.format(
                "\n<h3>Volume: <em>%s</em></h3>" +
                "\n<h3>Percent Change Price: <em>%s</em></h3>" +
                "\n<h3>percent change volume over last wk: <em>%s</em></h3>" +
                "\n<h3>previous weeks volume: <em>%s</em></h3>" +
                "\n<h3>next weeks open: <em>%s</em></h3>" +
                "\n<h3>next weeks close: <em>%s</em></h3>" +
                "\n<h3>days to next dividend: <em>%s</em></h3>" +
                "\n<h3>percent return next dividend: <em>%s</em></h3>\n",
                this.volume, this.percent_change_price, this.percent_change_volume_over_last_wk, this.percent_change_volume_over_last_wk, this.previous_weeks_volume, this.next_weeks_open, this.next_weeks_close, this.days_to_next_dividend, this.percent_return_next_dividend);
        return mainStr + opt;
    }
    //========== Getter methods ==========

    public int getId() {return id;}
    public String getQuarter() {return quarter;}
    public String getTickerName() {return this.tickerName;}
    public String getDate() {return date;}
    public String getOpen() {return open;}
    public String getHigh() {return high;}
    public String getLow() {return low;}
    public String getClose() {return close;}
    public String getVolume() {return volume;}
    public String getPercent_change_price() {return percent_change_price;}
    public String getPercent_change_volume_over_last_wk() {return percent_change_volume_over_last_wk;}
    public String getPrevious_weeks_volume() {return previous_weeks_volume;}
    public String getNext_weeks_open() {return next_weeks_open;}
    public String getNext_weeks_close() {return next_weeks_close;}
    public String getPercent_change_next_weeks_price() {return percent_change_next_weeks_price;}
    public String getDays_to_next_dividend() {return days_to_next_dividend;}
    public String getPercent_return_next_dividend() {return percent_return_next_dividend;}

    //========== Setter methods ==========
    public void setId(int id) {this.id = id;}
    public void setQuarter(String quarter) {this.quarter = quarter;}
    public void setTickerName(String tickerName) {this.tickerName = tickerName;}
    public void setDate(String date) {this.date = date;}
    public void setOpen(String open) {this.open = open;}
    public void setHigh(String high) {this.high = high;}
    public void setLow(String low) {this.low = low;}
    public void setClose(String close) {this.close = close;}
    public void setVolume(String volume) {this.volume = volume;}
    public void setPercent_change_price(String percent_change_price) {
        this.percent_change_price = percent_change_price;
    }
    public void setPercent_change_volume_over_last_wk(String percent_change_volume_over_last_wk) {
        this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
    }
    public void setPrevious_weeks_volume(String previous_weeks_volume) {
        this.previous_weeks_volume = previous_weeks_volume;
    }
    public void setNext_weeks_open(String next_weeks_open) {
        this.next_weeks_open = next_weeks_open;
    }
    public void setNext_weeks_close(String next_weeks_close) {
        this.next_weeks_close = next_weeks_close;
    }
    public void setPercent_change_next_weeks_price(String percent_change_next_weeks_price) {
        this.percent_change_next_weeks_price = percent_change_next_weeks_price;
    }
    public void setDays_to_next_dividend(String days_to_next_dividend) {
        this.days_to_next_dividend = days_to_next_dividend;
    }
    public void setPercent_return_next_dividend(String percent_return_next_dividend) {
        this.percent_return_next_dividend = percent_return_next_dividend;
    }


}

