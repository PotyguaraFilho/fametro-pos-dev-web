package br.edu.unifametro.myproj.v1.produtos.dto;

import java.time.LocalDateTime;

/**
 * Um DTO é uma classe simples que contém 
 * apenas as informações necessárias para 
 * transferência de dados.
 * @author marcos.eduardo
 */
public class ProdutoDto {
	
    private Long id;
    private String nomeProduto;
    private String descricaoProduto;
    private LocalDateTime dataProduto;

    // Construtor
    public ProdutoDto(Long id, String nomeProduto, String descricaoProduto, LocalDateTime dataProduto) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.dataProduto = dataProduto;
    }
    // Construtor
    public ProdutoDto(String nomeProduto, String descricaoProduto) {
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
    }
    
    public ProdutoDto() {
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
