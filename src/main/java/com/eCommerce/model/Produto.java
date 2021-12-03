package com.eCommerce.model;

public class Produto {
  private String nomeProduto;
  private double valorProduto;
  private int quantidadeProduto;
  private String tipoProduto;

  public Produto() {

  }

  public Produto(String nomeProduto, double valorProduto, int quantidadeProduto, String tipoProduto) {
    this.nomeProduto = nomeProduto;
    this.valorProduto = valorProduto;
    this.quantidadeProduto = quantidadeProduto;
    this.tipoProduto = tipoProduto;
  }

  public String getNomeProduto() {
    return this.nomeProduto;
  }

  public void setNomeProduto(String nomeProduto) {
    this.nomeProduto = nomeProduto;
  }

  public double getValorProduto() {
    return this.valorProduto;
  }

  public void setValorProduto(double valorProduto) {
    this.valorProduto = valorProduto;
  }

  public int getQuantidadeProduto() {
    return quantidadeProduto;
  }

  public void setQuantidadeProduto(int quantidadeProduto) {
    this.quantidadeProduto = quantidadeProduto;
  }

  public String getTipoProduto() {
    return this.tipoProduto;
  }

  public void setTipoProduto(String tipoProduto) {
    this.tipoProduto = tipoProduto;
  }
}
