package Data;

public abstract class Car {
    private String brand;
    private String model;
    private int rentDuration;

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
