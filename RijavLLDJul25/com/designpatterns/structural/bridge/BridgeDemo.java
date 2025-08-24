package designpatterns.RijavLLDJul25.com.designpatterns.structural.bridge;

public class BridgeDemo {
    public static void main(String[] args) {
        Remote tvRemote = new AdvancedRemote(new TV());
        tvRemote.pressOn();
        tvRemote.pressOff();

        Remote acRemote = new AdvancedRemote(new AC());
        acRemote.pressOn();
        acRemote.pressOff();
    }
}
