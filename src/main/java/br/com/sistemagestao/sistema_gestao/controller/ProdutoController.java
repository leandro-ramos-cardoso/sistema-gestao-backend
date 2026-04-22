package br.com.sistemagestao.sistema_gestao.controller;

import br.com.sistemagestao.sistema_gestao.dto.produto.ProdutoRequestDTO;
import br.com.sistemagestao.sistema_gestao.dto.produto.ProdutoResponseDTO;
import br.com.sistemagestao.sistema_gestao.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponseDTO criarProduto(@Valid @RequestBody ProdutoRequestDTO dto) {
        return produtoService.criarProduto(dto);
    }
}
