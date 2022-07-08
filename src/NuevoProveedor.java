
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class NuevoProveedor extends javax.swing.JFrame {
    datosProveedores datosP = new datosProveedores(); //Guardar datos
    Menu menu = new Menu();
    Connection con = conexion();
    
    public NuevoProveedor() {
        initComponents();
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.GRAY);
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
        public void actualizarDatos() { //Es la misma de mostrarDatos de ventana Menu 
        String[] columnas = {"nombreCorp", "estado", "calle", "colonia", "cp", "rfc", "curp", "telefono", "celular", "notas"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);       
        //tMenu.setModel(modelo);

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
            System.out.println("actualizarDatos.NuevoProveedor = " + ex);
        }

    }
    public void crearTabla(){
        String nombre = txtNombre.getText();
        try {
            Statement st = con.createStatement();
            String query = "CREATE TABLE " + "`" + nombre + "`" + "(`" 
                    + "nombreCorp" + "`" + "VARCHAR(45) NULL,"  //Llave primaria
                    + "`" + "estado" + "`" + "VARCHAR(45) NULL," 
                    + "`" + "calle" + "`" + "VARCHAR(45) NULL," 
                    + "`" + "colonia" + "`" + "VARCHAR(45) NULL," 
                    + "`" + "cp" + "`" + "VARCHAR(45) NULL," 
                    + "`" + "rfc" + "`" + "VARCHAR(45) NULL," 
                    + "`" + "curp" + "`" + "VARCHAR(45) NULL," 
                    + "`" + "telefono" + "`" + "VARCHAR(45) NULL," 
                    + "`" + "celular" + "`" + "VARCHAR(45) NULL,"
                    + "`" + "notas" + "`" + "VARCHAR(45) NULL)" ;
            st.execute(query);
            System.out.println(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(NuevoProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void insertarTabla(String cp,String curp){
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtColonia = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotas = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCURP = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCP = new javax.swing.JTextField();
        txtCalle = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setText("C.P.");
        jLabel5.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setText("Celular");
        jLabel6.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setText("Estado");
        jLabel7.setToolTipText("");

        txtNotas.setColumns(20);
        txtNotas.setRows(5);
        jScrollPane1.setViewportView(txtNotas);

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel8.setText("R.F.C.");
        jLabel8.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel9.setText("Telefono");
        jLabel9.setToolTipText("");

        btnCrear.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel10.setText("C.U.R.P.");
        jLabel10.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel11.setText("Calle");
        jLabel11.setToolTipText("");

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel12.setText("Colonia");
        jLabel12.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Nuevo Proveedor ");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("Nombre");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setText("Notas");
        jLabel4.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtColonia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCalle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRFC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCURP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCelular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtEstado))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtCalle, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
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

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        
        String cp = txtCP.getText();
        String curp = txtCURP.getText();
        String calle = txtCalle.getText();
        String celular = txtCelular.getText();
        String colonia = txtColonia.getText();
        String estado = txtEstado.getText();
        String nombreCorp = txtNombre.getText();
        String notas = txtNotas.getText();
        String rfc = txtRFC.getText();
        String telefono = txtTelefono.getText();
       
        try {
            Statement st = con.createStatement();
            String query = "INSERT INTO proveedores (nombreCorp,estado,calle,colonia,cp,rfc,curp,telefono,celular,notas) VALUES (\"" + nombreCorp + "\",\"" + estado + "\",\"" + calle + "\",\"" + colonia + "\",\"" + cp + "\",\"" + rfc +  "\", \"" + curp + "\",\"" + telefono + "\",\"" + celular + "\",\"" + notas + "\")";
            st.execute(query);
            crearTabla();
            
        } catch (SQLException ex) {
            Logger.getLogger(NuevoProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = con.createStatement();
            String query = "INSERT INTO " + "`" + txtNombre.getText() + "`" + "(nombreCorp,estado,calle,colonia,cp,rfc,curp,telefono,celular,notas) VALUES (\"" + nombreCorp + "\",\"" + estado + "\",\"" + calle + "\",\"" + colonia + "\",\"" + cp + "\",\"" + rfc +  "\", \"" + curp + "\",\"" + telefono + "\",\"" + celular + "\",\"" + notas + "\")";
            st.execute(query);           
            
        } catch (SQLException ex) {
            Logger.getLogger(NuevoProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Menu menu = new Menu();//actualiza la tabla al momento
       
    }//GEN-LAST:event_btnCrearActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCP;
    private javax.swing.JTextField txtCURP;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtNotas;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
