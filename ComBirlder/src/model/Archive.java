package model;

import java.io.Serializable;

public class Archive implements Serializable{
    
    private String dir;
    private String name;
    private String code;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFileType() {
        return "birl";
    }
}
