package com.zyneonstudios.nexus;

import com.zyneonstudios.nexus.index.ReadableZyndex;
import com.zyneonstudios.nexus.instance.ReadableZynstance;
import live.nerotv.shademebaby.logger.Logger;

public class Main {

    public static Logger logger = new Logger("ZDX");
    public static String[] args = null;

    public static void main(String[] a) {
        args = a;
        ReadableZyndex index = new ReadableZyndex("https://raw.githubusercontent.com/zyneonstudios/nexus-nex/main/zyndex/index.json");
        for(ReadableZynstance instance:index.getInstances()) {
            System.out.println(instance.getName());
        }
    }
}
