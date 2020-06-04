package models;
import javax.persistence.*;
@Entity
public class pantalla{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long PAN_ID_PANTALLA;
	String PAN_NOMBRE;
	Long PAN_ID_PANTALLA_PADRE;
	Long PAN_INIVEL;
	Long PAN_ORDEN;
	String PAN_RUTA;
	Long PAN_ESTATUS;
	String PAN_FECHA;
	String PAN_RUTAICONO;
	String PAN_PERTENECE;
	public Long getPAN_ID_PANTALLA() {
		return PAN_ID_PANTALLA;
	}

	public void setPAN_ID_PANTALLA(Long PAN_ID_PANTALLA) {
		this.PAN_ID_PANTALLA = PAN_ID_PANTALLA;
	}

	public String getPAN_NOMBRE() {
		return PAN_NOMBRE;
	}

	public void setPAN_NOMBRE(String PAN_NOMBRE) {
		this.PAN_NOMBRE = PAN_NOMBRE;
	}

	public Long getPAN_ID_PANTALLA_PADRE() {
		return PAN_ID_PANTALLA_PADRE;
	}

	public void setPAN_ID_PANTALLA_PADRE(Long PAN_ID_PANTALLA_PADRE) {
		this.PAN_ID_PANTALLA_PADRE = PAN_ID_PANTALLA_PADRE;
	}

	public Long getPAN_INIVEL() {
		return PAN_INIVEL;
	}

	public void setPAN_INIVEL(Long PAN_INIVEL) {
		this.PAN_INIVEL = PAN_INIVEL;
	}

	public Long getPAN_ORDEN() {
		return PAN_ORDEN;
	}

	public void setPAN_ORDEN(Long PAN_ORDEN) {
		this.PAN_ORDEN = PAN_ORDEN;
	}

	public String getPAN_RUTA() {
		return PAN_RUTA;
	}

	public void setPAN_RUTA(String PAN_RUTA) {
		this.PAN_RUTA = PAN_RUTA;
	}

	public Long getPAN_ESTATUS() {
		return PAN_ESTATUS;
	}

	public void setPAN_ESTATUS(Long PAN_ESTATUS) {
		this.PAN_ESTATUS = PAN_ESTATUS;
	}

	public String getPAN_FECHA() {
		return PAN_FECHA;
	}

	public void setPAN_FECHA(String PAN_FECHA) {
		this.PAN_FECHA = PAN_FECHA;
	}

	public String getPAN_RUTAICONO() {
		return PAN_RUTAICONO;
	}

	public void setPAN_RUTAICONO(String PAN_RUTAICONO) {
		this.PAN_RUTAICONO = PAN_RUTAICONO;
	}

	public String getPAN_PERTENECE() {
		return PAN_PERTENECE;
	}

	public void setPAN_PERTENECE(String PAN_PERTENECE) {
		this.PAN_PERTENECE = PAN_PERTENECE;
	}


}