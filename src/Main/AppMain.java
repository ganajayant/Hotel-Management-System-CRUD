package Main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import Connection.JdbcConnection;
import Hotel.Hotel;
import Utilities.BasicFunction;

public class AppMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Connection con = JdbcConnection.getConnection();
        Hotel rs = new Hotel();
        BasicFunction.clearConsole();
        if (args.length != 0) {
            if (args[0].toLowerCase().equals("--insert")) {
                try {
                    if (args[1].toLowerCase().equals("--employees"))
                        rs.InsertEmployeeList(con, args[2]);
                    else if (args[1].toLowerCase().equals("--customers"))
                        rs.InsertCustomerList(con, args[2]);
                    else if (args[1].toLowerCase().equals("--rooms"))
                        rs.InsertRoomList(con, args[2]);
                    else if (args[1].toLowerCase().equals("--dishes"))
                        rs.InsertDishList(con, args[2]);
                    else
                        System.out.println("Invalid argument " + args[1] + ". use --help for help");
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                } finally {
                    con.close();
                }
            } else if (args[0].toLowerCase().equals("--delete")) {
                try {
                    if (args[1].toLowerCase().equals("--employees"))
                        rs.DeleteEmployee(con, args[2]);
                    else if (args[1].toLowerCase().equals("--customers"))
                        rs.DeleteCustomer(con, args[2]);
                    else if (args[1].toLowerCase().equals("--rooms"))
                        rs.DeleteRoom(con, args[2]);
                    else if (args[1].toLowerCase().equals("--dishes"))
                        rs.DeleteDish(con, args[2]);
                    else
                        System.out.println("Invalid argument " + args[1] + ". use --help for help");
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                } finally {
                    con.close();
                }
            } else if (args[0].toLowerCase().equals("--update")) {
                try {
                    if (args[1].toLowerCase().equals("--employees"))
                        rs.UpdateEmployeeList(con, args[2]);
                    else if (args[1].toLowerCase().equals("--customers"))
                        rs.UpdateCustomerList(con, args[2]);
                    else if (args[1].toLowerCase().equals("--rooms"))
                        rs.UpdateRoomList(con, args[2]);
                    else if (args[1].toLowerCase().equals("--dishes"))
                        rs.UpdateDishList(con, args[2]);
                    else
                        System.out.println("Invalid argument " + args[1] + ". use --help for help");
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                } finally {
                    con.close();
                }
            } else if (args[0].toLowerCase().equals("--search")) {
                try {
                    if (args[1].toLowerCase().equals("--employees")) {
                        rs.SearchEmployee(con, args[2], args[3], args[4]);
                    } else if (args[1].toLowerCase().equals("--customers")) {
                        rs.SearchCustomer(con, args[2], args[3], args[4]);
                    } else if (args[1].toLowerCase().equals("--rooms")) {
                        rs.SearchRoom(con, args[2], args[3], args[4]);
                    } else if (args[1].toLowerCase().equals("--dishes")) {
                        rs.SearchDish(con, args[2], args[3], args[4]);
                    } else
                        System.out.println("Invalid argument " + args[1] + ". use --help for help");
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                } finally {
                    con.close();
                }
            } else if (args[0].toLowerCase().equals("--aggregate")) {
                try {
                    if (args[1].toLowerCase().equals("--employees")) {
                        rs.AggregateEmployee(con);
                    } else if (args[1].toLowerCase().equals("--customers")) {
                        rs.AggreagateCustomer(con);
                    } else if (args[1].toLowerCase().equals("--rooms")) {
                        rs.AggreagateRoom(con);
                    } else if (args[1].toLowerCase().equals("--dishes")) {
                        rs.AggregateDish(con);
                    } else
                        System.out.println("Invalid argument " + args[1] + ". use --help for help");
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                } finally {
                    con.close();
                }
            } else if (args[0].toLowerCase().equals("--version")) {
                BasicFunction.Version();
            } else if (args[0].toLowerCase().equals("--help")) {
                BasicFunction.Help();
            } else
                System.out.println("Invalid Input " + args[0] + " Use --help For Syntax");
        } else {
            System.out.println("No arguments. use --help for help");
        }
    }
}
