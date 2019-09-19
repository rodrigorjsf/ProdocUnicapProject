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



    /*
    public boolean isLogin(String user, String pass, String opt) throws Exception{
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM login where username = ? and password = ? and division = ?";

        try{
            pr = this.connection.prepareStatement(sql);
            pr.setString(1, user);
            pr.setString(2, pass);
            pr.setString(3, opt);

            pr.executeQuery();

            boolean boll1;
            if (rs.next()){
                return true;
            }
            return false;
        }catch (SQLException ex){
            return false;
        }finally {
            pr.close();
            rs.close();
        }

    }
     */




}
