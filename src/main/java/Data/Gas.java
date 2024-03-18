package Data;

public class Gas extends Car{
    private String brand;
    private String model;
    private int rentDuration;

    public Gas(String brand, String model, int rentDuration){
        this.brand = brand;
        this.model = model;
        this.rentDuration = rentDuration;
        System.out.println("Gas car created");
    }
}
