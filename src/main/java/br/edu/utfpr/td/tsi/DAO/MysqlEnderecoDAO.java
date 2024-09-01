package br.edu.utfpr.td.tsi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.MODELO.Endereco;

@Component
public class MysqlEnderecoDAO implements EnderecoDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public void inserir(Endereco endereco, String idPaciente) {
        String sql = "INSERT INTO endereco (logradoura, numero, cep, idBairro, idPaciente) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, endereco.getLogradouro());
            preparedStatement.setString(2, endereco.getNumero());
            preparedStatement.setString(3, endereco.getCep());
            preparedStatement.setLong(4, endereco.getBairro().getId());
            preparedStatement.setString(5, idPaciente);
            preparedStatement.executeUpdate();

            conn.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }

    @Override
    public void atualizar(String idPaciente, Endereco endereco) {
        String sql = "UPDATE endereco SET logradouro = ?, numero = ?, cep = ?, idBairro = ? WHERE idPaciente = ?";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, endereco.getLogradouro());
            preparedStatement.setString(2, endereco.getNumero());
            preparedStatement.setString(3, endereco.getCep());
            preparedStatement.setLong(4, endereco.getBairro().getId());
            preparedStatement.setString(5, idPaciente);
            preparedStatement.executeUpdate();

            conn.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover(String idPaciente) {
        String sql = "DELETE FROM endereco WHERE idPaciente = ?";
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
    public List<Endereco> listarTodos() {
       ArrayList<Endereco> enderecos = new ArrayList<>();
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM endereco");
            preparedStatement.executeQuery();

            conn.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enderecos;
    }

    @Override
    public Endereco procurar(String idPaciente) {
        String sql = "SELECT * FROM endereco WHERE idPaciente = ?";
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
