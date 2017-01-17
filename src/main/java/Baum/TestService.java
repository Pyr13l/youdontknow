package Baum;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class TestService {

    public static List<Product> getAllProducts(){
        return  Application.products;
    }

    public static List<Product> getFilteredProducts(ProductRequestDto productRequest){
        List<Product> result = new ArrayList<>();
        List<Product> allProducts = getAllProducts();

        for ( Product product : findMatches(productRequest.name, byName, allProducts) ){
            if( !result.contains(product)) result.add(product);
        }

        for ( Product product : findMatches(productRequest.cut, byCut, allProducts) ){
            if( !result.contains(product)) result.add(product);
        }

        for ( Product product : findMatches(productRequest.tags, byTag, allProducts) ){
            if( !result.contains(product)) result.add(product);
        }

        return result;
    }

    private static List<Product> findMatches(String[] values, Function<String,Predicate<Product>> byPredicate, List<Product> allProducts){
        List<Product> storage = new ArrayList<>();

        if (values != null && values.length > 0) {
            for (String value : values){
                if (value != ""){
                    for (Product product : allProducts.stream()
                            .filter(byPredicate.apply(value))
                            .collect(Collectors.toList())) {
                        if (!storage.contains(product)) storage.add(product);
                    }
                }
            }
        }
        return storage;
    }

    private static Function<String, Predicate<Product>> byName =
            name -> product ->  product.getName().equals(name);

    private static Function<String, Predicate<Product>> byCut =
            cut -> product ->  product.getCut().equals(cut);

    private static Function<String, Predicate<Product>> byTag =
            tag -> product -> product.getTags().stream().anyMatch(e -> e.equals(tag));
}
