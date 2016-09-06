package com.guohangding.study;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Exporter;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.rpc.ProxyFactory;
import com.alibaba.dubbo.rpc.support.ProtocolUtils;
import com.guohangding.study.common.api.InterfaceA;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
//        serviceKeyDemo();
        localExportDemo();
    }

    private static void serviceKeyDemo() {
        // url = "http://127.0.0.1:8999/com.guohangding.study.dubbo_demo.demoService?group=demo_group&version=1.0.0&timeout=1000"
        URL url = new URL("http", "127.0.0.1", 8999, "com.guohangding.study.dubbo_demo.demoService",
                Constants.GROUP_KEY, "demo_group", Constants.VERSION_KEY, "1.0.0", Constants.TIMEOUT_KEY, "1000");
        String s = ProtocolUtils.serviceKey(url);
        // s = demo_group/com.guohangding.study.dubbo_demo.demoService:1.0.0:8999
        System.out.println(s);
    }

    private static void localExportDemo() {
        URL url = new URL("dubbo", "0.0.0.0", 9999, "com.guohangding.study.common.api.InterfaceA",
                Constants.GROUP_KEY, "my_group", Constants.VERSION_KEY, "1.0.0",
                Constants.SCOPE_REMOTE, "remote");

        Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
        ProxyFactory factory = ExtensionLoader.getExtensionLoader(ProxyFactory.class).getAdaptiveExtension();

        Exporter exporter = protocol.export(factory.getInvoker(new ServiceDemo(), InterfaceA.class, url));

        InterfaceA face = factory.getProxy(protocol.refer(InterfaceA.class, url));
        face.methodA("demossss");

        exporter.unexport();
        face = factory.getProxy(protocol.refer(InterfaceA.class, url));
        face.methodA("ss");
    }
}
