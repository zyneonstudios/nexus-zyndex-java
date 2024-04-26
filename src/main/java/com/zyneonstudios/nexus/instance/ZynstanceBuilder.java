package com.zyneonstudios.nexus.instance;

import live.nerotv.shademebaby.file.Config;

import java.io.File;

public class ZynstanceBuilder {

    private final Config instance;
    private String author = null;
    private String background = null;
    private String description = null;
    private String downloadUrl = null;
    private String fabricVersion = null;
    private String forgeType = null;
    private String forgeVersion = null;
    private String icon = null;
    private Boolean isHidden = null;
    private String id = null;
    private String indexUrl = null;
    private String logo = null;
    private String minecraftVersion = null;
    private String modloader = null;
    private String name = null;
    private String location = null;
    private String origin = null;
    private String quiltVersion = null;
    private String neoForgeVersion = null;
    private String version = null;
    private String thumbnail = null;
    private final String schemeVersion = "2024.3";

    public ZynstanceBuilder(String path) {
        if(path.toLowerCase().endsWith(".json")) {
            instance = new Config(path);
        } else {
            instance = new Config(path+"/instance.json");
        }
        init();
    }

    public ZynstanceBuilder(File file) {
        if(file.isDirectory()) {
            instance = new Config(file.getAbsolutePath()+"/instance.json");
        } else {
            instance = new Config(file);
        }
        init();
    }

    public ZynstanceBuilder(Config config) {
        instance = config;
        init();
    }

    private void init() {
        author = "Unknown";
        instance.set("instance.info.author",author);
        description = "No description";
        instance.set("instance.info.description",description);
        name = "Unknown";
        instance.set("instance.info.name",name);
        version = "unknown";
        instance.set("instance.info.version",version);

        downloadUrl = "unknownUrl";
        instance.set("instance.meta.download",downloadUrl);

        id = "unknown";
        instance.set("instance.meta.id",id);
        isHidden = true;
        instance.set("instance.meta.isHidden",isHidden);
        location = "unknownUrl";
        instance.set("instance.meta.location",location);
        indexUrl = "unknownUrl";
        instance.set("instance.meta.origin",indexUrl);

        minecraftVersion = "unknown";
        instance.set("instance.versions.minecraft",minecraftVersion);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public void setForgeType(String forgeType) {
        this.forgeType = forgeType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public void setLocationUrl(String locationUrl) {
        this.location = locationUrl;
    }

    public void setOriginUrl(String indexUrl) {
        this.indexUrl = indexUrl;
    }

    public void setBackgroundUrl(String imageUrl) {
        this.background = imageUrl;
    }

    public void setIconUrl(String imageUrl) {
        this.icon = imageUrl;
    }

    public void setLogoUrl(String imageUrl) {
        this.logo = imageUrl;
    }

    public void setThumbnailUrl(String imageUrl) {
        this.thumbnail = imageUrl;
    }

    public void setFabricVersion(String fabricVersion) {
        this.fabricVersion = fabricVersion;
    }

    public void setForgeVersion(String forgeVersion) {
        this.forgeVersion = forgeVersion;
    }

    public void setMinecraftVersion(String minecraftVersion) {
        this.minecraftVersion = minecraftVersion;
    }

    public void setNeoForgeVersion(String neoForgeVersion) {
        this.neoForgeVersion = neoForgeVersion;
    }

    public void setQuiltVersion(String quiltVersion) {
        this.quiltVersion = quiltVersion;
    }

    public void setInfoProperty(infoPath infoPath, String value) {
        instance.set("instance.info."+infoPath.toString(), value);
    }

    public void setMetaProperty(metaPath metaPath, Object value) {
        instance.set("instance.meta."+metaPath.toString(), value);
    }

    public void setMetaProperty(String metaPath, Object value) {
        instance.set("instance.meta."+metaPath,value);
    }

    public void setResourceProperty(resourcePath resourcePath, String value) {
        instance.set("instance.resources."+resourcePath.toString(),value);
    }

    public void setVersionProperty(versionPath versionPath, String value) {
        instance.set("instance.versions."+versionPath.toString(),value);
    }

    public Zynstance create() {
        write();
        return new Zynstance(instance);
    }

    public File createFile() {
        write();
        return instance.getJsonFile();
    }

    public ReadableZynstance read() {
        return new ReadableZynstance(createFile());
    }

    private void write() {
        setInfoProperty(infoPath.author,author);
        setInfoProperty(infoPath.description,description);
        setInfoProperty(infoPath.name,name);
        setInfoProperty(infoPath.version,version);

        setMetaProperty(metaPath.download,downloadUrl);
        if(forgeType!=null) {
            setMetaProperty(metaPath.forgeType,forgeType);
        }
        setMetaProperty(metaPath.id,id);
        setMetaProperty(metaPath.isHidden,isHidden);
        setMetaProperty(metaPath.location,location);
        setMetaProperty(metaPath.origin,indexUrl);

        if(background!=null) {
            setResourceProperty(resourcePath.background, background);
        }
        if(icon!=null) {
            setResourceProperty(resourcePath.icon, icon);
        }
        if(logo!=null) {
            setResourceProperty(resourcePath.logo, logo);
        }
        if(thumbnail!=null) {
            setResourceProperty(resourcePath.thumbnail, thumbnail);
        }

        if(fabricVersion!=null) {
            setVersionProperty(versionPath.fabric,fabricVersion);
        }
        if(forgeVersion!=null) {
            setVersionProperty(versionPath.forge,forgeVersion);
        }
        setVersionProperty(versionPath.minecraft,minecraftVersion);
        if(neoForgeVersion!=null) {
            setVersionProperty(versionPath.neoforge,neoForgeVersion);
        }
        if(quiltVersion!=null) {
            setVersionProperty(versionPath.quilt,quiltVersion);
        }

        instance.set("scheme",schemeVersion);
    }

    public enum infoPath {
        author,
        description,
        name,
        version
    }

    public enum metaPath {
        download,
        forgeType,
        id,
        isHidden,
        location,
        origin
    }

    public enum resourcePath {
        background,
        icon,
        logo,
        thumbnail
    }

    public enum versionPath {
        fabric,
        forge,
        minecraft,
        neoforge,
        quilt
    }
}