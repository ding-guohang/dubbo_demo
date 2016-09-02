package com.guohangding.study;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.support.ProtocolUtils;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        serviceKeyDemo();
    }

    private static void serviceKeyDemo() {
        // url = "http://127.0.0.1:8999/com.guohangding.study.dubbo_demo.demoService?group=demo_group&version=1.0.0&timeout=1000"
        URL url = new URL("http", "127.0.0.1", 8999, "com.guohangding.study.dubbo_demo.demoService",
                Constants.GROUP_KEY, "demo_group", Constants.VERSION_KEY, "1.0.0", Constants.TIMEOUT_KEY, "1000");
        String s = ProtocolUtils.serviceKey(url);
        // s = demo_group/com.guohangding.study.dubbo_demo.demoService:1.0.0:8999
        System.out.println(s);
    }
}
