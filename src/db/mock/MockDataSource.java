package db.mock;

import model.PlayList;
import model.Track;
import model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Mock data source of playlist, tracks and users list.
 */
public class MockDataSource {

    private Map<Integer, User> mockUserList = new HashMap<>();

    private Map<Integer, Map<Integer, PlayList<Track>>> mockPlayList = new HashMap<>();

    private Map<Integer, MockTrack> mockTrackList = new HashMap<Integer, MockTrack>();

    public MockDataSource() {
        initData();
    }

    private void initData() {
        User user1 = new MockUser("User1", 1, false);
        User user2 = new MockUser("User2", 2, true);
        mockUserList.put(user1.getId(), user1);
        mockUserList.put(user2.getId(), user2);

        Map<Integer, PlayList<Track>> playLists = new HashMap();
        PlayList<Track> playList1 = new PlayList<>(1, user1);
        playList1.addTrack(new MockTrack(1, "PlayList1", 55));
        playLists.put(playList1.getId(), playList1);
        mockPlayList.put(user1.getId(), playLists);
        mockTrackList.put(1, new MockTrack(1, "Track1", 50));
        mockTrackList.put(2, new MockTrack(2, "Track2", 40));
        mockTrackList.put(3, new MockTrack(3, "Track3", 70));
        mockTrackList.put(4, new MockTrack(4, "Track4", 90));
    }

    User getUser(int userId) {
        return mockUserList.get(userId);
    }

    PlayList<Track> getPlayLst(int playListId) {
        Map<Integer, PlayList<Track>> playLists = mockPlayList.get(playListId);
        if (playLists != null) {
            return playLists.get(playListId);
        }
        return null;
    }

    MockTrack getTrack(int trackId) {
        return mockTrackList.get(trackId);
    }

}
