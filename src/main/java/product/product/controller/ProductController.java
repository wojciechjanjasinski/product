package product.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import product.product.model.CategoryOfEnum;
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
    @GetMapping("/products")
    public List<Product> showProducts(Enum<CategoryOfEnum> categoryOfEnum) {
        List<Product> products = productRepository.showAll();
        if (categoryOfEnum.equals(CategoryOfEnum.GROCERY))
            return productRepository.showGroceryStreamOfProducts();
        if (categoryOfEnum.equals(CategoryOfEnum.HOUSEHOLD))
            return productRepository.showHouseholdStreamOfProducts();
        if (categoryOfEnum.equals(CategoryOfEnum.OTHER))
            return productRepository.showOtherStreamOFProducts();
        return products;
    }

}
