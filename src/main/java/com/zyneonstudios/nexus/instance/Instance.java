package com.zyneonstudios.nexus.instance;

import java.util.ArrayList;

public interface Instance {

    String getAuthor();

    ArrayList<String> getAuthors();

    String getBackgroundUrl();

    ArrayList<String> getChangelogs();

    String getDescription();

    String getDownloadUrl();

    String getFabricVersion();

    String getForgeType();

    String getForgeVersion();

    String getIconUrl();

    Boolean isEditable();

    Boolean isHidden();

    Boolean forceUpdates();

    String getId();

    String getIndexUrl();

    String getInfoCard();

    String getInfoText();

    String getLogoUrl();

    String getMinecraftVersion();

    String getModloader();

    String getName();

    String getLocation();

    String getOrigin();

    String getNeoForgeVersion();

    String getQuiltVersion();

    String getSummary();

    ArrayList<String> getTags();

    String getTagString();

    String getVersion();

    ArrayList<String> getVersions();

    String getThumbnailUrl();

    String getSchemeVersion();
}
