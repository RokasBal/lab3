package Data;

/*
 * Class made for factory design pattern implementation.
 * Creates a hybrid powered vehicle.
 */


public class Hybrid extends Car{
    public Hybrid(String brand, String model, int rentDuration){
        setBrand(brand);
        setModel(model);
        setRentDuration(rentDuration);
        System.out.println("Hybrid car created");
    }
}
