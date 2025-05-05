package mylab.music.entity;

public class MP3 extends DigitalMedia implements Playable {
    private int fileSize;
    private int volume;

    public MP3(String title, String artist, int fileSize) {
        this(title, artist, fileSize, 5);  // default volume = 5
    }

    public MP3(String title, String artist, int fileSize, int volume) {
        super(title, artist, "MP3");
        this.fileSize = fileSize;
        this.volume = volume;
    }

    @Override
    public void play() {
        super.play();
        System.out.println("���� ����: " + volume);
    }

    @Override
    public void stop() {
        System.out.println("MP3 ����� �����Ǿ����ϴ�.");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("������ " + volume + "�� �����Ǿ����ϴ�.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("���� ũ��: " + fileSize + "MB");
    }
}
