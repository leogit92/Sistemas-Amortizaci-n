import java.util.Hashtable;

public class Controller {

    public Controller(){

    }

    public Hashtable<String, Hashtable<String, Double>> CalculoSistemaAmericano(Double Capital, Double Interes, String periodoInteres, Double Cuota, String periodoCuota){
        Hashtable<String, Double> datosPeriodo;
        OpInteresPeriodico objInteres = new OpInteresPeriodico();
        datosPeriodo = objInteres.OpInteres(Capital, Interes, periodoInteres, Cuota, periodoCuota);
        Hashtable<String, Hashtable<String, Double>> Resultado;
        OpSistemasAmortizacion objAmort = new OpSistemasAmortizacion();
        Resultado = objAmort.CalculoSistemaAmericano(datosPeriodo);
        return Resultado;
    }

    public Hashtable<String, Hashtable<String, Double>> CalculoSistemaAleman(Double Capital, Double Interes, String periodoInteres, Double Cuota, String periodoCuota){
        Hashtable<String, Double> datosPeriodo;
        OpInteresPeriodico objInteres = new OpInteresPeriodico();
        datosPeriodo = objInteres.OpInteres(Capital, Interes, periodoInteres, Cuota, periodoCuota);
        Hashtable<String, Hashtable<String, Double>> Resultado;
        OpSistemasAmortizacion objAmort = new OpSistemasAmortizacion();
        Resultado = objAmort.CalculoSistemaAleman(datosPeriodo);
        return Resultado;
    }

    public Hashtable<String, Hashtable<String, Double>> CalculoSistemaFrances(Double Capital, Double Interes, String periodoInteres, Double Cuota, String periodoCuota){
        Hashtable<String, Double> datosPeriodo;
        OpInteresPeriodico objInteres = new OpInteresPeriodico();
        datosPeriodo = objInteres.OpInteres(Capital, Interes, periodoInteres, Cuota, periodoCuota);
        Hashtable<String, Hashtable<String, Double>> Resultado;
        OpSistemasAmortizacion objAmort = new OpSistemasAmortizacion();
        Resultado = objAmort.CalculoSistemaFrances(datosPeriodo);
        return Resultado;
    }
    
    
}
