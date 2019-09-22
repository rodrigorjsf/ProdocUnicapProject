package DOC;

import Model.DocenteModel;
import dbUtil.dbConection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class usuarioDAO {
    //Declarações
    private static usuarioDAO instance;
    private  Connection connection;
    private DocenteModel objDados;

/*
    public DocenteModel() {
        try {
            this.connection = dbConection.getConnection();
            this.objDados = new objDadosDocente();

        }catch (SQLException e){
            if (this.connection == null){
                System.exit(1);
            }
        }
    }
 */

    //Construtor
    private usuarioDAO() {
        try {
            this.connection = dbConection.getConnection();

        }catch (SQLException e){
            if (this.connection == null){
                System.exit(1);
            }
        }
    }

    public static usuarioDAO GETINSTANCE(){
        if (instance == null){
            instance = new usuarioDAO();
        }
        return instance;
    }

    //Metódos
    public  boolean isDataBaseConected(){
        return this.connection != null;
    }
    public LinkedList<DocenteModel> mtConsulta() throws SQLException {
        LinkedList<DocenteModel> retorno;
        Statement stmt;
        ResultSet dbRetorno;

        try{
            retorno = new LinkedList<>();
            String Comando;
            Comando = "select * from tbUsuario ";
            Comando = Comando + " where id = " + objDados.getId();

                stmt = this.connection.createStatement();
                dbRetorno = stmt.executeQuery(Comando);
                while(dbRetorno.next()){
                        retorno.add(new DocenteModel(
                                dbRetorno.getInt("id"),
                                dbRetorno.getString("nome"),
                                dbRetorno.getString("titulo"),
                                dbRetorno.getInt("tempoXP"),
                                dbRetorno.getString("senha"),
                                dbRetorno.getString("usuario"),
                                dbRetorno.getString("cargo")

                        ));
                }
                return retorno;
            }catch (Exception e){
                throw e;
            }finally {

        }



    }
    public DocenteModel mtConsultaUnico(DocenteModel p_obj) throws SQLException {
        DocenteModel retorno;
        Statement stmt;
        ResultSet dbRetorno;

        try{
            retorno = new DocenteModel();
            String Comando;
            Comando = "select * from tbUsuario ";
            Comando = Comando + " where id = " + p_obj.getId();

            stmt = this.connection.createStatement();
            dbRetorno = stmt.executeQuery(Comando);
            if(dbRetorno.next()){
                retorno = (new DocenteModel(
                        dbRetorno.getInt("id"),
                        dbRetorno.getString("nome"),
                        dbRetorno.getString("titulo"),
                        dbRetorno.getInt("tempoXP"),
                        dbRetorno.getString("senha"),
                        dbRetorno.getString("usuario"),
                        dbRetorno.getString("cargo")

                ));
            }
            return retorno;
        }catch (Exception e){
            throw e;
        }finally {

        }



    }
    public LinkedList<DocenteModel> mtConsultaTodos() throws SQLException {
        LinkedList<DocenteModel> retorno;
        Statement stmt;
        ResultSet dbRetorno;

        try{
            retorno = new LinkedList<>();
            String Comando;
            Comando = "select * from tbUsuario where tipo = 'DOC'";

            stmt = this.connection.createStatement();
            dbRetorno = stmt.executeQuery(Comando);
            while(dbRetorno.next()){
                retorno.add(new DocenteModel(
                        dbRetorno.getInt("id"),
                        dbRetorno.getString("nome"),
                        dbRetorno.getString("titulo"),
                        dbRetorno.getInt("tempoXP"),
                        dbRetorno.getString("senha"),
                        dbRetorno.getString("usuario"),
                        dbRetorno.getString("cargo")

                ));
            }
            return retorno;
        }catch (Exception e){
            throw e;
        }finally {

        }



    }
    public boolean mtInserir(){
        Statement stmt = null;
        String Comando;

        try{
            this.connection.setAutoCommit(false);
            stmt = this.connection.createStatement();

            Comando = "insert into tbUsuario (nome, titulo, tempoXP,cargo,senha,usuario,tipo) ";
            Comando = Comando + " values('" + objDados.getNome() + "', ";
            Comando = Comando + "'" + objDados.getTitulo() + "', ";
            Comando = Comando + objDados.getTempoXP() + ", ";
            Comando = Comando + "'" + objDados.getCargo() + "', ";
            Comando = Comando + "'" + objDados.getSenha() + "', ";
            Comando = Comando + "'" + objDados.getUsuario() + "', ";
            Comando = Comando + "'DOC') ";
            stmt.executeUpdate(Comando);
            stmt.close();
            this.connection.commit();
            return true;

        }catch (Exception e){
            return false;
        }
    }
    public boolean mtIremover(){
        Statement stmt;
        ResultSet dbRetorno;
        String Comando;
        try{
            this.connection.setAutoCommit(false);
            Comando = "DELETE FROM tbUsuario ";
            Comando = Comando + " WHERE id = " + objDados.getId();
            stmt = this.connection.createStatement();
            stmt.executeUpdate(Comando);
            connection.commit();
            return true;

        }catch (Exception e) {
            return false;
        }
    }
    public boolean mtAtualizar() throws SQLException {
        Statement stmt;
        ResultSet dbRetorno;
        String Comando;
        try{
            this.connection.setAutoCommit(false);
            Comando = "update tbUsuario ";
            Comando = Comando + " set nome = '" + objDados.getNome() + "', ";
            Comando = Comando + " titulo = '" + objDados.getTitulo() + "', ";
            Comando = Comando + " tempoXP = '" + objDados.getTempoXP() + "', ";
            Comando = Comando + " cargo = '" + objDados.getCargo() + "', ";
            Comando = Comando + " usuario = '" + objDados.getUsuario() + "', ";
            Comando = Comando + " senha = '" + objDados.getSenha() + "' ";
            Comando = Comando + " where id = " + objDados.getId();
            stmt = this.connection.createStatement();
            stmt.executeUpdate(Comando);
            connection.commit();
            return true;

        }catch (Exception e) {
            return false;
        }
    }

    //getters e setters
    public DocenteModel getObjDados() {
        return objDados;
    }
    public void setObjDados(DocenteModel p_obj) {
        this.objDados = new DocenteModel(p_obj.getId(), p_obj.getNome(), p_obj.getTitulo(), p_obj.getTempoXP(),
                p_obj.getSenha(), p_obj.getUsuario(),p_obj.getCargo());
    }


}
