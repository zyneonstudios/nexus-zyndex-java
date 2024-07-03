package com.zyneonstudios.nexus.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.zyneonstudios.nexus.Main;
import live.nerotv.shademebaby.utils.GsonUtil;

import java.io.File;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class ReadableModule implements Module {

    // MODULE JSON INFO SECTION
    private ArrayList<String> info_authors = null;
    private String info_summary = null;
    private String info_name;
    private String info_version = null;

    // MODULE JSON META SECTION
    private ArrayList<String> meta_changelogs = null;
    private String meta_description = null;
    private String meta_download = null;
    private String meta_id = null;
    private String meta_infoCard = null;
    private String meta_infoText = null;
    private Boolean meta_isHidden = null;
    private String meta_location = null;
    private String meta_indexUrl = null;
    private ArrayList<String> meta_tags = null;
    private ArrayList<String> meta_versions = null;

    // MODULE JSON RESOURCES SECTION
    private String resources_background = null;
    private String resources_icon = null;
    private String resources_logo = null;
    private String resources_thumbnail = null;

    // OTHER STUFF
    private String scheme_version = null;
    private final String origin;

    private void init(String json_) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject root = gson.fromJson(json_, JsonObject.class);

        try {
            JsonObject json = root.get("module").getAsJsonObject();
            JsonObject info = json.getAsJsonObject("info");
            ArrayList<String> authors = new ArrayList<>();
            for(JsonElement author:info.getAsJsonArray("authors")) {
                authors.add(author.getAsString());
            }

            info_authors = authors;
            info_summary = info.get("summary").getAsString();
            info_name = info.get("name").getAsString();
            info_version = info.get("version").getAsString();

            JsonObject meta = json.getAsJsonObject("info");
            if(meta.has("changelogs")) {
                ArrayList<String> changelogs = new ArrayList<>();
                for(JsonElement changelog:meta.getAsJsonArray("changelogs")) {
                    changelogs.add(changelog.getAsString());
                }
                meta_changelogs = changelogs;
            }
            if(meta.has("description")) {
                meta_description = meta.get("description").getAsString();
            } else {
                meta_description = info_summary;
            }
            meta_download = meta.get("download").getAsString();
            meta_id = meta.get("id").getAsString();
            if(meta.has("infoCard")) {
                meta_infoCard = meta.get("infoCard").getAsString();
            }
            if(meta.has("infoText")) {
                meta_infoText = meta.get("infoText").getAsString();
            }
            meta_isHidden = meta.get("isHidden").getAsBoolean();
            meta_location = meta.get("location").getAsString();
            meta_indexUrl = meta.get("origin").getAsString();
            ArrayList<String> tags = new ArrayList<>();
            for(JsonElement tag:meta.getAsJsonArray("tags")) {
                tags.add(tag.getAsString());
            }
            meta_tags = tags;
            if(meta.has("versions")) {
                ArrayList<String> versions = new ArrayList<>();
                for(JsonElement version:meta.getAsJsonArray("versions")) {
                    versions.add(version.getAsString());
                }
                meta_versions = versions;
            }

            if(json.has("resources")) {
                JsonObject resources = json.getAsJsonObject("resources");
                if(resources.has("background")) {
                    resources_background = resources.get("background").getAsString();
                }
                if(resources.has("icon")) {
                    resources_icon = resources.get("icon").getAsString();
                }
                if(resources.has("logo")) {
                    resources_logo = resources.get("logo").getAsString();
                }
                if(resources.has("thumbnail")) {
                    resources_thumbnail = resources.get("thumbnail").getAsString();
                }
            }

            scheme_version = root.get("scheme").getAsString();
        } catch (Exception e) {
            Main.logger.error("Couldn't initialize ReadableModule - JSON Format error: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public ReadableModule(String url) {
        origin = url;
        try {
            init(GsonUtil.getFromURL(url));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ReadableModule(File file) {
        origin = file.getAbsolutePath();
        try {
            init(GsonUtil.getFromFile(file));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getAuthor() {
        return info_authors.toString().replace("[","").replace("]","");
    }

    @Override
    public ArrayList<String> getAuthors() {
        return info_authors;
    }

    @Override
    public String getSummary() {
        return info_summary;
    }

    @Override
    public String getName() {
        return info_name;
    }

    @Override
    public String getVersion() {
        return info_version;
    }

    @Override
    public ArrayList<String> getChangelogs() {
        return meta_changelogs;
    }

    @Override
    public String getDescription() {
        return meta_description;
    }

    @Override
    public String getDownloadUrl() {
        return meta_download;
    }

    @Override
    public String getId() {
        return meta_id;
    }

    @Override
    public String getInfoCard() {
        return meta_infoCard;
    }

    @Override
    public String getInfoText() {
        return meta_infoText;
    }

    @Override
    public Boolean isHidden() {
        return meta_isHidden;
    }

    @Override
    public String getLocation() {
        return meta_location;
    }

    @Override
    public String getIndexUrl() {
        return meta_indexUrl;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public String getTagString() {
        return meta_tags.toString().replace("[","").replace("]","");
    }

    @Override
    public ArrayList<String> getTags() {
        return meta_tags;
    }

    @Override
    public ArrayList<String> getVersions() {
        return meta_versions;
    }

    @Override
    public String getBackgroundUrl() {
        return resources_background;
    }

    @Override
    public String getIconUrl() {
        return resources_icon;
    }

    @Override
    public String getLogoUrl() {
        return resources_logo;
    }

    @Override
    public String getThumbnailUrl() {
        return resources_thumbnail;
    }

    @Override
    public String getSchemeVersion() {
        return scheme_version;
    }
}