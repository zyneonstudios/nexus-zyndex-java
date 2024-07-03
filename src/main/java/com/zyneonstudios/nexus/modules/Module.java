package com.zyneonstudios.nexus.modules;

import java.util.ArrayList;

public interface Module {

    default String getAuthor() {
        return null;
    }

    default ArrayList<String> getAuthors() {
        return null;
    }

    default String getSummary() {
        return null;
    }

    default String getName() {
        return null;
    }

    default String getVersion() {
        return null;
    }

    default ArrayList<String> getChangelogs() {
        return null;
    }

    default String getDescription() {
        return null;
    }

    default String getDownloadUrl() {
        return null;
    }

    default String getId() {
        return null;
    }

    default String getInfoCard() {
        return null;
    }

    default String getInfoText() {
        return null;
    }

    default Boolean isHidden() {
        return null;
    }

    default String getLocation() {
        return null;
    }

    default String getIndexUrl() {
        return null;
    }

    default String getTagString() {
        return null;
    }

    default ArrayList<String> getTags() {
        return null;
    }

    default ArrayList<String> getVersions() {
        return null;
    }

    default String getBackgroundUrl() {
        return null;
    }

    default String getIconUrl() {
        return null;
    }

    default String getLogoUrl() {
        return null;
    }

    default String getThumbnailUrl() {
        return null;
    }

    default String getSchemeVersion() {
        return null;
    }
}