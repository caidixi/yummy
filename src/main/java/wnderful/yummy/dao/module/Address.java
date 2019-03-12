package wnderful.yummy.dao.module;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long addressId;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String locationInfo1;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String locationInfo2;

    @Column(nullable = false,columnDefinition = "varchar(255) character set utf8")
    private String locationInfo3;

    public Address() {
    }

    public Address(String locationInfo1, String locationInfo2, String locationInfo3) {
        this.locationInfo1 = locationInfo1;
        this.locationInfo2 = locationInfo2;
        this.locationInfo3 = locationInfo3;
    }

    public Long getAddressId() {
        return addressId;
    }

    public String getLocationInfo1() {
        return locationInfo1;
    }

    public String getLocationInfo2() {
        return locationInfo2;
    }

    public String getLocationInfo3() {
        return locationInfo3;
    }

    public void setLocationInfo1(String locationInfo1) {
        this.locationInfo1 = locationInfo1;
    }

    public void setLocationInfo2(String locationInfo2) {
        this.locationInfo2 = locationInfo2;
    }

    public void setLocationInfo3(String locationInfo3) {
        this.locationInfo3 = locationInfo3;
    }
}
