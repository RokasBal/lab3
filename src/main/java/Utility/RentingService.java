package Utility;

public class RentingService implements RentingInterface {

    @Override
    public void rent() {
        System.out.println("RentingService: Renting a car");
    }
}
