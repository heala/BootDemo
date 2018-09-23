package com.syh.bean;

public class Permission {
    private Integer pid;

    private String pname;

    private String path;

    private String type;

    private Integer parentid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Permission(Integer pid, String pname, String path, String type, Integer parentid) {
        this.pid = pid;
        this.pname = pname;
        this.path = path;
        this.type = type;
        this.parentid = parentid;
    }

    public Permission() {
    }
}