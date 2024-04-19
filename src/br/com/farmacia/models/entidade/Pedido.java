package br.com.farmacia.models.entidade;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

public class Pedido {

  private ArrayList<Medicamento> medicamentos;
  private static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
  private Cliente cliente;
  private int idPedido;
  private String data;
  private Double valorTotal;
  private boolean status = false;

  public Pedido(int idPedido, Cliente cliente) {
    this.idPedido = idPedido;
    this.medicamentos = new ArrayList<Medicamento>();
    this.data = getData();
    this.valorTotal = 0.00;
    this.cliente = cliente;
  }

  public Pedido(ArrayList<Medicamento> medicamentos, int idPedido, Cliente cliente) {
    this.idPedido = idPedido;
    this.medicamentos = medicamentos;
    this.data = getData();
    this.valorTotal = getValorTotal();
    this.cliente = cliente;
  }

  public static criaPedido(int idPedido, Cliente cliente){
      pedidos.add(new Pedido(idPedido, cliente));
    }

  public static criaPedido(ArrayList<Medicamento> medicamentos,int idPedido, Cliente cliente){
        pedidos.add(new Pedido(medicamentos,idPedido, cliente));
    }

  public double pagarPedido(double pagamento) {
    if (pagamento < valorTotal) {
      System.out.println("Valor insuficiente");
      return -1;
    }
    this.status = true;
    return (pagamento - valorTotal);
  }

  public void editarPedido(Scanner scan) {
    MenusPedido.editarPedido(this, scan);
  }

  public void deletarPedido(int idPedido) {
    Pedido pedido = buscaPedido(idPedido);
    pedidos.remove(pedido);
  }

  public void adicionarMedicamento(Medicamento medicamento) {
    if (medicamento == null) {
      return;
    }
    this.medicamentos.add(medicamento);
  }

  public void adicionarMedicamento(ArrayList<Medicamento> medicamentos) {
    if (medicamentos == null) {
      return;
    }
    this.medicamentos = medicamentos;
  }

  public void removerMedicamento(int idMedicamento) {
    for (Medicamento medicamento : medicamentos) {
      if (medicamento.getIdMedicamento() == idMedicamento) {
        medicamentos.remove(medicamento);
      }
    }
  }

  public String getData() {
    Date data = new Date();
    SimpleDateFormat formatacaoSimples = new SimpleDateFormat("dd/MM/yyyy");
    String dataFormatada = formatacaoSimples.format(data);
    return dataFormatada;
  }

  public String getMedicamentos() {
    String infomarcoesMedicamentos = "";
    for (Medicamento medicamento : medicamentos) {
      infomarcoesMedicamentos += medicamento.toString();
    }
    return infomarcoesMedicamentos;
  }

  private double getValorTotal() {
    double soma = 0;
    for (Medicamento medicamento : medicamentos)
      soma += medicamento.getPreco();
    return soma;
  }

  public String getStatus() {
    if (this.status) {
      return "Pago";
    }
    return "Aberto";

  }

  public String getValorString() {
    String valorFormatado = new DecimalFormat("#,#00.00").format(this.valorTotal);
    return valorFormatado;
  }

  public boolean equals(Object objeto) {
    if (this == objeto) {
      return true;
    }
    if (objeto == null) {
      return false;
    }
    if (getClass() != objeto.getClass()) {
      return false;
    }
    Pedido pedidoAComparar = (Pedido) objeto;
    if (this.idPedido == pedidoAComparar.idPedido) {
      return true;
    }
    return false;
  }

  public static void listarPedido() {
    for (Pedido pedido : pedidos) {
      pedido.visualizarPedido();
    }
  }

  public void visualizarPedido() {
    System.out.println(this.toString());
  }

  public static Pedido buscaPedido(int idPedido) {
    for (Pedido pedido : pedidos) {
      if (pedido.idPedido == idPedido) {
        return pedido;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return "Pedido #" + idPedido + ":" + "\n\tMedicamentos no pedido:" + getMedicamentos()
        + "\n\tData de emissão do pedido: " + data + "\n\tValor total do pedido: " + getValorString()
        + "\n\tStatus do pedido: " + getStatus() + "\n";
  }

}