import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;


public class GUI_Amortizacion extends JFrame{
    private JLabel lblCapital;
    private JLabel lblInteres;
    private JLabel lblCuotas;
    private JComboBox cbInteres;
    private JComboBox cbCuotas;
    private JTextField CapitalIn;
    private JTextField InteresIn;
    private JTextField CuotasIn;
    private JLabel lblI2;
    private JLabel lblC2;

    private JButton btnSA;
    private JButton btnSAm;
    private JButton btnSF;

    public GUI_Amortizacion(){
        // Titulo de la ventana
        this.setTitle("Sistemas de Amortización");
        // Ubicación y tamaño
        this.setBounds(0, 0, 500, 140);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        // Construir objeto layout
        GridLayout northLayout = new GridLayout(2, 5, 5, 5);
        // Contenedor de elementos
        Container northContainer = new Container();
        // Indicar el layout al objContainer
        northContainer.setLayout(northLayout);

        this.lblCapital = new JLabel("Capital: ");
        northContainer.add(this.lblCapital);
        this.lblInteres = new JLabel("Interes: ");
        northContainer.add(this.lblInteres);
        this.cbInteres = new JComboBox<>();
        this.cbInteres.addItem("Anual");
        this.cbInteres.addItem("Semestral");
        this.cbInteres.addItem("Cuatrimestral");
        this.cbInteres.addItem("Trimestral");
        this.cbInteres.addItem("Bimestral");
        this.cbInteres.addItem("Mensual");
        northContainer.add(this.cbInteres);
        this.lblCuotas = new JLabel("Cuotas: ");
        northContainer.add(this.lblCuotas);
        this.cbCuotas = new JComboBox<>();
        this.cbCuotas.addItem("Anual");
        this.cbCuotas.addItem("Semestral");
        this.cbCuotas.addItem("Cuatrimestral");
        this.cbCuotas.addItem("Trimestral");
        this.cbCuotas.addItem("Bimestral");
        this.cbCuotas.addItem("Mensual");
        northContainer.add(this.cbCuotas);
        this.CapitalIn = new JTextField();
        northContainer.add(this.CapitalIn);
        this.InteresIn = new JTextField();
        northContainer.add(this.InteresIn);
        this.lblI2 = new JLabel();
        northContainer.add(this.lblI2);
        this.CuotasIn = new JTextField();
        northContainer.add(this.CuotasIn);
        this.lblC2 = new JLabel();
        northContainer.add(this.lblC2);
        
        // Construir objeto layout
        GridLayout southLayout = new GridLayout(1, 3, 5, 5);
        // Contenedor de elementos
        Container southContainer = new Container();
        // Indicar el layout al objContainer
        southContainer.setLayout(southLayout);
        
        this.btnSA = new JButton("Sistema Alemán");
        southContainer.add(this.btnSA);
        this.btnSAm = new JButton("Sistema Americano");
        southContainer.add(this.btnSAm);
        this.btnSF = new JButton("Sistema Francés");
        southContainer.add(this.btnSF);

        this.btnSAm.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                Hashtable<String, Hashtable<String, Double>> Resultado;
                Controller objR = new Controller();
                Resultado = objR.CalculoSistemaAmericano(Double.parseDouble(CapitalIn.getText()), Double.parseDouble(InteresIn.getText()), (String) cbInteres.getSelectedItem(), Double.parseDouble(CuotasIn.getText()), (String) cbCuotas.getSelectedItem());
                //System.out.println(Resultado);
                VistaTabla objVista = new VistaTabla(Resultado);
                objVista.setVisible(true);
            }
        });

        this.btnSA.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                Hashtable<String, Hashtable<String, Double>> Resultado;
                Controller objR = new Controller();
                Resultado = objR.CalculoSistemaAleman(Double.parseDouble(CapitalIn.getText()), Double.parseDouble(InteresIn.getText()), (String) cbInteres.getSelectedItem(), Double.parseDouble(CuotasIn.getText()), (String) cbCuotas.getSelectedItem());
                //System.out.println(Resultado);
                VistaTabla objVista = new VistaTabla(Resultado);
                objVista.setVisible(true);
            }
        });

        this.btnSF.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                Hashtable<String, Hashtable<String, Double>> Resultado;
                Controller objR = new Controller();
                Resultado = objR.CalculoSistemaFrances(Double.parseDouble(CapitalIn.getText()), Double.parseDouble(InteresIn.getText()), (String) cbInteres.getSelectedItem(), Double.parseDouble(CuotasIn.getText()), (String) cbCuotas.getSelectedItem());
                //System.out.println(Resultado);
                VistaTabla objVista = new VistaTabla(Resultado);
                objVista.setVisible(true);
            }
        });

        this.add(northContainer, BorderLayout.CENTER);
        this.add(southContainer, BorderLayout.SOUTH);
    }

    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        GUI_Amortizacion obj = new GUI_Amortizacion();
        obj.setVisible(true);
    }
    
}
