package models;

public class vendedor {
    public int getVEN_CODIGO() {
        return VEN_CODIGO;
    }

    public void setVEN_CODIGO(int VEN_CODIGO) {
        this.VEN_CODIGO = VEN_CODIGO;
    }

    public String getVEN_FECHANACIMIENTO() {
        return VEN_FECHANACIMIENTO;
    }

    public void setVEN_FECHANACIMIENTO(String VEN_FECHANACIMIENTO) {
        this.VEN_FECHANACIMIENTO = VEN_FECHANACIMIENTO;
    }

    public String getVEN_FOTO() {
        return VEN_FOTO;
    }

    public void setVEN_FOTO(String VEN_FOTO) {
        this.VEN_FOTO = VEN_FOTO;
    }

    public String getVEN_TURNO() {
        return VEN_TURNO;
    }

    public void setVEN_TURNO(String VEN_TURNO) {
        this.VEN_TURNO = VEN_TURNO;
    }

    public int getVEN_IDPERSONA() {
        return VEN_IDPERSONA;
    }

    public void setVEN_IDPERSONA(int VEN_IDPERSONA) {
        this.VEN_IDPERSONA = VEN_IDPERSONA;
    }

    int VEN_CODIGO;
	String VEN_FECHANACIMIENTO;
	String VEN_FOTO;
	String VEN_TURNO;
	int VEN_IDPERSONA;
}
