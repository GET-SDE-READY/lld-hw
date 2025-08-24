package designpatterns.RijavLLDJul25.com.designpatterns.structural.bridge;

public class TV implements Device {
    public void turnOn() {
        System.out.println("TV is ON");
    }
    public void turnOff() {
        System.out.println("TV is OFF");
    }
}
