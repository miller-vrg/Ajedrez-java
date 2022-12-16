package controllers;

import java.awt.Color;
import javax.swing.*;
import views.Inicio;

/**
 *
 * @author Miller
 * 
 */
public abstract class Ficha {
    
    private String color,title,url;
    private JLabel img;
    private boolean isActive;
    private int id;

    public Ficha(String color, String title, boolean isActive, int id) {
        this.color = color;
        this.title = id+title;
        this.img = new JLabel("");
        this.isActive = isActive;
        this.id = id;
        this.url = null;
    }

    public abstract void movimiento(Inicio i);
    public abstract void isKill(Inicio i);
    public abstract void verMovimientos(Inicio i);
  
    public boolean isNullPosition(Inicio i){
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
        boolean flag = getColor().equals("Blanco");
        if(flag) return i.posiciones[y+1][x].getComponentCount()== 0;
        else return i.posiciones[y-1][x].getComponentCount()== 0;  
    }
     
    protected void kill(Inicio i,String tipo){
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
        int y2 = i.cordenadas[2];
        int x2 = i.cordenadas[3];
        
        Color reed = new Color(255,0,0);
        Color temp = (Color) i.posiciones[y2][x2].getBackground();
        
      boolean flag = (("Blanco").equals(tipo));
      if(flag){
//              =========== Matar con la torre =========================
                flag = reed.equals(temp);
                if(flag){
//                      Sacar el tipo si es blanco o negro
                        JPanel panel = (JPanel) i.posiciones[y2][x2];
                        JLabel label = (JLabel) panel.getComponent(0);
                        String value[] = (label.getText()).split("-");
                        i.actualizarPanel(x2, y2);
                        

                        i.posiciones[y2][x2].add(i.posiciones[y][x].getComponent(0));

//                       =========== Mover la ficha muerta al panel de kills =========================
//                        Panel usuario 1
                        flag = value[2].equals("Blanco");
                        if(flag){
                            int size = i.panelusuario1.getComponentCount();
                            int X = size * 50;
                            int Y = 0;
                            
//                          Cordenadas en el panel del kills
                            flag = size == 8;
                            if(flag){
                                X = (size - 8) * 50;
                                Y = 1;
                            }
                            
                            label.setLocation(X, Y);
                            label.setText("");
                            i.panelusuario1.updateUI();
                            i.panelusuario1.add(label);
                        }
//                        Panel usuario 2
                        else{
                            int size = i.panelusuario1.getComponentCount();
                            int X = size * 50;
                            int Y = 0;
                            
//                          Cordenadas en el panel del kills
                            flag = size == 8;
                            if(flag){
                                X = (size - 8) * 50;
                                Y = 1;
                            }
                            label.setLocation(X, Y);
                            label.setText("");
                            i.panelusuario1.updateUI();
                            i.panelusuario1.add(label);
                        }
                        liampiarPosicionAnterior(i, x, y);
                    }
                }else{
//             =========== Matar con el peon negro =========================
                flag = reed.equals(temp);
                if(flag){
                    JPanel panel = (JPanel) i.posiciones[y2][x2];
                    JLabel label = (JLabel) panel.getComponent(0);
                    String value[] = (label.getText()).split("-");
                    i.actualizarPanel(x2, y2);
                    
//             =========== Mover la ficha muerta al panel de kills =====

                    i.posiciones[y2][x2].add(i.posiciones[y][x].getComponent(0));

                    flag = value[2].equals("Negro");
                    if(flag){
                        int size = i.panelusuario2.getComponentCount();
                        int X = size * 50;
                        int Y = 0;

                        flag = size == 8;
                        if(flag){
                            X = (size - 8) * 50;
                            Y = 1;
                        }

                        label.setLocation(X, Y);
                        label.setText("");
                        i.panelusuario2.updateUI();
                        i.panelusuario2.add(label);
                    }else{
                        int size = i.panelusuario2.getComponentCount();
                        int X = size * 50;
                        int Y = 0;

                        flag = size == 8;
                        if(flag){
                            X = (size - 8) * 50;
                            Y = 1;
                        }
                        label.setLocation(X, Y);
                        label.setText("");
                        i.panelusuario2.updateUI();
                        i.panelusuario2.add(label);
                    }
                    liampiarPosicionAnterior(i, x, y);
                }
            }  
    }
    //          ==== Quitar la ficha de la antigua posicion ====
    private void liampiarPosicionAnterior(Inicio i, int x, int y){
            i.actualizarPanel(x,y);
            i.normalizarTablero(0);
            return; 
    }
    
    public JLabel getImg() {
        return img;
    }

    public void setImg(JLabel img) {
        this.img = img;
        this.img.setHorizontalTextPosition(SwingConstants.CENTER);
        this.img.setVerticalTextPosition(SwingConstants.BOTTOM);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
   
}
