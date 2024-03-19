package Data;

public class Gas extends Car{

    public Gas(String brand, String model, int rentDuration){
        setBrand(brand);
        setModel(model);
        setRentDuration(rentDuration);
        System.out.println("Gas car created");
    }
}
