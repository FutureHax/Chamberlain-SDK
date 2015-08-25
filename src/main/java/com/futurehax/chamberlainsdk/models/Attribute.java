
package com.futurehax.chamberlainsdk.models;


import com.google.gson.annotations.Expose;

public class Attribute {

    @Expose
    private String Name;
    @Expose
    private String Value;
    @Expose
    private String UpdatedTime;
    @Expose
    private Integer MyQDeviceTypeAttributeId;
    @Expose
    private Boolean IsDeviceProperty;
    @Expose
    private Boolean IsPersistent;
    @Expose
    private Boolean IsTimeSeries;
    @Expose
    private Boolean IsGlobal;
    @Expose
    private String UpdatedDate;

    /**
     * @return The Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name The Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return The Value
     */
    public String getValue() {
        return Value;
    }

    /**
     * @param Value The Value
     */
    public void setValue(String Value) {
        this.Value = Value;
    }

    /**
     * @return The UpdatedTime
     */
    public String getUpdatedTime() {
        return UpdatedTime;
    }

    /**
     * @param UpdatedTime The UpdatedTime
     */
    public void setUpdatedTime(String UpdatedTime) {
        this.UpdatedTime = UpdatedTime;
    }

    /**
     * @return The MyQDeviceTypeAttributeId
     */
    public Integer getMyQDeviceTypeAttributeId() {
        return MyQDeviceTypeAttributeId;
    }

    /**
     * @param MyQDeviceTypeAttributeId The MyQDeviceTypeAttributeId
     */
    public void setMyQDeviceTypeAttributeId(Integer MyQDeviceTypeAttributeId) {
        this.MyQDeviceTypeAttributeId = MyQDeviceTypeAttributeId;
    }

    /**
     * @return The IsDeviceProperty
     */
    public Boolean getIsDeviceProperty() {
        return IsDeviceProperty;
    }

    /**
     * @param IsDeviceProperty The IsDeviceProperty
     */
    public void setIsDeviceProperty(Boolean IsDeviceProperty) {
        this.IsDeviceProperty = IsDeviceProperty;
    }

    /**
     * @return The IsPersistent
     */
    public Boolean getIsPersistent() {
        return IsPersistent;
    }

    /**
     * @param IsPersistent The IsPersistent
     */
    public void setIsPersistent(Boolean IsPersistent) {
        this.IsPersistent = IsPersistent;
    }

    /**
     * @return The IsTimeSeries
     */
    public Boolean getIsTimeSeries() {
        return IsTimeSeries;
    }

    /**
     * @param IsTimeSeries The IsTimeSeries
     */
    public void setIsTimeSeries(Boolean IsTimeSeries) {
        this.IsTimeSeries = IsTimeSeries;
    }

    /**
     * @return The IsGlobal
     */
    public Boolean getIsGlobal() {
        return IsGlobal;
    }

    /**
     * @param IsGlobal The IsGlobal
     */
    public void setIsGlobal(Boolean IsGlobal) {
        this.IsGlobal = IsGlobal;
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

}
