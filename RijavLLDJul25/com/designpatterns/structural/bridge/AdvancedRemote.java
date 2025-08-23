package designpatterns.RijavLLDJul25.com.designpatterns.structural.bridge;

public class AdvancedRemote extends Remote {
    public AdvancedRemote(Device device) {
        super(device);
    }
    public void pressOn() {
        device.turnOn();
    }
    public void pressOff() {
        device.turnOff();
    }
}
