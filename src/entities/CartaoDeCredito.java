package entities;

import entities.Compra;

import java.util.List;
import java.util.ArrayList;

public class CartaoDeCredito {
    private Double limite;
    private Double saldo;
    private List<Compra> compras = new ArrayList<>();

    public CartaoDeCredito(Double limite) {
        this.limite = limite;
        this.saldo = limite;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public boolean lancaCompra(Compra compra) {
        if(compra.getValor() < saldo) {
            saldo -= compra.getValor();
            compras.add(compra);
            return true;
        }
        return false;
    }
}
