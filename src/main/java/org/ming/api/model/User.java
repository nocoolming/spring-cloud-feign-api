package org.ming.api.model;

import java.util.Date;

public class User {
    public User() {

    }

    public User(String username, String displayName) {
        this(username, displayName, new Date());
    }

    public User(String username, String displayName, Date createTime) {
        this.username = username;
        this.displayName = displayName;
        this.createTime = createTime;
    }

    private String username;
    private String displayName;
    private Date createTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}