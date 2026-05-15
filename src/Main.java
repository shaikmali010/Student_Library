import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import service.AdminService;
import service.BookService;
import service.StudentService;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            System.out.println("================================");

            System.out.println("WELCOME TO LIBRARY SYSTEM");

            System.out.println("================================");


            // LOGIN

            boolean login = AdminService.login(con);

            if(!login){

                System.out.println("Access Denied");
                
                con.close();

                return;
            }



            while(true){

                System.out.println("\n========= MENU =========");

                System.out.println("1. Add Student");

                System.out.println("2. Show Students");

                System.out.println("3. Search Student");

                System.out.println("4. Update Student");

                System.out.println("5. Delete Student");

                System.out.println("6. Add Book");

                System.out.println("7. Show Books");

                System.out.println("8. Search Book");

                System.out.println("9. Issue Book");

                System.out.println("10. Return Book");

                System.out.println("11. Update Book");

                System.out.println("12. Delete Book");

                System.out.println("13. Add Admin");

                System.out.println("14. Show Admins");

                System.out.println("15. Exit");

                System.out.print("Choose Option: ");

                int choice;
                try{

                	choice = sc.nextInt();

                	sc.nextLine();

                	}
                	catch(Exception e){

                	System.out.println("Enter valid number");

                	sc.nextLine();

                	continue;
                	}

                switch(choice){

                    // STUDENTS

                    case 1:
                        StudentService.addStudent(con);
                        break;


                    case 2:
                        StudentService.showStudents(con);
                        break;


                    case 3:
                        StudentService.searchStudent(con);
                        break;


                    case 4:
                        StudentService.updateStudent(con);
                        break;


                    case 5:
                        StudentService.deleteStudent(con);
                        break;



                    // BOOKS

                    case 6:
                        BookService.addBook(con);
                        break;


                    case 7:
                        BookService.showBooks(con);
                        break;


                    case 8:
                        BookService.searchBook(con);
                        break;


                    case 9:
                        BookService.issueBook(con);
                        break;


                    case 10:
                        BookService.returnBook(con);
                        break;


                    case 11:
                        BookService.updateBook(con);
                        break;


                    case 12:
                        BookService.deleteBook(con);
                        break;



                    // ADMIN

                    case 13:
                        AdminService.addAdmin(con);
                        break;


                    case 14:
                        AdminService.showAdmins(con);
                        break;



                    case 15:

                        System.out.println("Exiting...");
                        
                        sc.close();
                        
                        con.close();

                        System.exit(0);

                        break;



                    default:

                        System.out.println("Invalid Choice");

                }

            }

        }

        catch(SQLException e){

            System.out.println("Database Error");

            System.out.println(e.getMessage());

        }

        catch(Exception e){

            System.out.println("Something Went Wrong");

            System.out.println(e.getMessage());

        }

    }
}

