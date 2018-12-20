package cn.nascent.pojo;

import java.util.Date;

public class LogInfo {
    private String id;
    private String lname;
    private String ltype;
    private String lpath;
    private String lmessage;
    private String ltimestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLtype() {
        return ltype;
    }

    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

    public String getLpath() {
        return lpath;
    }

    public void setLpath(String lpath) {
        this.lpath = lpath;
    }

    public String getLmessage() {
        return lmessage;
    }

    public void setLmessage(String lmessage) {
        this.lmessage = lmessage;
    }

    public String getLtimestamp() {
        return ltimestamp;
    }

    public void setLtimestamp(String ltimestamp) {
        this.ltimestamp = ltimestamp;
    }

    @Override
    public String toString() {
        return "LogInfo{" +
                "lname='" + lname + '\'' +
                ", ltype='" + ltype + '\'' +
                ", lpath='" + lpath + '\'' +
                ", lmessage='" + lmessage + '\'' +
                ", ltimestamp=" + ltimestamp +
                '}';
    }
}
