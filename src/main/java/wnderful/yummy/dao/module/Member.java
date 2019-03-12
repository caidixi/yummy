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

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private int xp;

    @Column(nullable = false)
    private int level;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "memberState_name")
    private MemberState memberState;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_addressId",referencedColumnName = "addressId")
    private Address address;

    @OneToMany(mappedBy  = "member",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Order> orderList;

    public Member() {
    }

    public Member(String name, String password, String phone, String email, MemberState memberState, Address address) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.xp = 0;
        this.level = 0;
        this.memberState = memberState;
        this.address = address;
        orderList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
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

    public Address getAddress() {
        return address;
    }

    public String getUid() {
        if(uid!=null){
            return Long.toString(uid);
        }else {
            return "";
        }
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

    public void setAddress(Address address) {
        this.address = address;
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
}
