package product.product.model;

public class CategoryOfProduct {
    private String category;

    public CategoryOfProduct(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "CategoryOfProduct{" +
                "category='" + category + '\'' +
                '}';
    }
}
