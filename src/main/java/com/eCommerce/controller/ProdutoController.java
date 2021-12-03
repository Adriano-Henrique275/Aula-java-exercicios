package com.eCommerce.controller;

import com.eCommerce.model.Produto;
import com.eCommerce.services.MeuCarrinho;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Patch;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller
public class ProdutoController {

  @Inject
  private MeuCarrinho meuCarrinhoService;

  @Post("/produto")
  public HttpResponse<?> addProduto(@Body Produto produto) {
    meuCarrinhoService.addProduto(produto);
    return HttpResponse.status(HttpStatus.OK).body("Produto adicionado com sucesso");
  }

  @Delete("/produto")
  public HttpResponse<?> removeProduto(@Body String nomeProduto) {
    meuCarrinhoService.removeProduto(nomeProduto);
    return HttpResponse.status(HttpStatus.OK).body("Produto removido com sucesso");
  }

  @Patch("/produto")
  public HttpResponse<?> updateProduto(@Body Produto produtoAtualizado) {
    meuCarrinhoService.updateProduto(produtoAtualizado);
    return HttpResponse.status(HttpStatus.OK).body("Produto atualizado com sucesso");
  }

  @Get("/saldo")
  public HttpResponse<?> saldo() {
    return HttpResponse.status(HttpStatus.OK).body(meuCarrinhoService.saldoTotal());
  }

  @Get("/lista")
  public HttpResponse<?> lista() {
    return HttpResponse.status(HttpStatus.OK).body(meuCarrinhoService.listaProdutos());
  }
}
