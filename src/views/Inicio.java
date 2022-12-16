package views;

import controllers.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Miller
 *
 */

public class Inicio extends javax.swing.JFrame {

    public Inicio() {
        posiciones = new JPanel[8][8];
        peonesBlancos = new ArrayList<>();
        peonesNegros = new ArrayList<>();
        torresBlancas = new ArrayList<>();
        torresNegras = new ArrayList<>();
        caballosNegros = new ArrayList<>();
        caballosBlancos = new ArrayList<>();
        alfilBlancos = new ArrayList<>();
        alfilNegros = new ArrayList<>();
        reinaBlanca = new ArrayList<>();
        reinaNegra = new ArrayList<>();
        cordenadas = new int[4];
        panelKillsUser1 = new JPanel[16];
        panelKillsUser2 = new JPanel[16];
        estado = "inactivo";
        posicionFicha = -1;
        valueFicha = new String[2];
        
        initComponents();
        llenarTablero(0);
        ponerFichas();
        JLabel imgPeonBlanco = new JLabel();
        posiciones[1][0].add(imgPeonBlanco);
        panelusuario1.setSize(400, 100);
        panelusuario2.setSize(400, 100);
        setSize(1000,550);
        getContentPane().setBackground(new Color(255,255,255));
        setLocationRelativeTo(null);
        setResizable(true);
    }
     
    private void llenarTablero(int i) {
         boolean flag = i < 8;
         if(flag){
             llenarFilaTablero(i,0);
             llenarTablero(++i);
         }
         return;
    }
    
    private void llenarFilaTablero(int j,int i){
         boolean flag = i < 8;
         if(flag){
             posiciones[j][i] = new JPanel();
             posiciones[j][i].setBounds((50*i), (50*j), 50, 50);
             posiciones[j][i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
             posiciones[j][i].setBackground(new Color(18,40,75));
             
             flag = (i+j)%2 == 0;
             if(flag) posiciones[j][i].setBackground(Color.WHITE);
             
             tablero.add(posiciones[j][i]);
             llenarFilaTablero(j,++i);
         }
         return;
    }
    
    private void ponerFichas(){
       ponerPeones(0);
       ponerTorres();
       ponerCaballos();
       ponerAlfiles();
       ponerReinas();
       ponerReyes();
    }
    
    private void ponerPeones(int i){
        boolean flag;
        flag = i < 8;
        if(flag){
            peonesBlancos.add(new Peon("Blanco", true));
            posiciones[1][i].add(peonesBlancos.get(i).getImg());
            ponerPeones(++i);
        }
        
        flag = i >= 8 && i < 16;
        if(flag){
            peonesNegros.add(new Peon("Negro", true));
            posiciones[6][i-8].add(peonesNegros.get(i-8).getImg());
            ponerPeones(++i);
        }
        return;
    }
    
    private void ponerTorres(){
            torresBlancas.add(new Torre("Blanco", true));
            torresBlancas.add(new Torre("Blanco", true));
            posiciones[0][0].add(torresBlancas.get(0).getImg());
            posiciones[0][7].add(torresBlancas.get(1).getImg());
            
            torresNegras.add(new Torre("Negro", true));
            torresNegras.add(new Torre("Negro", true));
            posiciones[7][0].add(torresNegras.get(0).getImg());
            posiciones[7][7].add(torresNegras.get(1).getImg());
    }
    
    private void ponerCaballos(){
            caballosBlancos.add(new Caballo("Blanco", true));
            caballosBlancos.add(new Caballo("Blanco", true));
            posiciones[0][1].add(caballosBlancos.get(0).getImg());
            posiciones[0][6].add(caballosBlancos.get(1).getImg());
            
            caballosNegros.add(new Caballo("Negro", true));
            caballosNegros.add(new Caballo("Negro", true));
            posiciones[7][1].add(caballosNegros.get(0).getImg());
            posiciones[7][6].add(caballosNegros.get(1).getImg());
    }
    
    private void ponerAlfiles(){
            alfilBlancos.add(new Alfil("Blanco", true));
            alfilBlancos.add(new Alfil("Blanco", true));
            posiciones[0][2].add(alfilBlancos.get(0).getImg());
            posiciones[0][5].add(alfilBlancos.get(1).getImg());
            
            alfilNegros.add( new Alfil("Negro", true));
            alfilNegros.add( new Alfil("Negro", true));
            posiciones[7][2].add(alfilNegros.get(0).getImg());
            posiciones[7][5].add(alfilNegros.get(1).getImg());
    }
    
    private void ponerReinas(){
        reinaBlanca.add(new Reina("Blanco", true));
        posiciones[0][3].add(reinaBlanca.get(0).getImg());
        
        reinaNegra.add(new Reina("Negro", true));
        posiciones[7][3].add(reinaNegra.get(0).getImg());
    }
    
    private void ponerReyes(){
        reyBlanco = new Rey("Blanco", true);
        posiciones[0][4].add(reyBlanco.getImg());
        
        reyNegro = new Rey("Negro", true);
        posiciones[7][4].add(reyNegro.getImg());
    }
    
    public void normalizarTablero(int i) {
         boolean flag = i < 8;
         if(flag){
             normalizarFilaTablero(i,0);
             normalizarTablero(++i);
         }
         return;
    }
    
    public void normalizarFilaTablero(int j,int i){
         boolean flag = i < 8;
        
         if(flag){
             posiciones[j][i].setBackground(new Color(18,40,75));
             
             flag = (i+j)%2 == 0;
             if(flag) posiciones[j][i].setBackground(Color.WHITE);
             
             tablero.add(posiciones[j][i]);
             normalizarFilaTablero(j,++i);
         }
         return;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        contentTablero = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tablero = new javax.swing.JPanel();
        panelusuario1 = new javax.swing.JPanel();
        panelusuario2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        contentTablero.setBackground(new java.awt.Color(0, 0, 0));
        contentTablero.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("     A              B              C              D              E               F              G              H");
        contentTablero.add(jLabel1);
        jLabel1.setBounds(30, 430, 390, 14);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("8");
        contentTablero.add(jLabel2);
        jLabel2.setBounds(10, 390, 10, 14);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("1");
        contentTablero.add(jLabel3);
        jLabel3.setBounds(10, 40, 10, 14);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("2");
        contentTablero.add(jLabel4);
        jLabel4.setBounds(10, 90, 10, 14);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("3");
        contentTablero.add(jLabel5);
        jLabel5.setBounds(10, 140, 10, 14);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("4");
        contentTablero.add(jLabel6);
        jLabel6.setBounds(10, 190, 10, 14);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("5");
        contentTablero.add(jLabel7);
        jLabel7.setBounds(10, 240, 10, 14);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("6");
        contentTablero.add(jLabel8);
        jLabel8.setBounds(10, 290, 10, 14);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("7");
        contentTablero.add(jLabel9);
        jLabel9.setBounds(10, 340, 10, 14);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("3");
        contentTablero.add(jLabel10);
        jLabel10.setBounds(430, 140, 10, 14);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("2");
        contentTablero.add(jLabel11);
        jLabel11.setBounds(430, 90, 10, 14);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("1");
        contentTablero.add(jLabel12);
        jLabel12.setBounds(430, 40, 10, 14);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("4");
        contentTablero.add(jLabel13);
        jLabel13.setBounds(430, 190, 10, 14);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("5");
        contentTablero.add(jLabel14);
        jLabel14.setBounds(430, 240, 10, 14);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("6");
        contentTablero.add(jLabel15);
        jLabel15.setBounds(430, 290, 10, 14);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("7");
        contentTablero.add(jLabel16);
        jLabel16.setBounds(430, 340, 10, 14);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("8");
        contentTablero.add(jLabel17);
        jLabel17.setBounds(430, 390, 10, 14);

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("     A              B              C              D              E               F              G              H");
        contentTablero.add(jLabel18);
        jLabel18.setBounds(30, 10, 390, 14);

        tablero.setBackground(new java.awt.Color(255, 255, 255));
        tablero.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableroMouseClicked(evt);
            }
        });
        tablero.setLayout(null);
        contentTablero.add(tablero);
        tablero.setBounds(25, 25, 400, 400);

        getContentPane().add(contentTablero);
        contentTablero.setBounds(10, 20, 450, 450);

        panelusuario1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelusuario1Layout = new javax.swing.GroupLayout(panelusuario1);
        panelusuario1.setLayout(panelusuario1Layout);
        panelusuario1Layout.setHorizontalGroup(
            panelusuario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelusuario1Layout.setVerticalGroup(
            panelusuario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(panelusuario1);
        panelusuario1.setBounds(500, 110, 400, 100);

        panelusuario2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelusuario2Layout = new javax.swing.GroupLayout(panelusuario2);
        panelusuario2.setLayout(panelusuario2Layout);
        panelusuario2Layout.setHorizontalGroup(
            panelusuario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelusuario2Layout.setVerticalGroup(
            panelusuario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(panelusuario2);
        panelusuario2.setBounds(500, 340, 400, 100);

        jPanel3.setBackground(new java.awt.Color(255, 204, 0));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Usuario 1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel19)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel19)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(535, 60, 330, 30);

        jPanel4.setBackground(new java.awt.Color(255, 204, 0));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Usuario 2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel20)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel20)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(535, 270, 330, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableroMouseClicked
        int x = evt.getX(), y = evt.getY(), posicion = -1;
        boolean flag;
        String[] value = new String[3];
        String tipo = "";
        JLabel label;
        
//      ========== Se nivelan las posiciónes ==========
        x = normalizarCordenada(x);
        y = normalizarCordenada(y);
       
//        estado activo
        flag = getEstado().equals("activo");
        if(flag){
         cordenadas[2]=y;
         cordenadas[3]=x;
        }
        
//        estado inactivo
       if(!flag){
        cordenadas[0]=y;
        cordenadas[1]=x;
        cordenadas[2]=-1;
        cordenadas[3]=-1;
        normalizarTablero(0);
        label = (JLabel) posiciones[y][x].getComponent(0);
        value = (label.getText()).split("-");
        posicion = Integer.parseInt(value[0]);
        tipo = value[2];
        setValueFicha(value);
        setPosicionFicha(posicion);
       }

       value = getValueFicha();
       posicion = getPosicionFicha();
       tipo = value[2];
       flag = value[1].equals("torre");
        if(flag){
            flag = tipo.equals("Blanco");
            if(flag) torresBlancas.get(posicion).movimiento(this);
            else{
                posicion = ((Torre.conteo)/2)-posicion;
                posicion *= posicion < 0 ? -1: 1;
                torresNegras.get(posicion).movimiento(this);
            }
        }
        flag = value[1].equals("peon");
        if(flag){
            flag = tipo.equals("Blanco");
            if(flag) peonesBlancos.get(posicion).movimiento(this);
            else{
                posicion -= 8;
                peonesNegros.get(posicion).movimiento(this);
            }
        }
        flag = value[1].equals("caballo");
        if(flag){
            flag = tipo.equals("Blanco");
            if(flag) caballosBlancos.get(posicion).movimiento(this);
            else{
                posicion -= Caballo.conteo;
                caballosNegros.get(posicion-2).movimiento(this);
            }
        }
        flag = value[1].equals("alfil");
        if(flag){
            flag = tipo.equals("Blanco");
            if(flag) alfilBlancos.get(posicion).movimiento(this);
            else {
                posicion -= Alfil.conteo;
                alfilNegros.get(posicion-2).movimiento(this);
            }
        }
        
    }//GEN-LAST:event_tableroMouseClicked

    public void actualizarPanel(int x, int y){
            posiciones[y][x].removeAll();
            posiciones[y][x].updateUI();
    }
    
    private int normalizarCordenada(int temp){
        boolean flag;
        int temp2 = 0;
        
        flag = temp >= 100; 
        
        /*Si la posicion es igual o mayor a 100 se corta y
        * se quitan los ultimo dos numeros para poder nivelar lo bien
        */
        
        if(flag){
            char[] value = (""+temp).toCharArray();
            temp2 = Integer.parseInt(""+value[1] + value[2]);
            temp2 = (temp2 > 50 )? temp2 - 50: temp2;
            flag = (temp2%50 !=0);
            
            if(flag) temp += (50 - temp2);
            return (temp / 50) - 1;
        }

        temp2 = (temp > 50 )? temp - 50: temp;
        flag = (temp2%50 !=0);
        if(flag) temp += (50 - temp2);
        return (temp / 50) - 1;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }
 
    // Mis variables
    public JPanel posiciones[][];
    public ArrayList <Peon> peonesBlancos, peonesNegros;
    public ArrayList <Torre> torresBlancas, torresNegras;
    public ArrayList <Caballo> caballosBlancos, caballosNegros;
    public ArrayList <Alfil> alfilBlancos, alfilNegros;
    public ArrayList <Reina> reinaBlanca, reinaNegra;
    public Rey reyBlanco, reyNegro;
    public int cordenadas[];
    private String estado;
    public String[] valueFicha;
    private int posicionFicha;
    public JPanel panelKillsUser1[], panelKillsUser2[];
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentTablero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JPanel panelusuario1;
    public javax.swing.JPanel panelusuario2;
    private javax.swing.JPanel tablero;
    // End of variables declaration//GEN-END:variables

    public String[] getValueFicha() {
        return valueFicha;
    }

    public void setValueFicha(String[] valueFicha) {
        this.valueFicha = valueFicha;
    }

    public int getPosicionFicha() {
        return posicionFicha;
    }

    public void setPosicionFicha(int posicionFicha) {
        this.posicionFicha = posicionFicha;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
