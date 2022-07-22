
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class pruebaj extends javax.swing.JFrame {

    Connection con = conexion();

    public pruebaj() {
        initComponents();
        conexion(); //Crea la conexion 
        mostrarDatos();//Actualiza la tabla de datos
        data();
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

    public double data() { //Método para sumar los totales de la tabla proveedores, agregar iCaptu 
        double value = 0.0;
        try {
           PreparedStatement statement = con.prepareStatement("select sum(total) FROM proveedores "); //se crea el query que suma los totales
            ResultSet result = statement.executeQuery();
            result.next();
            String sum = result.getString(1);
            System.out.println(sum);
            value = Double.parseDouble(sum);

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return value;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tMenu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tMenu.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(pruebaj.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pruebaj.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pruebaj.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pruebaj.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pruebaj().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tMenu;
    // End of variables declaration//GEN-END:variables
}
