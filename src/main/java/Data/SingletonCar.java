package Data;

public class SingletonCar {
    private static SingletonCar instance;
//    private CarData carData = new CarData();
    private static Car pCar;
    private SingletonCar() {
    }

    public static Car getCarData() {
        return pCar;
    }

    public void setCarData(Car pCar) {
        this.pCar = pCar;
        System.out.println("Car data set: " + pCar.getBrand() + " " + pCar.getModel() + " " + pCar.getRentDuration());
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
