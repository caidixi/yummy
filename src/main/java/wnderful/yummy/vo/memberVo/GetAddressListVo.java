package wnderful.yummy.vo.memberVo;

import wnderful.yummy.entity.voEntity.memberVo.AddressInfo;

import java.util.ArrayList;

public class GetAddressListVo {
    private ArrayList<AddressInfo> addressList;

    public GetAddressListVo() {
        this.addressList = new ArrayList<>();
    }

    public ArrayList<AddressInfo> getAddressList() {
        return addressList;
    }

    public void setAddressList(ArrayList<AddressInfo> addressList) {
        this.addressList = addressList;
    }

    public void addAddress(AddressInfo addressInfo){
        addressList.add(addressInfo);
    }
}
