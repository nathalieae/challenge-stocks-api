package com.cg;
import com.cg.services.StockServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
@SpringBootApplication
@Configuration
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);

        //Run services
        //StockServices services = context.getBean("stockService", StockServices.class);
    }
}
