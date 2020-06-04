package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class cliente{
    @Id
    int CLI_ID;
    public int getCLI_ID() {
        return CLI_ID;
    }

    public void setCLI_ID(int CLI_ID) {
        this.CLI_ID = CLI_ID;
    }



    public String getCLI_FECHAFACTURA() {
        return CLI_FECHAFACTURA;
    }

    public void setCLI_FECHAFACTURA(String CLI_FECHAFACTURA) {
        this.CLI_FECHAFACTURA = CLI_FECHAFACTURA;
    }

    String CLI_FECHAFACTURA;
    String CLI_FACTURA;
    int CLI_IDPERSONA;
    //@Constraints.Required
   // @Constraints.MinLength(value = 3)
    //@Constraints.MaxLength(value = 10)

    public String getCLI_FACTURA() {
        return CLI_FACTURA;
    }

    public void setCLI_FACTURA(String CLI_FACTURA) {
        this.CLI_FACTURA = CLI_FACTURA;
    }

    public int getCLI_IDPERSONA() {
        return CLI_IDPERSONA;
    }

    public void setCLI_IDPERSONA(int CLI_IDPERSONA) {
        this.CLI_IDPERSONA = CLI_IDPERSONA;
    }


}

