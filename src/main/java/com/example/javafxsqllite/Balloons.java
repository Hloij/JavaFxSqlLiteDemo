package com.example.javafxsqllite;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Balloons {
    private SimpleIntegerProperty _id;
    public Integer  getIdBallon() {
        return _id.get();
    }
    public void  setIdBallon(Integer value){
        _id.set(value);
    }

    private SimpleStringProperty _description;
    public String  getDesBallon() {
        return _description.get();
    }
    public void  setDesBallon(String value){
        _description.set(value);
    }

    private     SimpleStringProperty  _nameBallon ;
    public String  getNameBallon() {
        return _nameBallon.get();
    }
    public void  setNameBallon(String value){
        _nameBallon.set(value);
    }

    public  Balloons(Integer id, String description, String nameBallon){
        this._description =new SimpleStringProperty(description);
        this._nameBallon=new SimpleStringProperty(nameBallon);
        this._id=new SimpleIntegerProperty(id);
    }
}
