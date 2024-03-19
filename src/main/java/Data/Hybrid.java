package Data;

public class Hybrid extends Car{
    public Hybrid(String brand, String model, int rentDuration){
        setBrand(brand);
        setModel(model);
        setRentDuration(rentDuration);
        System.out.println("Hybrid car created");
    }
}
