package Baum;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by marten.reinlaender on 21.12.2016.
 */

@RestController
public class TestController {

    public List<Product>index(){
        return Application.products;
    }
}
