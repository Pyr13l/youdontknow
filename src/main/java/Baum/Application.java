package Baum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marten.reinlaender on 21.12.2016.
 */

@SpringBootApplication
public class Application {

    public static List<Product> products;
    public static void main(String[] args){
        products = new ArrayList<Product>(){{
            for (int i = 0; i < 10; i++){
                add(new Product());
                i++;
            }
        }};

        products.get(0).addTag("Baum");
        products.get(0).addTag("Horst");
        products.get(0).addTag("Baum");

        SpringApplication.run(Application.class, args);
    }

}
