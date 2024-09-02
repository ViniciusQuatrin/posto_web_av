package br.edu.utfpr.td.tsi.DAO;

import java.util.List;

import br.edu.utfpr.td.tsi.MODELO.Consulta;

public interface ConsultaDAO {
    
    public void inserir(Consulta consulta, String idPaciente);

    public void atualizar(String idPaciente, Consulta consulta);

    public void remover(String idPaciente);

    public List<Consulta> listarTodos();
    
    public Consulta procurar(String idPaciente);
}
