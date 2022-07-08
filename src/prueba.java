
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class prueba {

    public static void main(String[] args) {
            
            String variable = "a";
            
            String query = "CREATE TABLE `automocion`." + "`" + variable + "`" + "(`" 
                    + variable + "`" + "VARCHAR(45) NOT NULL,"
                    + "`" + variable + "`" + "VARCHAR(45) NULL," 
                    + "`" + variable + "`" + "VARCHAR(45) NULL," 
                    + "`" + variable + "`" + "VARCHAR(45) NULL," 
                    + "`" + variable + "`" + "VARCHAR(45) NULL," 
                    + "`" + variable + "`" + "VARCHAR(45) NULL," 
                    + "`" + variable + "`" + "VARCHAR(45) NULL," 
                    + "`" + variable + "`" + "VARCHAR(45) NULL," 
                    + "`" + variable + "`" + "VARCHAR(45) NULL," 
                    + "`" + variable + "`" + "VARCHAR(45) NULL," 
                    + "`" + variable + "`" + "VARCHAR(45) NULL)" ;
            System.out.println(query);
    }

}  //

