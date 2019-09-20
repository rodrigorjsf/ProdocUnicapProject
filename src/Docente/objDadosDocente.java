package Docente;

public class objDadosDocente {
    private int id;
    private String nome;
    private String titulo;
    private int tempoXP;
    private String senha;
    private String usuario;


    public objDadosDocente() {
        this.id = 0;
        this.nome = "";
        this.titulo = "";
        this.tempoXP = 0;
        this.senha = "";
        this.usuario = "";
    }

    public objDadosDocente(int id, String nome, String titulo, int tempoXP, String senha, String usuario) {
        this.id = id;
        this.nome = nome;
        this.titulo = titulo;
        this.tempoXP = tempoXP;
        this.senha = senha;
        this.usuario = usuario;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTempoXP() {
        return tempoXP;
    }

    public void setTempoXP(int tempoXP) {
        this.tempoXP = tempoXP;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "objDadosDocente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", titulo='" + titulo + '\'' +
                ", tempoXP=" + tempoXP +
                ", senha='" + senha + '\'' +
                ", usuario='" + usuario + '\'' +
                '}';
    }
}
