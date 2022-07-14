
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class prueba {

    public static void main(String[] args) {
        int id = 0;
        int contador = 0;
        while (contador < 10) {
            System.out.println("Imprimo la linea: " + contador);
            contador++;
        }
        while (id >= 0) {
            System.out.println(id);
                id++;
            }
    }

}  //

