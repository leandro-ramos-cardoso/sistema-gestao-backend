package br.com.sistemagestao.sistema_gestao.dto.produto;

import br.com.sistemagestao.sistema_gestao.enums.CategoriaProdutoEnum;

import java.math.BigDecimal;

public record ProdutoResponseDTO(

        // Campos que serão respondidos ao frontend

        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        Integer quantidadeEstoque,
        CategoriaProdutoEnum categoria,
        Long fornecedorId,
        String fornecedorNome
) {
}
