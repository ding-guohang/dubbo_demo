package com.guohangding.study;

import com.guohangding.study.common.api.InterfaceA;

/**
 * @author guohang.ding on 16-9-6
 */
public class ServiceA implements InterfaceA {

    public String methodA(String arg) {
        System.out.println(getClass().getSimpleName() + " arg=" + arg);
        return "methodA";
    }
}
