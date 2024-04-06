package br.com.farmacia.classes.Pedido;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

import farmacia.classes.Medicamento;

public class Pedido{

    private LinkedList<Medicamento> medicamentos;
    private static LinkedList<Pedido> pedidos = new LinkedList<>();
    private int idPedido;
    private String data;
    private Double valorTotal;
    private boolean status = false;

    public Pedido(int idPedido) {
        this.idPedido = idPedido;
        this.medicamentos = new LinkedList<Medicamento>();
        this.data = getData();
        this.valorTotal = 0.00;
    }

    public Pedido(LinkedList<Medicamento> medicamentos, int idPedido) {
        this.idPedido = idPedido;
        this.medicamentos = medicamentos;
        this.data = getData();
        this.valorTotal = getValorTotal();
    }

    public static Pedido criaPedido(int idPedido, boolean status){
        pedidos.add(new Pedido(idPedido));
        return new Pedido(idPedido);
    }

    public static Pedido criaPedido(LinkedList<Medicamento> medicamentos,int idPedido, boolean status){
        pedidos.add(new Pedido(medicamentos ,idPedido));
        return new Pedido(medicamentos,idPedido);
    }

    public double pagarPedido(double pagamento){
        if(pagamento < valorTotal){
            System.out.println("Valor insuficiente");
            return 0;
        }
        this.status = true;
        return (pagamento - valorTotal);
    }
  
    
    public void editarPedido(Scanner scan){
        if(status != false){
            return;
        }
    }
    
    public void deletarPedido(){
        return;
    }
    
    public void adicionarMedicamento(LinkedList<Medicamento> medicamentos){
        this.medicamentos = medicamentos;
    }
    
    public void removerMedicamento(){
        
    }
    
    public String getData(){
        Date data = new Date();
        SimpleDateFormat formatacaoSimples = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatacaoSimples.format(data);
        return dataFormatada;
    }

    public String getMedicamentos(){
        String infomarcoesMedicamentos = "";
        for(Medicamento medicamento: medicamentos){
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

    public String getStatus(){
        if(this.status){
            return "Pago";
        }
        return "Aberto";

    }

    public String getValorString(){
        String valorFormatado = new DecimalFormat("#,#00.00").format(this.valorTotal);
        return valorFormatado;
    }

    public boolean equals(int idPedido){
        if(this.idPedido == idPedido){
            return true;
        }
        return false;
    }

    public static void listarPedido(){
        for(Pedido pedido: pedidos){
            System.out.println(pedido.toString());
        }
    }

    public void visualizarPedido(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Pedido #" + idPedido + ":" + "\nMedicamentos no pedido:" + getMedicamentos() + "\nData de emissão do pedido: " + data + "\nValor total do pedido: " + getValorString() + "\nStatus do pedido: " + getStatus() + "\n";
    }

}