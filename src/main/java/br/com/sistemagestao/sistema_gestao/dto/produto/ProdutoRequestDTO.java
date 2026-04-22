package br.com.sistemagestao.sistema_gestao.dto.produto;

import br.com.sistemagestao.sistema_gestao.enums.CategoriaProdutoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
        // Campos que o frontend vai conseguir enxergar // DTO = Filtro

        @NotBlank(message = "O nome do produto é obrigatório") // Validacao do Java
        String nome,

        String descricao,

        @NotNull(message = "O preço é obrigatório")
        @PositiveOrZero(message = "O preço deve ser maior ou igual a zero")
        BigDecimal preco,

        @NotNull(message = "A quantidade em estoque é obrigatória")
        @PositiveOrZero(message = "A quantidade em estoque não pode ser negativa")
        Integer quantidadeEstoque,

        @NotNull(message = "A categoria é obrigatória")
        CategoriaProdutoEnum categoria,

        @NotNull(message = "O fornecedor é obrigatório")
        Long fornecedorId
        // No front nao é enviado o objeto Fornecedor (Java) e sim o id dele que depois será convertido em objeto Java.
) {
    // Alusao ao futuro JSON (O que vem do front)
    // Request - JSON que vem do front e Response - JSON que vai para o front
}
