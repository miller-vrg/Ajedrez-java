package controllers;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import views.Inicio;

/**
 *
 * @author Miller
 */
public class Caballo extends Ficha{
    public static int conteo; 

    public Caballo(String color, boolean isActive) {
        super(color, ("-"+"caballo"+"-"+color), isActive, conteo);
        JLabel temp = new JLabel("");
        temp.setText(getTitle());
        setUrl((color.equals("Blanco"))? "/img/caballoBlanco.png": "/img/caballoNegro.png");
        temp.setIcon(new ImageIcon(getClass().getResource(getUrl())));
        setImg(temp);
        conteo ++;
    }

    public Caballo() {
        super(null, null, false, 0);
    }
    
    @Override
    public void movimiento(Inicio i) {
        boolean flag;
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
        flag = (getColor() == "Blanco");
        if(flag){
            //=========== Mover peon =========================
            i.posiciones[y+2][x+1].removeAll();
            i.posiciones[y+2][x+1].updateUI();
            i.posiciones[y+2][x+1].add(i.posiciones[y][x].getComponent(0));

            //==== Quitar peon de la antigua posicion ====
            i.posiciones[y][x].removeAll();
            i.posiciones[y][x].updateUI();
        return;
        }else{
            //=========== Mover peon =========================
            i.posiciones[y-2][x-1].removeAll();
            i.posiciones[y-2][x-1].updateUI();
            i.posiciones[y-2][x-1].add(i.posiciones[y][x].getComponent(0));

            //==== Quitar peon de la antigua posicion ====
            i.posiciones[y][x].removeAll();
            i.posiciones[y][x].updateUI();
        }
    }

    @Override
    public void isKill(Inicio i) {
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
    }

    @Override
    public void verMovimientos(Inicio i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
