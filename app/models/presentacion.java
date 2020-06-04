package models;

import javax.persistence.*;

@Entity
public class presentacion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int PRE_ID;
	String PRE_NOMBRE;
	String PRE_DESCRIPCION;
	
	public int getPRE_ID() {
        return PRE_ID;
    }
    public void setPRE_ID(int PRE_ID) {
        this.PRE_ID = PRE_ID;
    }
	
	
	public String getPRE_NOMBRE() {
        return PRE_NOMBRE;
    }
    public void setPRE_NOMBRE(String PRE_NOMBRE) {
        this.PRE_NOMBRE = PRE_NOMBRE;
    }
	
	public String getPRE_DESCRIPCION() {
        return PRE_DESCRIPCION;
    }
    public void setPRE_DESCRIPCION(String PRE_DESCRIPCION) {
        this.PRE_DESCRIPCION = PRE_DESCRIPCION;
    }
}

