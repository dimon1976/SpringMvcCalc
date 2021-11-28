package by.tms.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private long id;
    private String name;
    private String userName;
    private String password;
    private int admin;

    public User(long id, String name, String login, String pass) {
        this.id = id;
        this.name = name;
        this.userName = login;
        this.password = pass;
    }

    public User(String name, String login, String pass) {
        this.name = name;
        this.userName = login;
        this.password = pass;
    }

    public User(long id, String name, String login, String pass, int admin) {
        this.id = id;
        this.name = name;
        this.userName = login;
        this.password = pass;
        this.admin = admin;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public void setName(String name) {
        this.name = name;
    }

}
