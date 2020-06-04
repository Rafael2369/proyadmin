package models;

import javax.persistence.*;

@Entity
public class unidadMedida{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int UNI_ID;
	String UNI_TIPO;
	String UNI_NOMBRE;
	String UNI_ABREVIATURA;
	
	public int getUNI_ID() {
        return UNI_ID;
    }
    public void setUNI_ID(int UNI_ID) {
        this.UNI_ID = UNI_ID;
    }
	
	
	public String getUNI_TIPO() {
        return UNI_TIPO;
    }
    public void setUNI_TIPO(String UNI_TIPO) {
        this.UNI_TIPO = UNI_TIPO;
    }
	
	public String getUNI_NOMBRE() {
        return UNI_NOMBRE;
    }
    public void setUNI_NOMBRE(String UNI_NOMBRE) {
        this.UNI_NOMBRE = UNI_NOMBRE;
    }
	
	public String getUNI_ABREVIATURA() {
        return UNI_ABREVIATURA;
    }
    public void setUNI_ABREVIATURA(String UNI_ABREVIATURA) {
        this.UNI_ABREVIATURA = UNI_ABREVIATURA;
    }
}

