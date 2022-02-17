package OtherClasses;

public class Manager extends Employee {

    public Manager(int EmployeeId, String EmployeeName, String EmployeeRole, double EmpSalary) {
        super(EmployeeId, EmployeeName, "Manager", EmpSalary * 1.10);
    }

    @Override
    public int getEmployeeId() {
        return super.getEmployeeId();
    }

    @Override
    public String getEmployeeName() {
        return super.getEmployeeName();
    }

    @Override
    public String getEmployeeRole() {
        return super.getEmployeeRole();
    }

    @Override
    public double getEmpSalary() {
        return super.getEmpSalary();
    }
}
