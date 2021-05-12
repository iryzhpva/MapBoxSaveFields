package com.example.mapboxsavefields.pojo;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.mapbox.geojson.Point;

import org.json.JSONArray;
import org.json.JSONException;


import java.util.List;
import java.util.Objects;


public class Field {
    @SerializedName("field_lon")
    @Expose
    private Double fieldLon;
    @SerializedName("field_lat")
    @Expose
    private Double fieldLat;
    private List<List<Double>> fieldPolyArrayList;

    @SerializedName("field_polyArr")
    @Expose
    private List<List<Double>> fieldPoly;

    private String fieldPolyStr;
    private Integer householdId;

    @SerializedName("field_cadastral_number")
    @Expose
    private String cadastralNumber;
    @SerializedName("field_status")
    @Expose
    private int field_status;
    List<List<Double>> fieldPoints;

    @SerializedName("current_crop")
    @Expose
    CurrentCrop currentCrop;
    @SerializedName("field_name")
    @Expose
    private String fieldName;


    //MapBox Point
    private List<Point> pointList;
    private Point centerPoint;

    private long seeding_date = 0;

    public Field(Point centerPoint, List<List<Double>> fieldPoints, String fieldName, Integer householdId, CurrentCrop currentCrop) {
        this.fieldLon = Double.parseDouble(String.valueOf(centerPoint.longitude()));
        this.fieldLat = Double.parseDouble(String.valueOf(centerPoint.latitude()));
        this.currentCrop = currentCrop;
        this.fieldPoly = fieldPoints;
        this.fieldName = fieldName;
        this.householdId = householdId;
    }


    public List<List<Double>> getFieldPolyArrayList() {
        return fieldPolyArrayList;
    }

    public void setFieldPolyArrayList(List<List<Double>> fieldPolyArrayList) {
        this.fieldPolyArrayList = fieldPolyArrayList;
    }

    public List<List<Double>> getFieldPoints() {
        return fieldPoints;
    }

    public void setFieldPoints(List<List<Double>> fieldPoints) {
        this.fieldPoints = fieldPoints;
    }

    public CurrentCrop getCurrentCrop() {
        return currentCrop;
    }

    public void setCurrentCrop(CurrentCrop currentCrop) {
        this.currentCrop = currentCrop;
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

    public List<List<Double>> getFieldPoly() throws JSONException {
        if (fieldPoly != null)
            return fieldPoly;
        else {
            String data = convertListPointsToJSONArray().toString();
            Gson gson = new Gson();
            List<List<Double>> fieldPolyRes = gson.fromJson(Objects.requireNonNull(data).toString(), new TypeToken<List<List<Double>>>() {
            }.getType());
            return fieldPolyRes;
        }
    }


    public void setFieldPoly(List<List<Double>> fieldPoly)  {
        this.fieldPoly = fieldPoly;
    }


    public String getCadastralNumber() {
        return cadastralNumber;
    }

    public void setCadastralNumber(String cadastralNumber) {
        this.cadastralNumber = cadastralNumber;
    }

    public long getSeeding_date() {
        return seeding_date;
    }

    public void setSeeding_date(long seeding_date) {
        this.seeding_date = seeding_date;
    }

    public String getFieldPolyStr() {
        return fieldPolyStr;
    }

    public void setFieldPolyStr(String fieldPolyStr) {
        this.fieldPolyStr = fieldPolyStr;
    }

    public int getField_status() {
        return field_status;
    }

    public void setField_status(int field_status) {
        this.field_status = field_status;
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Integer getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Integer householdId) {
        this.householdId = householdId;
    }

    public JSONArray convertListPointsToJSONArray() throws JSONException {
        JSONArray jsonArray = new JSONArray();
        if (pointList!= null && pointList.size()>0){
            for (Point point: pointList){
                JSONArray item = new JSONArray();
                item.put(point.latitude());
                item.put(point.longitude());
                jsonArray.put(item);
            }
        }
        return jsonArray;
    }

}
