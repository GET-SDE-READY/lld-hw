package designpatterns.RijavLLDJul25.com.designpatterns.structural.bridge;

public abstract class Remote {
    protected Device device;
    public Remote(Device device) {
        this.device = device;
    }
    public abstract void pressOn();
    public abstract void pressOff();
}
