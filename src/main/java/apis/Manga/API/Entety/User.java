package apis.Manga.API.Entety;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long nutzerId;
    @JsonIgnore
    private String password;
    @Column(unique = true)
    private String username;
    @JsonIgnore
    @Column(unique = true)
    private String email;


    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Film> clips = new HashSet<>();


    public long getNutzerId() {
        return nutzerId;
    }

    public void setNutzerId(long nutzerId) {
        this.nutzerId = nutzerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void add(User user) {
    }



}
