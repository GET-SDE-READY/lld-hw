package designpatterns.RijavLLDJul25.com.designpatterns.structural.adapter;

public class MediaAdapter implements MediaPlayer {
    private final AudioPlayer audioPlayer;
    public MediaAdapter(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }
    public void play(String filename) {
        audioPlayer.playMp3(filename);
    }
}
