package com.allanwang.lottery.domain.award.model.vo;

/**
 * @description: Physical Goods Delivery 4-level Address
 */
public class ShippingAddress {

    /** receiver */
    private String name;

    /**
     * 1 ID
     * */
    private String provinceId;
    /** first level address name
     * */
    private String provinceName;

    /** second level address ID
     */
    private String cityId;
    /** second level address name
     * */
    private String cityName;

    /** third level address ID */

    private String countyId;
    /** third level address name
     * */
    private String countyName;

    /** fourth level address ID */
    private String townId;
    /** fourth level address name
     * */
    private String townName;

    /** extended address */
    private String address;

    /** phone */
    private String phone;
    /** email */
    private String email;
    /** remark */
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getTownId() {
        return townId;
    }

    public void setTownId(String townId) {
        this.townId = townId;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
