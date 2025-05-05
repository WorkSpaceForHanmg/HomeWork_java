package mylab.music.entity;

public class DigitalMedia extends MusicMedia {
    protected String format;

    public DigitalMedia(String title, String artist, String format) {
        super(title, artist);
        this.format = format;
    }

    @Override
    public void play() {
        System.out.printf("%s ������ '%s'��(��) �����з� ����˴ϴ�.\n", format, title);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("����: " + format);
    }
}
