package com.pru.hk.ap.test;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;

class Albums {
    public String title;
    public String message;
    public List<String> errors = new ArrayList<String>();
    public String total;
    public int total_pages;
    public int page;
    public String limit;
}