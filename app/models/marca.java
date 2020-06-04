package models;

import javax.persistence.*;

@Entity
public class marca{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int MAR_ID;
	String MAR_NOMBRE;
	String MAR_PAISORIGEN;
	String MAR_WEB;
	public int getMAR_ID() {
        return MAR_ID;
    }
    public void setMAR_ID(int MAR_ID) {
        this.MAR_ID = MAR_ID;
    }
	
	
	public String getMAR_NOMBRE() {
        return MAR_NOMBRE;
    }
    public void setMAR_NOMBRE(String MAR_NOMBRE) {
        this.MAR_NOMBRE = MAR_NOMBRE;
    }
	
	public String getMAR_PAISORIGEN() {
        return MAR_PAISORIGEN;
    }
    public void setMAR_PAISORIGEN(String MAR_PAISORIGEN) {
        this.MAR_PAISORIGEN = MAR_PAISORIGEN;
    }
	
	public String getMAR_WEB() {
        return MAR_WEB;
    }
    public void setMAR_WEB(String MAR_WEB) {
        this.MAR_WEB = MAR_WEB;
    }
}

