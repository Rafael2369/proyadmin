package models;
import javax.persistence.*;

@Entity
public class colonia{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long COL_ID;
    String COL_TIPO;
    String COL_NOMBRE;
	Long COL_CP;
	Long COL_IDCIUDAD;
	

    public Long getCOL_ID() {
        return COL_ID;
    }

    public void setCOL_ID(Long COL_ID) {
        this.COL_ID = COL_ID;
    }

    public String getCOL_TIPO() {
        return COL_TIPO;
    }

    public void setCOL_TIPO(String COL_TIPO) {
        this.COL_TIPO = COL_TIPO;
    }

    public String getCOL_NOMBRE() {
        return COL_NOMBRE;
    }

    public void setCOL_NOMBRE(String COL_NOMBRE) {
        this.COL_NOMBRE = COL_NOMBRE;
    }

    public Long getCOL_CP() {
        return COL_CP;
    }

    public void setCOL_CP(Long COL_CP) {
        this.COL_CP = COL_CP;
    }
	public Long getCOL_IDCIUDAD() {
        return COL_IDCIUDAD;
    }

    public void setCOL_IDCIUDAD (Long COL_IDCIUDAD) {
        this.COL_IDCIUDAD =  COL_IDCIUDAD;
    }
}