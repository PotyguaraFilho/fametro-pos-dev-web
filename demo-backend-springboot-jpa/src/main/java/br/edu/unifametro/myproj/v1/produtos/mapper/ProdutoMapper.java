package br.edu.unifametro.myproj.v1.produtos.mapper;

import java.util.List;

import br.edu.unifametro.myproj.v1.produtos.dto.ProdutoDto;
import br.edu.unifametro.myproj.v1.produtos.model.Produto;

public class ProdutoMapper {

    public static ProdutoDto toDto(Produto in) {
        ProdutoDto out = new ProdutoDto();
        out.setId(in.getId());
        out.setNomeProduto(in.getNomeProduto());
        out.setDescricaoProduto(in.getDescricaoProduto());
        out.setDataProduto(in.getDataProduto());
        return out;
    }
    
    public static Produto fromDto(Produto produto) { 
        Produto out = new Produto();
        out.setId(produto.getId());
        out.setNomeProduto(produto.getNomeProduto());
        out.setDescricaoProduto(produto.getDescricaoProduto());
        out.setDataProduto(produto.getDataProduto());
        return out;
    }

    public static List<ProdutoDto> toDtoList(List<Produto> list) {
        return list.stream()
                .map(ProdutoMapper::toDto)
                .toList();
    }

    public static List<Produto> fromDtoList(List<Produto> list) {
        return list.stream()
                .map(ProdutoMapper::fromDto)
                .toList();
    }
}
