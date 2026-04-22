package br.com.sistemagestao.sistema_gestao.model;

import br.com.sistemagestao.sistema_gestao.enums.CategoriaProdutoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    // O @Column é uma validacao do banco de dados
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @Column(name = "quantidade_estoque", nullable = false)
    private Integer quantidadeEstoque;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", nullable = false)
    private CategoriaProdutoEnum categoria;
    // @Enumerated No banco ao inves de exibir categorias 0,1,2 mostra o nome da categoria

    // Um produto é fornecido por um FORNECEDOR. (Um fornecedor associado ao produto)
    @ManyToOne // Muitos (Classe atual = PRODUTO) para 1 FORNECEDOR
    @JoinColumn(name = "fornecedor_id", nullable = false) // Fornecedor era chave primaria na table dele e aqui vira chave estrangeira
    private Fornecedor fornecedor;
}
