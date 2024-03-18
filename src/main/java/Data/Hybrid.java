package Data;

public class Hybrid extends Car{
    private String brand;
    private String model;
    private int rentDuration;

    public Hybrid(String brand, String model, int rentDuration){
        this.brand = brand;
        this.model = model;
        this.rentDuration = rentDuration;
        System.out.println("Hybrid car created");
    }
}
