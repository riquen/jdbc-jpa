package JDBC.MySQL;

public class Curso {
    private int id;
    private String nome;
    private String duracaoHoras;

    public Curso(int id, String nome, String duracaoHoras) {
        this.id = id;
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso(String nome, String duracaoHoras) {
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso () {}

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

    public String getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(String duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", duracao_horas='" + duracaoHoras + '\'' +
                '}';
    }
}
