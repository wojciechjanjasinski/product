package product.product.repository;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import product.product.model.CategoryOfEnum;
import product.product.model.CategoryOfProduct;
import product.product.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Repository
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("masło", 4.49, CategoryOfEnum.GROCERY));
        products.add(new Product("mleko", 2.79, CategoryOfEnum.GROCERY));
        products.add(new Product("kawa", 14.89, CategoryOfEnum.GROCERY));
        products.add(new Product("robot kuchenny", 399.99, CategoryOfEnum.HOUSEHOLD));
        products.add(new Product("mikser", 149.99, CategoryOfEnum.HOUSEHOLD));
        products.add(new Product("mikrofala", 499.99, CategoryOfEnum.HOUSEHOLD));
        products.add(new Product("zeszyt", 1.99, CategoryOfEnum.OTHER));
        products.add(new Product("głośnik bluetooth", 299.99, CategoryOfEnum.OTHER));
        products.add(new Product("kąpielówki", 99.99, CategoryOfEnum.OTHER));
    }

    public void addNewProduct(Product product) {
        products.add(product);
    }

    public List<Product> showAll() {
        return new ArrayList<>(products);
    }

    public double sumPricesOfAllProducts() {
        double sum = 0.0;
        for (Product product : products) {
            double price = product.getPrice();
            sum += price;
        }
        return sum;
    }

    public double newSum() {
        return products.stream()
                .mapToDouble(price -> Double.parseDouble(String.valueOf(price)))
                .sum();
    }

    public List<Product> showGroceryStreamOfProducts() {
        return products.stream()
                .filter(product -> product.getCategoryOfEnum().equals(CategoryOfEnum.GROCERY))
                .collect(Collectors.toList());
    }

    public List<Product> showTest() {
        return products.stream()
                .filter(product -> product.getCategoryOfEnum().equals(CategoryOfEnum.GROCERY))
                .filter(product -> product.getCategoryOfEnum().equals(CategoryOfEnum.HOUSEHOLD))
                .filter(product -> product.getCategoryOfEnum().equals(CategoryOfEnum.OTHER))
                .collect(Collectors.toList());
    }

    public double grocerySum() {
       return products.stream()
                .filter(product -> product.getCategoryOfEnum().equals(CategoryOfEnum.GROCERY))
                .mapToDouble(price -> Double.parseDouble(String.valueOf(price)))
                .sum();
    }

    public List<Product> showHouseholdStreamOfProducts() {
        return products.stream()
                .filter(product -> product.getCategoryOfEnum().equals(CategoryOfEnum.HOUSEHOLD))
                .collect(Collectors.toList());
    }

    public double householdSum() {
        return products.stream()
                .filter(product -> product.getCategoryOfEnum().equals(CategoryOfEnum.HOUSEHOLD))
                .mapToDouble(price -> Double.parseDouble(String.valueOf(price)))
                .sum();
    }

    public List<Product> showOtherStreamOFProducts() {
        return products.stream()
                .filter(product -> product.getCategoryOfEnum().equals(CategoryOfEnum.OTHER))
                .collect(Collectors.toList());
    }

    public double otherSum() {
        return products.stream()
                .filter(product -> product.getCategoryOfEnum().equals(CategoryOfEnum.OTHER))
                .mapToDouble(price -> Double.parseDouble(String.valueOf(price)))
                .sum();

    }
}