package by.tms.storage;

import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryUserStorage {
    private final List<User> users = new ArrayList<>();
    private long incId = 0;


    public void save(User user) {
        user.setId(incId++);
        users.add(user);
    }

    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User findByUserId(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public void delete(User user) {
        if (users != null && !users.isEmpty()) {
            for (User r : users) {
                if (user.getId() == r.getId()) {
                    users.remove(r);
                    return;
                }
            }
        }
    }

    public void editRole(long userId, int admin) {
        if (users != null && !users.isEmpty()) {
            for (User r : users) {
                if (r.getId() == userId) {
                    r.setAdmin(admin);
                    return;
                }
            }
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
