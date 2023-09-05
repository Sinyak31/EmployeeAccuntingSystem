import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {

    private String fullName;
    private GregorianCalendar dateOfBirth;
    private String gender;
    private long contactNumber;
    private String position;
    private String department;
    private String supervisor;
    private GregorianCalendar hireDate;
    private double salary;

    public Employee(String fullName, GregorianCalendar dateOfBirth, String gender, long contactNumber, String position,String department,String supervisor, GregorianCalendar hireDate, double salary) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.position = position;
        this.department = department;
        this.supervisor = supervisor;
        this.hireDate = hireDate;
        this.salary = salary;
    }


    public String getFullName() {return fullName;}

    public void setFullName(String fullName) {this.fullName = fullName;}

    public GregorianCalendar getDateOfBirth() {return dateOfBirth;}

    public void setDateOfBirth(GregorianCalendar dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public String getGender() {return gender;}

    public void setGender(String gender) {this.gender = gender;}

    public long getContactNumber() {return contactNumber;}

    public void setContactNumber(long contactNumber) {this.contactNumber = contactNumber;}

    public String getPosition() {return position;}

    public void setPosition(String position) {this.position = position;}

    public String getDepartment() {return department;}

    public void setDepartment(String department) {this.department = department;}

    public String getSupervisor() {return supervisor;}

    public void setSupervisor(String supervisor) {this.supervisor = supervisor;}

    public GregorianCalendar getHireDate() {return hireDate;}

    public void setHireDate(GregorianCalendar hireDate) {this.hireDate = hireDate;}

    public double getSalary() {return salary;}

    public void setSalary(double salary) {this.salary = salary;}

    @Override
    public String toString() {
        return "Employee{" + '\n' +
                "fullName=" + fullName + '\n' +
                "dateOfBirth=" + dateOfBirth + '\n' +
                "gender=" + gender + '\n' +
                "contactNumber=" + contactNumber + '\n' +
                "position=" + position + '\n' +
                "department=" + department + '\n' +
                "supervisor=" + supervisor + '\n' +
                "hireDate=" + hireDate + '\n' +
                "salary=" + salary + '\n' +
                '}';
    }
}
