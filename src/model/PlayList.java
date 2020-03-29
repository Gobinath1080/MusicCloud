package model;

import util.PlayListHelper;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * Playlist of tracks which supports adding and removing multiple tracks.
 */
public class PlayList<T extends Track> {

    // Owner of the the current playlist.
    private User user;

    // Unique playlist id.
    private int playlistId;

    // Set of unique tracks in the playlist;
    private Set<T> trackList;

    // Sum of duration of individual tracks in the playlist.
    private float totalDuration;

    public PlayList(int playlistId, User user) {
        this.playlistId = playlistId;
        this.user = user;
        this.trackList = new HashSet<>();
    }

    /**
     * Add the <track> to the playlist.
     *
     * @param track the track to be added
     * @return
     */
    public boolean addTrack(T track) {
        if (isTrackListFull()) {
            throw new Error("Track list if full");
        }
        if (trackList.add(track)) {
            totalDuration += track.getDuration();
        }
        return true;
    }

    public boolean addTracks(Set<T> trackList) {
        Iterator<T> trackIterator = trackList.iterator();
        while (trackIterator.hasNext()) {
            if (!addTrack(trackIterator.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean removeTrack(T track) {
        if (trackList.remove(track)) {
            totalDuration -= track.getDuration();
        }
        return true;
    }

    public boolean removeTracks(Set<T> trackList) {
        Iterator<T> trackIterator = trackList.iterator();
        while (trackIterator.hasNext()) {
            removeTrack(trackIterator.next());
        }
        return true;
    }

    /**
     * @return total duration of tracks in playlist.
     */
    public float getDuration() {
        return totalDuration;
    }

    /**
     * @return whether the track list full based on the number of tracks supported per playlist for user.
     */
    private boolean isTrackListFull() {
        return trackList.size() >= PlayListHelper.getMaxTrackCount(user);
    }

    public Integer getId() {
        return playlistId;
    }


    public User getUser() {
        return user;
    }
}
