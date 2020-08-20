package product.product.model;

public class Product {
    private String name;
    private double price;
    private CategoryOfEnum categoryOfEnum;

    public Product(String name, double price, CategoryOfEnum categoryOfEnum) {
        this.name = name;
        this.price = price;
        this.categoryOfEnum = categoryOfEnum;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public CategoryOfEnum getCategoryOfEnum() {
        return categoryOfEnum;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categoryOfProduct=" + categoryOfEnum +
                '}';
    }
}
