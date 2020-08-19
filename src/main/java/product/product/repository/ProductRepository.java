package product.product.repository;

import org.springframework.stereotype.Controller;
import product.product.model.CategoryOfProduct;
import product.product.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class ProductRepository {
    private List<Product> products;

    public ProductRepository(){
        products = new ArrayList<>();
        products.add(new Product("masło", 4.49, new CategoryOfProduct("spożywcze")));
        products.add(new Product("mleko", 2.79, new CategoryOfProduct("spożywcze")));
        products.add(new Product("kawa", 14.89, new CategoryOfProduct("spożywcze")));
        products.add(new Product("robot kuchenny", 399.99, new CategoryOfProduct("gospodarstwo domowe")));
        products.add(new Product("mikser", 149.99, new CategoryOfProduct("gospodarstwo domowe")));
        products.add(new Product("mikrofala", 499.99, new CategoryOfProduct("gospodarstwo domowe")));
        products.add(new Product("zeszyt", 1.99, new CategoryOfProduct("inne")));
        products.add(new Product("głośnik bluetooth", 299.99, new CategoryOfProduct("inne")));
        products.add(new Product("kąpielówki", 99.99, new CategoryOfProduct("inne")));
    }
    public void addNewProduct(Product product){
        products.add(product);
    }
    public List<Product> showAll(){
        return new ArrayList<>(products);
    }
    public double sumPricesOfAllProducts (){
        double sum = 0.0;
        for (Product product : products) {
            double price = product.getPrice();
            sum += price;
        }
        return sum;
    }
    public Stream<Object> showAllAndSum (){
        return Stream.of(products, sumPricesOfAllProducts());
    }
    public static Stream<Product> showGroceryStreamOfProducts(ArrayList<Product> list)
    {
        return list.stream()
                .filter(product -> product.getCategoryOfProduct().getCategory().startsWith("spożywcze"));
    }
    public static Stream<Product> showHouseholdStreamOfProducts(ArrayList<Product> list)
    {
        return list.stream()
                .filter(product -> product.getCategoryOfProduct().getCategory().startsWith("gospodarstwo domowe"));
    }
    public static Stream<Product> showOtherStreamOFProducts(ArrayList<Product> list)
    {
        return list.stream()
                .filter(product -> product.getCategoryOfProduct().getCategory().startsWith("inne"));
    }
//    public ArrayList<Product> showGroceryProducts (){
//        if (products.contains("spożywcze"))
//        return new ArrayList<>(products);
//    }
//    public ArrayList<Product> showHouseholdProducts (){
//        final String HOUSEHOLD = "gospodarstwo domowe";
//        if (products.contains(HOUSEHOLD)){
//            return new ArrayList<>();
//        }
//        return null;
//    }
//    public ArrayList<Product> showOtherProducts (){
//        final String OTHER = "inne";
//        if (products.contains(OTHER)){
//            return new ArrayList<>();
//        }
//        return null;
//    }
}
//        if (imie != null && imie.equals("")) {
//            return "redirect:/error.html";
//        } else {
//            User user = new User(imie, lastName, age);
//            userRepository.save(user);
//            return "redirect:/success.html";
//        }