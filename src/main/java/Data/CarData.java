package Data;

public class CarData {
    private String brand;
    private String model;
    private int rentDuration;

    public CarData(){
    }

    public CarData(String brand, String model, int rentDuration) {
        this.brand = brand;
        this.model = model;
        this.rentDuration = rentDuration;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRentDuration() {
        return rentDuration;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRentDuration(int rentDuration) {
        this.rentDuration = rentDuration;
    }
}
