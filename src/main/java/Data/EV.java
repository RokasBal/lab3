package Data;

public class EV extends Car{
    private String brand;
    private String model;
    private int rentDuration;

    public EV(String brand, String model, int rentDuration){
        this.brand = brand;
        this.model = model;
        this.rentDuration = rentDuration;
        System.out.println("EV car created");
    }
}
