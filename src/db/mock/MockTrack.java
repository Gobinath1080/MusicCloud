package db.mock;


import model.Track;

/**
 * Mock implementation of music track.
 */
public class MockTrack implements Track {

    int id;

    String title;

    float duration;

    public MockTrack(int id, String title, float duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public float getDuration() {
        return duration;
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((MockTrack) obj).id;
    }
}
