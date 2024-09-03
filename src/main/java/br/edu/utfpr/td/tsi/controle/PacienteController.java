package br.edu.utfpr.td.tsi.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.td.tsi.DAO.EnderecoDAO;
import br.edu.utfpr.td.tsi.DAO.PacienteDAO;
import br.edu.utfpr.td.tsi.MODELO.Endereco;
import br.edu.utfpr.td.tsi.MODELO.Paciente;

@Controller
public class PacienteController {
    
    @Autowired
    PacienteDAO pacienteDAO;
    EnderecoDAO enderecoDAO;

    @GetMapping("/listarPacientes")
    public String listar( Model model) {
        List<Paciente> pacientes = pacienteDAO.listarTodos();
        model.addAttribute("pacientes", pacientes);
        return "listarPacientes";

    }

    @GetMapping(value = "/cadastrarpaciente")
    public String cadastrarPaciente() {
        return "cadastrarpaciente";
    }

    @PostMapping("/cadastrarPaciente")
    public String cadastrar(Paciente paciente, Endereco endereco) {
        pacienteDAO.inserir(paciente);
        enderecoDAO.inserir(endereco, paciente.getId());
        return "redirect:/listarPacientes";
    }
}
