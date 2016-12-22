package Baum;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TestController {

    @RequestMapping("/index")
    @ResponseBody
    public List<Product>index(){
        return Application.products;
    }

    @RequestMapping("/some")
    @ResponseBody
    public List<Product> some(ProductRequestDto productRequest) {
        return TestService.getFilteredProducts(productRequest);
    }
}
