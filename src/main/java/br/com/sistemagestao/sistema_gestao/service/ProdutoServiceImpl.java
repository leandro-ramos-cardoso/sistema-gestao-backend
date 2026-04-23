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
        return produtoRepository.findAll().stream().map(ProdutoMapper::toResponseDTO).toList();
    }

    @Override
    public ProdutoResponseDTO buscarProdutoPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Produto não encontrado"));

        return ProdutoMapper.toResponseDTO(produto);
    }

    @Override
    public ProdutoResponseDTO atualizarProdutoPorId(Long id, ProdutoRequestDTO dto) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Produto não encontrado"));

        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());
        produto.setQuantidadeEstoque(dto.quantidadeEstoque());
        produto.setCategoria(dto.categoria());
        produto.setFornecedor(buscarFornecedorPorid(dto.fornecedorId()));

        return ProdutoMapper.toResponseDTO(produto);
    }

    @Override
    public void deletarProdutoPorId(Long id) {
        if(!produtoRepository.existsById(id)) {
            throw new
                    ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Produto não encontrado");
        }
        produtoRepository.deleteById(id);
    }

    private Fornecedor buscarFornecedorPorid(Long id) {
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }
}
