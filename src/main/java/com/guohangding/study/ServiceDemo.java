package com.guohangding.study;

import com.guohangding.study.common.api.InterfaceA;

/**
 * @author guohang.ding on 16-9-6
 */
public class ServiceDemo implements InterfaceA {

    public String methodA(String arg) {
        System.out.println("in service demos");
        return "demo";
    }
}
