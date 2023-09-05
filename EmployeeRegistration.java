import java.util.*;
import java.util.List;

//Метод регистрации сотрудника
public class EmployeeRegistration {

    Scanner scanner = new Scanner(System.in);
    Employee employee;
    public ArrayList<String> departments = new ArrayList<>();



    // Метод для устройства на работу сотрудника (Заполнение анкеты)
    public Employee registration() {
        System.out.println("ФИО сотрудника");
        String fullName = scanner.nextLine();
        System.out.println("Введите дату рождения");
        GregorianCalendar dateOfBirth = addData();
        scanner.nextLine();
        System.out.println("Введите пол сотрудника М/Ж");
        String gender;
        while (true) {
            gender = scanner.nextLine();
            if (gender.equals("М") || gender.equals("Ж"))
                break;
            else System.out.println("\u001B[31m"+"Введите пол правильно м или ж"+"\u001B[0m");
        }
        System.out.println("Введите номер телефона сотрудника");
        long contactNumber = addNumberPhone();
        System.out.println("Выберите отдел сотрудника");
        String department = addDepartments();
        String supervizor = addSupervizor(department);
        scanner.nextLine();
        System.out.println("Введите должность сотрудника");
        String position = scanner.nextLine();
        System.out.println("Дата устройства сотрудника");
        GregorianCalendar hireDate = addData();
        System.out.println("Зарплата сотрудника");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        return employee = new Employee(fullName, dateOfBirth, gender, contactNumber, position,department,supervizor, hireDate, salary);
    }

    //метод добавления даты
    public GregorianCalendar addData() {
        GregorianCalendar calendar= new GregorianCalendar();
        System.out.println("Введите год");
        int year = scanner.nextInt();
        System.out.println("Введите месяц");
        int month = scanner.nextInt();
        System.out.println("Введите день");
        int day= scanner.nextInt();
        calendar.set(year,month,day);
        return calendar;
    }


    //Метод добавление отдела
    public String addDepartments(){
        for (int i = 0; i < departments.size(); i++) {
            System.out.println((i + 1) + "." + departments.get(i));
        }
            int choice = scanner.nextInt();
            while (true){
                if(choice<1 || choice>4) {
                    System.out.println("\u001B[31m"+"Выберите существующий отдел"+"\u001B[0m");
                    choice = scanner.nextInt();
                }
                else break;
            }
            String dep = departments.get(choice-1);
            return dep;
        }


    // Метод добавления руководителя
public String addSupervizor(String department) {
    if(department.equals("Юридический"))
        return "Иванова Татьяна Ивановна";
    if(department.equals("Бухгалтерия"))
        return "Сидоренко Татьяна Вячеславовна";
    if(department.equals("Отдел продаж"))
        return "Мышкин Иван Игоревич";
    if(department.equals("Хозяйственный"))
        return "Петров Антон Олегович";
    else return null;

    }


    //Метод добавления номера телефона
    public long addNumberPhone(){
        long contactNumber;
        while (true){
            try {
                contactNumber = scanner.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31m"+"Неверный формат номера"+"\u001B[0m");
                scanner.nextLine();
            }
        }
        return contactNumber;
    }

    public ArrayList<String> departments() {
        return departments;
    }
}


