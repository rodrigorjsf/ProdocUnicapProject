package Main;

import java.sql.Connection;
import java.sql.SQLException;
import dbUtil.dbConection;


public class MainModel {
    Connection connection;

    public MainModel(){
        try{
            this.connection = dbConection.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        if (this.connection == null){
            System.exit(1);
        }
    }

    public  boolean isDataBaseConected(){
        return this.connection != null;
    }


}
