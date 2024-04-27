package com.zyneonstudios.nexus.index;

import com.google.gson.*;
import com.zyneonstudios.nexus.instance.ReadableZynstance;
import live.nerotv.shademebaby.file.Config;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Zyndex extends ReadableZyndex {

    private Config json;

    private String name = "";
    private String url = "";
    private String owner = "";

    private ArrayList<ReadableZynstance> zynstances;

    private void init() {
        json.checkEntry("name","unknown");
        json.checkEntry("name","url");
        json.checkEntry("name","owner");

        name = json.getString("name");
        url = json.getString("url");
        owner = json.getString("owner");
        this.zynstances = super.getInstances();
    }

    public Zyndex(File json) {
        super(json);
        this.json = new Config(json);
        init();
    }

    public Zyndex(Config config) {
        super(config.getJsonFile());
        this.json = config;
        init();
    }

    public Config getJson() {
        return json;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String getOwner() {
        return this.owner;
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

    public void setJson(Config newJson) {
        this.json = newJson;
    }

    public void setName(String newName) {
        this.json.set("name",newName);
        this.name = newName;
    }

    public void setUrl(String newUrl) {
        this.json.set("url",newUrl);
        this.url = newUrl;
    }

    public void setOwner(String newOwner) {
        this.json.set("owner",newOwner);
        this.owner = newOwner;
    }

    public void setInstances(ArrayList<ReadableZynstance> instances) {
        json.delete("instances");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray array = gson.fromJson("[]",JsonArray.class);
        if(!instances.isEmpty()) {
            for (ReadableZynstance zynstance : instances) {
                array.add(zynstance.getLocation());
            }
        }
        zynstances = instances;
        System.gc();
    }

    public void addInstance(ReadableZynstance zynstance) {
        ArrayList<ReadableZynstance> instances = zynstances;
        if(!instances.contains(zynstance)) {
            instances.add(zynstance);
        }
        setInstances(instances);
    }

    public void removeInstance(ReadableZynstance zynstance) {
        ArrayList<ReadableZynstance> instances = zynstances;
        instances.remove(zynstance);
        setInstances(instances);
    }
}