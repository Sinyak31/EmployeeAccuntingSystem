import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


//Метод поиска сотрудников(общий)
public class Serch {
    Scanner scanner = new Scanner(System.in);

    public ArrayList<Employee> serchEmploye(ArrayList<Employee> employee) {
        System.out.println("Выберите");
        System.out.println("""
                ❶Поиск по фио
                ❷Поиск по номеру телефона
                ❸Поиск по должности
                ❹Главное меню
                \s""");
        int choice = scanner.nextInt();
        while (true) {
            try {
                if (choice > 5 || choice < 1) {
                    throw new InputMismatchException();
                } else {
                    scanner.nextLine();
                    break;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("\u001B[31m" + "Введите верное значение\n" + "\u001B[0m");
                System.out.println("""
                        ❶Поиск по фио
                        ❷Поиск по номеру телефона
                        ❸Поиск по должности
                        ❹Главное меню
                        \s""");
            }
        }
        switch (choice) {
            case 1 -> {
                return searchByFullName(employee);
            }
            case 2 -> {
                return serchTelephoneNumber(employee);
            }
            case 3 -> {
                return searchByPosition(employee);

            }
            case 4 -> {
                break;
            }
        }
        return new ArrayList<>();
    }


    //Метод поиска по ФИО
    public ArrayList<Employee> searchByFullName(ArrayList<Employee> emp) {
        ArrayList<Employee> e = new ArrayList<>();
        System.out.println("Введите ФИО сотрудника");
        String searchFullName = scanner.nextLine();
        for (int i = 0; i < emp.size(); i++) {
            if (emp.get(i).getFullName().contains(searchFullName)) {
                e.add(emp.get(i));
            }
        }
        return e;
    }


    //Метод поиска по номеру телефона
    public ArrayList<Employee> serchTelephoneNumber(ArrayList<Employee> emp) {
        ArrayList<Employee> e = new ArrayList<>();
        System.out.println("Введите номер телефона сотрудника сотрудника");
        long searchPhoneNumber;
        while (true){
            try {
                searchPhoneNumber = scanner.nextLong();
                break;
            } catch (InputMismatchException ex) {
                System.out.println("\u001B[31m"+"Неверный формат номера"+"\u001B[0m");
                scanner.nextLine();
            }
        }
        for (Employee employee : emp) {
            if (employee.getContactNumber() == searchPhoneNumber)
                e.add(employee);

        }
        return e;
    }


        //Метод поиска по должности
        public ArrayList<Employee> searchByPosition (ArrayList < Employee > emp) {
            ArrayList<Employee> e = new ArrayList<>();
            System.out.println("Введите должность сотрудника");
            String searchPosition = scanner.nextLine();
            for (Employee employee : emp) {
                if (employee.getPosition().equals(searchPosition))
                    e.add(employee);
            }
            return e;
        }
    }

