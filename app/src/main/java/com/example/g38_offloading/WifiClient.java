package com.example.g38_offloading;

public class WifiClient {
    private String ip;
    private String mac;
    private String device;
    private int rssi;

    public WifiClient(String ip, String mac, String device, int rssi) {
        this.ip = ip;
        this.mac = mac;
        this.device = device;
        this.rssi = rssi;
    }

    public String getIp() {
        return ip;
    }

    public String getMac() {
        return mac;
    }

    public String getDevice() {
        return device;
    }

    public int getRssi() {
        return rssi;
    }
}

