package Utility;

import Data.SingletonCar;

public class RentCommand implements Command {

    private RentingService rentingService;
    public RentCommand(RentingService rentingService) {
        this.rentingService = rentingService;
    }

    @Override
    public void execute() {
        System.out.println("Renting a car.");
    }
}
