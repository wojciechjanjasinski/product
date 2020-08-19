package product.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import product.product.model.Product;
import product.product.repository.ProductRepository;

import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    private ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @ResponseBody
//    @GetMapping("/old")

    //    @ResponseBody
//    @GetMapping("/prices")
    public double showSumOfPricesOfAllProducts() {
        return productRepository.sumPricesOfAllProducts();
    }

    @ResponseBody
    @GetMapping("/test")
    public Object showSpecifiedProductsTest(@RequestParam(name = "name", required = false) String name,
                                            @RequestParam(name = "price", required = false) Double price,
                                            @RequestParam(name = "category", required = false) String categoryOfAProduct) {
//        productRepository.showAllProducts();
//        productRepository.sumPricesOfAllProducts();
        List<Product> products = productRepository.showAll();
        if (categoryOfAProduct.startsWith("spożywcze"))
            return ProductRepository.showGroceryStreamOfProducts(products) + "" + ProductRepository.showGrocerySum(products);
        if (categoryOfAProduct.startsWith("gospodarstwo domowe"))
            return ProductRepository.showHouseholdStreamOfProducts(products) + "" + ProductRepository.showHouseholdSum(products);
        if (categoryOfAProduct.startsWith("inne"))
            return ProductRepository.showOtherStreamOFProducts(products) + "" + ProductRepository.showOtherSum(products);
        return products + " " + productRepository.sumPricesOfAllProducts();
    }

//    @ResponseBody
//    @GetMapping("/abc")
//    public Stream<Object> getHousehold(@RequestParam(name = "name", required = false) String name,
//                                       @RequestParam(name = "price", required = false) Double price,
//                                       @RequestParam(name = "categoryOfProduct", required = false) String nazwaKategorii) {
//        return productRepository.showAllAndSum()
//          //      .filter(product -> product.getCategoryOfProduct().getCategory().startsWith("inne"))
//           //     .collect(Collectors.toList());;
//    }
    //    @PostMapping("/add")
//    public String add(@RequestParam(name = "firstName"/*, required = false, defaultValue = "Anonim"*/) String imie,
//                      @RequestParam String lastName,
//                      @RequestParam Integer age) {
//        if (imie != null && imie.equals("")) {
//            return "redirect:/error.html";
//        } else {
//            User user = new User(imie, lastName, age);
//            userRepository.save(user);
//            return "redirect:/success.html";
//        }
    //  }
}
