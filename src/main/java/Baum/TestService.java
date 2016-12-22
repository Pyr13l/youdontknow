package Baum;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class TestService {
    static List<Product> getFilteredProducts(ProductRequestDto productRequest){
        List<Product> result = new ArrayList<>();

        if (productRequest.name != null) {
            for (Product product : FilterProducts(getByName.apply(productRequest.name))){
                result.add(product);
            }
        }

        if (productRequest.cut != null) {
            for (Product product : FilterProducts(getByCut.apply(productRequest.cut))){
                result.add(product);
            }
        }

        if (productRequest.tags != null) {
            for (String tag : productRequest.tags){
                for (Product product : FilterProducts(getByTag.apply(tag))){
                    result.add(product);
                }
            }
        }

        return result;
    }

    private static List<Product> FilterProducts(Predicate<Product> predicate){
        return Application.products.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    private static Function<String, Predicate<Product>> getByName =
            name -> product ->  product.getName().equals(name);

    private static Function<String, Predicate<Product>> getByCut =
            cut -> product ->  product.getCut().equals(cut);

    private static Function<String, Predicate<Product>> getByTag =
            tag -> product -> product.getTags().stream().anyMatch(e -> e.equals(tag));
}
