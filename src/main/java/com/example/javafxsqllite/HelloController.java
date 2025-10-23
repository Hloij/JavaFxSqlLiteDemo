package com.example.javafxsqllite;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HelloController {
    @FXML
    private TableView<Balloons> Tab1;
    @FXML
    private TableColumn<Balloons, Integer> IdTab1;
    @FXML
    private TableColumn<Balloons, String> NameTab1;
    @FXML
    private TableColumn<Balloons, String> DiscriptTab1;
    List<Balloons> balloonsList;
    JdbcConnector db = new JdbcConnector();

    public void initialize() throws SQLException, ClassNotFoundException {
        db.Conn();
        ObservableList<Balloons> balloon = FXCollections.observableArrayList();
        balloonsList = (List<Balloons>) db.ReadDB("Balloons");
        balloon.addAll(balloonsList);
        // определяем таблицу и устанавливаем данные


        IdTab1.setCellValueFactory(new PropertyValueFactory<>("IdBallon"));
        NameTab1.setCellValueFactory(new PropertyValueFactory<>("NameBallon"));
        DiscriptTab1.setCellValueFactory(new PropertyValueFactory<>("DesBallon"));

        Tab1.setItems(balloon);
    }

    @FXML
    GridPane Tab1vi;
    @FXML
    AnchorPane AdderInTab1;

    @FXML
    protected void OnAddClick1() throws SQLException, ClassNotFoundException {

        Tab1vi.setVisible(false);
        AdderInTab1.setVisible(true);
        changtab1btn.setVisible(false);
        addtab1btn.setVisible(true);
        Balloons bln = balloonsList.get(balloonsList.size() - 1);
        tab1id.setText(String.valueOf(bln.getIdBallon() + 1));
    }

    @FXML
    TextField tab1id;
    @FXML
    TextField tab1name;
    @FXML
    TextField tab1dis;
    @FXML
    Button addtab1btn;
    @FXML
    Button changtab1btn;


    @FXML
    public void AddInBallons(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String disc = tab1dis.getText();
        String name = tab1name.getText();
        Integer id = Integer.valueOf(tab1id.getText());
        Balloons bln = new Balloons(id, disc, name);
        db.WriteDB(bln, "Balloons");
        Tab1vi.setVisible(true);
        AdderInTab1.setVisible(false);

        initialize();
    }

    @FXML
    public void OnDelClick1(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        bln = Tab1.getSelectionModel().getSelectedItem();
        db.DelDB(bln,"Balloons");
        initialize();
    }

    Balloons bln;

    @FXML
    public void OnChangeClick1(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        bln = Tab1.getSelectionModel().getSelectedItem();
        Tab1vi.setVisible(false);
        AdderInTab1.setVisible(true);
        changtab1btn.setVisible(true);
        addtab1btn.setVisible(false);
        tab1id.setText(String.valueOf(bln.getIdBallon()));
        tab1name.setText(bln.getNameBallon());
        tab1dis.setText(bln.getDesBallon());
    }
    @FXML
    public void ChangeInBallons(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String disc = tab1dis.getText();
        String name = tab1name.getText();
        Integer id = Integer.valueOf(tab1id.getText());
        Balloons bln = new Balloons(id, disc, name);
        db.UpdateDB(bln, "Balloons");
        Tab1vi.setVisible(true);
        AdderInTab1.setVisible(false);

        initialize();
    }
}
