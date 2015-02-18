package com.example.yuvaraj.febworkspace;

import java.io.Serializable;

/**
 * Created by yuvaraj on 2/18/15.
 */
public class RSSItem implements Serializable {

    private static final long serialVersionUID = 1L;
    private String title,description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
