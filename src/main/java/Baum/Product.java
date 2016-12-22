package Baum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marten.reinlaender on 21.12.2016.
 */
public class Product {

    private String name;
    private String cut;
    private String model;
    private int size;
    private int count;
    private List<String> tags;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCut() {
        return cut;
    }

    public void setCut(String cut) {
        this.cut = cut;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Product(){
        this.name = "";
        this.cut = "";
        this.model = "";
        this.size = 0;
        this.count = 42;
        this.tags = new ArrayList<String>();
    }

    public void addTag(String newTag){
        if(!tags.stream().anyMatch( tag -> tag == newTag)) {
            this.tags.add(newTag);
        }
    }
}