package Docente;

import dbUtil.dbConection;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class DocenteModel {
    private  Connection connection;
    private objDadosDocente objDados;

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


    public DocenteModel(objDadosDocente p_obj) {
        try {
            this.connection = dbConection.getConnection();
            this.objDados = new objDadosDocente(p_obj.getId(), p_obj.getNome(), p_obj.getTitulo(), p_obj.getTempoXP(),
                    p_obj.getSenha(), p_obj.getUsuario());

        }catch (SQLException e){
            if (this.connection == null){
                System.exit(1);
            }
        }
    }

    public  boolean isDataBaseConected(){
        return this.connection != null;
    }

    public LinkedList<objDadosDocente> mtConsulta() throws SQLException {
        LinkedList<objDadosDocente> retorno;
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
                    retorno.add(new objDadosDocente(
                            dbRetorno.getInt("id"),
                            dbRetorno.getString("nome"),
                            dbRetorno.getString("titulo"),
                            dbRetorno.getInt("tempoXP"),
                            dbRetorno.getString("senha"),
                            dbRetorno.getString("usuario")
                    ));
                }
                return retorno;
            }catch (Exception e){
                throw e;
            }finally {

        }



    }

    public void mtInserir(){

    }

    public void mtIremover(){

    }

    public void mtAtualizar(){

    }
}
