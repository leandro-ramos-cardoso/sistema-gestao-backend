package br.com.sistemagestao.sistema_gestao.service;

import br.com.sistemagestao.sistema_gestao.model.Fornecedor;
import br.com.sistemagestao.sistema_gestao.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    FornecedorRepository fornecedorRepository;

    public void criarFornecedor(Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public void deletarFornecedorPorId(Long id) {
        fornecedorRepository.deleteById(id);
    }

    public void atualizarFornecedorPorId(Long id, Fornecedor fornecedorAtualizadoNoFront) {

        // PASSO 01 - Pegar o que existe (O id o front que vai mandar)
        Optional<Fornecedor> fornecedor = buscarFornecedorPorId(id);

        // PASSO 02 - Se não existir o ID (Validar se existe o ID no BD)
        // Se entrar nesse IF o programa PARA aqui
        if(fornecedor.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Fornecedor não encontrado"
            );
        }

        // PASSO 03 - Sobescrever com a atualizacao (Se nao entrou no IF existe, entao prossigo com a atualizacao)
        Fornecedor fornecedorAtualizado = fornecedor.get();

        // O cnpj nao altera pois definimos que era update = false
        // SET no que existe e GET do que vem do front
        fornecedorAtualizado.setNomeFantasia(fornecedorAtualizadoNoFront.getNomeFantasia());
        fornecedorAtualizado.setEmail(fornecedorAtualizadoNoFront.getEmail());
        fornecedorAtualizado.setTelefonePrincipal(fornecedorAtualizadoNoFront.getTelefonePrincipal());
        fornecedorAtualizado.setTelefoneSecundario(fornecedorAtualizadoNoFront.getTelefoneSecundario());

        // PASSO 04 - Devolver atualizado para o BD
        fornecedorRepository.save(fornecedorAtualizado);
    }

}
