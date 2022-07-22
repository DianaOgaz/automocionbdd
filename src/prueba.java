
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class prueba {
    Connection con = conexion();

    
    
    
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
    
    
    
}//fin
