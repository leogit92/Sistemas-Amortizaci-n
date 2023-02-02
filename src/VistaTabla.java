import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.*;

public class VistaTabla extends JFrame {

    private static String titlesReq1[];
    private static String dataReq1[][];

    public VistaTabla(Hashtable<String, Hashtable<String, Double>> dicDats) {
        // Titulo de la ventana
        this.setTitle("Tabla Tallo");
        // Ubicación y tamaño
        this.setBounds(0, 0, 500, 300);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        setLayout(new BorderLayout());
        vista_Tabla(dicDats);
        JTable tablaReq1 = new JTable(dataReq1, titlesReq1);
        tablaReq1.setRowSelectionAllowed(true);
        tablaReq1.setColumnSelectionAllowed(true);
        tablaReq1.setSelectionForeground(Color.white);
        tablaReq1.setSelectionBackground(Color.red);
        add(new JScrollPane(tablaReq1), BorderLayout.CENTER);
        /*
         * JLabel lblResultado = new JLabel("Resultado: ");
         * lblResultado.setBounds(60, 260, 100, 30);
         * add(lblResultado);
         */
    }

    public static void vista_Tabla(Hashtable<String, Hashtable<String, Double>> dicD) {

        titlesReq1 = new String[5];
        titlesReq1[0] = "Período";
        titlesReq1[1] = "Cuota";
        titlesReq1[2] = "Interés";
        titlesReq1[3] = "Amortización";
        titlesReq1[4] = "Saldo";


        // System.out.println(listTallo);
        String NFilsS = ""+dicD.get("Periodo0").get("NCuotas");
        int NFils;
        //System.out.println(NFilsS);
        NumberFormat myFormat = new DecimalFormat("#0.00");
        //System.out.println(myFormat.format(1.02E7));
        NFils = Integer.parseInt(NFilsS.substring(0, NFilsS.length()-2))+1;
        dataReq1 = new String[NFils][5];
        for (int iY = 0; iY < NFils; iY++) {
            String strPeriod = "" + dicD.get("Periodo"+iY).get("PeriodoPeriodo"+iY);
            dataReq1[iY][0] = "" + strPeriod.substring(0, strPeriod.length()-2);
            dataReq1[iY][1] = "" + myFormat.format(dicD.get("Periodo"+iY).get("CuotaPeriodo"+iY));
            dataReq1[iY][2] = "" + myFormat.format(dicD.get("Periodo"+iY).get("InteresPeriodo"+iY));
            dataReq1[iY][3] = "" + myFormat.format(dicD.get("Periodo"+iY).get("AmortizacionPeriodo"+iY));
            dataReq1[iY][4] = "" + myFormat.format(dicD.get("Periodo"+iY).get("SaldoPeriodo"+iY));
        }

    }

}
