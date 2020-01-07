package lib;

import java.time.Instant;

public class User {

    private Integer userId;
    private String userName;
    private String password;
    private Instant created;

    public Integer getUserId() {
        return userId;
    }

    public Instant getCreated() {
        return created;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
