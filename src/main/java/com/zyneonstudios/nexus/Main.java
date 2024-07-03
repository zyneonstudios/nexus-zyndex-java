package com.zyneonstudios.nexus;

import com.zyneonstudios.nexus.instance.Instance;
import com.zyneonstudios.nexus.instance.ReadableZynstance;
import live.nerotv.shademebaby.logger.Logger;

import java.io.File;

public class Main {

    public static Logger logger = new Logger("ZDX");

    public static void main(String[] a) {
        logger.log("=======================================================");
        logger.log("This is the Zyndex API by Zyneon Nexus");
        logger.log("https://nexus.zyneonstudios.com");
        logger.log("https://github.com/zyneonstudios/nexus-zyndex-java");
        logger.log("=======================================================");
        Instance i = new ReadableZynstance(new File("B:/Workspaces/IntelliJ/nexus-nex/zyndex/instances/official/argria2.json"));
        System.out.println(i.getAuthor()+", "+i.getTags());
    }
}
