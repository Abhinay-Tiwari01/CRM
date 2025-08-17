package com.abhi.CRM.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Supplier_Entity")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Supp_id")
    private Integer id;

    @Column(name = "Supp_Name")
    private String name;

    @Column(name = "Supp_Address")
    private String address;
    @Column(name = "Supp_Mobile")
    private String mobile;
    @Column(name = "Supp_title")
    private String title;



    //    @Column(name = "state")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "State_id")
    private StateEntity state;

    //    @Column(name = "city")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "City_Id")
    private CityEntity city;

    //    @Column(name = "area")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Area_Id")
    private AreaEntity area;

    public SupplierEntity(Integer id, String name, String address, String mobile, String title, StateEntity state, CityEntity city, AreaEntity area) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.title = title;
        this.state = state;
        this.city = city;
        this.area = area;
    }

    public SupplierEntity() {
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StateEntity getState() {
        return state;
    }

    public void setState(StateEntity state) {
        this.state = state;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public AreaEntity getArea() {
        return area;
    }

    public void setArea(AreaEntity area) {
        this.area = area;
    }
}
