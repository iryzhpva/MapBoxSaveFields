package com.example.mapboxsavefields.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Crops {

    private long idDBCrop;

    @SerializedName("id")
    @Expose
    private Integer id;

   // @ColumnInfo(name = "name_crop")
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("wiki_link")
    @Expose
    private String wikiLink;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }

    public long getIdDBCrop() {
        return idDBCrop;
    }

    public void setIdDBCrop(long idDBCrop) {
        this.idDBCrop = idDBCrop;
    }

}
