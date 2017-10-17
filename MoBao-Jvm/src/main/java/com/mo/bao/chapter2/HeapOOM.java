package com.mo.bao.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2017/10/17.
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

}
