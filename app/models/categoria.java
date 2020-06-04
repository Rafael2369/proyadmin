package models;

import javax.persistence.*;

@Entity
public class categoria{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int CAT_ID;
	String CAT_NOMBRE;
	String CAT_AREA;
	public int getCAT_ID() {
        return CAT_ID;
    }
    public void setCAT_ID(int CAT_ID) {
        this.CAT_ID = CAT_ID;
    }
	
	
	public String getCAT_NOMBRE() {
        return CAT_NOMBRE;
    }
    public void setCAT_NOMBRE(String CAT_NOMBRE) {
        this.CAT_NOMBRE = CAT_NOMBRE;
    }
	public String getCAT_AREA() {
        return CAT_AREA;
    }
    public void setCAT_AREA(String CAT_AREA) {
        this.CAT_AREA = CAT_AREA;
    }
}

