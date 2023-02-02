import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;

public class OpSistemasAmortizacion {
    private static Hashtable<String, Double> dicDatosR;
    
    public OpSistemasAmortizacion(){
        this.dicDatosR = new Hashtable<String, Double>();
    }
    
    public Hashtable<String, Hashtable<String, Double>> CalculoSistemaAmericano(Hashtable<String, Double> dat){
        Hashtable<String, Double> dictPeriodo = new Hashtable<String, Double>();
        Hashtable<String, Hashtable<String, Double>> dictResultado = new Hashtable<String, Hashtable<String, Double>>();
        Double interesDecimal = (Double) dat.get("Interes")/100;
        Double valorInteres = (Double) dat.get("Capital") * interesDecimal;
        Double cuotaFinal = valorInteres + (Double) dat.get("Capital");
        Double contLinea = (Double) dat.get("NCuotas")+1;
        for (int lin=0;lin < contLinea;lin++){
            if(lin==0){
                dictPeriodo.put("PeriodoPeriodo0",(double) lin);
                dictPeriodo.put("CuotaPeriodo0",(double) 0);
                dictPeriodo.put("InteresPeriodo0",(double) 0);
                dictPeriodo.put("AmortizacionPeriodo0",(double) 0);
                dictPeriodo.put("SaldoPeriodo0",(Double) dat.get("Capital"));
                dictResultado.put("Periodo0", dictPeriodo);
            } else if (lin==(Double) dat.get("NCuotas")){
                dictPeriodo.put("PeriodoPeriodo"+lin,(double) lin);
                dictPeriodo.put("CuotaPeriodo"+lin,(double) cuotaFinal);
                dictPeriodo.put("InteresPeriodo"+lin,(double) valorInteres);
                dictPeriodo.put("AmortizacionPeriodo"+lin, (Double) dat.get("Capital"));
                dictPeriodo.put("SaldoPeriodo"+lin,(double) 0);
                dictResultado.put("Periodo"+lin, dictPeriodo);
            } else{
                dictPeriodo.put("PeriodoPeriodo"+lin,(double) lin);
                dictPeriodo.put("CuotaPeriodo"+lin,(double) valorInteres);
                dictPeriodo.put("InteresPeriodo"+lin,(double) valorInteres);
                dictPeriodo.put("AmortizacionPeriodo"+lin, (double) 0);
                dictPeriodo.put("SaldoPeriodo"+lin,(Double) dictResultado.get("Periodo"+(lin-1)).get("SaldoPeriodo"+(lin-1)));
                dictResultado.put("Periodo"+lin, dictPeriodo);
            }
        }
        dictResultado.get("Periodo0").put("NCuotas", (double) dat.get("NCuotas"));
        return dictResultado;
    }

    public Hashtable<String, Hashtable<String, Double>> CalculoSistemaAleman(Hashtable<String, Double> dat){
        Hashtable<String, Double> dictPeriodo = new Hashtable<String, Double>();
        Hashtable<String, Hashtable<String, Double>> dictResultado = new Hashtable<String, Hashtable<String, Double>>();
        Double valorAmortizacion = (Double) dat.get("Capital") / (Double) dat.get("NCuotas");
        Double interesDecimal = (Double) dat.get("Interes")/100;
        Double contLinea = (Double) dat.get("NCuotas")+1;
        for (int lin=0;lin < contLinea;lin++){
            if(lin==0){
                dictPeriodo.put("PeriodoPeriodo0",(double) lin);
                dictPeriodo.put("CuotaPeriodo0",(double) 0);
                dictPeriodo.put("InteresPeriodo0",(double) 0);
                dictPeriodo.put("AmortizacionPeriodo0",(double) 0);
                dictPeriodo.put("SaldoPeriodo0",(Double) dat.get("Capital"));
                dictResultado.put("Periodo0", dictPeriodo);
            } else{
                Double interes = (Double) dictResultado.get("Periodo"+(lin-1)).get("SaldoPeriodo"+(lin-1)) * interesDecimal;
                Double cuota = valorAmortizacion + interes;
                Double saldoRes = (Double) dictResultado.get("Periodo"+(lin-1)).get("SaldoPeriodo"+(lin-1)) - valorAmortizacion;
                dictPeriodo.put("PeriodoPeriodo"+lin,(double) lin);
                dictPeriodo.put("CuotaPeriodo"+lin, cuota);
                dictPeriodo.put("InteresPeriodo"+lin, interes);
                dictPeriodo.put("AmortizacionPeriodo"+lin, valorAmortizacion);
                dictPeriodo.put("SaldoPeriodo"+lin, saldoRes);
                dictResultado.put("Periodo"+lin, dictPeriodo);
            }
        }
        dictResultado.get("Periodo0").put("NCuotas", (double) dat.get("NCuotas"));
        return dictResultado;

    }

    public Hashtable<String, Hashtable<String, Double>> CalculoSistemaFrances(Hashtable<String, Double> dat){
        Hashtable<String, Double> dictPeriodo = new Hashtable<String, Double>();
        Hashtable<String, Hashtable<String, Double>> dictResultado = new Hashtable<String, Hashtable<String, Double>>();
        Double interesDecimal = (Double) dat.get("Interes")/100;
        //Double valorCuota = (Integer.parseInt(""+dat.get("Capital")) * interesDecimal ) / (1-(Math.pow((1+interesDecimal),-(Integer.parseInt(""+dat.get("NCuotas"))))));
        //Double valorCuota = (Integer.parseInt((""+dat.get("Capital")).substring(0, (""+dat.get("Capital")).length()-2)) * interesDecimal ) / (1-(Math.pow((1+interesDecimal),-(Integer.parseInt((""+dat.get("NCuotas")).substring(0, (""+dat.get("NCuotas")).length()-2))))));
        Double valorCuota = (dat.get("Capital") * interesDecimal ) / (1-(Math.pow((1+interesDecimal),-(dat.get("NCuotas")))));
        Double contLinea = (Double) dat.get("NCuotas")+1;
        for (int lin=0;lin < contLinea;lin++){
            if(lin==0){
                dictPeriodo.put("PeriodoPeriodo0",(double) lin);
                dictPeriodo.put("CuotaPeriodo0",(double) 0);
                dictPeriodo.put("InteresPeriodo0",(double) 0);
                dictPeriodo.put("AmortizacionPeriodo0",(double) 0);
                dictPeriodo.put("SaldoPeriodo0",(Double) dat.get("Capital"));
                dictResultado.put("Periodo0", dictPeriodo);
            } else{
                Double interes = (Double) dictResultado.get("Periodo"+(lin-1)).get("SaldoPeriodo"+(lin-1)) * interesDecimal;
                Double amortizacion = valorCuota - interes;
                Double saldoRes = (Double) dictResultado.get("Periodo"+(lin-1)).get("SaldoPeriodo"+(lin-1)) - amortizacion;
                dictPeriodo.put("PeriodoPeriodo"+lin,(double) lin);
                dictPeriodo.put("CuotaPeriodo"+lin, valorCuota);
                dictPeriodo.put("InteresPeriodo"+lin, interes);
                dictPeriodo.put("AmortizacionPeriodo"+lin, amortizacion);
                dictPeriodo.put("SaldoPeriodo"+lin, saldoRes);
                dictResultado.put("Periodo"+lin, dictPeriodo);
            }
        }
        dictResultado.get("Periodo0").put("NCuotas", (double) dat.get("NCuotas"));
        return dictResultado;
    }

    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        OpSistemasAmortizacion obj = new OpSistemasAmortizacion();
        Hashtable<String, Double> dictDatos = new Hashtable<String, Double>();
        dictDatos.put("Capital",(double) 10000000);
        dictDatos.put("Interes",(double) 2);
        dictDatos.put("NCuotas",(double) 5);
        Hashtable<String, Hashtable<String, Double>> Resultado;
        Resultado = obj.CalculoSistemaAmericano(dictDatos);
        /*
        for (Entry<String, Hashtable<String, Double>> Period : Resultado.entrySet()){
            System.out.println(""+Period.getKey());
            for (Entry<String, Double> datos : Period.getValue().entrySet()){
                if (datos.getKey().endsWith(Period.getKey())){
                    System.out.println(""+datos.getKey().substring(0,(datos.getKey().length()-Period.getKey().length()))+" - "+datos.getValue());
                }
            }
        }*/
        System.out.println("Periodo - Cuota");
        for(int i=0;i < Resultado.get("Periodo0").get("NCuotas")+1;i++){
            System.out.println(""+Resultado.get("Periodo"+i).get("PeriodoPeriodo"+i)+" - "+Resultado.get("Periodo"+i).get("CuotaPeriodo"+i));
        }
    }
}
