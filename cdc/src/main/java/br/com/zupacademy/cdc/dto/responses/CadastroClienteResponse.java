package br.com.zupacademy.cdc.dto.responses;

public class CadastroClienteResponse {
    private Long id;

    public CadastroClienteResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}