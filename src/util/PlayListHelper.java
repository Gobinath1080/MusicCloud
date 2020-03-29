package util;


import model.User;

public class PlayListHelper {

    /**
     * @param user the user object.
     * @return the number of tracks supported per playlist of the <code>user</code>
     */
    public static int getMaxTrackCount(User user) {
        return user.isPro() ? 200 : 100;
    }
}
