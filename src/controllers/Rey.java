package controllers;

import javax.swing.*;
import views.Inicio;

/**
 *
 * @author Miller
 * 
 */

public class Rey extends Ficha{
    public static int conteo; 
    
    public Rey(String color, boolean isActive) {
        super(color, ("-"+"rey"+"-"+color), isActive, conteo);
        JLabel temp = new JLabel("");
        temp.setText(getTitle());
        setUrl((color.equals("Blanco"))? "/img/reyBlanco.png": "/img/reyNegro.png"); 
        temp.setIcon(new ImageIcon(getClass().getResource(getUrl())));
        setImg(temp);
        conteo ++;
    }

    @Override
    public void movimiento(Inicio i) {
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void isKill(Inicio i) {
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void verMovimientos(Inicio i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
