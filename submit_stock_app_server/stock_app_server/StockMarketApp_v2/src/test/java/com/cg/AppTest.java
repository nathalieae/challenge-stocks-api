package com.cg;

import com.cg.doas.StockDAO;
import com.cg.pojos.Stock;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;//for testing

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    @Autowired
    private StockDAO stockRepository;
    /**Testing that add method for single stock upload
     *
     * @param stock stock to be uploaded to the database
     */
    public void testAddSingleRecord(Stock stock) {
        assertThat(stock).isNotNull();
        stockRepository.save(stock);
        String formatedStockID = ""+ stock.getId();
        assertThat(stockRepository.findById(formatedStockID)).isNotNull();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
