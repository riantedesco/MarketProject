package com.compasso.ProjetoMercado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.compasso.ProjetoMercado.dto.ProdutosDto;
import com.compasso.ProjetoMercado.dto.ProdutosFormDto;
import com.compasso.ProjetoMercado.entity.Produtos;
import com.compasso.ProjetoMercado.repository.ProdutosRepository;
import com.compasso.ProjetoMercado.validation.DadosNulosValidation;

public class ProdutosServiceImpl implements ProdutosService {

	@Autowired
	private ProdutosRepository produtosRepository;
	
    @Autowired
    private ModelMapper mapper;
    
    @Autowired
	private DadosNulosValidation validation;

    @Override
    public ProdutosDto salvar(ProdutosFormDto body) {
        Produtos produtos = mapper.map(body, Produtos.class);
        validation.validaProduto(produtos);
        Produtos produtosResponse = this.produtosRepository.save(produtos);
        return mapper.map(produtosResponse, ProdutosDto.class);
    }
    
    @Override
	public List<ProdutosDto> listar() {
		List<ProdutosDto> produtos = new ArrayList<>();
		produtos = this.produtosRepository.findAll().stream().map(c -> mapper.map(c, ProdutosDto.class))
					.collect(Collectors.toList());
		return produtos;
	}

    @Override
    public ProdutosDto procurar(Long id) {
        Optional<Produtos> produtos = this.produtosRepository.findById(id);
        if (produtos.isPresent() == true) {
            return mapper.map(produtos.get(), ProdutosDto.class);
        }
        throw new RuntimeException("Produto não encontrado");
    }


    @Override
    public ProdutosDto atualizar(Long id, ProdutosFormDto body) {
        Optional<Produtos> produtos = this.produtosRepository.findById(id);
        if (produtos.isPresent() == true) {
            produtos.get().setNome(body.getNome());
            produtos.get().setValor(body.getValor());
            produtos.get().setQuantidade(body.getQuantidade());
            produtos.get().setMarca(body.getMarca());
            produtos.get().setSetor(body.getSetor());
            Produtos pt = this.produtosRepository.save(produtos.get());
            return mapper.map(pt, ProdutosDto.class);
        }
        throw new RuntimeException("Produto não encontrado");
    }

    @Override
    public void remover(Long id) {
    	Optional<Produtos> produtos = this.produtosRepository.findById(id);
		if (produtos.isPresent() == true) {
			this.produtosRepository.deleteById(id);
		} else {
			throw new RuntimeException("Produto não encontrado");
		}
    }
}