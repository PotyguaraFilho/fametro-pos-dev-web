package br.edu.unifametro.myproj.v1.produtos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifametro.myproj.v1.produtos.dto.ProdutoDto;
import br.edu.unifametro.myproj.v1.produtos.mapper.ProdutoMapper;
import br.edu.unifametro.myproj.v1.produtos.model.Produto;
import br.edu.unifametro.myproj.v1.produtos.service.ServicoProduto;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

	private final ServicoProduto produtoService;

	public ProdutoController(ServicoProduto produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping
	public ResponseEntity<List<ProdutoDto>> listarTodos() {
		List<Produto> produtos = produtoService.listarProdutos();
		return ResponseEntity.ok(ProdutoMapper.toDtoList(produtos));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDto> obterPorId(@PathVariable Long id) {
		Produto produto = produtoService.buscarProdutoPorId(id);
		return ResponseEntity.ok(ProdutoMapper.toDto(produto));
	}

	@PostMapping
	public ResponseEntity<ProdutoDto> criarProduto(@RequestBody Produto Produto) {
		Produto produto = ProdutoMapper.fromDto(Produto);
		Produto novoProduto = produtoService.criarProduto(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoMapper.toDto(novoProduto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
		produtoService.removerProduto(new Produto(id));
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDto> editarProduto(@PathVariable Long id, @RequestBody Produto Produto) {
		Produto.setId(id);
		Produto produto = ProdutoMapper.fromDto(Produto);
		Produto produtoAtualizado = produtoService.atualizarProduto(produto);
		return ResponseEntity.ok(ProdutoMapper.toDto(produtoAtualizado));
	}

}
