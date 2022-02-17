package OtherClasses;

public class Employee {
    private int EmployeeId = 0;
    private String EmployeeName;
    private String EmployeeRole;
    private double EmpSalary;

    public Employee(String EmployeeName, String EmployeeRole, double EmpSalary) {
        this.EmployeeName = EmployeeName;
        this.EmployeeRole = EmployeeRole;
        this.EmpSalary = EmpSalary;
    }

    public Employee(int EmployeeId, String EmployeeName, String EmployeeRole, double EmpSalary) {
        this.EmployeeId = EmployeeId;
        this.EmployeeName = EmployeeName;
        this.EmployeeRole = EmployeeRole;
        this.EmpSalary = EmpSalary;
    }

    @Override
    public String toString() {
        return "Id: " + EmployeeId + " Name: " + EmployeeName + " Role: " + EmployeeRole + " Salary: " + EmpSalary;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public String getEmployeeRole() {
        return EmployeeRole;
    }

    public double getEmpSalary() {
        return EmpSalary;
    }
}
