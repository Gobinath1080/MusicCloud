package db.mock;

import db.Database;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import model.PlayList;
import model.Track;
import model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Mock database implementation.
 */
public class MockDatabase implements Database {

    // Cache should  be replaced with InMemory database list Memcached or Redis.
    private Map<Integer, Map<Integer, PlayList>> playListCache;

    private MockDataSource mockDataSource;

    public MockDatabase() {
        mockDataSource = new MockDataSource();
        this.playListCache = new HashMap<>();
    }

    public Observable<PlayList<Track>> getPlayList(int userId, int playListId) {
        return Observable.create(emitter -> {
            if (playListCache.get(userId) != null && playListCache.get(userId).get(playListId) != null) {
                emitter.onNext(playListCache.get(userId).get(playListId));
                return;
            }
            User user = mockDataSource.getUser(userId);
            PlayList<Track> playList = mockDataSource.getPlayLst(playListId);
            if (user != null && playList != null) {
                cachePlayList(userId, playListId, playList);
            }
            emitter.onNext(playList);
        });

    }

    private void cachePlayList(int userId, int playListId, PlayList playList) {
        if (playListCache.get(userId) == null) {
            playListCache.put(userId, new HashMap<Integer, PlayList>());
        }
        playListCache.get(userId).put(playListId, playList);
    }

    public Observable<Track> getTrack(int trackId) {
        return Observable.create(emitter -> {
            emitter.onNext(mockDataSource.getTrack(trackId));
        });
    }

    public void updateDB() {
        // Update the cache at regular interval to the DB.
    }
}
