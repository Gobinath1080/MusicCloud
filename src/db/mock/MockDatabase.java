package db.mock;

import db.Database;
import model.PlayList;
import model.Track;
import model.User;

import java.util.HashMap;
import java.util.Map;


public class MockDatabase implements Database {

    // Cache should  be replaced with InMemory database list Memcached or Redis.
    private Map<Integer, Map<Integer, PlayList>> playListCache;

    private MockDataSource mockDataSource;

    public MockDatabase() {
        mockDataSource = new MockDataSource();
        this.playListCache = new HashMap<>();
    }

    public PlayList<Track> getPlayList(int userId, int playListId) {
        if (playListCache.get(userId) != null && playListCache.get(userId).get(playListId) != null) {
            return playListCache.get(userId).get(playListId);
        }
        User user = mockDataSource.getUser(userId);
        PlayList<Track> playList = mockDataSource.getPlayLst(playListId);
        if (user != null && playList != null) {
            cachePlayList(userId, playListId, playList);
        }
        return playList;
    }

    private void cachePlayList(int userId, int playListId, PlayList playList) {
        if (playListCache.get(userId) == null) {
            playListCache.put(userId, new HashMap<Integer, PlayList>());
        }
        playListCache.get(userId).put(playListId, playList);
    }

    public Track getTrack(int trackId) {
        return mockDataSource.getTrack(trackId);
    }

    public void updateDB() {
        // Update the cache at regular interval to the DB.
    }
}
