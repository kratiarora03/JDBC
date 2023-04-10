import java.sql.*;
import java.util.Scanner;

public class CityBrowser {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating a connection
            String url = "jdbc:mysql://localhost:3306/krati";
            String username = "root";
            String password = "Abktanvi03";
            Connection con = DriverManager.getConnection(url, username, password);


                if(con != null)
                    System.out.println("Connection is successfull....");
                Statement stm = con.createStatement();
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                con.setAutoCommit(false);
                Savepoint save = con.setSavepoint();
                System.out.println("Enter the code of the country whose information you need:");
                String code1 = sc.next();
                String query = "SELECT * FROM city WHERE CountryCode = '"+code1+"'";
                stm.executeQuery(query);
                con.rollback(save);
                System.out.println("Enter the name of the city whose information you need:");
                String name = sc.next();
                String query1 = "SELECT * FROM city WHERE Name = '"+name+"'";
                ResultSet res = stm.executeQuery(query1);
                while(res.next())
                {
                    int i = res.getInt("ID");
                    String cc = res.getString("CountryCode");
                    String d = res.getString("District");
                    System.out.println("id:" + i + " ,Countrycode:" + cc+ " ,District:" + d );
                }
                System.out.println("Enter city name:");
                String cityname = sc.next();
                if(cityname.equals("Paris"))
                {
                    String query2 = "UPDATE city set District = 'London' WHERE Name = 'Paris'";
                    stm.executeUpdate(query2);
                }
                else
                {
                    System.out.println("City not found!!");
                }
                System.out.println("The countries form the country table are:");
//updateable resultset in table country!!
                String query3 = "SELECT * FROM country";
                stm.executeQuery(query3);
                ResultSet res1 = stmt.executeQuery(query3);
                while (res1.next()) {
                    String name_cc= res.getString("Name");
                    System.out.println("Name: " + name_cc );
                }
// res.moveToInsertRow();
// res.updateString(2,"Albania");
// res.insertRow();
//insert , delete, update records
                int count = 0;
                while(res.next()) {
                    String code = res.getString("Code");
                    String cap = res.getString("Capital");
                    String continent = res.getString("Continent");
                    int lifeexpen = res.getInt("LifeExpectancy");
                    String localname = res.getString("LocalName");
                    String name_cc = res.getString("Name");
                    int pop = res.getInt("Population");
                    String reg = res.getString("Region");
                    System.out.println("Code: "+code+" "
                            + " Captial: "+cap+" "
                            + " Continent: "+continent+" "
                            + " lifeexpectancy: "+lifeexpen+" "
                            + " Local Name: "+localname+" "
                            + " Name: "+name+" "
                            + " Population:"+ pop+" " +" Region:"+ reg);
                    count++;
                    if(count == 1) {
                        res.updateString(1, "ABC");
                        res.updateRow();
                    }
                    if(count==2) {
                        res.deleteRow();
                    }
                }
                res.moveToInsertRow();
                res.updateString(1,"BCD");
                res.updateInt(14,200);
                res.updateString(3,"Asia");
                res.updateInt(8,50);
                res.updateString(11,"Hindustan");
                res.updateString(2,"India");
                res.updateInt(7, 380);
                res.insertRow();
                stm.close();
                con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        }
}
