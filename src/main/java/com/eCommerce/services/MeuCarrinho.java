package com.eCommerce.services;

import java.util.ArrayList;
import java.util.List;

import com.eCommerce.model.Produto;

import jakarta.inject.Singleton;

@Singleton
public class MeuCarrinho {

  private List<Produto> produtos = new ArrayList<Produto>();
  private double saldo;

  public void addProduto(Produto produto) {
    produtos.add(produto);
    for (Produto p : produtos) {
      saldo = saldo + (p.getValorProduto() * p.getQuantidadeProduto());
    }
  }

  public void updateProduto(Produto produtoAtualizado) {
    for (int i = 0; i < produtos.size(); i++) {
      if (produtos.get(i).getNomeProduto().equals(produtoAtualizado.getNomeProduto())) {
        saldo = saldo - (produtos.get(i).getValorProduto() * produtos.get(i).getQuantidadeProduto());
        produtos.remove(i);
        produtos.add(produtoAtualizado);
        saldo = saldo + (produtoAtualizado.getValorProduto() * produtoAtualizado.getQuantidadeProduto());
      }
    }
  }

  public void removeProduto(String nomeProduto) {
    for (int i = 0; i < produtos.size(); i++) {
      if (produtos.get(i).getNomeProduto().equals(nomeProduto)) {
        if (produtos.get(i).getQuantidadeProduto() == 1) {
          produtos.remove(i);
        } else {
          Produto produtoNovo = new Produto(nomeProduto, produtos.get(i).getValorProduto(),
              produtos.get(i).getQuantidadeProduto() - 1, produtos.get(i).getTipoProduto());
          saldo = saldo - produtos.get(i).getValorProduto();
          produtos.add(produtoNovo);
          produtos.remove(i);
        }

      }
    }
  }

  public double saldoTotal() {

    return saldo;
  }

  public List<Produto> listaProdutos() {
    return produtos;
  }
}
