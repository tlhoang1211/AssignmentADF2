import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class MainThread {
    public static void main(String[] args) throws SQLException {
        boolean loop = true;
        int choose = 0;
        while (loop) {
            System.out.println("=====================================");
            System.out.println("=====Welcome to the menu======");
            System.out.println("                                     ");
            System.out.println("1.Sign up for an account             ");
            System.out.println("2.Log   in                              ");
            System.out.println("3.Exit                               ");
            System.out.println("                                     ");
            System.out.println("=====================================");
            Scanner scanner = new Scanner(System.in);
            try {
                choose = scanner.nextInt();scanner.nextLine();
            }catch (Exception e)
            {
                System.err.println(e);
                System.err.println("Please enter a number from 1-3");
            }
            EmployeeModel emp = new EmployeeModel();
            //lựa chọn
            switch(choose) {
                case 1:
                    System.out.println("You have chosen to register for an account");
                    System.out.println("Please fill this form");
                    Employee employee = new Employee();

                    System.out.println("Your name:");
                    employee.setName(scanner.nextLine());

                    System.out.println("Your email:");
                    employee.setEmail(scanner.nextLine());

                    System.out.println("Your address:");
                    employee.setAddress(scanner.nextLine());


                    System.out.println("Username:");
                    employee.setAccount(scanner.nextLine());

                    System.out.println("Password:");
                    employee.setPassword(scanner.nextLine());

                    employee.setCreateAt(Date.valueOf(LocalDate.now()));
                    employee.setUpdateAt(Date.valueOf(LocalDate.now()));
                    System.out.println("Enter status:");
                    employee.setStatus(scanner.nextInt());
                    scanner.nextLine();
                    emp.register(employee);
                    System.out.println("\n\n\n\n\n\n");
                    System.out.println("Do you want to continue or not?");
                    System.out.println("1-Continue");
                    System.out.println("2-Exit");
                    choose = scanner.nextInt();scanner.nextLine();
                    switch (choose){
                        case 1:
                            loop = true;
                            break;
                        default:
                            System.out.println("Thank you for using our service and see you again");
                            loop = false;
                            break;
                    }
                    break;
                case 2:
                    System.out.println("You have chosen to login");
                    System.out.println("Please enter your username");
                    String acc = scanner.nextLine();
                    System.out.println("Please enter your password");
                    String pwd = scanner.nextLine();
                    emp.login(acc,pwd);
                    System.out.println("\n\n\n\n\n\n");
                    System.out.println("Do you want to continue or not?");
                    System.out.println("1-Continue");
                    System.out.println("2-Exit");
                    choose = scanner.nextInt();scanner.nextLine();
                    switch (choose){
                        case 1:
                            loop = true;
                            break;
                        default:
                            System.out.println("Thank you for using our service and see you again");
                            loop = false;
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using our service and see you again");
                    loop = false;
                    break;
                default:
                    System.out.println("Please pick a valid number: ");
                    break;
            }
        }
    }
}
