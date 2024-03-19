package Data;

/*
 * Class made for factory design pattern implementation.
 * Creates a gas engine vehicle.
 */


public class Gas extends Car{

    public Gas(String brand, String model, int rentDuration){
        setBrand(brand);
        setModel(model);
        setRentDuration(rentDuration);
        System.out.println("Gas car created");
    }
}
