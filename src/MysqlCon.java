import java.sql.*;
import java.util.Scanner;

class MysqlCon {

    private static void createHero() {
        Scanner sc = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/warriors", "walid", "Zayn.2020");
            Statement stmt = con.createStatement();
            System.out.println("Enter hero's class : ");
            String type = sc.nextLine();
            System.out.println("Enter hero's name : ");
            String name = sc.nextLine();
            System.out.println("Enter hero's image : ");
            String image = sc.nextLine();
            System.out.println("Enter hero's hp : ");
            int hp = sc.nextInt();
            System.out.println("Enter hero's attack : ");
            int attack = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter hero's weapon/spell : ");
            String weapon = sc.nextLine();
            System.out.println("Enter hero's shield : ");
            String shield = sc.nextLine();
            stmt.executeUpdate("INSERT INTO hero VALUES (Id,'"+type+"','"+name+"','"+image+"','"+hp+"','"+ attack+"','"+weapon+"','"+shield+"')");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    private static void updateHero() {
        Scanner sc = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/warriors", "walid", "Zayn.2020");
            Statement stmt = con.createStatement();
            System.out.println("Enter hero's class : ");
            String type = sc.nextLine();
//            System.out.println("Enter hero's name : ");
//            String name = sc.nextLine();
//            System.out.println("Enter hero's image : ");
//            String image = sc.nextLine();
//            System.out.println("Enter hero's hp : ");
//            int hp = sc.nextInt();
//            System.out.println("Enter hero's attack : ");
//            int attack = sc.nextInt();
//            sc.nextLine();
//            System.out.println("Enter hero's weapon/spell : ");
//            String weapon = sc.nextLine();
//            System.out.println("Enter hero's shield : ");
//            String shield = sc.nextLine();
            stmt.executeUpdate("UPDATE hero " +
                    "SET Type = '"+type+"'" +
                    "WHERE id=2");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void getHeroes() {
        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/warriors", "walid", "Zayn.2020");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM hero");
            while (rs.next())
            {
                String classes = rs.getString("Type");
                String name = rs.getString("Name");
                System.out.format("%s, %s,\n", classes, name);
            }
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void getHeroe() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/warriors", "walid", "Zayn.2020");

            Statement stmt = con.createStatement();
            System.out.println("Enter character id :");
            String id = sc.nextLine();
            ResultSet rs = stmt.executeQuery("SELECT * FROM hero WHERE id="+id);
            while (rs.next())
            {
                String classes = rs.getString("Type");
                String name = rs.getString("Name");
                System.out.format("%s, %s\n", classes, name);
            }
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void deleteHero() {
        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/warriors", "walid", "Zayn.2020");

            Statement stmt = con.createStatement();
            System.out.println("Enter character id to delete :");
            String id = sc.nextLine();
            String sql = "DELETE FROM hero WHERE id = "+id;
            System.out.println("Suppression...");
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        deleteHero();
        //getHeroe();
        //getHeroes();
        //createHero();
        //updateHero();
    }
}