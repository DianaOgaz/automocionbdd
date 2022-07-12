
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Menu extends javax.swing.JFrame {

    Connection con = conexion(); //conexion con la BDD
    datosProveedores datosProv = new datosProveedores();

    public Menu() {
        initComponents();
        conexion();
        mostrarDatos();
        this.setVisible(true);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.GRAY);
    }

    public Connection conexion() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/automocion", "root", "root");
        } catch (SQLException ex) {
            System.out.println("Conexion fallida " + ex);
        }
        return con;
    }

    public void mostrarDatos() {
        String[] columnas = {"id" + "nombreCorp", "estado", "calle", "colonia", "cp", "rfc", "curp", "telefono", "celular", "notas"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        tMenu.setModel(modelo);

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM proveedores");

            while (rs.next()) {
                String[] datos = new String[11];
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("nombreCorp");
                datos[2] = rs.getString("estado");
                datos[3] = rs.getString("calle");
                datos[4] = rs.getString("colonia");
                datos[5] = rs.getString("cp");
                datos[6] = rs.getString("rfc");
                datos[7] = rs.getString("curp");
                datos[8] = rs.getString("telefono");
                datos[9] = rs.getString("celular");
                datos[10] = rs.getString("notas");

                modelo.addRow(datos);

            }

        } catch (SQLException ex) {
            System.out.println("Fallo query Menu = " + ex);
        }

    }
    
    public void borrarTablas(String iCaptu){
        try {
            Statement st = con.createStatement();
            String query = "DELETE FROM proveedores WHERE nombreCorp = '" + iCaptu + "'";
            System.out.println(query);
            st.execute(query);

        } catch (SQLException ex) {
            Logger.getLogger(NuevoProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = con.createStatement();
            String query = "DROP TABLE `" + iCaptu + "`";
            System.out.println(query);
            st.execute(query);

        } catch (SQLException ex) {
            Logger.getLogger(NuevoProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        mostrarDatos(); //Actualiza la tabla 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tMenu = new javax.swing.JTable();
        btnSelecionar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnSelecionar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Proveedores Registrados");

        tMenu.setAutoCreateRowSorter(true);
        tMenu.setBackground(new java.awt.Color(204, 204, 204));
        tMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tMenu);

        btnSelecionar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSelecionar.setText("Seleccionar Proveedor");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar Nuevo Proveedor");
        btnAgregar.setActionCommand("");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnSelecionar1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSelecionar1.setText("Borrar Proveedor");
        btnSelecionar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnSelecionar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSelecionar)
                            .addComponent(btnSelecionar1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnAgregar)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
      
        NuevoProveedor nProveedor = new NuevoProveedor(this);
        nProveedor.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed

        //Obtener informacion de la seleccion
        int fila = tMenu.getSelectedRow(); //obtiene el numero de fila seleccionada
        int columna = 1;
        String iCaptu = (String) tMenu.getValueAt(fila, columna); //Se declara la variable 
        int id = 0;

        //intancia para mostrar ventana de proveedores
        Proveedores vProveedores = new Proveedores(iCaptu,id);
        vProveedores.setVisible(true);
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnSelecionar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionar1ActionPerformed
        //Obtener informacion de la seleccion
        int fila = tMenu.getSelectedRow(); //obtiene el numero de fila seleccionada
        int columna = 1;
        String iCaptu = (String) tMenu.getValueAt(fila, columna); //Se declara la variable 
       
        borrarTablas(iCaptu);

    }//GEN-LAST:event_btnSelecionar1ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JButton btnSelecionar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tMenu;
    // End of variables declaration//GEN-END:variables
}
