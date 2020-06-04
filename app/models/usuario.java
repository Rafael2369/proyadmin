package models;
import javax.persistence.*;

@Entity
public class usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long USU_ID;
    String USU_USUARIO;
    String USU_PASS;
    String USU_FOTO;
    Long USU_STATUS;
    Long USU_SESION;
    Long USU_INTENTOS;
    Long USU_BLOQUEO;
    Long USU_IDPERSONA;

    public Long getUSU_ID() {
        return USU_ID;
    }

    public void setUSU_ID(Long USU_ID) {
        this.USU_ID = USU_ID;
    }

    public String getUSU_USUARIO() {
        return USU_USUARIO;
    }

    public void setUSU_USUARIO(String USU_USUARIO) {
        this.USU_USUARIO = USU_USUARIO;
    }

    public String getUSU_PASS() {
        return USU_PASS;
    }

    public void setUSU_PASS(String USU_PASS) {
        this.USU_PASS = USU_PASS;
    }

    public String getUSU_FOTO() {
        return USU_FOTO;
    }

    public void setUSU_FOTO(String USU_FOTO) {
        this.USU_FOTO = USU_FOTO;
    }

    public Long getUSU_STATUS() {
        return USU_STATUS;
    }

    public void setUSU_STATUS(Long USU_STATUS) {
        this.USU_STATUS = USU_STATUS;
    }

    public Long getUSU_SESION() {
        return USU_SESION;
    }

    public void setUSU_SESION(Long USU_SESION) {
        this.USU_SESION = USU_SESION;
    }

    public Long getUSU_INTENTOS() {
        return USU_INTENTOS;
    }

    public void setUSU_INTENTOS(Long USU_INTENTOS) {
        this.USU_INTENTOS = USU_INTENTOS;
    }

    public Long getUSU_BLOQUEO() {
        return USU_BLOQUEO;
    }

    public void setUSU_BLOQUEO(Long USU_BLOQUEO) {
        this.USU_BLOQUEO = USU_BLOQUEO;
    }

    public Long getUSU_IDPERSONA() {
        return USU_IDPERSONA;
    }

    public void setUSU_IDPERSONA(Long USU_IDPERSONA) {
        this.USU_IDPERSONA = USU_IDPERSONA;
    }
}