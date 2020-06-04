package models;

import javax.persistence.*;

@Entity
public class movimiento{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long MOV_ID;
	String MOV_TIPO;
	Long MOV_NUMFACTURA;
	String MOV_FECHA;
	Double MOV_TOTAL;
	Long MOV_IVA;
	Long MOV_IDPERSONA;
	
	public Long getMOV_ID() {
        return MOV_ID;
    }
    public void setMOV_ID(Long MOV_ID) {
        this.MOV_ID = MOV_ID;
    }
	public String getMOV_TIPO() {
        return MOV_TIPO;
    }
    public void setMOV_TIPO(String MOV_TIPO) {
        this.MOV_TIPO = MOV_TIPO;
    }
	
	public Long getMOV_NUMFACTURA() {
        return MOV_NUMFACTURA;
    }
    public void setMOV_NUMFACTURA(Long MOV_NUMFACTURA) {
        this.MOV_NUMFACTURA = MOV_NUMFACTURA;
    }
	
	public String getMOV_FECHA() {
        return MOV_FECHA;
    }
    public void setMOV_FECHA(String MOV_FECHA) {
        this.MOV_FECHA = MOV_FECHA;
    }

	public Double getMOV_TOTAL() {
        return MOV_TOTAL;
    }
    public void setMOV_TOTAL(Double MOV_TOTAL) {
        this.MOV_TOTAL = MOV_TOTAL;
    }
	
	public Long getMOV_IVA() {
        return MOV_IVA;
    }
    public void setMOV_IVA(Long MOV_IVA) {
        this.MOV_IVA = MOV_IVA;
    }
	
	public Long getMOV_IDPERSONA() {
        return MOV_IDPERSONA;
    }
    public void setMOV_IDPERSONA(Long MOV_IDPERSONA) {
        this.MOV_IDPERSONA = MOV_IDPERSONA;
    }	
}
