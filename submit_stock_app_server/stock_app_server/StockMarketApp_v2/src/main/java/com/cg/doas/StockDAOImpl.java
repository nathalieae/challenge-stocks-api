package com.cg.doas;

//@Component(value = "stockDOA")
public class StockDAOImpl {} /*implements StockDOA {
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
