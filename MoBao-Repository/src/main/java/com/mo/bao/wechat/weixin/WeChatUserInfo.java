package com.mo.bao.wechat.weixin;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hadoop on 2016/10/23.
 */
public class WeChatUserInfo implements Serializable {


    private static final long serialVersionUID = 3554660216568104615L;
    private Long wechatId;
    private String openid;
    private String nickName;
    private Byte sex;
    private String city;
    private String province;
    private String country;
    private String headimgurl;
    private String privilege;
    private String vipUserId;
    private String productId;
    private Date applyTime;
    private String latitude;
    private String longitude;
    private String wechatPrecision;

    public void setWechatId(Long wechatId) {
        this.wechatId = wechatId;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public void setVipUserId(String vipUserId) {
        this.vipUserId = vipUserId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setWechatPrecision(String wechatPrecision) {
        this.wechatPrecision = wechatPrecision;
    }

    public Long getWechatId() {
        return wechatId;
    }

    public String getOpenid() {
        return openid;
    }

    public String getNickName() {
        return nickName;
    }

    public Byte getSex() {
        return sex;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public String getPrivilege() {
        return privilege;
    }

    public String getVipUserId() {
        return vipUserId;
    }

    public String getProductId() {
        return productId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getWechatPrecision() {
        return wechatPrecision;
    }

    @Override
    public String toString() {
        return "WeChatUserInfo{" +
                "wechatId=" + wechatId +
                ", openid='" + openid + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", privilege='" + privilege + '\'' +
                ", vipUserId='" + vipUserId + '\'' +
                ", productId='" + productId + '\'' +
                ", applyTime=" + applyTime +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", wechatPrecision='" + wechatPrecision + '\'' +
                '}';
    }
}
