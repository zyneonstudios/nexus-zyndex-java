package com.zyneonstudios.nexus.instance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.zyneonstudios.nexus.Main;
import live.nerotv.shademebaby.utils.GsonUtil;

import java.io.File;

public class ReadableZynstance implements Instance {

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
    private final String origin;
    private String version = null;
    private String thumbnail = null;
    private String schemeVersion = null;

    private void init(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject root = gson.fromJson(json, JsonObject.class);
        try {
            JsonObject json1 = root.get("instance").getAsJsonObject();

            JsonObject info = json1.get("info").getAsJsonObject();
            author = info.get("author").getAsString();
            description = info.get("description").getAsString();
            name = info.get("name").getAsString();
            version = info.get("version").getAsString();

            JsonObject meta = json1.get("meta").getAsJsonObject();
            downloadUrl = meta.get("download").getAsString();
            if (meta.get("forgeType") != null) {
                forgeType = meta.get("forgeType").getAsString();
            }
            isHidden = meta.get("isHidden").getAsBoolean();
            id = meta.get("id").getAsString();
            indexUrl = meta.get("origin").getAsString();
            location = meta.get("location").getAsString();

            if (json1.get("resources") != null) {
                JsonObject resources = json1.get("resources").getAsJsonObject();
                if (resources.get("background") != null) {
                    background = resources.get("background").getAsString();
                }
                if (resources.get("icon") != null) {
                    icon = resources.get("icon").getAsString();
                }
                if (resources.get("logo") != null) {
                    logo = resources.get("logo").getAsString();
                }
                if (resources.get("thumbnail") != null) {
                    thumbnail = resources.get("thumbnail").getAsString();
                }
            }

            JsonObject versions = json1.get("versions").getAsJsonObject();
            if (versions.get("fabric") != null) {
                fabricVersion = versions.get("fabric").getAsString();
            }
            if (versions.get("forge") != null) {
                forgeVersion = versions.get("forge").getAsString();
            }
            minecraftVersion = versions.get("minecraft").getAsString();

            this.schemeVersion = root.get("scheme").getAsString();
            if (fabricVersion != null) {
                modloader = "Fabric";
            } else if (forgeType != null && forgeVersion != null) {
                modloader = "Forge";
            } else {
                modloader = "Vanilla";
            }
        } catch (Exception e) {
            Main.logger.error("Couldn't initialize ReadableZynstance - JSON Format error: "+e.getMessage());
        }
    }

    public ReadableZynstance(String url) {
        origin = url;
        try {
            init(GsonUtil.getFromURL(url));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ReadableZynstance(File file) {
        origin = file.getAbsolutePath();
        try {
            init(GsonUtil.getFromFile(file));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
        return icon;
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
        return logo;
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
    public String getVersion() {
        return version;
    }

    @Override
    public String getThumbnailUrl() {
        return thumbnail;
    }

    @Override
    public String getSchemeVersion() {
        return schemeVersion;
    }
}