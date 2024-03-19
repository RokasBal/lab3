package Utility;

public class RentingProxy implements RentingInterface{

    private RentingService rentingService;
    private static RentingProxy rentingProxy;
    private String password = "1234";

    private RentingProxy(String password) {
        if(password.equals(password)) {
            rentingService = new RentingService();
            System.out.println("Authenticated");
        } else {
            System.out.println("Not Authenticated");
        }
    }

    public static RentingProxy createProxy(String password) {
        if(rentingProxy == null) {
            rentingProxy = new RentingProxy(password);
        }
        return rentingProxy;
    }

    @Override
    public void rent() {
        if(rentingService != null) {
            rentingService.rent();
        } else {
            System.out.println("Not Authenticated");
        }
    }
}
