package wnderful.yummy.vo.memberVo;

import wnderful.yummy.util.PriceHelper;

public class GetMemInfoVo {
    private String uid;
    private String name;
    private String phone;
    private String email;
    private int level;
    private int xp;
    private double memberDiscount;
    private String address1;
    private String address2;
    private String address3;

    public GetMemInfoVo() {
    }

    public GetMemInfoVo(String uid, String name, String phone, String email, int level, int xp, String address1, String address2, String address3) {
        this.uid = uid;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.level = level;
        this.xp = xp;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.memberDiscount = PriceHelper.getMemberDiscount(level);
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getLevel() {
        return level;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getAddress3() {
        return address3;
    }

    public String getEmail() {
        return email;
    }

    public int getXp() {
        return xp;
    }

    public double getMemberDiscount() {
        return memberDiscount;
    }
}
