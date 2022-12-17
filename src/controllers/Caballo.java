package controllers;

import java.awt.Color;
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
        
        flag = i.getEstado().equals("inactivo");
        if(flag){
             verMovimientos(i);
             i.setEstado("activo");
             return;
        }
        flag = i.cordenadas[2] != -1;
        if(flag){
            i.setEstado("inactivo");
            int y2 = i.cordenadas[2];
            int x2 = i.cordenadas[3];
            Color green = new Color(0,255,0);
            Color reed = new Color(255,0,0);
            Color temp = (Color) i.posiciones[y2][x2].getBackground();
            
            flag = green.equals(temp);
            if(flag){
//                =========== Mover Ficha blanco =========================
                i.actualizarPanel(x2, y2);
                i.posiciones[y2][x2].add(i.posiciones[y][x].getComponent(0));
                
//                ==== Quitar ficha de la antigua posicion ====
                i.actualizarPanel(x,y);
                i.normalizarTablero(0);
                return;
            }

            flag = getColor().equals("Blanco");
            if(flag) kill(i, "Blanco");
            else kill(i, "Negro");
            
        }
    }

    @Override
    public void isKill(Inicio i) {}

    @Override
    public void verMovimientos(Inicio i) {
        boolean flag;
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
        
        flag = y >= 0;
        if(flag) movimientosArribaAbajo(i,i.cordenadas[0]+2);
        
        flag = y < 8;
        if(flag) movimientosArribaAbajo(i,i.cordenadas[0]-2);
        
        flag = x < 8;
        if(flag) movimientosDerechaIzquierda(i, i.cordenadas[1]+2);
        
        flag = x > 0;
        if(flag) movimientosDerechaIzquierda(i,i.cordenadas[1]-2);

    }
    
    private void movimientosArribaAbajo(Inicio i,int y){
        int x = i.cordenadas[1];
        boolean flag = y <= 7 && y >= 0;
        
        if(flag){
            
            flag = (x-1) >= 0;
            if(flag){
                flag = i.posiciones[y][x-1].getComponentCount() == 0;
                if(flag)i.posiciones[y][x-1].setBackground(Color.green);
                else{
                    JLabel label = (JLabel) i.posiciones[y][x-1].getComponent(0);
                    String[] value = (label.getText()).split("-");
                    flag = value[2].equals(getColor());
                    if(!flag) isKill(i,x-1,y);
                }
            }
            flag = (x+1) <= 7;
            if(flag){
                flag = i.posiciones[y][x+1].getComponentCount() == 0;
                if(flag)i.posiciones[y][x+1].setBackground(Color.green);
                else{
                    JLabel label = (JLabel) i.posiciones[y][x+1].getComponent(0);
                    String[] value = (label.getText()).split("-");
                    flag = value[2].equals(getColor());
                    if(!flag) isKill(i,x+1,y);
                }
            }
        }
    }
    
    private void movimientosDerechaIzquierda(Inicio i, int x){
        int y = i.cordenadas[0];
        boolean flag = x <= 7 && x >= 0 && (y-1) >= 0 && (y+1) <= 7;

        if(flag){
            flag = i.posiciones[y-1][x].getComponentCount() == 0;
            if(flag)i.posiciones[y-1][x].setBackground(Color.green);
            else{
                JLabel label = (JLabel) i.posiciones[y-1][x].getComponent(0);
                String[] value = (label.getText()).split("-");
                flag = value[2].equals(getColor());
                if(!flag) isKill(i,x,y-1);
            }

            flag = i.posiciones[y+1][x].getComponentCount() == 0;
            if(flag)i.posiciones[y+1][x].setBackground(Color.green);
            else{
                JLabel label = (JLabel) i.posiciones[y+1][x].getComponent(0);
                String[] value = (label.getText()).split("-");
                flag = value[2].equals(getColor());
                if(!flag) isKill(i,x,y+1);
            }
            
        } 
    }
    
    public void isKill(Inicio i,int x, int y) {
      i.posiciones[y][x].setBackground(Color.red);
    }
}
