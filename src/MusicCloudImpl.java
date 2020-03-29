import db.Database;
import db.mock.MockDatabase;
import model.PlayList;
import model.Track;

import java.util.List;

/**
 * Implementation of <code>{@link MusicCloud}</code>
 */
public class MusicCloudImpl implements MusicCloud {

    // Singleton MusiCloud object.
    private volatile static MusicCloudImpl musicCloudImpl;

    private Database dbHelper;

    public static MusicCloudImpl getInstance() {
        if (musicCloudImpl == null) {
            synchronized (MusicCloudImpl.class) {
                if (musicCloudImpl == null) {
                    musicCloudImpl = new MusicCloudImpl();
                }
            }
        }
        return musicCloudImpl;
    }

    private MusicCloudImpl() {
        dbHelper = new MockDatabase();
    }

    private PlayList<Track> getPlayList(int userId, int playListId) {
        return dbHelper.getPlayList(userId, playListId);
    }

    private Track getTrack(int trackId) {
        return dbHelper.getTrack(trackId);
    }

    @Override
    public void addTrack(int userId, int playListId, int trackId) {
        PlayList<Track> playList = getPlayList(userId, playListId);
        if (playList != null) {
            playList.addTrack(getTrack(trackId));
        }
    }

    @Override
    public void addTracks(int userId, int playListId, List<Integer> trackIds) {
        for (Integer trackId : trackIds) {
            addTrack(userId, playListId, trackId);
        }
    }

    @Override
    public void removeTrack(int userId, int playListId, int trackId) {
        PlayList<Track> playList = getPlayList(userId, playListId);
        if (playList != null) {
            playList.removeTrack(getTrack(trackId));
        }
    }

    @Override
    public void removeTracks(int userId, int playListId, List<Integer> trackIds) {
        for (Integer trackId : trackIds) {
            removeTrack(userId, playListId, trackId);
        }
    }

    @Override
    public float getDuration(int userId, int playListId) {
        PlayList<Track> playList = getPlayList(userId, playListId);
        if (playList != null) {
            return playList.getDuration();
        }
        return 0;
    }
}
