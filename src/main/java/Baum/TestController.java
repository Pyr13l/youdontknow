package Baum;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @RequestMapping("/api/index")
    public List<Product> index(){
        return TestService.getAllProducts();
    }

    @RequestMapping("/api/some")
    public List<Product> some(@RequestParam(value="name", required=false) String[] name,
                              @RequestParam(value="cut", required = false) String[] cut,
                              @RequestParam(value = "tags", required = false) String[] tags) {
        return TestService.getFilteredProducts(new ProductRequestDto(name, cut, tags ));
    }
}
