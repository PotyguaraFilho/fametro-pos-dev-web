package br.edu.unifametro.myproj.v1.produtos.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.unifametro.myproj.v1.produtos.model.Produto;

/**
 * Interface de repositório para a entidade Produto.
 * Esta interface fornece métodos CRUD padrão para a entidade Produto e 
 * outros métodos genéricos (de uso padrão) de acesso e manipulação
 * de dados.
 */
public interface RepositorioProduto extends JpaRepository<Produto, Long> {

    /**
     * Retorna todos os registros da entidade Produto ordenados de acordo com a ordenação especificada.</br></br><b>
     *
     * Exemplo de uso:											</br></b>
     *  Sort ordenacao = Sort.by(Sort.Direction.DESC, "id");	</br>
     *  return repositorioProduto.findAllOrdered(ordenacao);
     *  
     *  </br></br>
     * @param ordenacao o tipo de ordenação a ser aplicado
     * @return uma lista de objetos Produto ordenados de acordo com a ordenação especificada
     */
    @Query("SELECT x FROM Produto x")//query jpql
    List<Produto> findAllOrdered(Sort ordenacao);
}
