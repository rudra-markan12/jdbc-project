import java.sql.Statement;
import java.util.Scanner;
import java.rmi.ConnectIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cllage", "root", "rudra@123456");

        Statement st = con.createStatement();
        Scanner src = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1) INSERT ");
            System.out.println("2) UPDATE ");
            System.out.println("3) DELETE ");
            System.out.println("4) SELECT ");
            System.out.println("5)  EXIT  ");

            int n = src.nextInt();

            if (n == 1) {
             System.out.println("Enter id");
             int id = src.nextInt();

             System.out.println("Enter name");
             String name = src.next();

             System.out.println("Enter age");
             int age = src.nextInt();

             int rowInsert = st.executeUpdate("INSERT INTO facalty(id , name  , age) VALUES(" + id + " , '" +name+ "' , " + age + ")");

             if (rowInsert > 0) {
                System.out.println("row update successfully");
             }
             else{
                System.out.println("row didn't update succesfully");
             }
            }
            else if (n == 2) {
                System.out.println("You want to update the row");

                    int m = src.nextInt();
                    if (m == 1) {
                        System.out.println("Select coloumn");

                        String coloumn = src.next();
        
        
                        System.out.println("Enter the name");
        
                        String newColoumn = src.next();
        
                        System.out.println("Enter id");
                        int id = src.nextInt();

                        int update_query = st.executeUpdate("UPDATE facalty SET "+coloumn+" = '"+newColoumn+"' WHERE "+id);
                    }
                    else if(m == 2){
                        System.out.println("Select coloumn");

                        int age = src.nextInt();
        
        
                        System.out.println("Enter the name");
        
                        String newAge = src.next();
        
                        System.out.println("Enter id");
                        int id = src.nextInt();
                        int update_query = st.executeUpdate("UPDATE facalty SET "+age+" = "+newAge+" WHERE "+id);
                    }
            }
            else if ( n == 3) {
                
                System.out.println("SELECT THE ROW which  you wanted to delet");

                int id = src.nextInt();

                int delete_query = st.executeUpdate("DELETE FROM facalty WHERE  id " + id);
            }
            else if (n == 4) {
                ResultSet rs = st.executeQuery("SELECT * FROM facalty");

                while (rs.next()) {
                    System.out.print(rs.getString(1));
                    System.out.print(" , "  + rs.getString(2));
                    System.out.print(" , "+ rs.getString(3));
                    System.out.println();
                }
                
            }
            
            else if (n == 5) {
                flag = false;
            }
            else{
                System.out.println("Unvalid property ");
            }
          
        }
        con.close();
        src.close();
    }
}