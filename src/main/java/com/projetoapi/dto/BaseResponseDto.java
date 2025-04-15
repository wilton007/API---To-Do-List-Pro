package com.projetoapi.dto;

public class BaseResponseDto {

    private Integer codigo;
    private String mensagem;
    private Object dados;

    public Integer getCondigo() {
        return codigo;
    }

    public void setCondigo(Integer condigo) {
        this.codigo = condigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Object getDados() {
        return dados;
    }

    public void setDados(Object dados) {
        this.dados = dados;
    }
}
