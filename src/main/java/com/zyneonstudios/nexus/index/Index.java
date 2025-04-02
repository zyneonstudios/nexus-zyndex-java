package com.zyneonstudios.nexus.index;

import com.zyneonstudios.nexus.instance.Instance;
import com.zyneonstudios.nexus.instance.ReadableZynstance;
import com.zyneonstudios.nexus.modules.ReadableModule;

import java.util.ArrayList;
import java.util.HashMap;

public interface Index {

    default String getOrigin() {
        return null;
    }

    default String getName() {
        return null;
    }

    default String getUrl() {
        return null;
    }

    default String getOwner() {
        return null;
    }

    default ArrayList<ReadableZynstance> getInstances() {
        return null;
    }

    default HashMap<String,ReadableZynstance> getInstancesById() {
        return null;
    }

    default ArrayList<ReadableModule> getModules() {
        return null;
    }

    default HashMap<String,ReadableModule> getModulesById() {
        return null;
    }
}