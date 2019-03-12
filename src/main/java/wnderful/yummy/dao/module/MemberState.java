package wnderful.yummy.dao.module;

import javax.persistence.*;
import java.util.List;

@Entity
public class MemberState {
    @Id
    @Column(nullable = false,unique = true)
    private String name;

    @OneToMany(mappedBy  = "memberState",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Member> memberList;

    public String getName() {
        return name;
    }

    public MemberState() {
    }

    public MemberState(String name) {
        this.name = name;
    }
}
