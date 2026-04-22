package br.com.sistemagestao.sistema_gestao.repository;

import br.com.sistemagestao.sistema_gestao.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}