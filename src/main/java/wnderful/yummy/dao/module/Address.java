package wnderful.yummy.dao.module;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long addressId;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8mb4")
    private String name;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8mb4")
    private String gender;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8mb4")
    private String location;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8mb4")
    private String detailAddress;

    @Column(nullable = false)
    private double lng;

    @Column(nullable = false)
    private double lat;

    @Column(nullable = false)
    private String phone;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name = "member_uid")
    private Member member;

    public Address() {
    }

    public Address(String name, String gender, String location, String detailAddress, double lng, double lat, String phone, Member member) {
        this.name = name;
        this.gender = gender;
        this.location = location;
        this.detailAddress = detailAddress;
        this.lng = lng;
        this.lat = lat;
        this.phone = phone;
        this.member = member;
    }

    public Long getAddressId() {
        return addressId;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getLocation() {
        return location;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public double getLng() {
        return lng;
    }

    public double getLat() {
        return lat;
    }

    public String getPhone() {
        return phone;
    }

    public Member getMember() {
        return member;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
