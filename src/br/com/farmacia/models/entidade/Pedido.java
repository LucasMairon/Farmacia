package br.com.farmacia.models.entidade;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

import br.com.farmacia.controllers.PedidoControle;
import br.com.farmacia.models.entidade.Medicamento;
public class Pedido {

  private ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
  private Cliente cliente;
  private int idPedido;
  private String data;
  private Double valorTotal;
  private boolean status = false;

  public Pedido(Cliente cliente, Double valortTotal, boolean status) {
    this.cliente = cliente;
    this.data = getData();
    this.valorTotal = valortTotal;
    this.status = status;
  }

  public Pedido(){}

  public static void criaPedido(int idCliente, Double valorTotal){
    PedidoControle.cadastrarPedido(idCliente,valorTotal);
  }

  public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
    this.medicamentos = medicamentos;
  }

  public ArrayList<Medicamento> getMedicamentos(){
    return medicamentos;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
  public int getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(int idPedido) {
    this.idPedido = idPedido;
  }

  public void setData(String data) {
    this.data = data;
  }

  public void setValorTotal(Double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public boolean getStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public static void pagarPedido(int idPedido, double pagamento) {
    PedidoControle.pagarPedido(idPedido, pagamento);
  }

  public void adicionarMedicamento(int idMedicamento) {
    
  }

  public void adicionarMedicamento(ArrayList<Medicamento> medicamentos) {

  }

  public void removerMedicamento(int idMedicamento) {

  }

  public String getData() {
    Date data = new Date();
    SimpleDateFormat formatacaoSimples = new SimpleDateFormat("dd/MM/yyyy");
    String dataFormatada = formatacaoSimples.format(data);
    return dataFormatada;
  }

  public String getMedicamentosFormatados() {
    String infomarcoesMedicamentos = "";
    for (Medicamento medicamento : medicamentos) {
      infomarcoesMedicamentos += medicamento.toString();
    }
    return infomarcoesMedicamentos;
  }

  // public double getValorTotal() {
  //   double soma = 0;
  //   for (Medicamento medicamento : medicamentos)
  //     soma += medicamento.getPreco();
  //   return soma;
  // }

  public double getValorTotal(){
    return this.valorTotal;
  }

  public String getStatusFormatado() {
    if (this.status) {
      return "Pago";
    }
    return "Aberto";

  }

  public String getValorString() {
    String valorFormatado = new DecimalFormat("#,#00.00").format(this.valorTotal);
    return valorFormatado;
  }

  public static void listarPedidos() {
    PedidoControle.listarPedidos();
  }

  public static void visualizarPedido(int idPedido) {
    PedidoControle.visualizarPedido(idPedido);
  }

  public static void deletarPedido(int idPedido){
    PedidoControle.deletarPedido(idPedido);
  }

  @Override
  public String toString() {
    return "Pedido #" + idPedido + ":" + "\n\tCliente que fez o pedido: " + getCliente().getNome() + "\n\tMedicamentos no pedido:" + getMedicamentosFormatados()
        + "\n\tData de emissão do pedido: " + data + "\n\tValor total do pedido: " + getValorString()
        + "\n\tStatus do pedido: " + getStatusFormatado() + "\n";
  }

}