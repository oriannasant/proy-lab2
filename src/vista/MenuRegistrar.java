package vista;

public class MenuRegistrar extends javax.swing.JFrame {

 
    
    public MenuRegistrar() {
        initComponents();
      setVisible(true);
        setLocationRelativeTo(null);
    }
 public void addEvents(java.awt.event.ActionListener evt)
    {
    btnRegistrarUsuario.addActionListener(evt);
    btnRegistrarEmpl.addActionListener(evt);
    btnRegistrarPeli.addActionListener(evt);
    btnCerrarSesion.addActionListener(evt);
    btnAtras.addActionListener(evt);
    btnRegistrarSucursal.addActionListener(evt);
    btnRegistrarFuncion.addActionListener(evt);
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSPanelGradiente1 = new rojeru_san.rspanel.RSPanelGradiente();
        rSButtonIconUno1 = new RSMaterialComponent.RSButtonIconUno();
        btnRegistrarEmpl = new rojeru_san.rsbutton.RSButtonForma();
        btnRegistrarUsuario = new rojeru_san.rsbutton.RSButtonForma();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        btnCerrarSesion = new rojeru_san.rsbutton.RSButtonForma();
        btnRegistrarPeli = new rojeru_san.rsbutton.RSButtonForma();
        btnAtras = new RSMaterialComponent.RSButtonIconUno();
        btnRegistrarSucursal = new rojeru_san.rsbutton.RSButtonForma();
        btnRegistrarFuncion = new rojeru_san.rsbutton.RSButtonForma();
        lblidemp = new javax.swing.JLabel();

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

        btnRegistrarEmpl.setBackground(new java.awt.Color(15, 158, 168));
        btnRegistrarEmpl.setText("Registrar Empleado");
        btnRegistrarEmpl.setColorHover(new java.awt.Color(97, 180, 184));
        btnRegistrarEmpl.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        btnRegistrarEmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEmplActionPerformed(evt);
            }
        });

        btnRegistrarUsuario.setBackground(new java.awt.Color(15, 158, 168));
        btnRegistrarUsuario.setText("Registrar Usuario");
        btnRegistrarUsuario.setColorHover(new java.awt.Color(97, 180, 184));
        btnRegistrarUsuario.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(131, 202, 205));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Menú de Opciones");

        btnCerrarSesion.setBackground(new java.awt.Color(15, 158, 168));
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setColorHover(new java.awt.Color(97, 180, 184));

        btnRegistrarPeli.setBackground(new java.awt.Color(15, 158, 168));
        btnRegistrarPeli.setText("Registrar Películas");
        btnRegistrarPeli.setColorHover(new java.awt.Color(97, 180, 184));
        btnRegistrarPeli.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N

        btnAtras.setBackground(new java.awt.Color(131, 202, 205));
        btnAtras.setBackgroundHover(new java.awt.Color(131, 202, 205));
        btnAtras.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ARROW_BACK);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnRegistrarSucursal.setBackground(new java.awt.Color(15, 158, 168));
        btnRegistrarSucursal.setText("Registrar Sucursal");
        btnRegistrarSucursal.setColorHover(new java.awt.Color(97, 180, 184));
        btnRegistrarSucursal.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        btnRegistrarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarSucursalActionPerformed(evt);
            }
        });

        btnRegistrarFuncion.setBackground(new java.awt.Color(15, 158, 168));
        btnRegistrarFuncion.setText("Registrar Función");
        btnRegistrarFuncion.setColorHover(new java.awt.Color(97, 180, 184));
        btnRegistrarFuncion.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N

        lblidemp.setBackground(new java.awt.Color(131, 202, 205));
        lblidemp.setForeground(new java.awt.Color(131, 202, 205));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(178, 178, 178)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnRegistrarPeli, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnRegistrarFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnRegistrarEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnRegistrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(140, 140, 140)
                                        .addComponent(btnRegistrarSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(lblidemp, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSButtonIconUno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSButtonIconUno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarPeli, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(lblidemp, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void btnRegistrarEmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEmplActionPerformed
    /*GenerarVenta ven= new GenerarVenta();        
    ven.setVisible(true);
    this.dispose();*/
    }//GEN-LAST:event_btnRegistrarEmplActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnRegistrarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarSucursalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public RSMaterialComponent.RSButtonIconUno btnAtras;
    public rojeru_san.rsbutton.RSButtonForma btnCerrarSesion;
    public rojeru_san.rsbutton.RSButtonForma btnRegistrarEmpl;
    public rojeru_san.rsbutton.RSButtonForma btnRegistrarFuncion;
    public rojeru_san.rsbutton.RSButtonForma btnRegistrarPeli;
    public rojeru_san.rsbutton.RSButtonForma btnRegistrarSucursal;
    public rojeru_san.rsbutton.RSButtonForma btnRegistrarUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel lblidemp;
    private RSMaterialComponent.RSButtonIconUno rSButtonIconUno1;
    private rojeru_san.rspanel.RSPanelGradiente rSPanelGradiente1;
    // End of variables declaration//GEN-END:variables
}
