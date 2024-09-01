package br.edu.utfpr.td.tsi.MODELO;

import org.springframework.format.annotation.DateTimeFormat;

public class Consulta {
    
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private String data_hora;
    private String idSituacao;
    
    public Consulta() {
        
    }
    
    public Consulta(Long id, String data, String hora, String descricao) {
        super();
        this.id = id;
        this.data_hora = data + " " + hora;
        this.idSituacao = descricao;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String dataHora) {
        this.data_hora = dataHora;
    }

    public String getIdSituacao() {
        return idSituacao;
    }

    public void setIdSituacao(String idSituacao) {
        this.idSituacao = idSituacao;
    }

}
