
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

public class Proveedores extends javax.swing.JFrame {

    Connection con = conexion(); //conexion con la BDD

    public Proveedores(String iCaptu, String iSeleccion, String iCheque) {
        initComponents();//inicializa los componentes, a partir de aqui se codifica
        conexion();
        totalSuma(iCaptu);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.GRAY);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);//Cierra la ventana 

        //el contructor recibe una variable y se puede compartir solamente con el mismo tipo de dato.
        mostrarProveedor(iCaptu);//Recarga la tabla con la informacion del nombre del proveedor seleccionado
        lblTitulo.setText(iCaptu);//coloca el nombre del proveedor seleccionado
        
    }

    private Proveedores() {//Metodo constructor sin parametros
    }

    public Connection conexion() { //realiza la conexion de la base de datos
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/automocion", "root", "root");
        } catch (SQLException ex) {
            System.out.println("Conexion fallida " + ex);
            JOptionPane.showMessageDialog(null, "Sin conexión a base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return con;

    }

    public void mostrarProveedor(String iCaptu) {//Llama los datos de la tabla proveedor para mostrarlos
        String[] columnas = {"Cheque", "Factura", "Fecha Registro", "Monto", "Abono", "Fecha Abono", "Total", "Estado", "Costo Proyecto", "Notas"};
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
                datos[9] = rs.getString("notas");

                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            System.out.println("Fallo query de proveedores = " + ex);
            JOptionPane.showMessageDialog(null, "No se encontró tabla " + iCaptu, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public double totalSuma(String iCaptu) {
        double value = 0.0;
        try {
            java.sql.PreparedStatement statement = con.prepareStatement("select sum(total) FROM " + iCaptu);
            ResultSet result = statement.executeQuery();
            result.next();
            String sum = result.getString(1);
            System.out.println(sum);
            value = Double.parseDouble(sum);
            lblTotal.setText(sum);

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return value;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTabla = new javax.swing.JTable();
        btnAgegar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();

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
        tTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tTabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnAgegar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnAgegar.setText("Agregar Nuevo Registro");
        btnAgegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgegarActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnBorrar.setText("Borrar Registro");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Busqueda");

        cmbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrar Todo", "PAGADO", "NO PAGADO" }));
        cmbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Total: ");

        lblTotal.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        btnEditar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnEditar.setText("Editar Registro");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(cmbox, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgegar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgegar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(btnBorrar)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(cmbox, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgegarActionPerformed

        AgregarRegistroProveedores registroProv = new AgregarRegistroProveedores(this, lblTitulo.getText());
        registroProv.setVisible(true);
    }//GEN-LAST:event_btnAgegarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
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
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tTablaMouseClicked

        int fila = tTabla.getSelectedRow(); //obtiene el numero de fila seleccionada

        //Se declaran las variables que guardan los datos
        String iCheque = (String) tTabla.getValueAt(fila, 0);
        String iFactura = (String) tTabla.getValueAt(fila, 1);
        String iFechaReg = (String) tTabla.getValueAt(fila, 2);
        String iMonto = (String) tTabla.getValueAt(fila, 3);
        String iAbono = (String) tTabla.getValueAt(fila, 4);
        String iFechaAbono = (String) tTabla.getValueAt(fila, 5);
        String iTotal = (String) tTabla.getValueAt(fila, 6);
        String iEstado = (String) tTabla.getValueAt(fila, 7);
        String iCostoPro = (String) tTabla.getValueAt(fila, 8);
        String iNotas = (String) tTabla.getValueAt(fila, 9);

        String iCaptu = lblTitulo.getText();//Guarda el nombre del proveedor para el registro
        EditarRegistroProveedores nvoReg = new EditarRegistroProveedores(iCaptu, this, iCheque, iFactura, iFechaReg, iMonto, iAbono, iFechaAbono, iTotal, iEstado, iCostoPro, iNotas);

        nvoReg.setVisible(true);//Abre ventana de nuevo registro
    }//GEN-LAST:event_tTablaMouseClicked

    private void cmboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboxActionPerformed
        String seleccion = (String) cmbox.getSelectedItem();
        System.out.println(seleccion);
        String iCaptu = lblTitulo.getText();//Guarda el nombre del proveedor para el registro

        if (seleccion == "PAGADO") {
            String[] columnas = {"cheque", "factura", "fechaReg", "monto", "abono", "fechaAbono", "total", "estado", "costoPro", "total"};
            DefaultTableModel modelo = new DefaultTableModel(null, columnas);
            tTabla.setModel(modelo);

            Statement st;
            ResultSet rs;

            String a = "SELECT * FROM " + "`" + iCaptu + "`" + "WHERE estado = 'PAGADO'";
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
                JOptionPane.showMessageDialog(null, "No se encontró tabla " + iCaptu, "ERROR", JOptionPane.ERROR_MESSAGE);

            }
        } else if (seleccion == "NO PAGADO") {
            String[] columnas = {"cheque", "factura", "fechaReg", "monto", "abono", "fechaAbono", "total", "estado", "costoPro", "total"};
            DefaultTableModel modelo = new DefaultTableModel(null, columnas);
            tTabla.setModel(modelo);

            Statement st;
            ResultSet rs;

            String a = "SELECT * FROM " + "`" + iCaptu + "`" + "WHERE estado = 'NO PAGADO'";
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
                JOptionPane.showMessageDialog(null, "No se encontró tabla " + iCaptu, "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } else if (seleccion.equals("Mostrar Todo")) {
            mostrarProveedor(iCaptu);
        }
    }//GEN-LAST:event_cmboxActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tTabla.getSelectedRow(); //obtiene el numero de fila seleccionada
        String iCheque = (String) tTabla.getValueAt(fila, 0); //Se declara la variable 

        int columna1 = 1;
        int columna2 = 2;
        int columna3 = 3;
        int columna4 = 4;
        int columna5 = 5;
        int columna6 = 6;
        int columna7 = 7;
        int columna8 = 8;
        int columna9 = 9;

        String iFactura = (String) tTabla.getValueAt(fila, columna1);
        String iFechaReg = (String) tTabla.getValueAt(fila, columna2);
        String iMonto = (String) tTabla.getValueAt(fila, columna3);
        String iAbono = (String) tTabla.getValueAt(fila, columna4);
        String iFechaAbono = (String) tTabla.getValueAt(fila, columna5);
        String iTotal = (String) tTabla.getValueAt(fila, columna6);
        String iEstado = (String) tTabla.getValueAt(fila, columna7);
        String iCostoPro = (String) tTabla.getValueAt(fila, columna8);
        String iNotas = (String) tTabla.getValueAt(fila, columna9);

        String iCaptu = lblTitulo.getText();//Guarda el nombre del proveedor para el registro
        EditarRegistroProveedores nvoReg = new EditarRegistroProveedores(iCaptu, this, iCheque, iFactura, iFechaReg, iMonto, iAbono, iFechaAbono, iTotal, iEstado, iCostoPro, iNotas);

        nvoReg.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgegar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox<String> cmbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tTabla;
    // End of variables declaration//GEN-END:variables
}
