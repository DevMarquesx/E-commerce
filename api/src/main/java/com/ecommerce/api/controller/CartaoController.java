package com.ecommerce.api.controller;

import com.ecommerce.api.dto.CartaoDto;
import com.ecommerce.api.dto.ProdutosDto;
import com.ecommerce.api.model.CartaoModel;
import com.ecommerce.api.model.ProdutosModel;
import com.ecommerce.api.repository.CartaoRepository;
import com.ecommerce.api.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("cart")
public class CartaoController {

    @Autowired
    CartaoRepository repo;

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    @PostMapping
    public ResponseEntity<CartaoModel> criarCartao(@RequestBody CartaoDto cartaoDto) {
        CartaoModel cartoes = new CartaoModel(cartaoDto);
        repo.save(cartoes);
        return ResponseEntity.status(201).body(cartoes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartaoModel> atualizarCartao(@PathVariable UUID id, @RequestBody CartaoDto cartaoDto) {
        Optional<CartaoModel> CartaoExistente = repo.findById(id);

        if (CartaoExistente.isPresent()) {
            CartaoModel cartoes = CartaoExistente.get();
            cartoes.setNome_cartao(cartaoDto.nome_cartao());
            cartoes.setNumero_cartao(cartaoDto.numero_cartao());
            cartoes.setValidade_cartao(cartaoDto.validade_cartao());
            cartoes.setCvv_cartao(cartaoDto.cvv_cartao());

            repo.save(cartoes);
            return ResponseEntity.ok(cartoes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
