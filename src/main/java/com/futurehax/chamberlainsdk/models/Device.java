
package com.futurehax.chamberlainsdk.models;


import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Device {

    @Expose
    private Integer MyQDeviceId;
    @Expose
    private Integer MyQDeviceTypeId;
    @Expose
    private String MyQDeviceTypeName;
    @Expose
    private String DeviceId;
    @Expose
    private String DeviceName;
    @Expose
    private Integer TypeId;
    @Expose
    private String TypeName;
    @Expose
    private String RegistrationDateTime;
    @Expose
    private String SerialNumber;
    @Expose
    private String UserName;
    @Expose
    private Integer UserConnectServerId;
    @Expose
    private Integer UserCountryId;
    @Expose
    private List<Attribute> Attributes = new ArrayList<Attribute>();
    @Expose
    private String UpdatedBy;
    @Expose
    private String UpdatedDate;
    @Expose
    private Integer ParentMyQDeviceId;

    /**
     * @return The MyQDeviceId
     */
    public Integer getMyQDeviceId() {
        return MyQDeviceId;
    }

    /**
     * @param MyQDeviceId The MyQDeviceId
     */
    public void setMyQDeviceId(Integer MyQDeviceId) {
        this.MyQDeviceId = MyQDeviceId;
    }

    /**
     * @return The MyQDeviceTypeId
     */
    public Integer getMyQDeviceTypeId() {
        return MyQDeviceTypeId;
    }

    /**
     * @param MyQDeviceTypeId The MyQDeviceTypeId
     */
    public void setMyQDeviceTypeId(Integer MyQDeviceTypeId) {
        this.MyQDeviceTypeId = MyQDeviceTypeId;
    }

    /**
     * @return The MyQDeviceTypeName
     */
    public String getMyQDeviceTypeName() {
        return MyQDeviceTypeName;
    }

    /**
     * @param MyQDeviceTypeName The MyQDeviceTypeName
     */
    public void setMyQDeviceTypeName(String MyQDeviceTypeName) {
        this.MyQDeviceTypeName = MyQDeviceTypeName;
    }

    /**
     * @return The DeviceId
     */
    public String getDeviceId() {
        return DeviceId;
    }

    /**
     * @param DeviceId The DeviceId
     */
    public void setDeviceId(String DeviceId) {
        this.DeviceId = DeviceId;
    }

    /**
     * @return The DeviceName
     */
    public String getDeviceName() {
        return DeviceName;
    }

    /**
     * @param DeviceName The DeviceName
     */
    public void setDeviceName(String DeviceName) {
        this.DeviceName = DeviceName;
    }

    /**
     * @return The TypeId
     */
    public Integer getTypeId() {
        return TypeId;
    }

    /**
     * @param TypeId The TypeId
     */
    public void setTypeId(Integer TypeId) {
        this.TypeId = TypeId;
    }

    /**
     * @return The TypeName
     */
    public String getTypeName() {
        return TypeName;
    }

    /**
     * @param TypeName The TypeName
     */
    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }

    /**
     * @return The RegistrationDateTime
     */
    public String getRegistrationDateTime() {
        return RegistrationDateTime;
    }

    /**
     * @param RegistrationDateTime The RegistrationDateTime
     */
    public void setRegistrationDateTime(String RegistrationDateTime) {
        this.RegistrationDateTime = RegistrationDateTime;
    }

    /**
     * @return The SerialNumber
     */
    public String getSerialNumber() {
        return SerialNumber;
    }

    /**
     * @param SerialNumber The SerialNumber
     */
    public void setSerialNumber(String SerialNumber) {
        this.SerialNumber = SerialNumber;
    }

    /**
     * @return The UserName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * @param UserName The UserName
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    /**
     * @return The UserConnectServerId
     */
    public Integer getUserConnectServerId() {
        return UserConnectServerId;
    }

    /**
     * @param UserConnectServerId The UserConnectServerId
     */
    public void setUserConnectServerId(Integer UserConnectServerId) {
        this.UserConnectServerId = UserConnectServerId;
    }

    /**
     * @return The UserCountryId
     */
    public Integer getUserCountryId() {
        return UserCountryId;
    }

    /**
     * @param UserCountryId The UserCountryId
     */
    public void setUserCountryId(Integer UserCountryId) {
        this.UserCountryId = UserCountryId;
    }

    /**
     * @return The Attributes
     */
    public List<Attribute> getAttributes() {
        return Attributes;
    }

    /**
     * @param Attributes The Attributes
     */
    public void setAttributes(List<Attribute> Attributes) {
        this.Attributes = Attributes;
    }

    /**
     * @return The UpdatedBy
     */
    public String getUpdatedBy() {
        return UpdatedBy;
    }

    /**
     * @param UpdatedBy The UpdatedBy
     */
    public void setUpdatedBy(String UpdatedBy) {
        this.UpdatedBy = UpdatedBy;
    }

    /**
     * @return The UpdatedDate
     */
    public String getUpdatedDate() {
        return UpdatedDate;
    }

    /**
     * @param UpdatedDate The UpdatedDate
     */
    public void setUpdatedDate(String UpdatedDate) {
        this.UpdatedDate = UpdatedDate;
    }

    @Override
    public String toString() {
        return "Device{" +
                "MyQDeviceId=" + MyQDeviceId + '\n' +
                ", MyQDeviceTypeId=" + MyQDeviceTypeId + '\n' +
                ", MyQDeviceTypeName='" + MyQDeviceTypeName + '\n' +
                ", DeviceId='" + DeviceId + '\n' +
                ", DeviceName='" + DeviceName + '\n' +
                ", TypeId=" + TypeId + '\n' +
                ", TypeName='" + TypeName + '\n' +
                ", RegistrationDateTime='" + RegistrationDateTime + '\n' +
                ", SerialNumber='" + SerialNumber + '\n' +
                ", UserName='" + UserName + '\n' +
                ", UserConnectServerId=" + UserConnectServerId + '\n' +
                ", UserCountryId=" + UserCountryId + '\n' +
                ", Attributes=" + Attributes + '\n' +
                ", UpdatedBy='" + UpdatedBy + '\n' +
                ", UpdatedDate='" + UpdatedDate + '\n' +
                ", ParentMyQDeviceId=" + ParentMyQDeviceId +
                '}';
    }

    /**
     * @return The ParentMyQDeviceId
     */
    public Integer getParentMyQDeviceId() {
        return ParentMyQDeviceId;
    }

    /**
     * @param ParentMyQDeviceId The ParentMyQDeviceId
     */
    public void setParentMyQDeviceId(Integer ParentMyQDeviceId) {
        this.ParentMyQDeviceId = ParentMyQDeviceId;
    }

}
