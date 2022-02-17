package Restaurant;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface Restaurant {
    abstract void InsertCustomerList(Connection con, String Path)
            throws IOException, SQLException, ClassNotFoundException;

    abstract void InsertEmployeeList(Connection con, String Path)
            throws IOException, ClassNotFoundException, SQLException;

    abstract void InsertDishList(Connection con, String Path) throws IOException, ClassNotFoundException, SQLException;

    abstract void DeleteCustomer(Connection con, String PhoneNumber) throws SQLException;

    abstract void DeleteEmployee(Connection con, String ID) throws SQLException;

    abstract void DeleteDish(Connection con, String DishName) throws SQLException;

    abstract void UpdateCustomerList(Connection con, String Path)
            throws IOException, SQLException, ClassNotFoundException;

    abstract void UpdateEmployeeList(Connection con, String Path)
            throws IOException, ClassNotFoundException, SQLException;

    abstract void UpdateDishList(Connection con, String Path) throws IOException, ClassNotFoundException, SQLException;

    abstract void SearchCustomer(Connection con, String Field, String Value, String expression)
            throws SQLException, ClassNotFoundException;

    abstract void SearchDish(Connection con, String Field, String Value, String expression)
            throws SQLException, ClassNotFoundException;

    abstract void SearchEmployee(Connection con, String Field, String Value, String expression)
            throws SQLException, ClassNotFoundException;
}
