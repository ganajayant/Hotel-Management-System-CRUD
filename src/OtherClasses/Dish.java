package OtherClasses;

public class Dish {
    private String DishName;
    private String Cuisine;
    private Double Price;

    public Dish(String DishName, String Cuisine, Double Price) {
        this.DishName = DishName;
        this.Cuisine = Cuisine;
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "Dish Name: " + DishName + " Cuisine: " + Cuisine + " Price: " + Price;
    }

    public String getDishName() {
        return DishName;
    }

    public String getCuisine() {
        return Cuisine;
    }

    public Double getPrice() {
        return Price;
    }
}
