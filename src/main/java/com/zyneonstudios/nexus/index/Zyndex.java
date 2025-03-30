package com.zyneonstudios.nexus.index;

import com.google.gson.JsonArray;
import com.zyneonstudios.nexus.instance.ReadableZynstance;
import com.zyneonstudios.nexus.modules.ReadableModule;
import com.zyneonstudios.nexus.utilities.storage.JsonStorage;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Zyndex extends ReadableZyndex implements Index {

    private JsonStorage json;

    private String name = "";
    private String url = "";
    private String owner = "";
    private ArrayList<ReadableZynstance> zynstances;
    private ArrayList<ReadableModule> modules;

    private void init() {
        json.ensure("name","unnamed zyndex");
        json.ensure("url","null");
        json.ensure("owner","unknown");
        json.ensure("instances",new JsonArray());
        json.ensure("modules",new JsonArray());

        name = json.getString("name");
        url = json.getString("url");
        owner = json.getString("owner");

        this.zynstances = super.getInstances();
        this.modules = super.getModules();
    }

    public Zyndex(File json) {
        super(json);
        this.json = new JsonStorage(json);
        init();
    }

    public Zyndex(JsonStorage config) {
        super(config.getJsonFile());
        this.json = config;
        init();
    }

    public JsonStorage getJson() {
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
    public HashMap<String, ReadableZynstance> getInstancesById() {
        HashMap<String,ReadableZynstance> zynstances = new HashMap<>();
        for(ReadableZynstance zynstance:this.zynstances) {
            zynstances.put(zynstance.getId(),zynstance);
        }
        return zynstances;
    }

    @Override
    public ArrayList<ReadableModule> getModules() {
        return modules;
    }

    @Override
    public HashMap<String, ReadableModule> getModulesById() {
        HashMap<String,ReadableModule> modules = new HashMap<>();
        for(ReadableModule module:this.modules) {
            modules.put(module.getId(),module);
        }
        return modules;
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
        JsonArray array = new JsonArray();
        if(!instances.isEmpty()) {
            for (ReadableZynstance zynstance : instances) {
                array.add(zynstance.getLocation());
            }
        }
        zynstances = instances;
        json.set("instances",array);
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

    public void setModules(ArrayList<ReadableModule> modules) {
        json.delete("modules");
        JsonArray array = new JsonArray();
        if(!modules.isEmpty()) {
            for (ReadableModule module : modules) {
                array.add(module.getLocation());
            }
        }
        this.modules = modules;
        json.set("modules",array);
        System.gc();
    }

    public void addModule(ReadableModule module) {
        ArrayList<ReadableModule> modules = this.modules;
        if(!modules.contains(module)) {
            modules.add(module);
        }
        setModules(modules);
    }

    public void removeModule(ReadableModule module) {
        ArrayList<ReadableModule> modules = this.modules;
        modules.remove(module);
        setModules(modules);
    }
}