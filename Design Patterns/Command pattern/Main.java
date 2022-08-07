package DesignPatterns.commandPattern;

public class Main {
    public static void main(String[] args) {
        TVRemote tvRemote = new TVRemote(10, "HBO");

        VolumeUpCommand volumeUp = new VolumeUpCommand(tvRemote);
        VolumeDownCommand volumeDown = new VolumeDownCommand(tvRemote);

        volumeUp.execute();
        volumeUp.execute();
        volumeUp.execute();
        volumeDown.execute();
        volumeUp.execute();
    }
}
