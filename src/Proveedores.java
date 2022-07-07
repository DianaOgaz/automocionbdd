
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class Proveedores extends javax.swing.JFrame {

    datosFacturas dFacturas = new datosFacturas();
    seleccion seleccion = new seleccion();
    
    
    
    public Proveedores(String iCaptu) {
        initComponents();
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.GRAY);
        
        //lblTitulo.setText(seleccion.getiCaptu());
        System.out.println(seleccion.getiCaptu()); //este siempre aparece en NULL
        
       //TODO: hacer jalar el boton de seleccionar y lograrcambiar el titulo del proveedor
       
        
        
        
    }

    private Proveedores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

     public Connection conexion() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/automocion", "root", "root");
            System.out.println("Conexion lograda");
        } catch (SQLException ex) {
            System.out.println("Conexion fallida " + ex);
        }
        return con;

    }
    
    public void mostrarDatosProveedor() {
        String[] columnas = {"Cantidad", "Tipo Hamburgesa", "Refresco", "Nombre", "Fecha", "Cantidad"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        tTabla.setModel(modelo);

        Connection con = conexion();

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM compras");

            while (rs.next()) {
                String[] datos = new String[6];
                datos[0] = rs.getString("cantidad");
                datos[1] = rs.getString("tipoh");
                datos[2] = rs.getString("ref");
                datos[3] = rs.getString("nombc");
                datos[4] = rs.getString("fecha");
                datos[5] = rs.getString("total");
                modelo.addRow(datos);

            }

        } catch (SQLException ex) {
            System.out.println("" + ex);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnSelecion, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgegar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecion)
                    .addComponent(btnAgegar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgegarActionPerformed
        AgregarRegistroProveedores registroProv = new AgregarRegistroProveedores();
        registroProv.setVisible(true);

    }//GEN-LAST:event_btnAgegarActionPerformed

    private void btnSelecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSelecionActionPerformed

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tTabla;
    // End of variables declaration//GEN-END:variables
}
