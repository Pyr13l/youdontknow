package Baum;

public class ProductRequestDto {
    public String name;
    public String cut;
    public String[] tags;

    public ProductRequestDto(String name, String cut, String[] tags){
        this.name = name;
        this.cut = cut;
        this.tags = tags;
    }
}
