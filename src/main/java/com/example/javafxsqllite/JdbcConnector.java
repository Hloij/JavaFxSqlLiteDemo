package com.example.javafxsqllite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class JdbcConnector {
    public  Connection conn;

    public  void Conn() throws  SQLException
    {
        try {

            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:/SqlLite/test.db");

            System.out.println("База Подключена!");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
    public  void DelDB(Object T,String Tabname) throws SQLException
    {

        switch (Tabname){
            case "Balloons":try {
                Statement statmt;
                statmt = conn.createStatement();
                Balloons bln = (Balloons)T;
                String query="DELETE FROM Balloons WHERE id = "+String.valueOf(bln.getIdBallon());
                statmt.executeUpdate(query);

                statmt.close();
                System.out.println("Таблица заполнена");
            }
            catch (Exception exception)
            {
                System.out.println(exception.getMessage());
            };break;
            case "Warehouses":try {
                Statement statmt;
                statmt = conn.createStatement();
                Warehouse bln = (Warehouse) T;
                String query="DELETE FROM Warehouses WHERE id = "+String.valueOf(bln.get_id());
                statmt.executeUpdate(query);

                statmt.close();
                System.out.println("Таблица заполнена");
            }
            catch (Exception exception)
            {
                System.out.println(exception.getMessage());
            };break;
            case "BallonsInWarehouse":try {
                Statement statmt;
                statmt = conn.createStatement();
                BallonsInWarehouse bln = (BallonsInWarehouse) T;
                String query="DELETE FROM BallonsInWarehouse WHERE id = "+String.valueOf(bln.get_id());
                statmt.executeUpdate(query);

                statmt.close();
                System.out.println("Таблица заполнена");
            }
            catch (Exception exception)
            {
                System.out.println(exception.getMessage());
            };break;
        }


    }
    public  void WriteDB(Object T,String Tabname) throws SQLException
    {   switch (Tabname){
        case "Balloons":try {
            Statement statmt;
            statmt = conn.createStatement();
            Balloons bln = (Balloons)T;
            String query="INSERT INTO 'Balloons' ('Id','Descript', 'NameBalloon') "+
                    "VALUES ('"+bln.getIdBallon()+"','"+bln.getDesBallon()+"','"+bln.getNameBallon()+"') ";
            statmt.executeUpdate(query);

            statmt.close();
            System.out.println("Таблица заполнена");
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        };break;
        case "Warehouses":try {
            Statement statmt;
            statmt = conn.createStatement();
            Warehouse bln = (Warehouse) T;
            String query="INSERT INTO 'Warehouses' ('Id','Adress') "+
                    "VALUES ('"+bln.get_id()+"','"+bln.get_address()+"') ";

            statmt.executeUpdate(query);

            statmt.close();
            System.out.println("Таблица заполнена");
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        };break;
        case "BallonsInWarehouse":try {
            Statement statmt;
            statmt = conn.createStatement();
            BallonsInWarehouse bln = (BallonsInWarehouse) T;
            String query="INSERT INTO 'BallonsInWarehouse' ('Id','BallonsId', 'WarehouseId','Quantity') "+
                    "VALUES ('"+bln.get_id()+"','"+bln.get_ballonsId()+"','"+bln.get_warehouseId()+"','"+bln.get_quantity()+"') ";

            statmt.executeUpdate(query);

            statmt.close();
            System.out.println("Таблица заполнена");
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        };break;
    }


    }
    public  void UpdateDB(Object T,String Tabname) throws SQLException {
        switch (Tabname) {
            case "Balloons":
                try {
                    Statement statmt;
                    statmt = conn.createStatement();
                    Balloons bln = (Balloons) T;
                    String query = "UPDATE Balloons " +

                            "SET Descript ='"+ bln.getDesBallon() +"', "+
                            "NameBalloon ='"+bln.getNameBallon()+"' "+
                            "WHERE Id = '"+bln.getIdBallon()+"'; " ;

                    statmt.executeUpdate(query);

                    statmt.close();
                    System.out.println("Таблица заполнена");
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
                ;
                break;
            case "Warehouses":
                try {
                    Statement statmt;
                    statmt = conn.createStatement();
                    Warehouse bln = (Warehouse) T;
                    String query = "INSERT INTO 'Warehouses' ('Id','Adress') " +
                            "VALUES ('" + bln.get_id() + "','" + bln.get_address() + "') ";

                    statmt.executeUpdate(query);

                    statmt.close();
                    System.out.println("Таблица заполнена");
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
                ;
                break;
            case "BallonsInWarehouse":
                try {
                    Statement statmt;
                    statmt = conn.createStatement();
                    BallonsInWarehouse bln = (BallonsInWarehouse) T;
                    String query = "INSERT INTO 'BallonsInWarehouse' ('Id','BallonsId', 'WarehouseId','Quantity') " +
                            "VALUES ('" + bln.get_id() + "','" + bln.get_ballonsId() + "','" + bln.get_warehouseId() + "','" + bln.get_quantity() + "') ";

                    statmt.executeUpdate(query);

                    statmt.close();
                    System.out.println("Таблица заполнена");
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
                ;
                break;
        }
    }

    public List<? extends Object> ReadDB(String Tabname) throws ClassNotFoundException, SQLException {
        switch (Tabname){
            case "Balloons":
                try {
                    Statement statmt;
                    ResultSet resSet;
                    statmt =  conn.createStatement();
                    resSet = statmt.executeQuery("SELECT *  "+
                            "FROM Balloons ");
                    List<Balloons> balloons = new ArrayList<Balloons>();
                    while (resSet.next()) {

                        int id = resSet.getInt("Id");
                        String Name = resSet.getString("NameBalloon");
                        String Descript = resSet.getString("Descript");

                        balloons.add(new Balloons(id,Descript,Name));
                    }
                    resSet.close();
                    statmt.close();
                    return balloons;

                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                };break;
            case "Warehouses": try {
                Statement statmt;
                ResultSet resSet;
                statmt =  conn.createStatement();
                resSet = statmt.executeQuery("SELECT *  "+
                        "FROM Warehouses ");
                List<Warehouse> balloons = new ArrayList<Warehouse>();
                while (resSet.next()) {

                    int id = resSet.getInt("Id");
                    String adres = resSet.getString("Adress");

                    balloons.add(new Warehouse(id,adres));
                }
                resSet.close();
                statmt.close();
                return Collections.singletonList(balloons);

            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            };break;
            case "BallonsInWarehouse":try {
                Statement statmt;
                ResultSet resSet;
                statmt =  conn.createStatement();
                resSet = statmt.executeQuery("SELECT *  "+
                        "FROM BallonsInWarehouse ");
                List<BallonsInWarehouse> balloons = new ArrayList<BallonsInWarehouse>();
                while (resSet.next()) {

                    int ballonsId = resSet.getInt("BallonsId");
                    int warehouseId = resSet.getInt("WarehouseId");
                    int quantity = resSet.getInt("Quantity");
                    int id = resSet.getInt("Id");

                    balloons.add(new BallonsInWarehouse(ballonsId,warehouseId,quantity,id));
                }
                resSet.close();
                statmt.close();
                return Collections.singletonList(balloons);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            };break;
        }

        return null;
    }
    public  void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();


        System.out.println("Соединения закрыты");
    }
}
