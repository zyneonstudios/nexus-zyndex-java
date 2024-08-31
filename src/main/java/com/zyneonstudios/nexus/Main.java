package com.zyneonstudios.nexus;

import com.zyneonstudios.nexus.utilities.NexusUtilities;
import com.zyneonstudios.nexus.utilities.logger.NexusLogger;

public class Main {

    public static NexusLogger logger = NexusUtilities.getLogger();

    public static void main(String[] a) {
        logger.log("=======================================================");
        logger.log("This is the Zyndex API by Zyneon Nexus");
        logger.log("https://nexus.zyneonstudios.com");
        logger.log("https://github.com/zyneonstudios/nexus-zyndex-java");
        logger.log("=======================================================");
    }
}
