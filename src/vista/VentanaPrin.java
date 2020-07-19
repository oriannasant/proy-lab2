package vista;


public class VentanaPrin extends javax.swing.JFrame {

   //Usuario mod;
    
    public VentanaPrin() {
        initComponents();
         setVisible(true);
        setLocationRelativeTo(null);
    }
       public void addEvents(java.awt.event.ActionListener evt)
    {
    btnEntradas.addActionListener(evt);
    btnGolosinas.addActionListener(evt);
    btnMenuReportes.addActionListener(evt);
    btnConfiguracion.addActionListener(evt);
    btnCerrarSesion.addActionListener(evt);
   }
     /*public VentanaPrin(Usuario mod) {
        initComponents();
        this.mod =mod;
        //si no hacemos un switch
        if (mod.getId_tipoRol() ==1)
        {
        }
        if (mod.getId_tipoRol() ==2)
        {
            btnEntradas.setVisible(false);
        }
        if (mod.getId_tipoRol()== 3)
        {
            btnGolosinas.setVisible(false);
        }
    }*/
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSPanelGradiente1 = new rojeru_san.rspanel.RSPanelGradiente();
        rSButtonIconUno1 = new RSMaterialComponent.RSButtonIconUno();
        jLabel1 = new javax.swing.JLabel();
        btnGolosinas = new rojeru_san.rsbutton.RSButtonForma();
        btnMenuReportes = new rojeru_san.rsbutton.RSButtonForma();
        btnEntradas = new rojeru_san.rsbutton.RSButtonForma();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        btnCerrarSesion = new rojeru_san.rsbutton.RSButtonForma();
        btnConfiguracion = new rojeru_san.rsbutton.RSButtonForma();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(131, 202, 205));

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(131, 202, 205));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(15, 158, 168));

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 164, Short.MAX_VALUE)
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        rSButtonIconUno1.setBackground(new java.awt.Color(131, 202, 205));
        rSButtonIconUno1.setBackgroundHover(new java.awt.Color(131, 202, 205));
        rSButtonIconUno1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);

        jLabel1.setBackground(new java.awt.Color(131, 202, 205));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido");

        btnGolosinas.setBackground(new java.awt.Color(15, 158, 168));
        btnGolosinas.setText("Venta de Golosinas");
        btnGolosinas.setColorHover(new java.awt.Color(97, 180, 184));
        btnGolosinas.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        btnGolosinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGolosinasActionPerformed(evt);
            }
        });

        btnMenuReportes.setBackground(new java.awt.Color(15, 158, 168));
        btnMenuReportes.setText("Menú de Reportes");
        btnMenuReportes.setColorHover(new java.awt.Color(97, 180, 184));
        btnMenuReportes.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        btnMenuReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuReportesActionPerformed(evt);
            }
        });

        btnEntradas.setBackground(new java.awt.Color(15, 158, 168));
        btnEntradas.setText("Venta de Entradas");
        btnEntradas.setColorHover(new java.awt.Color(97, 180, 184));
        btnEntradas.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(131, 202, 205));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Menú de Opciones");

        btnCerrarSesion.setBackground(new java.awt.Color(15, 158, 168));
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setColorHover(new java.awt.Color(97, 180, 184));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnConfiguracion.setBackground(new java.awt.Color(15, 158, 168));
        btnConfiguracion.setText("Configuración");
        btnConfiguracion.setColorHover(new java.awt.Color(97, 180, 184));
        btnConfiguracion.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGolosinas, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMenuReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(jLabel2)))
                        .addGap(0, 155, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSButtonIconUno1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rSButtonIconUno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addComponent(btnGolosinas, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMenuReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGolosinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGolosinasActionPerformed
    
    }//GEN-LAST:event_btnGolosinasActionPerformed

    private void btnMenuReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuReportesActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public rojeru_san.rsbutton.RSButtonForma btnCerrarSesion;
    public rojeru_san.rsbutton.RSButtonForma btnConfiguracion;
    public rojeru_san.rsbutton.RSButtonForma btnEntradas;
    public rojeru_san.rsbutton.RSButtonForma btnGolosinas;
    public rojeru_san.rsbutton.RSButtonForma btnMenuReportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private RSMaterialComponent.RSButtonIconUno rSButtonIconUno1;
    private rojeru_san.rspanel.RSPanelGradiente rSPanelGradiente1;
    // End of variables declaration//GEN-END:variables
}
