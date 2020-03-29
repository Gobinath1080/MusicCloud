import java.util.List;

/**
 * Contract for adding, removing tracks to playlist.
 */
public interface MusicCloud {

    /**
     * Add the track to <code>playListId</code> for <code>userId</code>
     *
     * @param userId     unique user id.
     * @param playListId playlist id of the user.
     * @param trackId    unique track it.
     */
    void addTrack(int userId, int playListId, int trackId);

    /**
     * Add the list of tracks to <code>playListId</code> for <code>userId</code>
     *
     * @param userId     unique user id.
     * @param playListId playlist id of the user.
     * @param trackIds   unique track it.
     */
    void addTracks(int userId, int playListId, List<Integer> trackIds);

    /**
     * Remove the track from <code>playListId</code> for <code>userId</code>
     *
     * @param userId     unique user id.
     * @param playListId playlist id of the user.
     * @param trackId    unique track it.
     */
    void removeTrack(int userId, int playListId, int trackId);

    /**
     * Remove the list of tracks from <code>playListId</code> for <code>userId</code>
     *
     * @param userId     unique user id.
     * @param playListId playlist id of the user.
     * @param trackIds   list of track ids.
     */
    void removeTracks(int userId, int playListId, List<Integer> trackIds);

    /**
     * @param userId     unique user id.
     * @param playListId playlist id of the user.
     * @return the total duration of tracks in  <code>playListId</code>
     */
    float getDuration(int userId, int playListId);

}
