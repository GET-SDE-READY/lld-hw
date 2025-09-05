package designpatterns.RijavLLDJul25.com.designpatterns.structural.bridge;

public class AC implements Device {
    public void turnOn() {
        System.out.println("AC is ON");
    }
    public void turnOff() {
        System.out.println("AC is OFF");
    }
}
