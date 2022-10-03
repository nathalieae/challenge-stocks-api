package com.cg.doas;

import com.cg.pojos.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

//@Component(value = "stockDOA")
public class StockDOAImpl{} /*implements StockDOA {
    @Autowired
    private EntityManagerFactory factory;

    @Override
    public Stock save(Stock stock){
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(stock);
        manager.getTransaction().commit();
        manager.close();
        return stock;
    }

    @Override
    public Stock update(Stock stock){
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(stock);
        manager.getTransaction().commit();
        manager.close();
        return stock;
    }
    @Override
    public List<Stock> getAllStocks(){
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Stock> query = manager.createQuery("FROM Stock s",Stock.class);
        return query.getResultList();
    }

    @Override
    public Optional<Stock> getStock(String tickerName){
        EntityManager manager = factory.createEntityManager();
        Stock stock = manager.find(Stock.class, tickerName);
        return Optional.ofNullable(stock);
    }

    @Override
    public  void insertBulkStocks(List<Stock> stocks){}
}*/
