package com.futurehax.chamberlainsdk.models;

/**
 * Created by Ken Kyger on 8/20/15.
 * Github - r2DoesInc
 * Email - r2DoesInc@futurehax.com
 */
public enum MyQDeviceTypes {
    GATEWAY(1, "Gateway"),
    GARAGE_DOOR_OPENER(2, "GarageDoorOpener"),
    VIRTUAL_GARAGE_DOOR_OPENER(7, "VGDO");

    int MyQDeviceTypeId;

    public int getMyQDeviceTypeId() {
        return MyQDeviceTypeId;
    }

    public String getMyQDeviceTypeName() {
        return MyQDeviceTypeName;
    }

    String MyQDeviceTypeName;

    MyQDeviceTypes(int myQDeviceTypeId, String myQDeviceTypeName) {
        MyQDeviceTypeId = myQDeviceTypeId;
        MyQDeviceTypeName = myQDeviceTypeName;
    }
}
