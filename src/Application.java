public class Application {

    public static void main(String[] args) {
        MusicCloud musicCloud = MusicCloudImpl.getInstance();
        musicCloud.addTrack(1, 1, 2);
        musicCloud.addTrack(1, 1, 3);
        musicCloud.addTrack(1, 1, 1);
        musicCloud.getDuration(1, 1).subscribe(aFloat -> {
            System.out.println(aFloat);
        });
        musicCloud.removeTrack(1, 1, 1);
        musicCloud.getDuration(1, 1).subscribe(aFloat -> {
            System.out.println(aFloat);
        });
    }
}
