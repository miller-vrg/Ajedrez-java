package controllers;

import javax.swing.*;
import views.Inicio;

/**
 *
 * @author Miller
 */

public class Reina extends Ficha{
    public static int conteo; 
    
    public Reina(String color, boolean isActive) {
        super(color, ("-"+"reina"+"-"+color), isActive, conteo);
        JLabel temp = new JLabel("");
        temp.setText(getTitle());
        setUrl((color.equals("Blanco"))? "/img/reinaBlanca.png": "/img/reinaNegra.png"); 
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
