package com.zyneonstudios.nexus.instance;

import live.nerotv.shademebaby.file.Config;

import java.io.File;

public class Zynstance extends ReadableZynstance implements Instance {

    private String author;
    private String background;
    private final Config config;
    private String description;
    private String downloadUrl;
    private String fabricVersion;
    private String forgeType;
    private String forgeVersion;
    private String iconUrl;
    private Boolean isHidden;
    private String id;
    private String indexUrl;
    private String logoUrl;
    private String minecraftVersion;
    private String modloader;
    private String name;
    private String location;
    private final String origin;
    private String quiltVersion;
    private String version;
    private String thumbnailUrl;
    private String schemeVersion;

    private void init() {
        this.author = config.getString("instance.info.author");
        this.background = config.getString("instance.resources.background");
        this.description = config.getString("instance.info.description");
        this.downloadUrl = config.getString("instance.meta.download");
        this.fabricVersion = config.getString("instance.versions.fabric");
        this.forgeType = config.getString("instance.meta.forgeType");
        this.forgeVersion = config.getString("instance.versions.forge");
        this.iconUrl = config.getString("instance.resources.icon");
        this.isHidden = config.getBoolean("instance.meta.isHidden");
        this.id = config.getString("instance.meta.id");
        this.location = config.getString("instance.meta.location");
        this.indexUrl = config.getString("instance.meta.origin");
        this.logoUrl = config.getString("instance.resources.logo");
        this.minecraftVersion = config.getString("instance.versions.minecraft");
        this.name = config.getString("instance.info.name");
        this.quiltVersion = config.getString("instance.versions.quilt");
        this.version = config.getString("instance.info.version");
        this.thumbnailUrl = config.getString("instance.resources.thumbnail");
        this.schemeVersion = config.getString("scheme");
        if(quiltVersion!=null) {
            modloader = "Quilt";
        } else if(fabricVersion!=null) {
            modloader = "Fabric";
        } else if(forgeType!=null&&forgeVersion!=null) {
            modloader = "Forge";
        } else {
            modloader = "Vanilla";
        }
    }

    public Zynstance(File file) {
        super(file);
        origin = file.getAbsolutePath();
        config = new Config(file);
        init();
    }

    public Zynstance(Config config) {
        super(config.getJsonFile());
        origin = config.getPath();
        this.config = config;
        init();
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getBackgroundUrl() {
        return background;
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
    public String getQuiltVersion() {
        return quiltVersion;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    @Override
    public String getSchemeVersion() {
        return schemeVersion;
    }

    public void setAuthor(String author) {
        config.set("instance.info.author",author);
        this.author = author;
    }

    public void setBackground(String background) {
        config.set("instance.resources.background",background);
        this.background = background;
    }

    public void setDescription(String description) {
        config.set("instance.info.description",description);
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

    public void setQuiltVersion(String quiltVersion) {
        config.set("instance.versions.quilt",quiltVersion);
        this.quiltVersion = quiltVersion;
    }

    public void setVersion(String version) {
        config.set("instance.info.version",version);
        this.version = version;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        config.set("instance.resources.thumbnail",thumbnailUrl);
        this.thumbnailUrl = thumbnailUrl;
    }
}