package com.compasso.ProjetoMercado.validation;

import org.springframework.stereotype.Service;

import com.compasso.ProjetoMercado.entity.Caixa;
import com.compasso.ProjetoMercado.entity.Cliente;
import com.compasso.ProjetoMercado.entity.Compra;
import com.compasso.ProjetoMercado.entity.Funcionario;
import com.compasso.ProjetoMercado.entity.ItemCompra;
import com.compasso.ProjetoMercado.entity.ItemNotaFiscal;
import com.compasso.ProjetoMercado.entity.Marca;
import com.compasso.ProjetoMercado.entity.NotaFiscal;
import com.compasso.ProjetoMercado.entity.Produtos;
import com.compasso.ProjetoMercado.entity.Setor;
import com.compasso.ProjetoMercado.exception.ErroDadosNulosException;

@Service
public class DadosNulosValidation {
	
	public void validaCliente (Cliente cliente) {
		if (cliente.getCpf() == null) {
			throw new ErroDadosNulosException("O CPF não pode ser nulo");
		}
		if (cliente.getNome() == null) {
			throw new ErroDadosNulosException("O nome não pode ser nulo");
		}
		if (cliente.getDataNascimento() == null) {
			throw new ErroDadosNulosException("A data de nascimento não pode ser nula");
		}
		if (cliente.getSexo() == null) {
			throw new ErroDadosNulosException("O sexo não pode ser nulo");
		}
	}
	
	public void validaFuncionario (Funcionario funcionario) {
		if (funcionario.getCpf() == null) {
			throw new ErroDadosNulosException("O CPF não pode ser nulo");
		}
		if (funcionario.getNome() == null) {
			throw new ErroDadosNulosException("O nome não pode ser nulo");
		}
		if (funcionario.getDataNascimento() == null) {
			throw new ErroDadosNulosException("A data de nascimento não pode ser nula");
		}
		if (funcionario.getSexo() == null) {
			throw new ErroDadosNulosException("O sexo não pode ser nulo");
		}
	}
	
	public void validaCaixa (Caixa caixa) {
		if (caixa.getDescricao() == null) {
			throw new ErroDadosNulosException("A descrição do caixa não pode ser nula");
		}
		if (caixa.getSenha() == null) {
			throw new ErroDadosNulosException("A senha não pode ser nula");
		}
		if (caixa.getFuncionario() == null) {
			caixa.setAtivo(false);
		}
	}
	
	public void validaCompra (Compra compra) {
		if (compra.getDataHora() == null) {
			throw new ErroDadosNulosException("A data e hora não podem ser nulas");
		}
		if (compra.getValorTotal() == null) {
			throw new ErroDadosNulosException("O valor total não pode ser nulo");
		}
		if (compra.getCaixa() == null) {
			throw new ErroDadosNulosException("O caixa não pode ser nulo");
		}
	}
	
	public void validaItemCompra (ItemCompra itemCompra) {
		if (itemCompra.getQuantidade() == null) {
			throw new ErroDadosNulosException("A quantidade não pode ser nula");
		}
		if (itemCompra.getValorTotal() == null) {
			throw new ErroDadosNulosException("O valor total não pode ser nulo");
		}
	}
	
	public void validaNotaFiscal (NotaFiscal notaFiscal) {
		if (notaFiscal.getNumero() == null) {
			throw new ErroDadosNulosException("O número não pode ser nulo");
		}
		if (notaFiscal.getDataHoraEntrada() == null) {
			throw new ErroDadosNulosException("A data e hora de entrada não podem ser nulas");
		}
	    if (notaFiscal.getValorTotal() == null) {
			throw new ErroDadosNulosException("O valor total não pode ser nulo");
		}
	}
	
	public void validaItemNotaFiscal (ItemNotaFiscal itemNotaFiscal) {
		if (itemNotaFiscal.getQuantidade() == null) {
			throw new ErroDadosNulosException("A quantidade não pode ser nula");
		}
		if (itemNotaFiscal.getValorTotal() == null) {
			throw new ErroDadosNulosException("O valor total não pode ser nulo");
		}
	}
	
	public void validaMarca (Marca marca) {
		if (marca.getNome() == null) {
			throw new ErroDadosNulosException("A marca deve possuir um nome");
		}
		if (marca.getTipoMercadoria() == null) {
			throw new ErroDadosNulosException("A marca deve possuir um tipo de mercadoria");
		}
	}
	
	public void validaProduto (Produtos produtos) {
		if (produtos.getSetor() == null) {
			throw new ErroDadosNulosException("O produto deve possuir um setor");
		}
		if (produtos.getMarca() == null) {
			throw new ErroDadosNulosException("O produto deve possuir uma marca");
		}
	}
	
	public void validaSetor (Setor setor) {
		if (setor.getNome() == null) {
			throw new ErroDadosNulosException("O setor deve possuir um nome");
		}
	}
}
