package db;

import io.reactivex.rxjava3.core.Observable;
import model.PlayList;
import model.Track;

public interface Database {

    /**
     * @param userId     unique user id.
     * @param playListId unique playlist id.
     * @return <code>PlayList</code> of the user.
     */
    Observable<PlayList<Track>> getPlayList(int userId, int playListId);

    /**
     * @param trackId unique track id.
     * @return <code>Track</code> object
     */
    Observable<Track> getTrack(int trackId);
}
