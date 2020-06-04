package controllers;

import java.util.Calendar;

public class Util {
    public String fechaActual(){
        Calendar fecha = Calendar.getInstance();
        String anio = valorCeroAntes(fecha.get(Calendar.YEAR)+"");
        String mes = valorCeroAntes((fecha.get(Calendar.MONTH)+1)+"");
        String date = valorCeroAntes(fecha.get(Calendar.DATE)+"");
        String hora = valorCeroAntes(fecha.get(Calendar.HOUR)+"");
        String min = valorCeroAntes(fecha.get(Calendar.MINUTE)+"");
        String seg = valorCeroAntes(fecha.get(Calendar.SECOND)+"");
        String fechaActual = anio+"-"+mes+"-"+date+" "+hora+":"+min+":"+seg;
        return fechaActual;
    }
    //9 -- 09
    public String valorCeroAntes(String valor){
        String resultado=valor;
        if(Integer.parseInt(resultado) <= 9){
            resultado ="0"+valor;
        }
        return resultado;
    }
}
