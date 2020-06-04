package models;

import javax.persistence.*;

@Entity
public class detalle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long DET_ID;
	Long DET_CANTIDAD;
	Double DET_VALOR;
	Long DET_NUMERO;
	Long DET_IDPRODUCTO;
	Long DET_IDMOVIMIENTO;
	
	public Long getDET_ID() {
        return DET_ID;
    }
    public void setDET_ID(Long DET_ID) {
        this.DET_ID = DET_ID;
    }
	
	public Long getDET_CANTIDAD() {
        return DET_CANTIDAD;
    }
    public void setDET_CANTIDAD(Long DET_CANTIDAD) {
        this.DET_CANTIDAD = DET_CANTIDAD;
    }
	
	public Double getDET_VALOR() {
        return DET_VALOR;
    }
    public void setDET_VALOR(Double DET_VALOR) {
        this.DET_VALOR = DET_VALOR;
    }
	
	public Long getDET_NUMERO() {
        return DET_NUMERO;
    }
    public void setDET_NUMERO(Long DET_NUMERO) {
        this.DET_NUMERO = DET_NUMERO;
    }
	
	public Long getDET_IDPRODUCTO() {
        return DET_IDPRODUCTO;
    }
    public void setDET_IDPRODUCTO(Long DET_IDPRODUCTO) {
        this.DET_IDPRODUCTO = DET_IDPRODUCTO;
    }
	
	public Long getDET_IDMOVIMIENTO() {
        return DET_IDMOVIMIENTO;
    }
    public void setDET_IDMOVIMIENTO(Long DET_IDMOVIMIENTO) {
        this.DET_IDMOVIMIENTO = DET_IDMOVIMIENTO;
    }
	
	
}

