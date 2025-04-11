package com.projetoapi.dto;

public class BaseResponseDto {

    private Integer condigo;
    private String mensagem;
    private Object dados;

    public Integer getCondigo() {
        return condigo;
    }

    public void setCondigo(Integer condigo) {
        this.condigo = condigo;
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
