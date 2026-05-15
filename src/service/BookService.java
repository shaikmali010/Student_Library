package service;

import java.sql.*;
import java.util.Scanner;

public class BookService {

    static Scanner sc=
            new Scanner(System.in);

    public static void addBook(Connection con)
            throws SQLException{

        String query=
                """
                INSERT INTO books
                (title,
                 author,
                student_id,
                issue_date,
                status
                )
                
                VALUES(?,?,?,?,?)
                """;

        PreparedStatement ps= con.prepareStatement(query);

        System.out.print("Enter title:");
        String title = sc.nextLine();

        System.out.print("Enter author:");
        String author= sc.nextLine();

        System.out.print("Enter student id:");
        int sid= sc.nextInt();

        sc.nextLine();

        System.out.print("Issue date:");
        String date= sc.nextLine();

        ps.setString(1,title);
        ps.setString(2,author);
        ps.setInt(3,sid);
        ps.setString(4,date);
        ps.setString(5, "Available");

        ps.executeUpdate();

        System.out.println("Book Added");

    }

    public static void showBooks(Connection con)
            throws SQLException{

        String query=
                """
                SELECT
                    b.book_id,
                    b.title,
                    b.author,
                    b.status,
                    s.name
                
                FROM books b 
                    
                LEFT JOIN student s 
                ON b.student_id = s.student_id
                """;

        PreparedStatement ps= con.prepareStatement(query);

        ResultSet rs= ps.executeQuery();

        while(rs.next()){

            System.out.println(rs.getString("name")
                            +" | "
                            +rs.getString("title")
                            +" | "
                            +rs.getString("author")
                            +" | "
                            +rs.getDate("issue_date")
            );

        }

    }


//     SEARCH BOOK -----------------------------------------------------------------------
    public static void searchBook(Connection con)
            throws SQLException{

        String query =
                """
                SELECT *
                FROM books
                WHERE book_id=?
                """;

        PreparedStatement ps = con.prepareStatement(query);

        System.out.print("Enter book id: ");

        int id = sc.nextInt();

        ps.setInt(1,id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            System.out.println("Book Id: "
                            +rs.getInt("book_id"));

            System.out.println("Title: "
                            +rs.getString("title"));

            System.out.println("Author: "
                            +rs.getString("author"));

        }
        else {

            System.out.println("Book not found");

        }

    }

//    ISSUE BOOK ------------------------------------------------------------------------
public static void issueBook(Connection con)
        throws SQLException{

    String query=
            """
            UPDATE books
            SET
           
            student_id=?,
            issue_date=NOW(),
            status = 'Issued'
            
            WHERE book_id=?
            """;

    PreparedStatement ps = con.prepareStatement(query);

    System.out.print("Enter student id:");

    int sid = sc.nextInt();

    System.out.print("Enter book id:");

    int bid = sc.nextInt();

    ps.setInt(1,sid);

    ps.setInt(2,bid);

    int row = ps.executeUpdate();

    if(row>0) System.out.println("Book Issued");

}

//RETURN BOOKS -----------------------------------------------------------------
    public static void returnBook(Connection con)
            throws SQLException{

        String query=
                """
                UPDATE books
                SET
                
                student_id=NULL,
                status = 'Available'
                
                WHERE book_id=?
                """;

        PreparedStatement ps= con.prepareStatement(query);

        System.out.print("Enter book id:");

        int id = sc.nextInt();

        ps.setInt(1,id);

        int row = ps.executeUpdate();

        if(row>0)

            System.out.println("Book Returned");

    }

//    UPDATE BOOKS ---------------------------------------------------------------------------
public static void updateBook(Connection con)
        throws SQLException{

    String query=
            """
            UPDATE books
            
            SET title=?,
            author=?
            
            WHERE book_id=?
            """;

    PreparedStatement ps= con.prepareStatement(query);

    System.out.print("Book id:");

    int id = sc.nextInt();

    sc.nextLine();

    System.out.print("New title:");

    String title = sc.nextLine();

    System.out.print("New author:");

    String author = sc.nextLine();

    ps.setString(1,title);

    ps.setString(2,author);

    ps.setInt(3,id);

    int rows = ps.executeUpdate();

    if(rows>0) System.out.println("Book Updated");
    else System.out.println("Book not found");


}

//DELETE BOOK ---------------------------------------------------------------------------
public static void deleteBook(Connection con)
        throws SQLException{

    String query=
            """
            DELETE FROM books
            
            WHERE book_id=?
            """;

    PreparedStatement ps= con.prepareStatement(query);

    System.out.print("Book id:");

    int id = sc.nextInt();

    ps.setInt(1,id);

    ps.executeUpdate();

    System.out.println("Deleted");

}


}