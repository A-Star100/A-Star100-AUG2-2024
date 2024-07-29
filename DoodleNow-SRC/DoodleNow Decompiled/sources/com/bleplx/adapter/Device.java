package com.bleplx.adapter;

import java.util.List;
import java.util.UUID;

public class Device {
    private String id;
    private Integer mtu;
    private String name;
    private Integer rssi;
    private List<Service> services;

    public String getId() {
        return this.id;
    }

    public Integer getMtu() {
        return this.mtu;
    }

    public String getName() {
        return this.name;
    }

    public Integer getRssi() {
        return this.rssi;
    }

    public List<Service> getServices() {
        return this.services;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMtu(Integer num) {
        this.mtu = num;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRssi(Integer num) {
        this.rssi = num;
    }

    public void setServices(List<Service> list) {
        this.services = list;
    }

    public Device(String str, String str2) {
        this.id = str;
        this.name = str2;
    }

    public Service getServiceByUUID(UUID uuid) {
        List<Service> list = this.services;
        if (list == null) {
            return null;
        }
        for (Service next : list) {
            if (uuid.equals(next.getUuid())) {
                return next;
            }
        }
        return null;
    }
}
