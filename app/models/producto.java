package models;
import javax.persistence.*;
@Entity
public class producto{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int  PRO_ID;
	String PRO_NOMBRE;
	String PRO_DESCRIPCION;
	int PRO_SALDO;
	double PRO_PRECIOCOMPRA;
	double PRO_PRECIOVENTA;
	double PRO_DESCUENTO;
	String PRO_FOTO;
	String PRO_UBICACION;
	String PRO_PAISFABRICA;
	int PRO_STATUS;
	int PRO_IVA;
	int PRO_CATMAX;
	int PRO_CATMIN;
	String PRO_COMENTARIO;
	int PRO_IDMARCA;
	int PRO_IDUNIDADMEDIDA;
	int PRO_IDPRESENTACION;
String PRO_CODIGOBARRA;
	int PRO_IDCATEGORIA;
	
	public int getPRO_STATUS() {
		return PRO_STATUS;
	}

	public void setPRO_STATUS(int PRO_STATUS){
		this.PRO_STATUS = PRO_STATUS;
	}
	
	public int getPRO_IDCATEGORIA() {
		return PRO_IDCATEGORIA;
	}

	public void setPRO_IDCATEGORIA(int PRO_IDCATEGORIA) {
		this.PRO_IDCATEGORIA = PRO_IDCATEGORIA;
	}
	
	public String getPRO_CODIGOBARRA() {
		return PRO_CODIGOBARRA;
	}

	public void setPRO_CODIGOBARRA(String PRO_CODIGOBARRA) {
		this.PRO_CODIGOBARRA = PRO_CODIGOBARRA;
	}

	public int getPRO_ID() {
		return PRO_ID;
	}

	public void setPRO_ID(int PRO_ID) {
		this.PRO_ID = PRO_ID;
	}

	public String getPRO_NOMBRE() {
		return PRO_NOMBRE;
	}

	public void setPRO_NOMBRE(String PRO_NOMBRE) {
		this.PRO_NOMBRE = PRO_NOMBRE;
	}

	public String getPRO_DESCRIPCION() {
		return PRO_DESCRIPCION;
	}

	public void setPRO_DESCRIPCION(String PRO_DESCRIPCION) {
		this.PRO_DESCRIPCION = PRO_DESCRIPCION;
	}

	public int getPRO_SALDO() {
		return PRO_SALDO;
	}

	public void setPRO_SALDO(int PRO_SALDO) {
		this.PRO_SALDO = PRO_SALDO;
	}

	public double getPRO_PRECIOCOMPRA() {
		return PRO_PRECIOCOMPRA;
	}

	public void setPRO_PRECIOCOMPRA(double PRO_PRECIOCOMPRA) {
		this.PRO_PRECIOCOMPRA = PRO_PRECIOCOMPRA;
	}
	public double getPRO_PRECIOVENTA() {
		return PRO_PRECIOVENTA;
	}

	public void setPRO_PRECIOVENTA(double PRO_PRECIOVENTA) {
		this.PRO_PRECIOVENTA = PRO_PRECIOVENTA;
	}
	
	public double getPRO_DESCUENTO() {
		return PRO_DESCUENTO;
	}

	public void setPRO_DESCUENTO(double PRO_DESCUENTO) {
		this.PRO_DESCUENTO = PRO_DESCUENTO;
	}

	public String getPRO_FOTO() {
		return PRO_FOTO;
	}

	public void setPRO_FOTO(String PRO_FOTO) {
		this.PRO_FOTO = PRO_FOTO;
	}

	public String getPRO_UBICACION() {
		return PRO_UBICACION;
	}

	public void setPRO_UBICACION(String PRO_UBICACION) {
		this.PRO_UBICACION = PRO_UBICACION;
	}

	public String getPRO_PAISFABRICA() {
		return PRO_PAISFABRICA;
	}

	public void setPRO_PAISFABRICA(String PRO_PAISFABRICA) {
		this.PRO_PAISFABRICA = PRO_PAISFABRICA;
	}

	public int getPRO_IVA() {
		return PRO_IVA;
	}

	public void setPRO_IVA(int PRO_IVA) {
		this.PRO_IVA = PRO_IVA;
	}

	public int getPRO_CATMAX() {
		return PRO_CATMAX;
	}

	public void setPRO_CATMAX(int PRO_CATMAX) {
		this.PRO_CATMAX = PRO_CATMAX;
	}

	public int getPRO_CATMIN() {
		return PRO_CATMIN;
	}

	public void setPRO_CATMIN(int PRO_CATMIN) {
		this.PRO_CATMIN = PRO_CATMIN;
	}

	public String getPRO_COMENTARIO() {
		return PRO_COMENTARIO;
	}

	public void setPRO_COMENTARIO(String PRO_COMENTARIO) {
		this.PRO_COMENTARIO = PRO_COMENTARIO;
	}

	public int getPRO_IDMARCA() {
		return PRO_IDMARCA;
	}

	public void setPRO_IDMARCA(int PRO_IDMARCA) {
		this.PRO_IDMARCA = PRO_IDMARCA;
	}

	public int getPRO_IDUNIDADMEDIDA() {
		return PRO_IDUNIDADMEDIDA;
	}

	public void setPRO_IDUNIDADMEDIDA(int PRO_IDUNIDADMEDIDA) {
		this.PRO_IDUNIDADMEDIDA = PRO_IDUNIDADMEDIDA;
	}

	public int getPRO_IDPRESENTACION() {
		return PRO_IDPRESENTACION;
	}

	public void setPRO_IDPRESENTACION(int PRO_IDPRESENTACION) {
		this.PRO_IDPRESENTACION = PRO_IDPRESENTACION;
	}
}