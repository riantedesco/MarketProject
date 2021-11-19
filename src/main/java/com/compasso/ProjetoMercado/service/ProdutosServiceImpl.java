package com.compasso.ProjetoMercado.service;

import com.compasso.ProjetoMercado.entity.Produtos;
import com.compasso.ProjetoMercado.repository.ProdutosRepository;
import com.compasso.ProjetoMercado.dto.ProdutosDTO;
import com.compasso.ProjetoMercado.dto.ProdutosFormDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProdutosServiceImpl implements ProdutosService{

    @Autowired
    private ProdutosRepository repository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public ProdutosDTO consultar(Long id) {
        Optional<Produtos> Produtos = this.repository.findById(id);
        if (Produtos.isPresent() == true) {
            return mapper.map(Produtos.get(), ProdutosDTO.class);
        }
        throw new RuntimeException("Produto não encontrado");
    }


    @Override
    public ProdutosDTO atualizar(Long id, ProdutosFormDTO body) {
        Optional<Produtos> Produtos = this.repository.findById(id);
        if (Produtos.isPresent() == true) {
            Produtos.get().setNome(body.getNome());
            Produtos pt = this.repository.save(Produtos.get());
            return mapper.map(pt, ProdutosDTO.class);
        }
        throw new RuntimeException("Produto não encontrado");
    }

    @Override
    public void excluir(Long id) {
        Produtos Produtos = this.repository.findById(id).get();
        this.repository.delete(Produtos);
    }
}
