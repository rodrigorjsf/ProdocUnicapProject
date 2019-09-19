package Login;

import dbUtil.dbConection;

import java.sql.*;

public class LoginModel {

    private Connection connection;

    public LoginModel(){
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

    public boolean isLogin(String user, String pass) throws SQLException {

        Statement Stmt = null;
        ResultSet resultSet = null;

        String sql = "select * from tbDocente ";
        sql = sql + " where usuario = '"+ user +"' ";
        sql = sql + " and senha = '"+pass+"' ";

        try {
            Stmt = connection.createStatement();
            resultSet =  Stmt.executeQuery(sql);

            if (resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            return false;
        } finally {
            Stmt.close();
            resultSet.close();
        }
    }
}
