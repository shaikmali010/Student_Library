package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminService {

    static Scanner sc = new Scanner(System.in);


    // ADD ADMIN
    public static void addAdmin(Connection con)
            throws SQLException {

        String query =
                """
                INSERT INTO admin(
                username,
                password)

                VALUES(?,?)
                """;

        try(PreparedStatement ps = con.prepareStatement(query)
        ){

            System.out.print("Enter Username: ");

            String username = sc.nextLine();

            System.out.print("Enter Password: ");

            String password = sc.nextLine();

            ps.setString(1, username);

            ps.setString(2, password);

            int row = ps.executeUpdate();

            if(row > 0)

                System.out.println("Admin Added");

        }

    }



    // LOGIN ADMIN
    public static boolean login(Connection con)
            throws SQLException {

        String query =
                """
                SELECT *

                FROM admin

                WHERE username=?

                AND password=?
                """;

        try(PreparedStatement ps = con.prepareStatement(query)
        ){

            System.out.println("\n========= ADMIN LOGIN =========");

            System.out.print("Username: ");

            String username = sc.nextLine();

            System.out.print("Password: ");

            String password = sc.nextLine();

            ps.setString(1, username);

            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                System.out.println("\nWelcome "
                                + rs.getString(
                                "username")
                );

                return true;
            }

            System.out.println("\nInvalid Login");

            return false;

        }

    }



    // SHOW ADMINS
    public static void showAdmins(Connection con)
            throws SQLException {

        String query = "SELECT * FROM admin";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {

            System.out.println(rs.getInt(
                            "admin_id")

                            +" | "

                            +rs.getString(
                            "username")

            );

        }

    }

}