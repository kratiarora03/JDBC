import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class question_15 {
    public static void main(String[] args) {


        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating a connection
            String url = "jdbc:mysql://localhost:3306/krati";
            String username = "root";
            String password = "Abktanvi03";
            Connection con = DriverManager.getConnection(url, username, password);


            // create a statement
            String q = " insert into table3(id ,title, author , price, quantity) values(?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
                                                  //INSERT IN TABLE
            pstmt.setInt(1,1001);
            pstmt.setString(2,"Java for dummies");
            pstmt.setString(3,"Tan Ah Teck");
            pstmt.setFloat(4, (float) 11.11);
            pstmt.setInt(5,11);

            pstmt.executeUpdate();


            PreparedStatement pstmt1 = con.prepareStatement(q);
            pstmt1.setInt(1,1002);
            pstmt1.setString(2,"More Java for Dummies");
            pstmt1.setString(3,"Tan Ah Teck");
            pstmt1.setFloat(4, (float) 22.22);
            pstmt1.setInt(5,22);

            pstmt1.executeUpdate();

            PreparedStatement pstmt2 = con.prepareStatement(q);
            pstmt2.setInt(1,1003);
            pstmt2.setString(2,"More java for dummies");
            pstmt2.setString(3,"Mohammad Ali");
            pstmt2.setFloat(4, (float) 33.33);
            pstmt2.setInt(5,33);

            pstmt2.executeUpdate();

            PreparedStatement pstmt3 = con.prepareStatement(q);
            pstmt3.setInt(1,1004);
            pstmt3.setString(2,"A cup of java ");
            pstmt3.setString(3,"Kumar");
            pstmt3.setFloat(4, (float) 44.44);
            pstmt3.setInt(5,44);

            pstmt3.executeUpdate();

            PreparedStatement pstmt4 = con.prepareStatement(q);
            pstmt4.setInt(1,1005);
            pstmt4.setString(2,"A Teaspoon of java ");
            pstmt4.setString(3,"Kevin Jones ");
            pstmt4.setFloat(4, (float) 55.55);
            pstmt4.setInt(5,55);

            pstmt4.executeUpdate();
                                                     //READ TABLE
            String query3 = "SELECT * from table3";

            ResultSet res = pstmt.executeQuery(query3);

            while (res.next()) {
                int id = res.getInt("id");
                String title = res.getString("title");
                String author = res.getString("author");
                float price = res.getFloat("price");
                int qty = res.getInt("quantity");

                System.out.println("Id: " + id + " Name: " + title + " salary: " + author + " Address: " + price + "Quantity" + qty);
            }
                                           //update
            String query4 = "UPDATE table3 set title = 'To the new world' WHERE id = 1002";

            pstmt.executeUpdate(query4);

                                            //delete
            String query5 = "DELETE from table3 where id = 1005";
            pstmt.executeUpdate(query5);


            System.out.println("INSERTED.....");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



