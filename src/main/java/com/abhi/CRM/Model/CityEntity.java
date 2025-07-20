package com.abhi.CRM.Model;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "City_Id")
    private int id;
    @Column(name = "City_Name")
    private String city;

    @ManyToOne
    @JoinColumn(name = "State_Id")
    private StateEntity state;

    @OneToMany(mappedBy = "city")
    private List<AreaEntity> areaEntityList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public StateEntity getState() {
        return state;
    }

    public void setState(StateEntity state) {
        this.state = state;
    }

    public List<AreaEntity> getAreaEntityList() {
        return areaEntityList;
    }

    public void setAreaEntityList(List<AreaEntity> areaEntityList) {
        this.areaEntityList = areaEntityList;
    }
}
