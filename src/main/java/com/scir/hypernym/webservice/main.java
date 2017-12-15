package com.scir.hypernym.webservice;

import com.model.TripleWithSSID;

import java.util.ArrayList;

public class main {
    public static void main(String args[]) {
        ArrayList<TripleWithSSID> tws_s = new ArrayList<TripleWithSSID>();
        tws_s.add(new TripleWithSSID("德国", "家", "康德", 1));
        tws_s.add(new TripleWithSSID("中国学生", "选择到", "美国", 0));
        tws_s.add(new TripleWithSSID("全国人大", "代表", "朱列玉", 1));
        dealResult a = new dealResult();
        System.out.println(a.pack(tws_s));
        System.out.println(a.pack(tws_s));

    }
}
