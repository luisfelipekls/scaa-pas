package br.com.scaa.domain;

import java.io.Serializable;

public class AssinaturaCacheModel implements Serializable {
    private Long assinaturaId;
    private String clienteNome;
    private String aplicativoNome;
    private String status;
    private String validade;

    // Getters e Setters
    public Long getAssinaturaId() {
        return assinaturaId;
    }

    public void setAssinaturaId(Long assinaturaId) {
        this.assinaturaId = assinaturaId;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getAplicativoNome() {
        return aplicativoNome;
    }

    public void setAplicativoNome(String aplicativoNome) {
        this.aplicativoNome = aplicativoNome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
}
