/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;
    private ArrayList<Employee> associatedEmployeeWithUser;

    public EmployeeDirectory() {
        employeeList = new ArrayList();
        associatedEmployeeWithUser=new ArrayList();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String name){
        Employee employee = new Employee();
        employee.setName(name);
        employeeList.add(employee);
        return employee;
    }
    
    public Boolean checkIfEmployeeIsUnique(String name){
        return this.employeeList.stream().noneMatch(emp->emp.getName().equalsIgnoreCase(name));
    }
    
    public void addAssoiciatedEmployee(Employee em){
        associatedEmployeeWithUser.add(em);
    };

    public ArrayList<Employee> getAssociatedEmployeeWithUser() {
        return this.associatedEmployeeWithUser;
    }

    public void setAssociatedEmployeeWithUser(ArrayList<Employee> associatedEmployeeWithUser) {
        this.associatedEmployeeWithUser = associatedEmployeeWithUser;
    }
    
    
}