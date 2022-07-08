
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Proveedores extends javax.swing.JFrame {

    Connection con = conexion(); //conexion con la BDD
    datosFacturas dFacturas = new datosFacturas();

    public Proveedores(String iCaptu) {
        initComponents();
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.GRAY);

        //el contructor recibe una variable y se puede compartir solamente con el mismo tipo de dato.
        mostrarProveedor(iCaptu);
        lblTitulo.setText(iCaptu);

    }

    private Proveedores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public void mostrarProveedor(String iCaptu) {
        String[] columnas = {"cheque", "factura", "fechaReg", "monto", "abono", "fechaAbono", "total", "estado", "costoPro", "total"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        tTabla.setModel(modelo);

        Statement st;
        ResultSet rs;

        String a = "SELECT * FROM " + "`" + iCaptu + "`";
        System.out.println(a);

        try {
            st = con.createStatement();
            rs = st.executeQuery(a);

            while (rs.next()) {
                String[] datos = new String[10];
                datos[0] = rs.getString("cheque");
                datos[1] = rs.getString("factura");
                datos[2] = rs.getString("fechaReg");
                datos[3] = rs.getString("monto");
                datos[4] = rs.getString("abono");
                datos[5] = rs.getString("fechaAbono");
                datos[6] = rs.getString("total");
                datos[7] = rs.getString("estado");
                datos[8] = rs.getString("costoPro");
                datos[9] = rs.getString("total");

                modelo.addRow(datos);

            }

        } catch (SQLException ex) {
            System.out.println("Fallo query de proveedores = " + ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTabla = new javax.swing.JTable();
        btnSelecion = new javax.swing.JButton();
        btnAgegar = new javax.swing.JButton();
        btnSelecion1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        lblTitulo.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Proveedor");

        tTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tTabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSelecion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSelecion.setText("Editar Seleccion");
        btnSelecion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionActionPerformed(evt);
            }
        });

        btnAgegar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnAgegar.setText("Agregar Nuevo Registro");
        btnAgegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgegarActionPerformed(evt);
            }
        });

        btnSelecion1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSelecion1.setText("Borrar Registro");
        btnSelecion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecion1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnSelecion, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnSelecion1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                        .addComponent(btnAgegar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgegar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSelecion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSelecion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgegarActionPerformed

        AgregarRegistroProveedores registroProv = new AgregarRegistroProveedores(lblTitulo.getText());
        registroProv.setVisible(true);

    }//GEN-LAST:event_btnAgegarActionPerformed

    private void btnSelecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSelecionActionPerformed

    private void btnSelecion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecion1ActionPerformed
        //Obtener informacion de la seleccion
        int fila = tTabla.getSelectedRow(); //obtiene el numero de fila seleccionada
        int columna = 0;
        String iSelecion = (String) tTabla.getValueAt(fila, columna); //Se declara la variable 
        try {
            Statement st = con.createStatement();
            String query = "DELETE FROM " + "`" + lblTitulo.getText() + "`" + " WHERE cheque = '" + iSelecion + "'";
            System.out.println(query);
            st.execute(query);

        } catch (SQLException ex) {
            Logger.getLogger(NuevoProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        mostrarProveedor(lblTitulo.getText()); //Actualiza tabla
    }//GEN-LAST:event_btnSelecion1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgegar;
    private javax.swing.JButton btnSelecion;
    private javax.swing.JButton btnSelecion1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tTabla;
    // End of variables declaration//GEN-END:variables
}
