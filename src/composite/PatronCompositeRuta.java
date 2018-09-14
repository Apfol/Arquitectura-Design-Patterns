/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;

/**
 *
 * @author Apfol
 */
public class PatronCompositeRuta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Componente c1 = new Calle("12.09.54", "14.23.64", "34.13.74", "345.26.42.5", "Calle 9", "9 mts");
        Componente c2 = new Calle("34.25.1", "64.26.32.6", "32.75.47", "36.32.1345", "Calle 57", "14 mts");
        Componente c3 = new Calle("52.63.7.2", "54.2.67.2", "3245.2.6.3", "32.1.5.3", "Calle 91", "16 mts");
        Componente c4 = new Calle("42.25.1.5", "74.2.6.3.8", "1541.5.3", "353.2.67.3", "Calle 56", "14 mts");
        Componente c5 = new Calle("251.6.2.6", "143.2.56.3", "632.6.2.5", "14.42.5", "Calle 45", "30 mts");
        Componente c6 = new Calle("131.4.2.4", "2424.2.3.", "2442.1.3.", "243.2.2.", "Calle 60", "50 mts");
        
        Ruta a = new Ruta("Ruta 1","2");
        Ruta b = new Ruta("Ruta 2","23");
        Ruta c = new Ruta("Ruta 3","23");
        
        a.add(c1);
        a.add(c2);
        a.add(c3);
        
        b.add(a);
        
        System.out.println(b.obtenerDatos());
        
        c.add(c4);
        c.add(c5);
        c.add(c6);
        System.out.println(c.obtenerDatos());
    }
    
}
