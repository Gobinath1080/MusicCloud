package model;

/**
 * Models the User data.
 */
public class User {

    private String username;
    // Unique user id
    private int id;
    // Tells whether pro features are enabled for the user.
    private boolean isPro;

    public User(String username, int id, boolean isPro) {
        this.username = username;
        this.id = id;
        this.isPro = isPro;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPro() {
        return isPro;
    }

    public void setPro(boolean pro) {
        isPro = pro;
    }
}
