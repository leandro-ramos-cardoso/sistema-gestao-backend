package br.com.sistemagestao.sistema_gestao.controller;

import br.com.sistemagestao.sistema_gestao.dto.produto.ProdutoRequestDTO;
import br.com.sistemagestao.sistema_gestao.dto.produto.ProdutoResponseDTO;
import br.com.sistemagestao.sistema_gestao.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoResponseDTO> listarTodosProdutos() {
        return produtoService.listarTodosProdutos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoResponseDTO buscarProdutoPorId (@PathVariable Long id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoResponseDTO atualizarProdutoPorId(@PathVariable Long id, @RequestBody ProdutoRequestDTO dto){
        return produtoService.atualizarProdutoPorId(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProdutoPorId(@PathVariable Long id) {
        produtoService.deletarProdutoPorId(id);
    }
}
