
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
        String[] columnas = {"Nombre", "Edtado", "Calle", "Colonia", "C.P.", "R.F.C.", "C.U.R.P", "Telefonoo", "Celular", "Correo", "Total", "Notas"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        tMenu.setModel(modelo);

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM proveedores");
  
            while (rs.next()) {
                String[] datos = new String[12];
                datos[0] = rs.getString("nombreCorp");
                datos[1] = rs.getString("estado");
                datos[2] = rs.getString("calle");
                datos[3] = rs.getString("colonia");
                datos[4] = rs.getString("cp");
                datos[5] = rs.getString("rfc");
                datos[6] = rs.getString("curp");
                datos[7] = rs.getString("telefono");
                datos[8] = rs.getString("celular");
                datos[9] = rs.getString("correo");
                datos[10] = rs.getString("total");
                datos[11] = rs.getString("notas");

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
        btnNuevo = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnNuevo1 = new javax.swing.JButton();

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

        btnNuevo1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnNuevo1.setText("Editar Proveedor");
        btnNuevo1.setActionCommand("");
        btnNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar)
                    .addComponent(btnNuevo1))
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

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        //JOptionPane.showMessageDialog(null, "Se borrarán todos los datos del proveedor", "¿Está seguro?", JOptionPane.YES_NO_OPTION);
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el proveedor? ", "Alerta!", JOptionPane.YES_NO_OPTION);

        if (resp == 0) {//Borra la tabla
            //Obtener informacion de la seleccion
            int fila = tMenu.getSelectedRow(); //obtiene el numero de fila seleccionada
            int columna = 0; //obtiene el nombre
            String iCaptu = (String) tMenu.getValueAt(fila, columna); //Se declara la variable        
            borrarTablas(iCaptu); //borra las tablas y el registro en proveedores de acuerdo con el nombre

        } else if (resp == 1) {//No hacer nada en caso de elegir NO          
        }

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMenuMouseClicked
        //Obtener informacion de la seleccion
        int fila = tMenu.getSelectedRow(); //obtiene el numero de fila seleccionada
        int columna = 0;
        String iCaptu = (String) tMenu.getValueAt(fila, columna); //Se declara la variable 

        //intancia para mostrar ventana de proveedores
        Proveedores vProveedores = new Proveedores(iCaptu, "", "");
        vProveedores.setVisible(true);
    }//GEN-LAST:event_tMenuMouseClicked

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        int fila = tMenu.getSelectedRow(); //obtiene el numero de fila seleccionada

        String iNombre = (String) tMenu.getValueAt(fila, 0);
        String iEstado = (String) tMenu.getValueAt(fila, 1);
        String iCalle = (String) tMenu.getValueAt(fila, 2);
        String iColonia = (String) tMenu.getValueAt(fila, 3);
        String iCP = (String) tMenu.getValueAt(fila, 4);
        String iRFC = (String) tMenu.getValueAt(fila, 5);
        String iCURP = (String) tMenu.getValueAt(fila, 6);
        String iTelefono = (String) tMenu.getValueAt(fila, 7);
        String iCelular = (String) tMenu.getValueAt(fila, 8);
        String iCorreo = (String) tMenu.getValueAt(fila, 9);
        String iNotas = (String) tMenu.getValueAt(fila, 10);

        String iNomProv = (String) tMenu.getValueAt(fila, 0);//Guarda el nombre del proveedor para la ventana EditarProv

        EditarProveedor editProv = new EditarProveedor(this, iNomProv, iNombre, iEstado, iCalle, iColonia, iCP, iRFC, iCURP, iTelefono, iCelular, iCorreo, iNotas);
        editProv.setVisible(true);
    }//GEN-LAST:event_btnNuevo1ActionPerformed

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
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tMenu;
    // End of variables declaration//GEN-END:variables
}
