package com.pangu.ConfigDiff;

import java.util.Objects;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/5/12 下午1:17
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class AcceptanceRate {
    public String open;
    public String title;
    public String h5Title;
    public String url;
    public String urlType;
    public String iconUrl;

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getH5Title() {
        return h5Title;
    }

    public void setH5Title(String h5Title) {
        this.h5Title = h5Title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcceptanceRate that = (AcceptanceRate) o;
        return Objects.equals(open, that.open) &&
                Objects.equals(title, that.title) &&
                Objects.equals(h5Title, that.h5Title) &&
                Objects.equals(url, that.url) &&
                Objects.equals(urlType, that.urlType) &&
                Objects.equals(iconUrl, that.iconUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(open, title, h5Title, url, urlType, iconUrl);
    }
}
