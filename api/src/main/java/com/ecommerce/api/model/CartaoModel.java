package com.ecommerce.api.model;

import com.ecommerce.api.dto.CartaoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Cartao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome_cartao;
    private int numero_cartao;
    private double validade_cartao;
    private int cvv_cartao;

    public CartaoModel(CartaoDto Dto)  {
        this.nome_cartao = Dto.nome_cartao();
        this.numero_cartao = Dto.numero_cartao();
        this.validade_cartao = Dto.validade_cartao();
        this.cvv_cartao = Dto.cvv_cartao();
    }
}

