package controllers;

import java.awt.*;
import javax.swing.*;
import views.Inicio;

/**
 *
 * @author Miller
 */
public class Torre extends Ficha{
    public static int conteo; 
    
    public Torre(String color, boolean isActive) {
        super(color, (conteo+"-"+"torre"+"-"+color), isActive, conteo);
        JLabel temp = new JLabel("");
        String title = ""+conteo+"-"+"torre"+"-"+color;
        temp.setText(title);
        setUrl((color.equals("Blanco"))? "/img/torreBlanca.png": "/img/torreNegra.png");
        temp.setIcon(new ImageIcon(getClass().getResource(getUrl())));
        setImg(temp);
        conteo ++;
    }

    public Torre() {
        super(null, null, false, 0);
    }

    @Override
    public void movimiento(Inicio i) {
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
        boolean flag;
        
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
//              =========== Mover Torre =========================
                i.actualizarPanel(x2, y2);
                i.posiciones[y2][x2].add(i.posiciones[y][x].getComponent(0));
                
//              ==== Quitar torre de la antigua posicion ====
                i.actualizarPanel(x, y);
                i.normalizarTablero(0);
            }
            
            flag = getColor().equals("Blanco");
            if(flag) kill(i,"Blanco");
            else kill(i,"Negro");
        }
        
    }
    
    @Override
    public void verMovimientos(Inicio i) {
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
        
        boolean flag = y >= 0;
        if(flag) movimientosArriba(i, 1);
        
        flag = y < 8;
        if(flag) movimeintosAbajo(i, 1);
        
        flag = x < 8;
        if(flag) movimeintosDerecha(i, 1);
        
        flag = x > 0;
        if(flag) movimeintosIzquierda(i, 1);
    }
    
    private void movimientosArriba (Inicio i,int size){
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
        y += size;
        
        boolean flag = y <= 7 && y >= 0;
        
        if(flag){
            flag = i.posiciones[y][x].getComponentCount() == 0;
            if(flag){
                i.posiciones[y][x].setBackground(Color.green);
                movimientosArriba(i, ++size);
            }else{
                JLabel label = (JLabel) i.posiciones[y][x].getComponent(0);
                String[] value = (label.getText()).split("-");
                flag = value[2].equals(getColor());
                if(!flag) isKill(i,x,y);
                return;
            }
            
        }
        return;
    }
    
    private void movimeintosAbajo (Inicio i,int size){
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
        y -= size;
        boolean flag = size < 15 && y >= 0;
        
        if(flag){
            flag = i.posiciones[y][x].getComponentCount() == 0;
            if(flag){
                i.posiciones[y][x].setBackground(Color.green);
                movimeintosAbajo(i, ++size);
            }else{
                JLabel label = (JLabel) i.posiciones[y][x].getComponent(0);
                String[] value = (label.getText()).split("-");
                flag = value[2].equals(getColor());
                if(!flag) isKill(i,x,y);
                return;
            }
            
        }
        return;
        
    }
    
    private void movimeintosDerecha (Inicio i, int size){
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
        x += size;
        
        boolean flag = x <= 7 && x >= 0;
        if(flag){
            flag = i.posiciones[y][x].getComponentCount() == 0;
            if(flag){
                i.posiciones[y][x].setBackground(Color.green);
                movimeintosDerecha(i, ++size);
            }else{
                JLabel label = (JLabel) i.posiciones[y][x].getComponent(0);
                String[] value = (label.getText()).split("-");
                flag = value[2].equals(getColor());
                if(!flag) isKill(i,x,y);
                return;
            }
            
        }
        return;
    }
    
    private void movimeintosIzquierda (Inicio i, int size){
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
        x -= size;
        boolean flag = size < 15 && x >= 0;
        
        if(flag){
            flag = i.posiciones[y][x].getComponentCount() == 0;
            if(flag){
                i.posiciones[y][x].setBackground(Color.green);
                movimeintosIzquierda(i, ++size);
            }else{
                JLabel label = (JLabel) i.posiciones[y][x].getComponent(0);
                String[] value = (label.getText()).split("-");
                flag = value[2].equals(getColor());
                if(!flag) isKill(i,x,y);
                return;
            }
            
        }
        return;
    }
    
    @Override
    public void isKill(Inicio i) {}
    
    public void isKill(Inicio i,int x, int y) {
      i.posiciones[y][x].setBackground(Color.red);
    }
    
}
