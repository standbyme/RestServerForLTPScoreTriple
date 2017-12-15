package com.model;

public class TripleWithSSID {
    public Triple triple;
    public int SSID;

    public TripleWithSSID(String headEntity, String relation, String tailEntity, int SSID) {
        triple = new Triple(headEntity,relation,tailEntity);
        this.SSID = SSID;
    }
}
