package br.com.sistemagestao.sistema_gestao.repository;

import br.com.sistemagestao.sistema_gestao.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
