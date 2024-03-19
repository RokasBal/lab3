package Data;

public class EV extends Car{

    public EV(String brand, String model, int rentDuration){
        setBrand(brand);
        setModel(model);
        setRentDuration(rentDuration);
        System.out.println("EV car created");
    }
}
