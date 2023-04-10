import java.sql.*;

public class City_Browser_Evaluation {
    public static void main(String[] args) {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");

        //creating a connection
        String url = "jdbc:mysql://localhost:3306/world1";
        String username = "root";
        String password = "sahil123";
        Connection con = DriverManager.getConnection(url, username, password);

        Statement stmt = con.createStatement();
        String q1 = "SELECT * from city";

        ResultSet res = stmt.executeQuery(q1);

        while (res.next()) {
            String name = res.getString("Name");
            String country_code = res.getString("CountryCode");
            String address = res.getString("District");

            System.out.println(     "  Name: " + name + "      Country code: " +country_code + "       District: " + address);
        }

        System.out.println("Operation successfully completed!!");

        String q2 = "UPDATE city set name = 'india'";


        if (stmt.executeUpdate(q2) == 1) {
            System.out.println("table is successfully updated!!");
        } else {
            System.out.println("city  not found!!");
        }
        String q3 = "UPDATE city set CountryCode = 'IND' ";
        stmt.executeUpdate(q3);
        String q4 = "UPDATE city set District = 'Delhi' ";
        stmt.executeUpdate(q4);
        String q5 = "SELECT * from city ";

        ResultSet re = stmt.executeQuery(q5);

        while (re.next()) {
            String name = re.getString("Name");
            String CC = re.getString("CountryCode");
            String address = re.getString("District");

            System.out.println( "  Name: " + name + "      Country code: " +CC + "       District: " + address);
        }	 String sql = "SELECT * FROM country";

        PreparedStatement pstmt = con.prepareStatement(
                sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet result = pstmt.executeQuery(sql);
        while (result.next()) {
            int code = result.getInt("Code");
            String name = result.getString("Name");
            String continent = result.getString("Continent");
            String region = result.getString("Region");
            int pop = result.getInt("Population");
            String govt = result.getString("GovernmentForm");
            String localName = result.getString("LocalName");

            System.out.println("code: " + code + "        Name: " + name + "      Continent " + continent + "       Region: " + region +   "         Population;" +pop+    "        GovernmentForm;"+govt+  "         LocalName:"+localName  );
        }




        stmt.close();
        con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

