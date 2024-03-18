package Data;

public class SingletonCar {
    private static SingletonCar instance;
    private CarData carData = new CarData();

    private SingletonCar() {
    }

    public CarData getCarData() {
        return carData;
    }

    public void setCarData(CarData carData) {
        this.carData = carData;
    }

    public static SingletonCar getInstance() {
        if (instance == null) {
            instance = new SingletonCar();
        }
        return instance;
    }
}
