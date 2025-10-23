package com.example.javafxsqllite;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Warehouse  {
    public SimpleIntegerProperty _id;
    public Integer  get_id() {
        return _id.get();
    }
    public void  set_id(Integer value){
        _id.set(value);
    }
    public SimpleStringProperty _address;
    public String  get_address() {
        return _address.get();
    }
    public void  set_address(String value){
        _address.set(value);
    }
    public Warehouse(Integer id, String address){
        this._address=new SimpleStringProperty(address);
        this._id=new SimpleIntegerProperty(id);
    }
}
