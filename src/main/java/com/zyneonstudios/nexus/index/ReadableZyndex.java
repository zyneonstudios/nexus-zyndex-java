package com.zyneonstudios.nexus.index;

import com.google.gson.*;
import com.zyneonstudios.nexus.Main;
import com.zyneonstudios.nexus.instance.ReadableZynstance;
import live.nerotv.shademebaby.utils.GsonUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadableZyndex implements Index {

    private final String origin;
    private String name = null;
    private String url = null;
    private String owner = null;
    private ArrayList<ReadableZynstance> zynstances;

    private void init(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject json1 = gson.fromJson(json, JsonObject.class);
        try {
            this.name = json1.get("name").getAsString();
            this.url = json1.get("url").getAsString();
            this.owner = json1.get("owner").getAsString();

            this.zynstances = new ArrayList<>();
            JsonArray array = json1.get("instances").getAsJsonArray();
            for(JsonElement e:array) {
                this.zynstances.add(new ReadableZynstance(e.getAsString()));
            }
        } catch (Exception e) {
            Main.logger.error("Couldn't initialize ReadableZyndex - JSON Format error: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public ReadableZyndex(String url) {
        origin = url;
        try {
            init(GsonUtil.getFromURL(url));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ReadableZyndex(File file) {
        origin = file.getAbsolutePath();
        try {
            init(GsonUtil.getFromFile(file));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getOrigin() {
        return origin;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public ArrayList<ReadableZynstance> getInstances() {
        return zynstances;
    }

    @Override
    public HashMap<String, ReadableZynstance> getZynstances() {
        HashMap<String, ReadableZynstance> zynstances = new HashMap<>();
        for(ReadableZynstance zynstance:this.zynstances) {
            zynstances.put(zynstance.getId(),zynstance);
        }
        return zynstances;
    }
}