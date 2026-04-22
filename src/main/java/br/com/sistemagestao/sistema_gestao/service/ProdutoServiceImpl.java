package br.com.sistemagestao.sistema_gestao.service;

import br.com.sistemagestao.sistema_gestao.dto.produto.ProdutoRequestDTO;
import br.com.sistemagestao.sistema_gestao.dto.produto.ProdutoResponseDTO;
import br.com.sistemagestao.sistema_gestao.mapper.ProdutoMapper;
import br.com.sistemagestao.sistema_gestao.model.Fornecedor;
import br.com.sistemagestao.sistema_gestao.model.Produto;
import br.com.sistemagestao.sistema_gestao.repository.FornecedorRepository;
import br.com.sistemagestao.sistema_gestao.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService{

    private final FornecedorRepository fornecedorRepository;
    private final ProdutoRepository produtoRepository;

    @Override
    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO dto) {

        // Resgatar do BD o fornecedor desse produto
        Fornecedor fornecedor = fornecedorRepository.findById(dto.fornecedorId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Fornecedor não encontrado"
                ));

        // Converter o DTO para Entity, para salvar no banco de dados
        Produto produto = ProdutoMapper.toEntity(dto, fornecedor);

        // Tirei do DTO, converti para Entity, agora sim posso salvar no banco de dados
        produtoRepository.save(produto);

        // Retorno para o frontend
        return ProdutoMapper.toResponseDTO(produto);
    }

    @Override
    public List<ProdutoResponseDTO> listarTodosProdutos() {
        return List.of();
    }

    @Override
    public ProdutoResponseDTO buscarProdutoPorId(Long id) {
        return null;
    }

    @Override
    public ProdutoResponseDTO atualizarProdutoPorId(Long id, ProdutoRequestDTO dto) {
        return null;
    }

    @Override
    public void deletarProdutoPorId(Long id) {

    }
}
