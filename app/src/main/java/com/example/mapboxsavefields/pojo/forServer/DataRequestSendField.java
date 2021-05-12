package com.example.mapboxsavefields.pojo.forServer;

import com.example.mapboxsavefields.pojo.CurrentCrop;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;



public class DataRequestSendField {
    @SerializedName("field_cadastral_number")
    @Expose
    private String fieldCadastralNumber;
    @SerializedName("field_lon")
    @Expose
    private Double fieldLon;
    @SerializedName("field_lat")
    @Expose
    private Double fieldLat;
    @SerializedName("field_poly")
    @Expose
    private List<List<Double>> fieldPoly = null;
    @SerializedName("current_crop")
    @Expose
    private CurrentCrop currentCrop;
    @SerializedName("field_name")
    @Expose
    private String fieldName;

    @SerializedName("household_id")
    @Expose
    private Integer householdId;
    @SerializedName("prev_crop")
    @Expose
    private List<PrevCrop> prevCrop = null;

    public String getFieldCadastralNumber() {
        return fieldCadastralNumber;
    }

    public void setFieldCadastralNumber(String fieldCadastralNumber) {
        this.fieldCadastralNumber = fieldCadastralNumber;
    }

    public Double getFieldLon() {
        return fieldLon;
    }

    public void setFieldLon(Double fieldLon) {
        this.fieldLon = fieldLon;
    }

    public Double getFieldLat() {
        return fieldLat;
    }

    public void setFieldLat(Double fieldLat) {
        this.fieldLat = fieldLat;
    }

    public List<List<Double>> getFieldPoly() {
        return fieldPoly;
    }

    public void setFieldPoly(List<List<Double>> fieldPoly) {
        this.fieldPoly = fieldPoly;
    }

    public CurrentCrop getCurrentCrop() {
        return currentCrop;
    }

    public void setCurrentCrop(CurrentCrop currentCrop) {
        this.currentCrop = currentCrop;
    }

    public List<PrevCrop> getPrevCrop() {
        return prevCrop;
    }

    public void setPrevCrop(List<PrevCrop> prevCrop) {
        this.prevCrop = prevCrop;
    }

    public Integer getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Integer householdId) {
        this.householdId = householdId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public class PrevCrop {

        @SerializedName("crop_name")
        @Expose
        private String cropName;
        @SerializedName("crop_sort")
        @Expose
        private String cropSort;
        @SerializedName("growth_date_start")
        @Expose
        private Integer growthDateStart;
        @SerializedName("growth_date_finish")
        @Expose
        private Integer growthDateFinish;

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

        public Integer getGrowthDateStart() {
            return growthDateStart;
        }

        public void setGrowthDateStart(Integer growthDateStart) {
            this.growthDateStart = growthDateStart;
        }

        public Integer getGrowthDateFinish() {
            return growthDateFinish;
        }

        public void setGrowthDateFinish(Integer growthDateFinish) {
            this.growthDateFinish = growthDateFinish;
        }

    }
}

