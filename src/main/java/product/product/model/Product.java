package product.product.model;

public class Product {
    private String name;
    private double price;
    private CategoryOfProduct categoryOfProduct;

    public Product(String name, double price, CategoryOfProduct categoryOfProduct) {
        this.name = name;
        this.price = price;
        this.categoryOfProduct = categoryOfProduct;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public CategoryOfProduct getCategoryOfProduct() {
        return categoryOfProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categoryOfProduct=" + categoryOfProduct +
                '}';
    }
}
