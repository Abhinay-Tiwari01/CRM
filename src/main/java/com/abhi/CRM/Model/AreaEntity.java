package com.abhi.CRM.Model;
import jakarta.persistence.*;

@Entity
public class AreaEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Area_Id")
    private int areaId;
    @Column(name = "Area_Name")
    private String area;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private CityEntity city;

//    @ManyToOne
//    @JoinColumn(name = "state_code")
//    private StateEntity state;


    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

//    public StateEntity getState() {
//        return state;
//    }
//
//    public void setState(StateEntity state) {
//        this.state = state;
//    }
}
