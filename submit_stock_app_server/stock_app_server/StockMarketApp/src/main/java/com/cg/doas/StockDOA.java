package com.cg.doas;

import com.cg.exceptions.StockDetailsNotFoundException;
import com.cg.pojos.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface StockDOA extends JpaRepository<Stock, String> {

}
