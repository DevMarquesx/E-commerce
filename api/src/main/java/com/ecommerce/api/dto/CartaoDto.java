package com.ecommerce.api.dto;

public record CartaoDto(String nome_cartao, int numero_cartao,
                        double validade_cartao, int cvv_cartao) {
}
