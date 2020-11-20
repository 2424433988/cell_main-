package com.neusoft.domain;

public class Business {
    private Integer businessId;
    private String password;
    private String businessName;
    private String businessAddress;
    private String bussinessExplain;
    private Double starPrice;
    private Double deliveryPrice;

    public Business(Integer businessId, String password, String businessName, String businessAddress, String bussinessExplain, Double starPrice, Double deliveryPrice) {
        this.businessId = businessId;
        this.password = password;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.bussinessExplain = bussinessExplain;
        this.starPrice = starPrice;
        this.deliveryPrice = deliveryPrice;
    }

    public Business() {

    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBussinessExplain() {
        return bussinessExplain;
    }

    public void setBussinessExplain(String bussinessExplain) {
        this.bussinessExplain = bussinessExplain;
    }

    public Double getStarPrice() {
        return starPrice;
    }

    public void setStarPrice(Double starPrice) {
        this.starPrice = starPrice;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    @Override
    public String toString() {
        return "Business{" +
                "businessId=" + businessId +
                ", password='" + password + '\'' +
                ", businessName='" + businessName + '\'' +
                ", businessAddress='" + businessAddress + '\'' +
                ", bussinessExplain='" + bussinessExplain + '\'' +
                ", starPrice=" + starPrice +
                ", deliveryPrice=" + deliveryPrice +
                '}';
    }
}
