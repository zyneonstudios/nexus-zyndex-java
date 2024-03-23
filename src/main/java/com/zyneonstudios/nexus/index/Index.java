package com.zyneonstudios.nexus.index;

import com.zyneonstudios.nexus.instance.ReadableZynstance;

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

    default HashMap<String,ReadableZynstance> getZynstances() {
        return null;
    }
}