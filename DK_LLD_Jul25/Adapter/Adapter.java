package designpatterns.DK_LLD_Jul25.Adapter;

public class Adapter {
    public static void main(String[] args) {

        USBTypeC newEarphone = new LatestEarphone(); // with Type-C plug
        Aux oldEarphone = new LegacyEarphone(); // with 3.5mm plug

        SmartPhone smartPhone = new SmartPhone();

        // Type C port <- newEarphone
        smartPhone.connect(newEarphone);
        smartPhone.play(); // "Playing music via Type-C port"

        // Type C port <- oldEarphone
        // smartPhone.connect(oldEarphone); // Error
        // reason: argument mismatch; Aux cannot be converted to USBTypeC

        // Type C port <- typeC to Aux port <- oldEarphone
        // Target <- Adapter <- Adaptee
        smartPhone.connect(new TypeCToAuxAdapter(oldEarphone));
        smartPhone.play(); // "Playing song via 3.5mm jack"

    }
}

interface USBTypeC { // Target
    void playMusic();
}

interface Aux {  // Adaptee
    void playSong();  // via 3.5mm jack
}

class SmartPhone { // New-Gen SmartPhones only supports Type-C

    private USBTypeC device;

    public void connect(USBTypeC device){
        this.device = device;
    }

    public void play() {
        if (device == null)
            System.out.println("Connect a Type-C supported device to play");
        else
            device.playMusic();
    }
}

class TypeCToAuxAdapter implements USBTypeC { // Adapter

    private final Aux device;

    public TypeCToAuxAdapter(Aux device) {
        this.device = device;
    }

    @Override
    public void playMusic() {
        device.playSong();
    }
}

class LatestEarphone implements USBTypeC {
    @Override
    public void playMusic() {
        System.out.println("Playing music via Type-C port");
    }
}

class LegacyEarphone implements Aux {
    @Override
    public void playSong() {
        System.out.println("Playing song via 3.5mm jack");
    }
}
