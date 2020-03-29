package model;

/**
 * A contract for the music track.
 */
public interface Track {

    /**
     * @return title of track
     */
    String getTitle();

    /**
     * @return the duration of track in seconds
     */
    float getDuration();
}
