package Utility;

public class RentingService implements RentingInterface {
    private Command rentCommand = new RentCommand(this);
    private Control controller = new Control();

    @Override
    public void rent() {
        controller.setCommand(rentCommand);
        controller.executeCommand();
    }
}
