package by.tms.service;

import by.tms.entity.User;
import by.tms.storage.InMemoryUserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class UserService {
    private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();
    private long incId = 1;

    @Autowired
    public UserService() {
    }

    public boolean register(User user) {
        if (verificationUserLogin(user)) {
            user.setId(incId++);
            if(inMemoryUserStorage.getUsers().isEmpty()){
                user.setAdmin(1);
            }
            inMemoryUserStorage.save(user);
            return true;
        }
        return false;
    }

    public boolean verificationUserLogin(User user) {
        if (inMemoryUserStorage.getUsers() != null) {
            if (!inMemoryUserStorage.getUsers().isEmpty()) {
                for (User us : inMemoryUserStorage.getUsers()) {
                    if (us.getUserName().equals(user.getUserName())) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }


    public User findByUsername(String name) {
        User user = inMemoryUserStorage.findByUsername(name);
        return user;
    }

    public User findByUserId(long id) {
        User user = inMemoryUserStorage.findByUserId(id);
        return user;
    }


    public void deleteUser(User user) {
        inMemoryUserStorage.delete(user);
    }

    public User editUser(User user, String name, String username, String password) {
        List<User> userList = inMemoryUserStorage.getUsers();
        if (userList != null && !userList.isEmpty()) {
            for (User r : userList) {
                if (user.getUserName().equals(r.getUserName())) {
                    r.setName(name);
                    r.setUserName(username);
                    r.setPassword(password);
                    return r;
                }
            }
        }
        return null;
    }

    public void useAdminMenu(String op, long userId) {
        User user = findByUserId(userId);
        switch (op) {
            case "del":
                deleteUser(user);
                break;
            case "adminon":
                inMemoryUserStorage.editRole(userId, 1);
                break;
            case "adminoff":
                inMemoryUserStorage.editRole(userId, 0);
                break;
            default:
                break;
        }
    }
    public List<User> findAllUsers() {
        return inMemoryUserStorage.getUsers();
    }
}
