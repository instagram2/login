package models.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "users")
@NamedQueries(value =
        {
                @NamedQuery(name = "UserEntity.getAll",
                        query = "SELECT im FROM UserEntity im")
        })

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "created")
    private Instant created;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Instant getCreated() {
        return created;
    }

    public Integer getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
