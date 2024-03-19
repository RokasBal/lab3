package Data;

/*
* Class made for factory design pattern implementation.
* Creates an EV vehicle.
*/

public class EV extends Car{

    public EV(String brand, String model, int rentDuration){
        setBrand(brand);
        setModel(model);
        setRentDuration(rentDuration);
        System.out.println("EV car created");
    }
}
