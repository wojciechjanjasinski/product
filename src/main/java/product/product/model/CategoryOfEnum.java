package product.product.model;

public enum CategoryOfEnum {
    GROCERY("spożywcze"), HOUSEHOLD("gospodarstwo domowe"), OTHER("inne");

    private final String description;

    CategoryOfEnum(String description) {
        this.description = description;
    }
}
