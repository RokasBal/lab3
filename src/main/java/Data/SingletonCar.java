package Data;

public class SingletonCar {
    private static SingletonCar instance;
//    private CarData carData = new CarData();
    private Car pCar;
    private SingletonCar() {
    }

    public Car getCarData() {
        return pCar;
    }

    public void setCarData(Car pCar) {
        this.pCar = pCar;
    }

    public static SingletonCar getInstance(String vehicleType, String brand, String model, int rentDuration) {
        if (instance == null) {
            instance = new SingletonCar();
        }

        if(vehicleType.equals("Hybrid"))
            instance.setCarData(new Hybrid(brand, model, rentDuration));
        else if(vehicleType.equals("Gas"))
            instance.setCarData(new Gas(brand, model, rentDuration));
        else if(vehicleType.equals("EV"))
            instance.setCarData(new EV(brand, model, rentDuration));

        return instance;
    }
}
