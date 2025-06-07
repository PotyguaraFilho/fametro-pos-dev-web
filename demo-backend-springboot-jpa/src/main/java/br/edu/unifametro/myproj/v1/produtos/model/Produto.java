package br.edu.unifametro.myproj.v1.produtos.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**	
 * Classe de domínio de negócio
 * @author marcos.eduardo
 */
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto; //titulo
    private String descricaoProduto; //descricao
    private LocalDateTime dataProduto; //data

    // Construtores e métodos getters/setters
    public Produto(Long id, String nomeProduto, String descricaoProduto, LocalDateTime dataProduto) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.dataProduto = dataProduto;
    }
    
    public Produto(Long id) {
        this.id = id;
    }
    public Produto() {
	}
    
	// Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }
	public LocalDateTime getDataProduto() {
		return dataProduto;
	}
	public void setDataProduto(LocalDateTime dataProduto) {
		this.dataProduto = dataProduto;
	}
    
}
