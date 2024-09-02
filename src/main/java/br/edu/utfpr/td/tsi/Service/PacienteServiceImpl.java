package br.edu.utfpr.td.tsi.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private DataSource dataSource;

    @Override
    public boolean podeAgendarConsulta(Long idPaciente) {
        String sql = "SELECT COUNT(*) FROM consulta WHERE idPaciente = ?";
       try (Connection conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setLong(1, idPaciente);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count == 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
