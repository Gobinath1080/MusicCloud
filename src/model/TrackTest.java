package model;

import db.mock.MockTrack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {

    public Track track;

    @BeforeEach
    public void setUp(){
        track = new MockTrack(1, "Track1", 10.15f);
    }

    @Test
    void getTitle() {
        assertEquals("Track1",track.getTitle());
    }

    @Test
    void getDuration() {
        assertEquals(10.15f,track.getDuration());
    }
}