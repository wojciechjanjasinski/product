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

    @ResponseBody
    @GetMapping("/test")
    public Object showSpecifiedProductsTest(@RequestParam(name = "name", required = false) String name,
                                            @RequestParam(name = "price", required = false) Double price,
                                            @RequestParam(name = "category", required = false) String categoryOfAProduct) {

        List<Product> products = productRepository.showAll();
        if (categoryOfAProduct.startsWith("spożywcze"))
            return ProductRepository.showGroceryStreamOfProducts(products) + "" + ProductRepository.showGrocerySum(products);
        if (categoryOfAProduct.startsWith("gospodarstwo domowe"))
            return ProductRepository.showHouseholdStreamOfProducts(products) + "" + ProductRepository.showHouseholdSum(products);
        if (categoryOfAProduct.startsWith("inne"))
            return ProductRepository.showOtherStreamOFProducts(products) + "" + ProductRepository.showOtherSum(products);
        return products + " " + productRepository.sumPricesOfAllProducts();
    }

}
