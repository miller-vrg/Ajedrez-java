package controllers;

import java.awt.*;
import javax.swing.*;
import views.Inicio;

/**
 *
 * @author Miller
 * 
 */

public class Peon extends Ficha {
    public static int conteo; 
    private int id;
    
    public Peon(String color, boolean isActive) {
        super(color, ("-"+"peon"+"-"+color), isActive, conteo);
        JLabel temp = new JLabel("");
        temp.setText(getTitle());
        setUrl((color.equals("Blanco"))? "/img/peonBlanco.png": "/img/peonNegro.png"); 
        temp.setIcon(new ImageIcon(getClass().getResource(getUrl())));
        setImg(temp);
        conteo ++;
    }

    public Peon() {
        super(null, null, false, 0);
    }

    @Override
    public void movimiento(Inicio i) {
        boolean flag;
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
                
        flag = y == 7;
        if(flag){
             JOptionPane.showMessageDialog(null,"Ya no puedes mover más");
            return;
        }
        
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
            
            flag = green.equals(temp) && isNullPosition(i);
            if(flag){
//                =========== Mover peon blanco =========================
                i.actualizarPanel(x2, y2);
                i.posiciones[y2][x2].add(i.posiciones[y][x].getComponent(0));
                //==== Quitar peon de la antigua posicion ====
                i.actualizarPanel(x,y);
                i.normalizarTablero(0);
                return;
            }

            flag = getColor().equals("Blanco");
            if(flag){
                flag = y2 == 7;
                if(flag) ejecutarCambio(i,"Blanco");
                kill(i, "Blanco");
            }
            else{
                flag = y2 == 0;
                if(flag)ejecutarCambio(i,"Negro");
                kill(i, "Negro");
            }
        }
    }
    
    private void ejecutarCambio(Inicio i, String tipo){
            JLabel labelTemp = new JLabel();
            int y = i.cordenadas[0];
            int x = i.cordenadas[1];
            boolean flag;
            String[] options = {"Reina", "Torre", "Alfil", "Caballo"};
            int opc = JOptionPane.showOptionDialog(null, "Tome la que necesita","Cambio de ficha",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (opc) {
                case 0:{
                    Reina r = new Reina(tipo, true);
                    labelTemp = (JLabel) r.getImg();
                    
                    flag = tipo.equals("Blanco");
                    if(flag) i.reinaBlanca.add(r);
                    else i.reinaNegra.add(r);
                    
                }break;

                case 1:{
                    Torre t = new Torre(tipo, true);
                    labelTemp = (JLabel) t.getImg();
                                 
                    flag = tipo.equals("Blanco");
                    if(flag) i.torresBlancas.add(t);
                    else i.torresNegras.add(t);
                }break;

                case 2:{
                    Alfil a = new Alfil(tipo, true);
                    labelTemp = (JLabel) a.getImg();
                                
                    flag = tipo.equals("Blanco");
                    if(flag) i.alfilBlancos.add(a);
                    else i.alfilNegros.add(a);
                }break;
                default:
                    Caballo c = new Caballo(tipo, true);
                    labelTemp = (JLabel) c.getImg();
                                    
                    flag = tipo.equals("Blanco");
                    if(flag) i.caballosBlancos.add(c);
                    else i.caballosNegros.add(c);
            }
            i.actualizarPanel(x, y);
            i.posiciones[y][x].add(labelTemp);
            i.peonesNegros.remove(id);
    }
    
    @Override
    public void verMovimientos(Inicio i){
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
        boolean flag;
        isKill(i);
       flag = getColor().equals("Blanco");
       if(flag){
            
        flag = isNullPosition(i);
        if(flag) i.posiciones[1+y][x].setBackground(Color.green);
        
        flag = y == 1 && isNullPosition(i) && (i.posiciones[y+2][x].getComponentCount() == 0);
        if(flag) i.posiciones[y+2][x].setBackground(Color.green);
       }
       else{  
        flag = isNullPosition(i);
        if(flag) i.posiciones[y-1][x].setBackground(Color.green);
       
        flag = y == 6 && isNullPosition(i) && (i.posiciones[y-2][x].getComponentCount() == 0);
        if(flag) i.posiciones[y-2][x].setBackground(Color.green);
       }
        
    }
    
    @Override
    public void isKill(Inicio i) {
        int y = i.cordenadas[0];
        int x = i.cordenadas[1];
        String[] value;
        JLabel label;
        boolean flag, isBlanco;
        
        flag = i.posiciones[y][x].getComponentCount() != 0;
        if(flag){
            label = (JLabel) i.posiciones[y][x].getComponent(0);
            value = (label.getText()).split("-");
            isBlanco = value[2].equals("Blanco");
        
            if(isBlanco){
                
                flag = x != 7; 
                if(flag){
                    flag = i.posiciones[y+1][x+1].getComponentCount() != 0;
                    if(flag){
                        label = (JLabel) i.posiciones[y+1][x+1].getComponent(0);
                        value = (label.getText()).split("-");
                        flag = value[2].equals("Negro");
                        if(flag) i.posiciones[y+1][x+1].setBackground(Color.red);
                    }
                }
                
                flag = x != 0;
                if(flag){
                    flag = i.posiciones[y+1][x-1].getComponentCount() != 0 && x!=0;
                    if(flag){
                        label = (JLabel) i.posiciones[y+1][x-1].getComponent(0);
                        value = (label.getText()).split("-");
                        flag = value[2].equals("Negro");
                        if(flag) i.posiciones[y+1][x-1].setBackground(Color.red);
                    }
                }
            }
            else{
                flag = x != 7;
                if(flag){
                    flag = i.posiciones[y-1][x+1].getComponentCount() != 0;
                    if(flag){
                        label = (JLabel) i.posiciones[y-1][x+1].getComponent(0);
                        value = (label.getText()).split("-");
                        flag = value[2].equals("Blanco");
                        if(flag) i.posiciones[y-1][x+1].setBackground(Color.red);
                    }
                }
                
                flag = x != 0;
                if(flag){
                    flag = i.posiciones[y-1][x-1].getComponentCount() != 0;
                    if(flag){
                        label = (JLabel) i.posiciones[y-1][x-1].getComponent(0);
                        value = (label.getText()).split("-");
                        System.err.println(label.getText());
                        flag = value[2].equals("Blanco");
                        if(flag) i.posiciones[y-1][x-1].setBackground(Color.red);
                    }
                }
            }
        }
    }
    
}
