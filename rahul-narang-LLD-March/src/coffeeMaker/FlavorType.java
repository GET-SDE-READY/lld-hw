package coffeeMaker;

public enum FlavorType {
    VANILLA("Vanilla", 26.0),
    CARAMEL("Caramel", 23.0),
    HAZELNUT("Hazelnut", 30.0);

    private final String flavor;
    private final double cost;
    FlavorType(String flavor, double cost) {
        this.flavor = flavor;
        this.cost = cost;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getCost() {
        return cost;
    }
}