package br.edu.unifametro.myproj.v1.produtos.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.unifametro.myproj.exception.RecursoNaoEncontradoGlobalException;
import br.edu.unifametro.myproj.v1.produtos.model.Produto;
import br.edu.unifametro.myproj.v1.produtos.repository.RepositorioProduto;

@Service
public class ServicoProduto {

    private final RepositorioProduto repositorioProduto;

    public ServicoProduto(RepositorioProduto repositorioProduto) {
        this.repositorioProduto = repositorioProduto;
    }

    public List<Produto> listarProdutos() {
        Sort ordenacao = Sort.by(Sort.Direction.DESC, "id");
        List<Produto> produtos = repositorioProduto.findAllOrdered(ordenacao);
        if (produtos.isEmpty()) {
            throw new RecursoNaoEncontradoGlobalException("Nenhum produto encontrada.");
        }
        return produtos;
    }

    public Produto criarProduto(Produto novaProduto) {
        return repositorioProduto.save(novaProduto);
    }

    public Produto atualizarProduto(Produto produto) {
        assegurarExistenciaProduto(produto.getId());
        return repositorioProduto.save(produto);
    }

    public void removerProduto(Produto produto) {
        assegurarExistenciaProduto(produto.getId());
        repositorioProduto.deleteById(produto.getId());
    }
    
    public Produto buscarProdutoPorId(Long id) {
        return repositorioProduto.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoGlobalException("Produto com ID " + id + " não encontrada."));
    }

    /**
     * Verifica se uma entidade Produto existe no repositório pelo ID.
     * Lança uma exceção se a entidade não for encontrada.
     * @param id O identificador da entidade Produto
     */
    private void assegurarExistenciaProduto(Long id) {
        if (!repositorioProduto.existsById(id)) {
            throw new RecursoNaoEncontradoGlobalException("Produto com ID " + id + " não encontrada.");
        }
    }
    
}
