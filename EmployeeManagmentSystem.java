import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class EmployeeManagmentSystem {
    Scanner scanner = new Scanner(System.in);
    public ArrayList<Employee> employees = new ArrayList<>();// Список сотрудников
    private String loginManager = "admin"; // Логин входа в систему учета
    private int passwordManger = 123456; // Пароль для входа в систему учета
    private Employee employee;
    private EmployeeRegistration employeeRegistration = new EmployeeRegistration();
    private Serch searchEmployee = new Serch();
    private Reporting reporting = new Reporting();


   //Метод для входа по логину
    public boolean logToInProgram() {
        System.out.println("Введите логин");
        if (!scanner.nextLine().equals(loginManager)) {
            System.out.println("\u001B[31m"+"Неверный логин"+"\u001B[0m");
            return false;
        } else {
            System.out.println("Введите пароль");
            if (scanner.nextInt() == passwordManger) {
                scanner.nextLine();
                return true;
            }
            else {
                System.out.println("\u001B[31m"+"Неверный пароль"+"\u001B[0m");
                scanner.nextLine();
                return false;
            }
        }
    }


    //Метод добавления сотрудника
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }


    //Метод увольнения сотрудника
    public void removeEmployee() {
        System.out.println("Выберите сотрудника для увольнения ");
        listOfEmployees();
        int numEmployee = scanner.nextInt();//numEmployee-порядковый номер сотрудника в списке, для увольнения
        fullInformationEmployee(numEmployee - 1); // Вывод полной информации об увольняемом сотруднике
        System.out.println("1.Уволить✅            " + "2.Не увольнять❌");
        switch (scanner.nextInt()) {
            case 1:
                employees.remove(numEmployee - 1);
                System.out.println("Сотрудник уволен");
                break;
            case 2:
                removeEmployee();
                break;
        }
    }


    //Метод выводит полную информации об увольняемом сотруднике
    private void fullInformationEmployee(int numEmployee) {
        System.out.println("---Информация о работнике---" +
                "\n1. ФИО: " + employees.get(numEmployee).getFullName() +
                "\n2. Дата рождения: " + employees.get(numEmployee).getDateOfBirth().get(GregorianCalendar.DAY_OF_MONTH) +"."+
                        employees.get(numEmployee).getDateOfBirth().get(GregorianCalendar.MONTH)+"."+
                        employees.get(numEmployee).getDateOfBirth().get(GregorianCalendar.YEAR)+
                "\n3. Пол: " + employees.get(numEmployee).getGender() +
                "\n4. Номер телефона: " + employees.get(numEmployee).getContactNumber() +
                "\n5. Должность: " + employees.get(numEmployee).getPosition() +
                "\n6. Отдел: " + employees.get(numEmployee).getDepartment() +
                "\n7. Руководитель: " + employees.get(numEmployee).getSupervisor() +
                "\n8. Дата приема: " + employees.get(numEmployee).getHireDate().get(GregorianCalendar.DAY_OF_MONTH) +"."+
                employees.get(numEmployee).getHireDate().get(GregorianCalendar.MONTH)+"."+
                employees.get(numEmployee).getHireDate().get(GregorianCalendar.YEAR)+
                "\n9. Зарплата: " + employees.get(numEmployee).getSalary());
    }

    // Информация о сотрудниках
    public void InformationEmployee() {
        if (employees.isEmpty())
            System.out.println("\u001B[31m"+"В штате еще нет сотрудников"+"\u001B[0m");
        else {
            listOfEmployees();
            System.out.println("Для полной информации, выберите номер сотрудника");
            int numEmployee = scanner.nextInt();

            fullInformationEmployee(numEmployee - 1);
        }
    }


    // Список сотрудников
    public void listOfEmployees() {
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + "." + "\nФИО: " + employees.get(i).getFullName() + "\nДата рождения: " +
                    employees.get(i).getDateOfBirth().get(GregorianCalendar.DAY_OF_MONTH) +"."+
                    employees.get(i).getDateOfBirth().get(GregorianCalendar.MONTH)+"."+
                    employees.get(i).getDateOfBirth().get(GregorianCalendar.YEAR)+
                    "\nДолжность: " + employees.get(i).getPosition());
        }
    }


    // Метод изменения информации о сотруднике
    public void changingEmployeeInformation() {
        System.out.println("Для изменения информации о сотруднике, введите номер сотрудника");
        listOfEmployees();// Метод выводит список сотрудников
        int numEmployee = scanner.nextInt() - 1;//numEmployee-порядковый номер сотрудника
        fullInformationEmployee(numEmployee); // Вывод полной информации о сотруднике
        System.out.println("10. Выход в главное меню");
        System.out.println("Выберите раздел для изменения информации");
        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("Введите ФИО сотрудника");
                    employees.get(numEmployee).setFullName(scanner.nextLine());// Вызываем сеттер ФИО выбранного сотрудника
                }
                case 2 -> {
                    System.out.println("Введите дату рождения в формате (25.02.1993)");
                    //Выбираем сетор Даты рождения выбранного сотрудника и передаем в параметр метод возвращающий Дату
                    employees.get(numEmployee).setDateOfBirth(employeeRegistration.addData());
                }
                case 3 -> {
                    System.out.println("Введите пол сотрудника");
                    String gender;
                    while (true) {
                        gender = scanner.nextLine();
                        if (gender.equals("М") || gender.equals("Ж"))
                            break;
                        else System.out.println("\u001B[31m"+"Введите пол правильно М или Ж"+"\u001B[0m");
                    }
                    employees.get(numEmployee).setGender(gender);

                }
                case 4 -> {
                    System.out.println("Введите номер телефона сотрудника");
                    employees.get(numEmployee).setContactNumber(scanner.nextInt());
                }
                case 5 -> {
                    System.out.println("Введите должность сотрудника");
                    employees.get(numEmployee).setPosition(scanner.nextLine());
                }
                case 6 -> {
                    System.out.println("Введите отдел сотрудника");
                    employees.get(numEmployee).setDepartment(scanner.nextLine());
                }
                case 7 -> {
                    System.out.println("Введите непосредственного руководителя");
                    employees.get(numEmployee).setSupervisor(scanner.nextLine());
                }
                case 8 -> {
                    System.out.println("Дата устройства сотрудника");
                    employees.get(numEmployee).setHireDate(employeeRegistration.addData());
                }
                case 9 -> {
                    System.out.println("Зарплата сотрудника");
                    employees.get(numEmployee).setSalary(scanner.nextDouble());
                }
                case 10 -> {
                    System.out.println("Выход в главное меню");
                    return;
                }
                default -> {
                }
            }
            fullInformationEmployee(numEmployee); // Вывод полной информации о сотруднике
            System.out.println("10. Выход в главное меню");
            System.out.println("Выберите раздел для изменения информации");
        }

    }

    public void search() {
        ArrayList<Employee> searchEmp = searchEmployee.serchEmploye(employees);
        if (searchEmp.isEmpty())
            System.out.println("\u001B[31m"+"Сотрудники по заданным параметрам не работают"+"\u001B[0m");
        else {
            for (int i = 0; i < searchEmp.size(); i++) {
                System.out.println((i + 1) + "." + "\nФИО: " + searchEmp.get(i).getFullName() + "\nДата рождения: " +
                        searchEmp.get(i).getDateOfBirth() +
                        "\nДолжность: " + searchEmp.get(i).getPosition());
            }
            System.out.println("Для полной информации, выберите номер сотрудника или наберите Exit для выхода в главное меню");
            String choice = scanner.nextLine();
           while (true){
            try{
            if (choice.equals("Exit"))
                break;
            else {
                int numEmployee = Integer.parseInt(choice);
                fullInformationEmployee(numEmployee - 1);
                break;
            }
            }catch (NumberFormatException e) {
                System.out.println("Для полной информации, выберите номер сотрудника или наберите Exit для выхода в главное меню");
                choice = scanner.nextLine();
            }
            }
        }
    }


    //Метод информации об организации
    public void reportingOrganization(ArrayList<String>departments) throws IOException {

        reporting.generalReporing(employees,departments);
    }


}


