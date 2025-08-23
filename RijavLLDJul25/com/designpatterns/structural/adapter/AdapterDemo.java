package designpatterns.RijavLLDJul25.com.designpatterns.structural.adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        MediaPlayer player = new MediaAdapter(new AudioPlayer());
        player.play("song.mp3");
    }
}
