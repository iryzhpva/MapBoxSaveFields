package com.example.mapboxsavefields.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserData {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("patronymic")
    @Expose
    private String patronymic;
    @SerializedName("photo")
    @Expose
    private Object photo;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("role")
    @Expose
    private Integer role;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("roles")
    @Expose
    private List<String> roles = null;
    @SerializedName("activated")
    @Expose
    private Boolean activated;
    @SerializedName("country")
    @Expose
    private Object country;
    @SerializedName("region")
    @Expose
    private Object region;
    @SerializedName("district")
    @Expose
    private Object district;
    @SerializedName("inn")
    @Expose
    private Object inn;
    @SerializedName("owned_households")
    @Expose
    private List<Object> ownedHouseholds = null;
    @SerializedName("worker_households")
    @Expose
    private List<Object> workerHouseholds = null;
    @SerializedName("is_owner")
    @Expose
    private Boolean isOwner;
    @SerializedName("fields_count")
    @Expose
    private Integer fieldsCount;
    @SerializedName("tou_version_accepted")
    @Expose
    private Integer touVersionAccepted;
    @SerializedName("pda_version_accepted")
    @Expose
    private Integer pdaVersionAccepted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Object getPhoto() {
        return photo;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public Object getRegion() {
        return region;
    }

    public void setRegion(Object region) {
        this.region = region;
    }

    public Object getDistrict() {
        return district;
    }

    public void setDistrict(Object district) {
        this.district = district;
    }

    public Object getInn() {
        return inn;
    }

    public void setInn(Object inn) {
        this.inn = inn;
    }

    public List<Object> getOwnedHouseholds() {
        return ownedHouseholds;
    }

    public void setOwnedHouseholds(List<Object> ownedHouseholds) {
        this.ownedHouseholds = ownedHouseholds;
    }

    public List<Object> getWorkerHouseholds() {
        return workerHouseholds;
    }

    public void setWorkerHouseholds(List<Object> workerHouseholds) {
        this.workerHouseholds = workerHouseholds;
    }

    public Boolean getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Boolean isOwner) {
        this.isOwner = isOwner;
    }

    public Integer getFieldsCount() {
        return fieldsCount;
    }

    public void setFieldsCount(Integer fieldsCount) {
        this.fieldsCount = fieldsCount;
    }

    public Integer getTouVersionAccepted() {
        return touVersionAccepted;
    }

    public void setTouVersionAccepted(Integer touVersionAccepted) {
        this.touVersionAccepted = touVersionAccepted;
    }

    public Integer getPdaVersionAccepted() {
        return pdaVersionAccepted;
    }

    public void setPdaVersionAccepted(Integer pdaVersionAccepted) {
        this.pdaVersionAccepted = pdaVersionAccepted;
    }
}
