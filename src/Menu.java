
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Menu extends javax.swing.JFrame {

    Connection con = conexion(); //conexion con la BDD

    public Menu() {
        initComponents();
        conexion(); //Crea la conexion 
        mostrarDatos();//Actualiza la tabla de datos
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
            JOptionPane.showMessageDialog(null, "Sin conexión a base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }

    public void mostrarDatos() {//Muestra la tabla
        String[] columnas = {"nombreCorp", "estado", "calle", "colonia", "cp", "rfc", "curp", "telefono", "celular", "notas"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        tMenu.setModel(modelo);

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM proveedores");

            while (rs.next()) {
                String[] datos = new String[10];
                datos[0] = rs.getString("nombreCorp");
                datos[1] = rs.getString("estado");
                datos[2] = rs.getString("calle");
                datos[3] = rs.getString("colonia");
                datos[4] = rs.getString("cp");
                datos[5] = rs.getString("rfc");
                datos[6] = rs.getString("curp");
                datos[7] = rs.getString("telefono");
                datos[8] = rs.getString("celular");
                datos[9] = rs.getString("notas");

                modelo.addRow(datos);

            }

        } catch (SQLException ex) {
            System.out.println("Fallo query Menu = " + ex);
            JOptionPane.showMessageDialog(null, "No se encontraron proveedores", "ERROR", JOptionPane.ERROR_MESSAGE);
        };

    }

    public void borrarTablas(String iCaptu) {

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
        btnNuevo = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Proveedores Registrados");

        tMenu.setAutoCreateRowSorter(true);
        tMenu.setBackground(new java.awt.Color(204, 204, 204));
        tMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tMenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tMenu);

        btnSelecionar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSelecionar.setText("Seleccionar Proveedor");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnNuevo.setText("Agregar Nuevo Proveedor");
        btnNuevo.setActionCommand("");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnBorrar.setText("Borrar Proveedor");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 484, Short.MAX_VALUE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionar)
                    .addComponent(btnBorrar)
                    .addComponent(btnNuevo))
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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        NuevoProveedor nProveedor = new NuevoProveedor(this);
        nProveedor.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed

        //Obtener informacion de la seleccion
        int fila = tMenu.getSelectedRow(); //obtiene el numero de fila seleccionada
        int columna = 0;
        String iCaptu = (String) tMenu.getValueAt(fila, columna); //Se declara la variable 

        //intancia para mostrar ventana de proveedores
        Proveedores vProveedores = new Proveedores(iCaptu, "", "");
        vProveedores.setVisible(true);
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        //JOptionPane.showMessageDialog(null, "Se borrarán todos los datos del proveedor", "¿Está seguro?", JOptionPane.YES_NO_OPTION);
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el proveedor? ", "Alerta!", JOptionPane.YES_NO_OPTION);

        if (resp == 0) {//Borra la tabla
            //Obtener informacion de la seleccion
            int fila = tMenu.getSelectedRow(); //obtiene el numero de fila seleccionada
            int columna = 0; //obtiene el nombre
            String iCaptu = (String) tMenu.getValueAt(fila, columna); //Se declara la variable        
            borrarTablas(iCaptu); //borra las tablas y el registro en proveedores de acuerdo con el nombre
            System.out.println("SI");

        } else if (resp == 1) {//No hacer nada en caso de elegir NO          
        }

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMenuMouseClicked
    
         //Obtener informacion de la seleccion
        int fila = tMenu.getSelectedRow(); //obtiene el numero de fila seleccionada
        int columna = 0;
        String iAchu = (String) tMenu.getValueAt(fila, columna); //Se declara la variable 
        
         //intancia para mostrar ventana de proveedores
        Proveedores vProveedores = new Proveedores(iAchu, "", "");
        vProveedores.setVisible(true);

        
        JOptionPane.showMessageDialog(null, iAchu, "ERROR", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_tMenuMouseClicked

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
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tMenu;
    // End of variables declaration//GEN-END:variables
}
