package com.example.mapboxsavefields.pojo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CurrentCrop {
    private long idDBCurrentCrop;

    @SerializedName("crop_id")
    @Expose
    private Integer cropId;

    @SerializedName("crop_name")
    @Expose
    private String cropName;

    @SerializedName("crop_sort")
    @Expose
    private String cropSort;

    @SerializedName("seeding_date")
    @Expose
    private long seedingDate;

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getCropSort() {
        return cropSort;
    }

    public void setCropSort(String cropSort) {
        this.cropSort = cropSort;
    }

    public long getSeedingDate() {
        return seedingDate;
    }

    public void setSeedingDate(long seedingDate) {
        this.seedingDate = seedingDate;
    }

    public long getIdDBCurrentCrop() {
        return idDBCurrentCrop;
    }

    public void setIdDBCurrentCrop(long idDBCurrentCrop) {
        this.idDBCurrentCrop = idDBCurrentCrop;
    }


}