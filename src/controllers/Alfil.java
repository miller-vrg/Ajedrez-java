package controllers;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import views.Inicio;

/**
 *
 * @author Miller
 */

public class Alfil extends Ficha{
    public static int conteo;
    
    public Alfil(String color, boolean isActive) {
        super(color, ("-"+"alfil"+"-"+color), isActive, conteo);
        JLabel temp = new JLabel("");
        temp.setText(getTitle());
        setUrl((color.equals("Blanco"))? "/img/alfilBlanco.png": "/img/alfilNegro.png"); 
        temp.setIcon(new ImageIcon(getClass().getResource(getUrl())));
        setImg(temp);
        conteo ++;
    }

    public Alfil() {
        super(null, null, false, 0);
    }

    @Override
    public void movimiento(Inicio i) {
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
        //=========== Mover peon =========================
        i.posiciones[y+1][x-1].removeAll();
        i.posiciones[y+1][x-1].updateUI();
        i.posiciones[y+1][x-1].add(i.posiciones[y][x].getComponent(0));
        
        //==== Quitar peon de la antigua posicion ====
        i.posiciones[y][x].removeAll();
        i.posiciones[y][x].updateUI();
    }

    @Override
    public void  isKill(Inicio i) {
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
    }

    @Override
    public void verMovimientos(Inicio i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
