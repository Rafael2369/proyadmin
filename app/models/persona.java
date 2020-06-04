package models;
import javax.persistence.*;

@Entity
public class persona{


    public Long getPER_IDPERSONA() {
        return PER_IDPERSONA;
    }

    public void setPER_IDPERSONA(Long PER_IDPERSONA) {
        this.PER_IDPERSONA = PER_IDPERSONA;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long PER_IDPERSONA;
    String PER_NOMBRE;
    String PER_APAT;
    String PER_AMAT;

    String PER_DIRECCION;
    String PER_TELEFONO;
    String PER_EMAIL;
    String PER_GENERO;
    String PER_REFERECIA;
    String PER_FECHAREGISTRO;
    Long PER_IDCOLONIA;
	
	public Long getPER_IDCOLONIA() {
        return PER_IDCOLONIA;
    }

    public void setPER_IDCOLONIA(Long PER_IDCOLONIA) {
        this.PER_IDCOLONIA = PER_IDCOLONIA;
    }
	
	public String getPER_REFERECIA() {
        return PER_REFERECIA;
    }

    public void setPER_REFERECIA(String PER_REFERECIA) {
        this.PER_REFERECIA = PER_REFERECIA;
    }

    public String getPER_NOMBRE() {
        return PER_NOMBRE;
    }

    public void setPER_NOMBRE(String PER_NOMBRE) {
        this.PER_NOMBRE = PER_NOMBRE;
    }

    public String getPER_APAT() {
        return PER_APAT;
    }

    public void setPER_APAT(String PER_APAT) {
        this.PER_APAT = PER_APAT;
    }

    public String getPER_AMAT() {
        return PER_AMAT;
    }

    public void setPER_AMAT(String PER_AMAT) {
        this.PER_AMAT = PER_AMAT;
    }

    public String getPER_DIRECCION() {
        return PER_DIRECCION;
    }

    public void setPER_DIRECCION(String PER_DIRECCION) {
        this.PER_DIRECCION = PER_DIRECCION;
    }

    public String getPER_TELEFONO() {
        return PER_TELEFONO;
    }

    public void setPER_TELEFONO(String PER_TELEFONO) {
        this.PER_TELEFONO = PER_TELEFONO;
    }

    public String getPER_EMAIL() {
        return PER_EMAIL;
    }

    public void setPER_EMAIL(String PER_EMAIL) {
        this.PER_EMAIL = PER_EMAIL;
    }

    public String getPER_GENERO() {
        return PER_GENERO;
    }

    public void setPER_GENERO(String PER_GENERO) {
        this.PER_GENERO = PER_GENERO;
    }

    public String getPER_FECHAREGISTRO() {
        return PER_FECHAREGISTRO;
    }

    public void setPER_FECHAREGISTRO(String PER_FECHAREGISTRO) {
        this.PER_FECHAREGISTRO = PER_FECHAREGISTRO;
    }

   

}
