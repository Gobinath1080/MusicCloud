package model;

import db.mock.MockTrack;
import db.mock.MockUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PlayListTest {

    PlayList<Track> playList;

    @BeforeEach
    public void setUp() {
        playList = new PlayList<>(1234, new MockUser("User1", 1, false));
    }

    @Test
    void addTracks() {
        playList.addTrack(new MockTrack(1, "Song1", 20));
        assertEquals(20f, playList.getDuration());
        playList.addTrack(new MockTrack(2, "Song2", 40.20f));
        assertEquals(60.20f, playList.getDuration());
        playList.addTrack(new MockTrack(3, "Song3", 50));
        assertEquals(110.20f, playList.getDuration());
        playList.addTrack(new MockTrack(4, "Song4", 60.05f));
        assertEquals(170.25f, playList.getDuration());
        playList.addTrack(new MockTrack(5, "Song5", 90.04f));
        assertEquals(260.29f, playList.getDuration());
        Set<Track> trackList = new HashSet();
        trackList.add(new MockTrack(6, "Song6", 10.00f));
        trackList.add(new MockTrack(7, "Song7", 30.00f));
        trackList.add(new MockTrack(8, "Song8", 100.00f));
        playList.addTracks(trackList);
        assertEquals(400.29f, playList.getDuration());
    }

    @Test
    void removeTrack() {
        playList.addTrack(new MockTrack(1, "Song1", 20));
        Set<Track> trackList = new HashSet();
        trackList.add(new MockTrack(5, "Song5", 30.00f));
        trackList.add(new MockTrack(10, "Song10", 20.00f));
        trackList.add(new MockTrack(11, "Song11", 15.00f));
        playList.addTracks(trackList);
        playList.removeTracks(trackList);
        assertEquals(20f, playList.getDuration());
        playList.addTracks(trackList);
        assertEquals(85f, playList.getDuration());
        playList.removeTrack(new MockTrack(1, "Song1", 20));
        assertEquals(65f, playList.getDuration());
        playList.removeTrack(new MockTrack(10, "Song10", 20.00f));
        assertEquals(45f, playList.getDuration());
        playList.removeTrack(new MockTrack(5, "Song5", 30.00f));
        playList.removeTrack(new MockTrack(11, "Song11", 15.00f));
        assertEquals(0f, playList.getDuration());
    }

    @Test
    void assertUser() {
        assertEquals(1, playList.getUser().getId());
        assertEquals("User1", playList.getUser().getUsername());
    }

}