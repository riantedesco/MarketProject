package com.compasso.ProjetoMercado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.ProjetoMercado.dto.ProdutosDto;
import com.compasso.ProjetoMercado.dto.ProdutosFormDto;
import com.compasso.ProjetoMercado.entity.ItemCompra;
import com.compasso.ProjetoMercado.entity.ItemNotaFiscal;
import com.compasso.ProjetoMercado.entity.Marca;
import com.compasso.ProjetoMercado.entity.Produtos;
import com.compasso.ProjetoMercado.entity.Setor;
import com.compasso.ProjetoMercado.exception.ErroChaveEstrangeiraException;
import com.compasso.ProjetoMercado.repository.MarcaRepository;
import com.compasso.ProjetoMercado.repository.ProdutosRepository;
import com.compasso.ProjetoMercado.repository.SetorRepository;
import com.compasso.ProjetoMercado.validation.DadosNulosValidation;

@Service
public class ProdutosServiceImpl implements ProdutosService {

	private List<ItemNotaFiscal> itensNotaFiscal = new ArrayList<ItemNotaFiscal>();
	
	private List<ItemCompra> itensCompra = new ArrayList<ItemCompra>();
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	@Autowired
	private SetorRepository setorRepository;
	
    @Autowired
    private ModelMapper mapper;
    
    @Autowired
	private DadosNulosValidation validation;

    @Override
    public ProdutosDto salvar(ProdutosFormDto body) {
    	mapper.getConfiguration().setAmbiguityIgnored(true);
        Produtos produtos = mapper.map(body, Produtos.class);
        
        if (body.getIdMarca() != null) {
	        Optional<Marca> marca = this.marcaRepository.findById(body.getIdMarca());
			if (marca.isPresent() == true) {
				produtos.setMarca(marca.get());
			} else {
				throw new ErroChaveEstrangeiraException("Marca não encontrada");
			}
        }
		
        if (body.getIdSetor() != null) {
			Optional<Setor> setor = this.setorRepository.findById(body.getIdSetor());
			if (setor.isPresent() == true) {
				produtos.setSetor(setor.get());
			} else {
				throw new ErroChaveEstrangeiraException("Setor não encontrado");
			}
        }
		
        for(ItemNotaFiscal inf : itensNotaFiscal) {
			produtos.setQuantidade(produtos.getQuantidade() + inf.getQuantidade());
		}
        for(ItemCompra icp : itensCompra) {
        	produtos.setQuantidade(produtos.getQuantidade() - icp.getQuantidade());
        }
        
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
        Optional<Marca> marca = this.marcaRepository.findById(body.getIdMarca());
        Optional<Setor> setor = this.setorRepository.findById(body.getIdSetor());
        if (produtos.isPresent() == true) {
            produtos.get().setNome(body.getNome());
            produtos.get().setValor(body.getValor());
            if (marca.isPresent() == true) {
    			produtos.get().setMarca(marca.get());
    		} else {
    			throw new ErroChaveEstrangeiraException("Marca não encontrada");
    		}
            if (setor.isPresent() == true) {
    			produtos.get().setSetor(setor.get());
    		} else {
    			throw new ErroChaveEstrangeiraException("Setor não encontrado");
    		}
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