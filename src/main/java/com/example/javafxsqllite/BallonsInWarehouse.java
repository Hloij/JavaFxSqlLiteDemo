package com.example.javafxsqllite;

import javafx.beans.property.SimpleIntegerProperty;

public class BallonsInWarehouse {
    public  SimpleIntegerProperty _ballonsId;
    public Integer  get_ballonsId() {
        return _ballonsId.get();
    }
    public void  set_ballonsId(Integer value){
        _ballonsId.set(value);
    }

    public  SimpleIntegerProperty _warehouseId;
    public Integer  get_warehouseId() {
        return _warehouseId.get();
    }
    public void  set_warehouseId(Integer value){
        _warehouseId.set(value);
    }

    public  SimpleIntegerProperty _quantity;
    public Integer  get_quantity() {
        return _quantity.get();
    }
    public void  set_quantity(Integer value){
        _quantity.set(value);
    }


    public  SimpleIntegerProperty _id;
    public Integer  get_id() {
        return _id.get();
    }
    public void  set_id(Integer value){
        _id.set(value);
    }

    public BallonsInWarehouse(Integer ballonsId, Integer warehouseId, Integer quantity,Integer id){
        this._ballonsId= new SimpleIntegerProperty(ballonsId);
        this._warehouseId= new SimpleIntegerProperty(warehouseId);
        this._id= new SimpleIntegerProperty(id);
        this._quantity= new SimpleIntegerProperty(quantity);

    }
}
