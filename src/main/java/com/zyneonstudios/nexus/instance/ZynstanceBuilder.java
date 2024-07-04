package com.zyneonstudios.nexus.instance;

import live.nerotv.shademebaby.file.Config;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ZynstanceBuilder {

    private final Config instance;
    private ArrayList<String> authors = null;
    private String background = null;
    private String description = "This is an unknown instance for which there is no description.";
    private String downloadUrl = "no url";
    private String fabricVersion = null;
    private String forgeType = null;
    private String forgeVersion = null;
    private String icon = null;
    private boolean isEditable = false;
    private boolean isHidden = true;
    private String id = "unknown";
    private String infoCard = null;
    private String infoText = null;
    private String indexUrl = "no index";
    private String logo = null;
    private String minecraftVersion = "1.21";
    private String name = "Unknown";
    private String location = null;
    private String origin = "no origin";
    private String quiltVersion = null;
    private String neoForgeVersion = null;
    private String version = new SimpleDateFormat("yyyy.M.d").format(Calendar.getInstance().getTime());;
    private final String schemeVersion = "2024.6";
    private String summary = "This is an unknown instance for which there is no summary.";
    private ArrayList<String> tags = null;
    private String thumbnail = null;

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
        ArrayList<String> a = new ArrayList<>();
        a.add("Anonymous");
        authors = a;

        instance.set("instance.info.authors",authors);
        instance.set("instance.info.name",name);
        instance.set("instance.info.summary",summary);
        instance.set("instance.info.version",version);

        instance.set("instance.meta.description",description);
        instance.set("instance.meta.download",downloadUrl);
        instance.set("instance.meta.id",id);
        instance.set("instance.meta.isEditable",isEditable);
        instance.set("instance.meta.isHidden",isHidden);
        location = "file://"+instance.getJsonFile().getAbsolutePath().replace("\\\\","\\").replace("\\","/");
        instance.set("instance.meta.location",location);
        origin = location;
        instance.set("instance.meta.origin",indexUrl);
        tags = new ArrayList<>();
        instance.set("instance.meta.tags",tags);
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setEditable(boolean editable) {
        isEditable = editable;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public void setLocationUrl(String locationUrl) {
        this.location = locationUrl;
    }

    public void setOriginUrl(String indexUrl) {
        this.indexUrl = indexUrl;
    }

    public void setInfoCard(String infoCard) {
        this.infoCard = infoCard;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
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

    public void setInfoProperty(infoPath infoPath, Object value) {
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
        setInfoProperty(infoPath.authors,authors);
        setInfoProperty(infoPath.name,name);
        setInfoProperty(infoPath.summary,summary);
        setInfoProperty(infoPath.version,version);

        setMetaProperty(metaPath.description,description);
        setMetaProperty(metaPath.download,downloadUrl);
        if(forgeType!=null) {
            setMetaProperty(metaPath.forgeType,forgeType);
        }
        setMetaProperty(metaPath.id,id);
        setMetaProperty(metaPath.isEditable,isEditable);
        setMetaProperty(metaPath.isHidden,isHidden);
        setMetaProperty(metaPath.location,location);
        setMetaProperty(metaPath.origin,indexUrl);
        setMetaProperty(metaPath.tags,tags);

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
        authors,
        name,
        summary,
        version
    }

    public enum metaPath {
        description,
        download,
        forgeType,
        id,
        isEditable,
        isHidden,
        infoCard,
        infoText,
        location,
        origin,
        tags
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