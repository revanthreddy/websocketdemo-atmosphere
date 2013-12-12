/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.websocketdemo;

import java.util.List;
import org.joda.time.DateTime;

/**
 *
 * @author rev
 */
public class Device {
    
    private String deviceType;
    private String deviceName;
    private boolean online;
    private String MAC;
    private String serialNumber;
    private boolean deviceRegistered;
    private String deviceOwner;
    private DateTime registeredDate;
    private boolean readOnly = true;
    private DateTime lastUpdated;
    private int unReadEvents;
    private List<String> tags;
    
    /**
     * @return the deviceType
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * @param deviceType the deviceType to set
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * @return the deviceName
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * @param deviceName the deviceName to set
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * @return the status
     */
    public boolean isOnline() {
        return online;
    }

    /**
     * @param status the status to set
     */
    public void setOnline(boolean online) {
        this.online = online;
    }

    /**
     * @return the MAC
     */
    public String getMAC() {
        return MAC;
    }

    /**
     * @param MAC the MAC to set
     */
    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    /**
     * @return the serialNumber
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * @param serialNumber the serialNumber to set
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * @return the deviceRegistered
     */
    public boolean isDeviceRegistered() {
        return deviceRegistered;
    }

    /**
     * @param deviceRegistered the deviceRegistered to set
     */
    public void setDeviceRegistered(boolean deviceRegistered) {
        this.deviceRegistered = deviceRegistered;
    }

    /**
     * @return the deviceOwner
     */
    public String getDeviceOwner() {
        return deviceOwner;
    }

    /**
     * @param deviceOwner the deviceOwner to set
     */
    public void setDeviceOwner(String deviceOwner) {
        this.deviceOwner = deviceOwner;
    }

    /**
     * @return the registeredDate
     */
    public DateTime getRegisteredDate() {
        return registeredDate;
    }

    /**
     * @param registeredDate the registeredDate to set
     */
    public void setRegisteredDate(DateTime registeredDate) {
        this.registeredDate = registeredDate;
    }

   
    /**
     * @return the readOnly
     */
    public boolean isReadOnly() {    
        return readOnly;
    }

    /**
     * @param readOnly the readOnly to set
     */
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * @return the lastUpdated
     */
    public DateTime getLastUpdated() {
        return lastUpdated;
    }

    /**
     * @param lastUpdated the lastUpdated to set
     */
    public void setLastUpdated(DateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * @return the unReadEvents
     */
    public int getUnReadEvents() {
        return unReadEvents;
    }

    /**
     * @param unReadEvents the unReadEvents to set
     */
    public void setUnReadEvents(int unReadEvents) {
        this.unReadEvents = unReadEvents;
    }

    /**
     * @return the tags
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
