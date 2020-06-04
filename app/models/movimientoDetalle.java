package models;

import javax.persistence.*;

@Entity
public class movimientoDetalle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	String PRO_NOMBRE;
	Double PRO_PRECIOVENTA;
	Long DET_CANTIDAD;
	Double DET_VALOR;
	Long DET_IDMOVIMIENTO;

	
	public String getPRO_NOMBRE() {
		return PRO_NOMBRE;
	}

	public void setPRO_NOMBRE(String PRO_NOMBRE) {
		this.PRO_NOMBRE = PRO_NOMBRE;
	}
	
	public double getPRO_PRECIOVENTA() {
		return PRO_PRECIOVENTA;
	}

	public void setPRO_PRECIOVENTA(double PRO_PRECIOVENTA) {
		this.PRO_PRECIOVENTA = PRO_PRECIOVENTA;
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
	
	public Long getDET_IDMOVIMIENTO() {
        return DET_IDMOVIMIENTO;
    }
	
    public void setDET_IDMOVIMIENTO(Long DET_IDMOVIMIENTO) {
        this.DET_IDMOVIMIENTO = DET_IDMOVIMIENTO;
    }
	
	
}

