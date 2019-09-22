package Login;

import Model.DocenteModel;
import dbUtil.dbConection;

import java.sql.*;

public class LoginDAO {

    private Connection connection;

    public LoginDAO(){
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

        String sql = "select * from tbUsuario ";
        sql = sql + " where usuario = '"+ user +"' ";
        sql = sql + " and senha = '"+ pass +"' ";

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


    public DocenteModel mtCapturaDocente(String user, String pass, String tipo) throws SQLException {
        Statement Stmt = null;
        ResultSet resultSet = null;
        DocenteModel retorno;

        String sql = "select * from tbUsuario ";
        sql = sql + " where usuario = '"+ user +"' ";
        sql = sql + " and senha = '"+ pass +"' ";
        sql = sql + " and tipo = '"+ tipo +"' ";

        try {
            Stmt = connection.createStatement();
            resultSet =  Stmt.executeQuery(sql);

            if (resultSet.next()) {

                retorno = new DocenteModel(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("titulo"),
                        resultSet.getInt("tempoXP"),
                        resultSet.getString("senha"),
                        resultSet.getString("usuario"),
                        resultSet.getString("cargo")
                );
               return retorno;

            }
            return null;
        } catch (SQLException ex) {
            return null;
        } finally {
            Stmt.close();
            resultSet.close();
        }
    }


}



