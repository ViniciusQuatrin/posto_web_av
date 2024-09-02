package br.edu.utfpr.td.tsi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.MODELO.Consulta;

public class MysqlConsultaDAO implements ConsultaDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public void inserir(Consulta consulta, String idPaciente) {
        String sql = "INSERT INTO consulta (data_hora, idSituacao, idPaciente) VALUES (?, ?, ?)";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, consulta.getData_hora());
            preparedStatement.setString(2, consulta.getIdSituacao());
            preparedStatement.setString(3, idPaciente);
            preparedStatement.executeUpdate();

            conn.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void atualizar(String idPaciente, Consulta consulta) {
        String sql = "UPDATE consulta SET data_hora = ?, idSituacao = ? WHERE idPaciente = ?";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, consulta.getData_hora());
            preparedStatement.setString(2, consulta.getIdSituacao());
            preparedStatement.setString(3, idPaciente);
            preparedStatement.executeUpdate();

            conn.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void remover(String idPaciente) {
        String sql = "DELETE FROM consulta WHERE idPaciente = ?";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, idPaciente);
            preparedStatement.executeUpdate();

            conn.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    @Override
    public List<Consulta> listarTodos() {
        ArrayList<Consulta> consultas = new ArrayList<>();
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM consulta");
            preparedStatement.executeQuery();

            conn.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consultas;
    }

    @Override
    public Consulta procurar(String idPaciente) {
        String sql = "SELECT * FROM consulta WHERE idPaciente = ?";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, idPaciente);
            preparedStatement.executeQuery();

            conn.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
