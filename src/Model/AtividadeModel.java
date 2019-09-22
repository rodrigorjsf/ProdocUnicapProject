package Model;

public class AtividadeModel {

    //Declarações

    private int CodProf;
    private String descricao;
    private int pontucao;
    private String status;
    private int codAtiv;

    //Construtores

    public AtividadeModel() {
        this.CodProf = 0;
        this.descricao = "";
        this.pontucao = 0;
        this.status = "";
        this.codAtiv = 0;
    }
    public AtividadeModel(int codProf, String descricao, int pontucao, String status, int codAtiv) {
        this.CodProf = codProf;
        this.descricao = descricao;
        this.pontucao = pontucao;
        this.status = status;
        this.codAtiv = codAtiv;
    }

    //Getters e setters
    public int getCodProf() {
        return CodProf;
    }
    public void setCodProf(int codProf) {
        CodProf = codProf;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getPontucao() {
        return pontucao;
    }
    public void setPontucao(int pontucao) {
        this.pontucao = pontucao;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getCodAtiv() {
        return codAtiv;
    }
    public void setCodAtiv(int codAtiv) {
        this.codAtiv = codAtiv;
    }

    //ToString
    @Override public String toString() {
        return "objDadosAtividade{" +
                "CodProf=" + CodProf +
                ", descricao='" + descricao + '\'' +
                ", pontucao=" + pontucao +
                ", status='" + status + '\'' +
                ", codAtiv=" + codAtiv +
                '}';
    }
}
