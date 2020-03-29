package db.mock;


import model.User;

/**
 * Mock implementation of User object
 */
public class MockUser extends User {

    public MockUser(String username, int id, boolean isPro) {
        super(username, id, isPro);
    }

    @Override
    public int hashCode() {
        return getUsername().hashCode() + getId() * 31;
    }

    @Override
    public boolean equals(Object obj) {
        return getId() == ((User) obj).getId();
    }
}
