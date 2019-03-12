package wnderful.yummy.dao.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Manager {
    @Id
    private Long mid;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,columnDefinition ="varchar(255) character set utf8")
    private String name;

    @Column(nullable = false)
    private String password;

    public Manager() {
    }

    public Manager(Long mid, String email, String name, String password) {
        this.mid = mid;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public Long getMid() {
        return mid;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
