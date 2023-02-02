import java.util.Hashtable;
import java.lang.Math;

public class OpInteresPeriodico {
    public OpInteresPeriodico(){

    }

    public Hashtable<String, Double> OpInteres(Double Capital, Double Interes, String periodoInteres, Double Cuota, String periodoCuota){
        Double verdaderoInteres = 0.0;
        Hashtable<String, Double> datos = new Hashtable<String, Double>();
        if(periodoInteres.equals("Anual")){
            if(periodoCuota.equals("Mensual")){
                verdaderoInteres = Interes/12;
            }else if(periodoCuota.equals("Bimestral")){
                verdaderoInteres = Interes/6;
            }else if(periodoCuota.equals("Trimestral")){
                verdaderoInteres = Interes/4;
            }else if(periodoCuota.equals("Cuatrimestral")){
                verdaderoInteres = Interes/3;
            }else if(periodoCuota.equals("Semestral")){
                verdaderoInteres = Interes/2;
            }else if(periodoCuota.equals("Anual")){
                verdaderoInteres = Interes/1;
            }
        }else if(periodoInteres.equals("Semestral")){
            if(periodoCuota.equals("Mensual")){
                verdaderoInteres = Interes/6;
            }else if(periodoCuota.equals("Bimestral")){
                verdaderoInteres = Interes/3;
            }else if(periodoCuota.equals("Trimestral")){
                verdaderoInteres = Interes/2;
            }else if(periodoCuota.equals("Cuatrimestral")){
                verdaderoInteres = Interes/1.5;
            }else if(periodoCuota.equals("Semestral")){
                verdaderoInteres = Interes/1;
            }else if(periodoCuota.equals("Anual")){
                verdaderoInteres = Interes*2;
            }
        }else if(periodoInteres.equals("Cuatrimestral")){
            if(periodoCuota.equals("Mensual")){
                verdaderoInteres = Interes/4;
            }else if(periodoCuota.equals("Bimestral")){
                verdaderoInteres = Interes/2;
            }else if(periodoCuota.equals("Trimestral")){
                verdaderoInteres = Interes/1.333333333;
            }else if(periodoCuota.equals("Cuatrimestral")){
                verdaderoInteres = Interes/1;
            }else if(periodoCuota.equals("Semestral")){
                verdaderoInteres = Interes*1.5;
            }else if(periodoCuota.equals("Anual")){
                verdaderoInteres = Interes*2;
            }
        }else if(periodoInteres.equals("Trimestral")){
            if(periodoCuota.equals("Mensual")){
                verdaderoInteres = Interes/3;
            }else if(periodoCuota.equals("Bimestral")){
                verdaderoInteres = Interes/1.5;
            }else if(periodoCuota.equals("Trimestral")){
                verdaderoInteres = Interes/1;
            }else if(periodoCuota.equals("Cuatrimestral")){
                verdaderoInteres = Interes*1.333333334;
            }else if(periodoCuota.equals("Semestral")){
                verdaderoInteres = Interes*2;
            }else if(periodoCuota.equals("Anual")){
                verdaderoInteres = Interes*4;
            }
        }else if(periodoInteres.equals("Bimestral")){
            if(periodoCuota.equals("Mensual")){
                verdaderoInteres = Interes/2;
            }else if(periodoCuota.equals("Bimestral")){
                verdaderoInteres = Interes/1;
            }else if(periodoCuota.equals("Trimestral")){
                verdaderoInteres = Interes*1.5;
            }else if(periodoCuota.equals("Cuatrimestral")){
                verdaderoInteres = Interes*2;
            }else if(periodoCuota.equals("Semestral")){
                verdaderoInteres = Interes*3;
            }else if(periodoCuota.equals("Anual")){
                verdaderoInteres = Interes*6;
            }
        }else if(periodoInteres.equals("Mensual")){
            if(periodoCuota.equals("Mensual")){
                verdaderoInteres = Interes/1;
            }else if(periodoCuota.equals("Bimestral")){
                verdaderoInteres = Interes*2;
            }else if(periodoCuota.equals("Trimestral")){
                verdaderoInteres = Interes*3;
            }else if(periodoCuota.equals("Cuatrimestral")){
                verdaderoInteres = Interes*4;
            }else if(periodoCuota.equals("Semestral")){
                verdaderoInteres = Interes*6;
            }else if(periodoCuota.equals("Anual")){
                verdaderoInteres = Interes*12;
            }
        }
        datos.put("Capital",Capital);
        datos.put("Interes",verdaderoInteres);
        datos.put("NCuotas",Cuota);
        return datos;
    }
    
}
