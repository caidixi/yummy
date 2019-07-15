package wnderful.yummy.dao.module;

import wnderful.yummy.util.PriceHelper;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long uid;

    @Column(nullable = false,unique = true,columnDefinition = "varchar(255) character set utf8mb4")
    private String name;

    @Column(nullable = false,unique = true)
    private String phone;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int xp;

    @Column(nullable = false)
    private int level;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8mb4")
    private String avatar;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "memberState_name")
    private MemberState memberState;

    @OneToMany(mappedBy  = "member",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Address> address;

    @OneToMany(mappedBy  = "member",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Order> orderList;

    @OneToMany(mappedBy  = "member",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<RestaurantCollection> collections;

    public Member() {
    }

    public Member(String phone, String password,String name,String avatar,MemberState memberState) {
        this.password = password;
        this.phone = phone;
        this.name = name;
        this.avatar = avatar;
        this.memberState = memberState;
        this.xp = 0;
        this.level = 0;
        address = new ArrayList<>();
        orderList = new ArrayList<>();
        collections = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public MemberState getMemberState() {
        return memberState;
    }

    public String getPassword() {
        return password;
    }

    public List<Address> getAddress() {
        return address;
    }

    public List<RestaurantCollection> getCollections() {
        return collections;
    }

    public String getUid() {
        if(uid!=null){
            return Long.toString(uid);
        }else {
            return "";
        }
    }

    public String getAvatar() {
        return avatar;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMemberState(MemberState memberState) {
        this.memberState = memberState;
    }

    public void addXp(int xp){
        this.xp = this.xp+xp;
        level = PriceHelper.getMemberLevel(this.xp);
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
