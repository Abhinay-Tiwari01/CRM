package com.abhi.CRM.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class StateEntity {
    @Id
    @Column(name = "State_Code")
    private int code;
    @Column(name = "State_Name")
    private String state;

    @OneToMany(mappedBy = "state")
    private List<CityEntity> cityEntityList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<CityEntity> getCityEntityList() {
        return cityEntityList;
    }

    public void setCityEntityList(List<CityEntity> cityEntityList) {
        this.cityEntityList = cityEntityList;
    }
}
