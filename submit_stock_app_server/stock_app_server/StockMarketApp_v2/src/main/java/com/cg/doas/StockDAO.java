package com.cg.doas;

import com.cg.exceptions.StockDetailsNotFoundException;
import com.cg.pojos.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDAO extends JpaRepository<Stock, String> {//repository works with a Stock entity and a String ID
    @Query("SELECT s FROM Stock s WHERE s.tickerName=?1")
    public Stock getDetails(String tickerName) throws StockDetailsNotFoundException;
}


