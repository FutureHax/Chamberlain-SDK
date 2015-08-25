
package com.futurehax.chamberlainsdk.models;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Devices {

    @Expose
    private List<Device> Devices = new ArrayList<Device>();
    @Expose
    private String ReturnCode;
    @Expose
    private String ErrorMessage;

    @Override
    public String toString() {
        return "Devices{" +
                "ErrorMessage='" + ErrorMessage + '\n' +
                ", Devices=" + Devices +
                '}';
    }

    /**
     * @return The Devices
     */
    public List<Device> getDevices() {
        return Devices;
    }

    /**
     * @param Devices The Devices
     */
    public void setDevices(List<Device> Devices) {
        this.Devices = Devices;
    }

    /**
     * @return The ReturnCode
     */
    public String getReturnCode() {
        return ReturnCode;
    }

    /**
     * @param ReturnCode The ReturnCode
     */
    public void setReturnCode(String ReturnCode) {
        this.ReturnCode = ReturnCode;
    }

    /**
     * @return The ErrorMessage
     */
    public String getErrorMessage() {
        return ErrorMessage;
    }

    /**
     * @param ErrorMessage The ErrorMessage
     */
    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

}
