package com.zyneonstudios.nexus.instance;

import com.zyneonstudios.nexus.utilities.storage.JsonStorage;

import java.io.File;
import java.util.ArrayList;

public class Zynstance extends ReadableZynstance implements Instance {

    private ArrayList<String> authors;
    private String background;
    private final JsonStorage config;
    private ArrayList<String> changelogs;
    private ArrayList<String> versions;
    private String description;
    private String downloadUrl;
    private String fabricVersion;
    private String forgeType;
    private String forgeVersion;
    private String iconUrl;
    private boolean isEditable;
    private boolean isHidden;
    private String id;
    private String indexUrl;
    private String infoCard;
    private String infoText;
    private String logoUrl;
    private String minecraftVersion;
    private String modloader;
    private String name;
    private String location;
    private final String origin;
    private String neoForgeVersion;
    private String quiltVersion;
    private String version;
    private String schemeVersion;
    private String summary;
    private ArrayList<String> tags;
    private String thumbnailUrl;

    private void init() {
        this.authors = (ArrayList<String>)config.get("instance.info.authors");
        this.background = config.getString("instance.resources.background");
        if(config.get("instance.meta.changelogs")!=null) {
            this.changelogs = (ArrayList<String>)config.get("instance.info.changelogs");
        } else {
            this.changelogs = new ArrayList<>();
        }
        this.description = config.getString("instance.meta.description");
        this.downloadUrl = config.getString("instance.meta.download");
        this.fabricVersion = config.getString("instance.versions.fabric");
        this.forgeType = config.getString("instance.meta.forgeType");
        this.forgeVersion = config.getString("instance.versions.forge");
        this.iconUrl = config.getString("instance.resources.icon");
        this.isEditable = config.getBoolean("instance.meta.isEditable");
        this.isHidden = config.getBoolean("instance.meta.isHidden");
        this.id = config.getString("instance.meta.id");
        this.location = config.getString("instance.meta.location");
        this.indexUrl = config.getString("instance.meta.origin");
        this.infoCard = config.getString("instance.meta.infoCard");
        this.infoText = config.getString("instance.meta.infoText");
        if(config.get("instance.meta.versions")!=null) {
            this.versions = (ArrayList<String>)config.get("instance.meta.versions");
        } else {
            this.versions = new ArrayList<>();
        }
        this.logoUrl = config.getString("instance.resources.logo");
        this.minecraftVersion = config.getString("instance.versions.minecraft");
        this.name = config.getString("instance.info.name");
        this.neoForgeVersion = config.getString("instance.versions.neoforge");
        this.quiltVersion = config.getString("instance.versions.quilt");
        this.version = config.getString("instance.info.version");
        this.summary = config.getString("instance.info.summary");
        this.schemeVersion = config.getString("scheme");
        if(config.get("instance.meta.tags")!=null) {
            this.tags = (ArrayList<String>)config.get("instance.meta.tags");
        } else {
            this.tags = new ArrayList<>();
        }
        this.thumbnailUrl = config.getString("instance.resources.thumbnail");
        if(quiltVersion!=null) {
            modloader = "Quilt";
        } else if(fabricVersion!=null) {
            modloader = "Fabric";
        } else if(forgeType!=null&&forgeVersion!=null) {
            modloader = "Forge";
        } else if(neoForgeVersion!=null) {
            modloader = "NeoForge";
        } else {
            modloader = "Vanilla";
        }
    }

    public Zynstance(File file) {
        super(file);
        origin = file.getAbsolutePath();
        config = new JsonStorage(file);
        init();
    }

    public Zynstance(JsonStorage config) {
        super(config.getJsonFile());
        origin = config.getPath();
        this.config = config;
        init();
    }

    @Override
    public String getAuthor() {
        return authors.toString().replace("[","").replace("]","");
    }

    @Override
    public ArrayList<String> getAuthors() {
        return authors;
    }

    @Override
    public String getBackgroundUrl() {
        return background;
    }

    @Override
    public ArrayList<String> getChangelogs() {
        return changelogs;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getDownloadUrl() {
        return downloadUrl;
    }

    @Override
    public String getFabricVersion() {
        return fabricVersion;
    }

    @Override
    public String getForgeType() {
        return forgeType;
    }

    @Override
    public String getForgeVersion() {
        return forgeVersion;
    }

    @Override
    public Boolean isEditable() {
        return isEditable;
    }

    @Override
    public Boolean isHidden() {
        return isHidden;
    }

    @Override
    public String getIconUrl() {
        return iconUrl;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getIndexUrl() {
        return indexUrl;
    }

    @Override
    public String getInfoCard() {
        return infoCard;
    }

    @Override
    public String getInfoText() {
        return infoText;
    }

    @Override
    public String getLogoUrl() {
        return logoUrl;
    }

    @Override
    public String getMinecraftVersion() {
        return minecraftVersion;
    }

    @Override
    public String getModloader() {
        return modloader;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String getOrigin() {
        return origin;
    }

    @Override
    public String getNeoForgeVersion() {
        return neoForgeVersion;
    }

    @Override
    public String getQuiltVersion() {
        return quiltVersion;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public ArrayList<String> getVersions() {
        return versions;
    }

    @Override
    public String getSchemeVersion() {
        return schemeVersion;
    }

    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public ArrayList<String> getTags() {
        return tags;
    }

    @Override
    public String getTagString() {
        return tags.toString().replace("[","").replace("]","");
    }

    @Override
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setAuthors(ArrayList<String> authors) {
        config.set("instance.info.author",authors);
        this.authors = authors;
    }

    public void setBackground(String background) {
        config.set("instance.resources.background",background);
        this.background = background;
    }

    public void setChangelogs(ArrayList<String> changelogs) {
        config.set("instance.meta.changelogs",changelogs);
        this.changelogs = changelogs;
    }

    public void setDescription(String description) {
        config.set("instance.meta.description",description);
        this.description = description;
    }

    public void setDownloadUrl(String downloadUrl) {
        config.set("instance.meta.download",downloadUrl);
        this.downloadUrl = downloadUrl;
    }

    public void setFabricVersion(String fabricVersion) {
        config.set("instance.versions.fabric",fabricVersion);
        this.fabricVersion = fabricVersion;
    }

    public void setForgeType(String forgeType) {
        config.set("instance.meta.forgeType",forgeType);
        this.forgeType = forgeType;
    }

    public void setForgeVersion(String forgeVersion) {
        config.set("instance.versions.forge",forgeVersion);
        this.forgeVersion = forgeVersion;
    }

    public void setEditable(Boolean editable) {
        config.set("instance.meta.isEditable",editable);
        isEditable = editable;
    }

    public void setHidden(Boolean hidden) {
        config.set("instance.meta.isHidden",hidden);
        isHidden = hidden;
    }

    public void setId(String id) {
        config.set("instance.meta.id",id);
        this.id = id;
    }

    public void setIndexUrl(String indexUrl) {
        config.set("instance.meta.origin",indexUrl);
        this.indexUrl = indexUrl;
    }

    public void setIconUrl(String iconUrl) {
        config.set("instance.resources.icon",iconUrl);
        this.iconUrl = iconUrl;
    }

    public void setLocation(String locationUrl) {
        this.location = locationUrl;
    }

    public void setLogoUrl(String logoUrl) {
        config.set("instance.resources.logo",logoUrl);
        this.logoUrl = logoUrl;
    }

    public void setMinecraftVersion(String minecraftVersion) {
        config.set("instance.versions.minecraft",minecraftVersion);
        this.minecraftVersion = minecraftVersion;
    }

    public void setName(String name) {
        config.set("instance.info.name",name);
        this.name = name;
    }

    public void setNeoForgeVersion(String neoForgeVersion) {
        config.set("instance.versions.neoforge",neoForgeVersion);
        this.neoForgeVersion = neoForgeVersion;
    }

    public void setQuiltVersion(String quiltVersion) {
        config.set("instance.versions.quilt",quiltVersion);
        this.quiltVersion = quiltVersion;
    }

    public void setVersion(String version) {
        config.set("instance.info.version",version);
        this.version = version;
    }

    public void setVersions(ArrayList<String> versions) {
        config.set("instance.meta.versions",versions);
        this.versions = versions;
    }

    public void setSummary(String summary) {
        config.set("instance.info.summary",summary);
        this.summary = summary;
    }

    public void setTags(ArrayList<String> tags) {
        config.set("instance.meta.tags",tags);
        this.tags = tags;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        config.set("instance.resources.thumbnail",thumbnailUrl);
        this.thumbnailUrl = thumbnailUrl;
    }
}