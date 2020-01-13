package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("phone")
public class Phone {

    public String phone;
    public String mobilePhone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
