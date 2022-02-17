package Hotel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.util.HashSet;
import java.util.Scanner;

import OtherClasses.Customer;
import OtherClasses.Dish;
import OtherClasses.Employee;
import OtherClasses.Rooms;
import Restaurant.Restaurant;
import Utilities.Print;

public class Hotel implements Restaurant {
    HashSet<Customer> CustomersSet = new HashSet<Customer>();
    HashSet<Employee> EmployeeSet = new HashSet<Employee>();
    HashSet<Dish> DishSet = new HashSet<Dish>();
    HashSet<Rooms> RoomSet = new HashSet<Rooms>();

    public void InsertCustomerList(Connection con, String Path)
            throws IOException, SQLException, ClassNotFoundException {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(Path)));
            while (sc.hasNext()) {
                String str = sc.nextLine();
                String[] tokens = str.split(",");
                Customer cs = new Customer(tokens[0], tokens[1], tokens[2], Double.parseDouble(tokens[3]),
                        Integer.parseInt(tokens[4]));
                CustomersSet.add(cs);
            }
            try {
                PreparedStatement ps = con.prepareStatement("insert into customer values (?,?,?,?,?)");
                for (Customer a : CustomersSet) {
                    ps.setString(1, a.getName());
                    ps.setString(2, a.getCustomerPh());
                    ps.setString(3, a.getPaymentStatus());
                    ps.setDouble(4, a.getAmount());
                    ps.setInt(5, a.getRoomAllocated());
                    int result = ps.executeUpdate();
                    if (result == 1)
                        System.out.println("Customer " + a.getName() + " Inserted successfully");
                }
            } catch (SQLException e) {
                if (e instanceof SQLSyntaxErrorException)
                    System.out.println("check the syntax of the SQL query. THere is an error.");
                else if (e instanceof SQLIntegrityConstraintViolationException)
                    System.out.println(
                            "Customer with this contact number already exists or This room is full or No room exists with this RoomNo.");
                else
                    System.out.println(e.getLocalizedMessage());
            }
        } catch (IOException e) {
            System.out.println("File not found. Check the file you entered.");
        }
    }

    public void InsertEmployeeList(Connection con, String Path)
            throws IOException, ClassNotFoundException, SQLException {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(Path)));
            while (sc.hasNext()) {
                String str = sc.nextLine();

                String[] tokens = str.split(",");
                Employee emp = new Employee(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
                EmployeeSet.add(emp);
            }
            try {
                PreparedStatement ps = con
                        .prepareStatement("insert into employee( EmployeeName,EmployeeRole, EmpSalary) values (?,?,?)");
                for (Employee a : EmployeeSet) {
                    ps.setString(1, a.getEmployeeName());
                    ps.setString(2, a.getEmployeeRole());
                    ps.setDouble(3, a.getEmpSalary());
                    int result = ps.executeUpdate();
                    if (result == 1)
                        System.out.println("Employee " + a.getEmployeeName() + " Inserted successfully");
                }
            } catch (SQLException e) {
                if (e instanceof SQLSyntaxErrorException)
                    System.out.println("check the syntax of the SQL query. There is an error.");
                else
                    System.out.println(e.getLocalizedMessage());
            }
        } catch (IOException e) {
            System.out.println("File not found. Check the file you entered.");
        }
    }

    public void InsertRoomList(Connection con, String Path) throws IOException, ClassNotFoundException, SQLException {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(Path)));
            while (sc.hasNext()) {
                String str = sc.nextLine();

                String[] tokens = str.split(",");
                Rooms room = new Rooms(tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]),
                        tokens[3]);
                RoomSet.add(room);
            }
            try {
                PreparedStatement ps = con
                        .prepareStatement("insert into rooms(Type,CostPerHour, Capacity,Vacancy) values (?,?,?,?)");
                for (Rooms a : RoomSet) {
                    ps.setString(1, a.getType());
                    ps.setDouble(2, a.getCostPerHour());
                    ps.setInt(3, a.getCapacity());
                    ps.setString(4, a.getVacancy());
                    int result = ps.executeUpdate();
                    if (result == 1)
                        System.out.println("Room Inserted successfully");
                }
            } catch (SQLException e) {
                if (e instanceof SQLSyntaxErrorException)
                    System.out.println("check the syntax of the SQL query. There is an error.");
                else
                    System.out.println(e.getLocalizedMessage());
            }
        } catch (IOException e) {
            System.out.println("File not found. Check the file you entered.");
        }
    }

    public void InsertDishList(Connection con, String Path) throws IOException, ClassNotFoundException, SQLException {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(Path)));
            while (sc.hasNext()) {
                String str = sc.nextLine();

                String[] tokens = str.split(",");
                Dish dish = new Dish(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
                DishSet.add(dish);
            }
            try {
                PreparedStatement ps = con.prepareStatement("insert into dish values (?,?,?)");
                for (Dish a : DishSet) {
                    ps.setString(1, a.getDishName());
                    ps.setString(2, a.getCuisine());
                    ps.setDouble(3, a.getPrice());
                    int result = ps.executeUpdate();
                    if (result == 1)
                        System.out.println("Dish " + a.getDishName() + " inserted successfully");
                }
            } catch (SQLException e) {
                if (e instanceof SQLSyntaxErrorException)
                    System.out.println("check the syntax of the SQL query. There is an error.");
                else if (e instanceof SQLIntegrityConstraintViolationException)
                    System.out.println("Dish with this name already exists.");
                else
                    System.out.println(e.getLocalizedMessage());
            }
        } catch (IOException e) {
            System.out.println("File not found. check the file you entered.");
        }
    }

    public void DeleteCustomer(Connection con, String PhoneNumber) throws SQLException {
        try {
            String query = "delete from customer where CustomerPh = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, PhoneNumber);
            int result = ps.executeUpdate();
            if (result == 1)
                System.out.println("Customer deleted successfully.");
            else
                System.out.println("Customer not found.");
        } catch (SQLException e) {
            if (e instanceof SQLSyntaxErrorException)
                System.out.println("check the syntax of the SQL query. THere is an error.");
            else
                System.out.println(e.getLocalizedMessage());
        }
    }

    public void DeleteEmployee(Connection con, String ID) throws SQLException {
        try {
            String query = "delete from employee where EmployeeId = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(ID));
            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Employee deleted successfully.");
            } else
                System.out.println("Employee not found.");
        } catch (SQLException e) {
            if (e instanceof SQLSyntaxErrorException)
                System.out.println("check the syntax of the SQL query. THere is an error.");
            else
                System.out.println(e.getLocalizedMessage());
        }
    }

    public void DeleteRoom(Connection con, String RoomNo) throws SQLException {
        try {
            String query = "delete from rooms where RoomNO = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(RoomNo));
            int result = ps.executeUpdate();
            if (result == 1)
                System.out.println("Room deleted successfully.");
            else
                System.out.println("Room not found.");
        } catch (SQLException e) {
            if (e instanceof SQLSyntaxErrorException)
                System.out.println("check the syntax of the SQL query. THere is an error.");
            else
                System.out.println(e.getLocalizedMessage());
        }
    }

    public void DeleteDish(Connection con, String DishName) throws SQLException {
        try {
            String query = "delete from dish where DishName = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, DishName);
            int result = ps.executeUpdate();
            if (result == 1)
                System.out.println("Dish deleted successfully.");
            else
                System.out.println("Dish not found.");
        } catch (SQLException e) {
            if (e instanceof SQLSyntaxErrorException)
                System.out.println("check the syntax of the SQL query. THere is an error.");
            else
                System.out.println(e.getLocalizedMessage());
        }
    }

    public void UpdateCustomerList(Connection con, String Path)
            throws IOException, SQLException, ClassNotFoundException {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(Path)));
            while (sc.hasNext()) {
                String str = sc.nextLine();

                String[] tokens = str.split(",");
                Customer cs = new Customer(tokens[0], tokens[1], tokens[2], Double.parseDouble(tokens[3]),
                        Integer.parseInt(tokens[4]));
                CustomersSet.add(cs);
            }
            try {
                PreparedStatement ps = con.prepareStatement(
                        "update customer set CustomerName = ?,PaymentStatus = ?,Amount=?,RoomAllocated = ? where CustomerPh=?");
                for (Customer a : CustomersSet) {
                    ps.setString(1, a.getName());
                    ps.setString(2, a.getPaymentStatus());
                    ps.setDouble(3, a.getAmount());
                    ps.setInt(4, a.getRoomAllocated());
                    ps.setString(5, a.getCustomerPh());
                    int result = ps.executeUpdate();
                    if (result == 1)
                        System.out.println("Customer " + a.getName() + " updated successfully");
                }
            } catch (SQLException e) {
                if (e instanceof SQLSyntaxErrorException)
                    System.out.println("check the syntax of the SQL query. THere is an error.");
                else
                    System.out.println(e.getLocalizedMessage());
            }
        } catch (IOException e) {
            System.out.println("File not found. Check the file you entered.");
        }
    }

    public void UpdateEmployeeList(Connection con, String Path)
            throws IOException, ClassNotFoundException, SQLException {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(Path)));
            while (sc.hasNext()) {
                String str = sc.nextLine();

                String[] tokens = str.split(",");
                Employee emp = new Employee(Integer.parseInt(tokens[0]), tokens[1], tokens[2],
                        Double.parseDouble(tokens[3]));
                EmployeeSet.add(emp);
            }
            try {
                PreparedStatement ps = con.prepareStatement(
                        "update employee set EmployeeName=?,EmployeeRole=?,EmpSalary=? where EmployeeId=?");
                for (Employee a : EmployeeSet) {
                    ps.setString(1, a.getEmployeeName());
                    ps.setString(2, a.getEmployeeRole());
                    ps.setDouble(3, a.getEmpSalary());
                    ps.setInt(4, a.getEmployeeId());
                    int result = ps.executeUpdate();
                    if (result == 1)
                        System.out.println("Employee updated successfully");
                }
            } catch (SQLException e) {
                if (e instanceof SQLSyntaxErrorException)
                    System.out.println("check the syntax of the SQL query. THere is an error.");
                else
                    System.out.println(e.getLocalizedMessage());
            }
        } catch (IOException e) {
            System.out.println("File not found. Check the file you entered.");
        }
    }

    public void UpdateRoomList(Connection con, String Path) throws IOException, ClassNotFoundException, SQLException {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(Path)));
            while (sc.hasNext()) {
                String str = sc.nextLine();

                String[] tokens = str.split(",");
                Rooms room = new Rooms(Integer.parseInt(tokens[0]), tokens[1], Double.parseDouble(tokens[2]),
                        Integer.parseInt(tokens[3]), tokens[4]);
                RoomSet.add(room);
            }
            try {
                PreparedStatement ps = con
                        .prepareStatement("update rooms set Type=?,CostPerHour=?, Capacity=?,Vacancy=? where RoomNo=?");
                for (Rooms a : RoomSet) {
                    ps.setString(1, a.getType());
                    ps.setDouble(2, a.getCostPerHour());
                    ps.setInt(3, a.getCapacity());
                    ps.setString(4, a.getVacancy());
                    ps.setInt(5, a.getRoomNo());
                    int result = ps.executeUpdate();
                    if (result == 1)
                        System.out.println("Room " + a.getRoomNo() + " updated successfully");
                }
            } catch (SQLException e) {
                if (e instanceof SQLSyntaxErrorException)
                    System.out.println("check the syntax of the SQL query. THere is an error.");
                else
                    System.out.println(e.getLocalizedMessage());
            }
        } catch (IOException e) {
            System.out.println("File not found. Check the file you entered.");
        }
    }

    public void UpdateDishList(Connection con, String Path) throws IOException, ClassNotFoundException, SQLException {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(Path)));
            while (sc.hasNext()) {
                String str = sc.nextLine();

                String[] tokens = str.split(",");
                Dish dish = new Dish(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
                DishSet.add(dish);
            }
            try {
                PreparedStatement ps = con.prepareStatement("update dish set Cuisine = ?,Price = ? where DishName = ?");
                for (Dish a : DishSet) {
                    ps.setString(1, a.getCuisine());
                    ps.setDouble(2, a.getPrice());
                    ps.setString(3, a.getDishName());
                    int result = ps.executeUpdate();
                    if (result == 1)
                        System.out.println("Dish " + a.getDishName() + " updated successfully");
                }
            } catch (SQLException e) {
                if (e instanceof SQLSyntaxErrorException)
                    System.out.println("check the syntax of the SQL query. THere is an error.");
                else
                    System.out.println(e.getLocalizedMessage());
            }
        } catch (IOException e) {
            System.out.println("File not found. check the file you entered.");
        }
    }

    public void SearchCustomer(Connection con, String Field, String Value, String expression)
            throws SQLException, ClassNotFoundException {
        try {
            if (Field.toLowerCase().contains("name")) {
                String query = "select * from customer where CustomerName=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, Value);
                ResultSet rs = ps.executeQuery();
                Print.printHeader(rs);
                Print.printValues(rs);
            } else if (Field.toLowerCase().contains("ph")) {
                String query = "select * from customer where CustomerPh=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, Value);
                ResultSet rs = ps.executeQuery();
                Print.printHeader(rs);
                Print.printValues(rs);
            } else if (Field.toLowerCase().contains("payment")) {
                String query = "select * from customer where PaymentStatus=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, Value);
                ResultSet rs = ps.executeQuery();
                Print.printHeader(rs);
                Print.printValues(rs);
            } else if (Field.toLowerCase().contains("amount")) {
                String query = "";
                if (expression.toLowerCase().equals("--gt"))
                    query = "select * from customer where Amount > ?";
                else if (expression.toLowerCase().equals("--gte"))
                    query = "select * from customer where Amount >= ?";
                else if (expression.toLowerCase().equals("--lt"))
                    query = "select * from customer where Amount < ?";
                else if (expression.toLowerCase().equals("--lte"))
                    query = "select * from customer where Amount <= ?";
                else if (expression.toLowerCase().equals("--e"))
                    query = "select * from customer where Amount = ?";
                else {
                    System.out.println("Invalid Expression");
                    System.exit(0);
                }
                PreparedStatement ps = con.prepareStatement(query);
                ps.setDouble(1, Double.parseDouble(Value));
                ResultSet rs = ps.executeQuery();
                Print.printHeader(rs);
                Print.printValues(rs);
            } else if (Field.toLowerCase().contains("room")) {
                String query = "";
                if (expression.toLowerCase().equals("--gt"))
                    query = "select * from customer where RoomAllocated > ?";
                else if (expression.toLowerCase().equals("--gte"))
                    query = "select * from customer where RoomAllocated >= ?";
                else if (expression.toLowerCase().equals("--lt"))
                    query = "select * from customer where RoomAllocated < ?";
                else if (expression.toLowerCase().equals("--lte"))
                    query = "select * from customer where RoomAllocated <= ?";
                else if (expression.toLowerCase().equals("--e"))
                    query = "select * from customer where RoomAllocated = ?";
                else {
                    System.out.println("Invalid Expression");
                    System.exit(0);
                }
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(Value));
                ResultSet rs = ps.executeQuery();
                Print.printHeader(rs);
                Print.printValues(rs);
            } else
                System.out.println("Invalid Field Name");
            System.exit(0);
        } catch (Exception e) {
            if (e instanceof SQLSyntaxErrorException)
                System.out.println("check the syntax of the SQL query. THere is an error.");
            else
                System.out.println(e.getLocalizedMessage());
        } finally {
            con.close();
        }
    }

    public void SearchRoom(Connection con, String Field, String Value, String expression)
            throws SQLException, ClassNotFoundException {
        try {
            if (Field.toLowerCase().contains("type")) {
                String query = "select * from rooms where Type=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, Value);
                ResultSet rs = ps.executeQuery();
                Print.printHeader(rs);
                Print.printValues(rs);
            } else if (Field.toLowerCase().contains("vacancy")) {
                String query = "select * from rooms where Vacancy=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, Value);
                ResultSet rs = ps.executeQuery();
                Print.printHeader(rs);
                Print.printValues(rs);
            } else if (Field.toLowerCase().contains("cost")) {
                String query = "";
                if (expression.toLowerCase().equals("--gt"))
                    query = "select * from rooms where  CostPerHour > ?";
                else if (expression.toLowerCase().equals("--gte"))
                    query = "select * from rooms where  CostPerHour >= ?";
                else if (expression.toLowerCase().equals("--lt"))
                    query = "select * from rooms where  CostPerHour < ?";
                else if (expression.toLowerCase().equals("--lte"))
                    query = "select * from rooms where  CostPerHour <= ?";
                else if (expression.toLowerCase().equals("--e"))
                    query = "select * from rooms where  CostPerHour = ?";
                else {
                    System.out.println("Invalid Expression");
                    System.exit(0);
                }
                PreparedStatement ps = con.prepareStatement(query);
                ps.setDouble(1, Double.parseDouble(Value));
                ResultSet rs = ps.executeQuery();
                Print.printHeader(rs);
                Print.printValues(rs);
            } else if (Field.toLowerCase().contains("room")) {
                String query = "";
                if (expression.toLowerCase().equals("--gt"))
                    query = "select * from rooms where RoomNo > ?";
                else if (expression.toLowerCase().equals("--gte"))
                    query = "select * from rooms where RoomNo >= ?";
                else if (expression.toLowerCase().equals("--lt"))
                    query = "select * from rooms where RoomNo < ?";
                else if (expression.toLowerCase().equals("--lte"))
                    query = "select * from rooms where RoomNo <= ?";
                else if (expression.toLowerCase().equals("--e"))
                    query = "select * from rooms where RoomNo = ?";
                else {
                    System.out.println("Invalid Expression");
                    System.exit(0);
                }
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(Value));
                ResultSet rs = ps.executeQuery();
                Print.printHeader(rs);
                Print.printValues(rs);
            } else if (Field.toLowerCase().contains("capacity")) {
                String query = "";
                if (expression.toLowerCase().equals("--gt"))
                    query = "select * from rooms where Capacity > ?";
                else if (expression.toLowerCase().equals("--gte"))
                    query = "select * from rooms where Capacity >= ?";
                else if (expression.toLowerCase().equals("--lt"))
                    query = "select * from rooms where Capacity < ?";
                else if (expression.toLowerCase().equals("--lte"))
                    query = "select * from rooms where Capacity <= ?";
                else if (expression.toLowerCase().equals("--e"))
                    query = "select * from rooms where Capacity = ?";
                else {
                    System.out.println("Invalid Expression");
                    System.exit(0);
                }
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(Value));
                ResultSet rs = ps.executeQuery();
                Print.printHeader(rs);
                Print.printValues(rs);
            } else {
                System.out.println("Invalid Field Name");
                System.exit(0);
            }
        } catch (Exception e) {
            if (e instanceof SQLSyntaxErrorException)
                System.out.println("check the syntax of the SQL query. There is an error.");
            else
                System.out.println(e.getLocalizedMessage());
        } finally {
            con.close();
        }
    }

    public void SearchDish(Connection con, String Field, String Value, String expression)
            throws SQLException, ClassNotFoundException {
        try {
            if (Field.toLowerCase().contains("name")) {
                String query = "select * from dish where DishName=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, Value);
                ResultSet rs = ps.executeQuery();
                Print.printHeader(rs);
                Print.printValues(rs);
            } else if (Field.toLowerCase().contains("cuisine")) {
                String query = "select * from dish where Cuisine=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, Value);
                ResultSet rs = ps.executeQuery();
                Print.printHeader(rs);
                Print.printValues(rs);
            } else if (Field.toLowerCase().contains("price")) {
                String query = "";
                if (expression.toLowerCase().equals("--gt"))
                    query = "select * from dish where Price > ?";
                else if (expression.toLowerCase().equals("--gte"))
                    query = "select * from dish where Price >= ?";
                else if (expression.toLowerCase().equals("--lt"))
                    query = "select * from dish where Price < ?";
                else if (expression.toLowerCase().equals("--lte"))
                    query = "select * from dish where Price <= ?";
                else if (expression.toLowerCase().equals("--e"))
                    query = "select * from dish where Price = ?";
                else {
                    System.out.println("Invalid Expression");
                    System.exit(0);
                }
                PreparedStatement ps = con.prepareStatement(query);
                ps.setDouble(1, Double.parseDouble(Value));
                ResultSet rs = ps.executeQuery();
                Print.printHeader(rs);
                Print.printValues(rs);
            } else {
                System.out.println("Invalid Field Name");
                System.exit(0);
            }
        } catch (Exception e) {
            if (e instanceof SQLSyntaxErrorException)
                System.out.println("check the syntax of the SQL query. There is an error.");
            else
                System.out.println(e.getLocalizedMessage());
        } finally {
            con.close();
        }
    }

    public void SearchEmployee(Connection con, String Field, String Value, String expression)
            throws SQLException, ClassNotFoundException {
        try {
            if (Field.toLowerCase().contains("name")) {
                String query = "select * from employee where EmployeeName=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, Value);
                ResultSet rs = ps.executeQuery();
                Print.printHeader(rs);
                Print.printValues(rs);
            } else if (Field.toLowerCase().contains("role")) {
                String query = "select * from employee where EmployeeRole=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, Value);
                ResultSet rs = ps.executeQuery();
                Print.printHeader(rs);
                Print.printValues(rs);
            } else if (Field.toLowerCase().contains("salary")) {
                String query = "";
                if (expression.toLowerCase().equals("--gt"))
                    query = "select * from employee where EmpSalary > ?";
                else if (expression.toLowerCase().equals("--gte"))
                    query = "select * from employee where EmpSalary >= ?";
                else if (expression.toLowerCase().equals("--lt"))
                    query = "select * from employee where EmpSalary < ?";
                else if (expression.toLowerCase().equals("--lte"))
                    query = "select * employee where EmpSalary <= ?";
                else if (expression.toLowerCase().equals("--e"))
                    query = "select * employee where EmpSalary = ?";
                else {
                    System.out.println("Invalid Expression");
                    System.exit(0);
                }
                PreparedStatement ps = con.prepareStatement(query);
                ps.setDouble(1, Double.parseDouble(Value));
                ResultSet rs = ps.executeQuery();
                Print.printHeader(rs);
                Print.printValues(rs);
            } else {
                System.out.println("Invalid Field Name");
                System.exit(0);
            }
        } catch (Exception e) {
            if (e instanceof SQLSyntaxErrorException)
                System.out.println("check the syntax of the SQL query. There is an error.");
            else
                System.out.println(e.getLocalizedMessage());
        } finally {
            con.close();
        }
    }

    public void AggregateEmployee(Connection con) throws SQLException {
        try {
            PreparedStatement ps = con
                    .prepareStatement("select SUM(EmpSalary),Count(EmpSalary),SUM(POWER(EmpSalary,2)) from employee");
            ResultSet rs = ps.executeQuery();
            rs.next();
            double sum = Double.parseDouble(rs.getString(1));
            int count = Integer.parseInt(rs.getString(2));
            double sumofsquare = Double.parseDouble(rs.getString(3));
            double variance = sumofsquare / count - Math.pow(sum / count, 2);
            System.out.println("No of Employees: " + count + "\nTotal Employees Salary: " + sum
                    + "\nEmployees Average Salary: " + sum / count +
                    "\nEmployees Salary Variance: " + variance + "\nEmployees Coefficient Of Variance: "
                    + 100 * Math.sqrt(variance) / (sum / count));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
    }

    public void AggreagateCustomer(Connection con) throws SQLException {
        try {
            PreparedStatement ps = con
                    .prepareStatement("select SUM(Amount),Count(Amount),SUM(POWER(Amount,2)) from customer");
            ResultSet rs = ps.executeQuery();
            rs.next();
            double sum = Double.parseDouble(rs.getString(1));
            int count = Integer.parseInt(rs.getString(2));
            double sumofsquare = Double.parseDouble(rs.getString(3));
            double variance = sumofsquare / count - Math.pow(sum / count, 2);
            System.out.println(
                    "No of Customers: " + count + "\nTotal Revenue: " + sum + "\nAverage Revenue: " + sum / count +
                            "\nVariance of Revenue: " + variance + "\nCoefficient Of Variance For Revenue: "
                            + 100 * Math.sqrt(variance) / (sum / count));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
    }

    public void AggreagateRoom(Connection con) throws SQLException {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "select SUM(CostPerHour),Count(CostPerHour),SUM(POWER(CostPerHour,2)) from rooms");
            ResultSet rs = ps.executeQuery();
            rs.next();
            double sum = Double.parseDouble(rs.getString(1));
            int count = Integer.parseInt(rs.getString(2));
            double sumofsquare = Double.parseDouble(rs.getString(3));
            double variance = sumofsquare / count - Math.pow(sum / count, 2);
            System.out.println("No of Rooms: " + count + "\nTotal Cost Of Rooms Per Hour: " + sum
                    + "\nAverage Room Cost: " + sum / count +
                    "\nVariance of Cost: " + variance + "\nCoefficient Of Variance For Cost: "
                    + 100 * Math.sqrt(variance) / (sum / count));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
    }

    public void AggregateDish(Connection con) throws SQLException {
        try {
            PreparedStatement ps = con.prepareStatement("select SUM(Price),Count(Price),SUM(POWER(Price,2)) from dish");
            ResultSet rs = ps.executeQuery();
            rs.next();
            double sum = Double.parseDouble(rs.getString(1));
            int count = Integer.parseInt(rs.getString(2));
            double sumofsquare = Double.parseDouble(rs.getString(3));
            double variance = sumofsquare / count - Math.pow(sum / count, 2);
            System.out.println("No of Dishes: " + count + "\nTotal Cost Of Dishes: " + sum + "\nAverage Dish Cost: "
                    + sum / count +
                    "\nVariance of Cost: " + variance + "\nCoefficient Of Variance For Cost: "
                    + 100 * Math.sqrt(variance) / (sum / count));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
    }
}