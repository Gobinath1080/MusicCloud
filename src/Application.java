public class Application {

    public static void main(String[] args) {
        MusicCloud musicCloud = MusicCloudImpl.getInstance();
        musicCloud.addTrack(1, 1, 2);
        musicCloud.addTrack(1, 1, 3);
        float duration = musicCloud.getDuration(1, 1);
    }
}
