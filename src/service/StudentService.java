package service;


import java.util.Scanner;
import java.sql.*;


public class StudentService {

    static Scanner sc =
            new Scanner(System.in);


    // ADD STUDENT
    public static void addStudent(
            Connection con)
            throws SQLException {

        String query =
                """
                INSERT INTO students(
                name,
                email)

                VALUES(?,?)
                """;

        PreparedStatement ps =
                con.prepareStatement(query);

        System.out.print(
                "Enter Name: ");

        String name =
                sc.nextLine();

        System.out.print(
                "Enter Email: ");

        String email =
                sc.nextLine();

        ps.setString(1,name);
        ps.setString(2,email);

        int row =
                ps.executeUpdate();

        if(row > 0)
            System.out.println(
                    "Student Added");

    }



    // SHOW STUDENTS
    public static void showStudents(
            Connection con)
            throws SQLException {

        String query =
                "SELECT * FROM students";

        PreparedStatement ps =
                con.prepareStatement(query);

        ResultSet rs =
                ps.executeQuery();

        while(rs.next()) {

            System.out.println(

                    rs.getInt("student_id")
                            +" | "
                            +rs.getString("name")
                            +" | "
                            +rs.getString("email")
            );

        }

    }



    // SEARCH STUDENT
    public static void searchStudent(
            Connection con)
            throws SQLException {

        System.out.print(
                "Enter Student Id: ");

        int id =
                sc.nextInt();

        String query =
                """
                SELECT *

                FROM students

                WHERE student_id=?
                """;

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1,id);

        ResultSet rs =
                ps.executeQuery();

        if(rs.next()) {

            System.out.println(
                    "\nStudent Found");

            System.out.println(
                    "Id: "
                            +rs.getInt("student_id"));

            System.out.println(
                    "Name: "
                            +rs.getString("name"));

            System.out.println(
                    "Email: "
                            +rs.getString("email"));

        }

        else {

            System.out.println(
                    "Student Not Found");

        }

    }



    // UPDATE STUDENT
    public static void updateStudent(
            Connection con)
            throws SQLException {

        System.out.print(
                "Student Id: ");

        int id =
                sc.nextInt();

        sc.nextLine();

        System.out.print(
                "New Name: ");

        String name =
                sc.nextLine();

        String query =
                """
                UPDATE students

                SET name=?

                WHERE student_id=?
                """;

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setString(1,name);

        ps.setInt(2,id);

        int row =
                ps.executeUpdate();

        if(row > 0)

            System.out.println(
                    "Updated Successfully");

        else

            System.out.println(
                    "Student Not Found");

    }



    // DELETE STUDENT
    public static void deleteStudent(
            Connection con)
            throws SQLException {

        System.out.print(
                "Student Id: ");

        int id =
                sc.nextInt();

        String query =
                """
                DELETE FROM students

                WHERE student_id=?
                """;

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1,id);

        int row =
                ps.executeUpdate();

        if(row > 0)

            System.out.println(
                    "Deleted Successfully");

        else

            System.out.println(
                    "Student Not Found");

    }

}