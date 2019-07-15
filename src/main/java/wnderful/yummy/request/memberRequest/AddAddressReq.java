package wnderful.yummy.request.memberRequest;

public class AddAddressReq {
    private String uid;
    private String name;
    private String gender;
    private String location;
    private String detailAddress;
    private double lng;
    private double lat;
    private String phone;

    public AddAddressReq() {
    }

    public AddAddressReq(String uid, String name, String gender, String location, String detailAddress, double lng, double lat, String phone) {
        this.uid = uid;
        this.name = name;
        this.gender = gender;
        this.location = location;
        this.detailAddress = detailAddress;
        this.lng = lng;
        this.lat = lat;
        this.phone = phone;
    }

    public String getUid() {
        return uid;
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
}
