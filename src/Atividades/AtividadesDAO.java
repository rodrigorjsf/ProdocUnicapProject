package Atividades;

import Model.AtividadeModel;
import Model.DocenteModel;
import dbUtil.dbConection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class AtividadesDAO {

    //Declarações
    private Connection connection;
    //private AtividadeModel objDados;

    //Construtores


    public AtividadesDAO() {
        try {
            this.connection = dbConection.getConnection();

            //this.objDados = new AtividadeModel(p_obj.getCodProf(), p_obj.getDescricao(), p_obj.getPontucao(),
            //        p_obj.getStatus(), p_obj.getCodAtiv());
        }catch (SQLException e){
            if (this.connection == null){
                System.exit(1);
            }
        }
    }

    //Métodos e Funções


    public  boolean isDataBaseConected(){
        return this.connection != null;
    }
    public LinkedList<AtividadeModel> mtConsulta(DocenteModel p_obj) throws SQLException{
        LinkedList<AtividadeModel> retorno;
        Statement stmt;
        ResultSet dbRetorno;

        try{
            retorno = new LinkedList<>();
            String Comando;
            Comando = "select * from tbAtividades ";
            Comando = Comando + " where codProf = " + p_obj.getId();

            stmt = this.connection.createStatement();
            dbRetorno = stmt.executeQuery(Comando);
            while(dbRetorno.next()){
                retorno.add(new AtividadeModel(
                        dbRetorno.getInt("codProf"),
                        dbRetorno.getString("descricao"),
                        dbRetorno.getInt("pontuacao"),
                        dbRetorno.getString("status"),
                        dbRetorno.getInt("codAtiv")
                ));
            }
            return retorno;
        }catch (Exception e){
            throw e;
        }
    }
    public LinkedList<AtividadeModel> mtConsultaTodos() throws SQLException{
        LinkedList<AtividadeModel> retorno;
        Statement stmt;
        ResultSet dbRetorno;

        try{
            retorno = new LinkedList<>();
            String Comando;
            Comando = "select * from tbAtividades ";

            stmt = this.connection.createStatement();
            dbRetorno = stmt.executeQuery(Comando);
            while(dbRetorno.next()){
                retorno.add(new AtividadeModel(
                        dbRetorno.getInt("codProf"),
                        dbRetorno.getString("descricao"),
                        dbRetorno.getInt("pontuacao"),
                        dbRetorno.getString("status"),
                        dbRetorno.getInt("codAtiv")
                ));
            }
            return retorno;
        }catch (Exception e){
            throw e;
        }
    }
    public boolean mtInserir(AtividadeModel p_Ativ, DocenteModel p_Doc){
        Statement stmt = null;
        String Comando;

        try{
            this.connection.setAutoCommit(false);
            stmt = this.connection.createStatement();

            Comando = "insert into tbAtividades (CodProf, descricao, pontuacao, status)";
            Comando = Comando + " values(" + p_Doc.getId() + ", ";
            Comando = Comando + "'" + p_Ativ.getDescricao() + "', ";
            Comando = Comando + p_Ativ.getPontucao() + ", ";
            Comando = Comando + "'" + p_Ativ.getStatus() + "') ";

            stmt.executeUpdate(Comando);
            stmt.close();
            this.connection.commit();
            return true;

        }catch (Exception e){
            return false;
        }
    }
    public boolean mtUpdate(AtividadeModel p_obj){
        Statement stmt;
        ResultSet dbRetorno;
        String Comando;

        try{
            this.connection.setAutoCommit(false);

            Comando = "update tbAtividades ";
            Comando = Comando + " set pontuacao = '" + p_obj.getPontucao() + "', ";
            Comando = Comando + " status = '" + p_obj.getStatus() + "'";
            Comando = Comando + " where codAtiv = " + p_obj.getCodAtiv();
            stmt = this.connection.createStatement();
            stmt.executeUpdate(Comando);
            connection.commit();
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public boolean mtDelete(AtividadeModel p_obj){
        Statement stmt;
        ResultSet dbRetorno;
        String Comando;
        try{
            this.connection.setAutoCommit(false);

            Comando = "DELETE from tbAtividades ";
            Comando = Comando + " where codAtiv = " + p_obj.getCodAtiv();
            stmt = this.connection.createStatement();
            stmt.executeUpdate(Comando);
            connection.commit();
            return true;

        }catch (Exception e) {
            return false;
        }
    }

    //Getters e setters

}
