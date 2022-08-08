package controller;

import model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductManager {
    public List<Product> productList= new ArrayList<>();

    public void display() {
        int count = 1;
        System.out.println("[Number of item: " + productList.size() + "]\n");
        if (productList.size() == 0) {
            System.err.println("There is no item !!!");
        } else {
            for (Product product : productList) {
                System.out.print("[" + (count++) + "]\t");
                System.out.println(product);
            }
        }
    }

    public void add(Product product) {
        productList.add(product);
    }

    public void edit(int id, Product product) {
        productList.set(id,product);
    }

    public void delete(int id) {
        productList.remove(id);
    }

    public int checkID(String id){
        int test = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (id.equals(productList.get(i).getID())){
                test = i;
            }
        }
        return test;
    }

    public void sortByCostLowToHigh() {
        productList.sort((Comparator.comparingDouble(Product::getCost)));
    }

}
