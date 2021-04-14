package JDBC.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    public List<Aluno> list () {
        List<Aluno> alunos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT id, nome, idade, estado FROM aluno";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String estado = rs.getString("estado");

                alunos.add(new Aluno(
                        id,
                        nome,
                        idade,
                        estado
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro na listagem dos alunos.");
            e.printStackTrace();
        }
        return alunos;
    }

    public Aluno getById (int id) {
        Aluno aluno = new Aluno();

        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT id, nome, idade, estado FROM aluno WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();

            if (rs.next()) {
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Erro na listagem dos alunos.");
            e.printStackTrace();
        }
        return aluno;
    }

    public void create(Aluno aluno) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO aluno(nome, idade, estado) VALUES (?, ?, ?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, aluno.getNome());
            stat.setInt(2, aluno.getIdade());
            stat.setString(3, aluno.getEstado());

            int rowsAffected = stat.executeUpdate();
            System.out.println("Inserido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro na inserção.");
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM aluno WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);

            int rowsAffected = stat.executeUpdate();
            System.out.println("Deletado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro em deletar.");
            e.printStackTrace();
        }
    }

    public void update(Aluno aluno) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "UPDATE aluno SET nome = ?, idade = ?, estado = ? WHERE id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, aluno.getNome());
            stat.setInt(2, aluno.getIdade());
            stat.setString(3, aluno.getEstado());
            stat.setInt(4, aluno.getId());

            int rowsAffected = stat.executeUpdate();
            System.out.println("Atualizado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro na atualização.");
            e.printStackTrace();
        }
    }
}
