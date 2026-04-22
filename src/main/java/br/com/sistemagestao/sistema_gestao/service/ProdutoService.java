package br.com.sistemagestao.sistema_gestao.service;

import br.com.sistemagestao.sistema_gestao.dto.produto.ProdutoRequestDTO;
import br.com.sistemagestao.sistema_gestao.dto.produto.ProdutoResponseDTO;

import java.util.List;

public interface ProdutoService {

    // Apenas assinaturas dos métodos

    ProdutoResponseDTO criarProduto(ProdutoRequestDTO dto);
    List<ProdutoResponseDTO> listarTodosProdutos();
    ProdutoResponseDTO buscarProdutoPorId(Long id);
    ProdutoResponseDTO atualizarProdutoPorId(Long id, ProdutoRequestDTO dto);
    void deletarProdutoPorId(Long id);
}
