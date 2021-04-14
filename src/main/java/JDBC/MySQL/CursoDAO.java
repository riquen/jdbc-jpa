package JDBC.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    public List<Curso> list () {
        List<Curso> cursos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT id, nome, duracao_horas FROM curso";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String duracaoHoras = rs.getString("duracao_horas");

                cursos.add(new Curso(
                        id,
                        nome,
                        duracaoHoras
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro na listagem dos cursos.");
            e.printStackTrace();
        }
        return cursos;
    }

    public Curso getById (int id) {
        Curso curso = new Curso();

        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT id, nome, duracao_horas FROM curso WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();

            if (rs.next()) {
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setDuracaoHoras(rs.getString("duracao_horas"));
            }
        } catch (SQLException e) {
            System.out.println("Erro na listagem dos cursos.");
            e.printStackTrace();
        }
        return curso;
    }

    public void create(Curso curso) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO curso(nome, duracao_horas) VALUES (?, ?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, curso.getNome());
            stat.setString(2, curso.getDuracaoHoras());

            int rowsAffected = stat.executeUpdate();
            System.out.println("Inserido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro na inserção.");
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM curso WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);

            int rowsAffected = stat.executeUpdate();
            System.out.println("Deletado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro em deletar.");
            e.printStackTrace();
        }
    }

    public void update(Curso curso) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "UPDATE curso SET nome = ?, duracao_horas = ? WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, curso.getNome());
            stat.setString(2, curso.getDuracaoHoras());
            stat.setInt(3, curso.getId());

            int rowsAffected = stat.executeUpdate();
            System.out.println("Atualizado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro na atualização.");
            e.printStackTrace();
        }
    }
}
