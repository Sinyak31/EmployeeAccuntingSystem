import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;


public class Reporting {

    EmployeeRegistration reg = new EmployeeRegistration();

//Метод отчета общий
    public void generalReporing(ArrayList<Employee> emp, ArrayList<String> departments) throws IOException {
        reportingOfOrganization(emp, departments);
        System.out.println();
        reportingOfDepartments(emp, departments);
        System.out.println();
        System.out.println("Список лидеров по Зарплате в организации");
        topEmployees(emp);
    }

    //Отчет по организации
    public void reportingOfOrganization(ArrayList<Employee> emp, ArrayList<String> departments) throws IOException {
        String fileName = "Reporting.txt";
        FileWriter fw = new FileWriter(fileName, false);
        int countSalary = 0;
        System.out.println("В организации " + departments.size() + " отделов");
        fw.write("В организации " + departments.size() + " отделов");
        fw.write("\n");
        for (int i = 0; i < departments.size(); i++) {
            System.out.println((i + 1) + " " + departments.get(i));
            fw.write((i + 1) + " " + departments.get(i));
            fw.write("\n");
        }
        System.out.println("\nВсего в организации работает " + emp.size() + " людей");
        fw.write("\nВсего в организации работает " + emp.size() + " людей");
        fw.write("\n");
        for (int i = 0; i < emp.size(); i++) {
            countSalary += emp.get(i).getSalary();
        }
        System.out.println("\nСредняя зарплата по всей организации: " + (countSalary / emp.size()));
        fw.write("\nСредняя зарплата по всей организации: " + (countSalary / emp.size()));
        fw.write("\n");
        fw.close();
    }


    //Отчет по отделам
    public void reportingOfDepartments(ArrayList<Employee> emp, ArrayList<String> departments) throws IOException {
        String fileName = "Reporting.txt";
        FileWriter fw = new FileWriter(fileName, true);
        GregorianCalendar cal = new GregorianCalendar();
        int countEmployees = 0;
        int countSalary = 0;
        long presentTime = cal.getTimeInMillis();
        long maxYear = 0;
        int numberMaxYear = -1;
        for (int i = 0; i < departments.size(); i++) {
            countEmployees=0;
            countSalary=0;
            System.out.println((i + 1) + ". " + departments.get(i));
            fw.write("\n"+(i + 1) + " " + departments.get(i));
            System.out.println("\nРуководитель отдела: " + reg.addSupervizor(departments.get(i)));
            fw.write("Руководитель отдела: " + reg.addSupervizor(departments.get(i))+"\n");

            for (int j = 0; j < emp.size(); j++) {
                if (emp.get(j).getDepartment().equals(departments.get(i))) {
                    countEmployees++;
                    countSalary += emp.get(j).getSalary();
                    if ((presentTime-emp.get(j).getHireDate().getTimeInMillis()) > maxYear) {
                        maxYear = presentTime-emp.get(j).getHireDate().getTimeInMillis();
                        numberMaxYear = j;
                    }


                }


            }
            System.out.println("В отделе " + countEmployees + " человек");
            fw.write("В отделе " + countEmployees + " человек"+"\n");
            System.out.println("Средняя зарплата по отделу " + (countSalary/emp.size()) + " .руб");
            fw.write("\nСредняя зарплата по отделу " + countSalary + " .руб"+"\n");
            System.out.println("Дольше всего в отделе работает:" + emp.get(numberMaxYear).getFullName() + " "
                    + (maxYear / 31536000000l) + " лет\n");
            fw.write("Дольше всего в отделе работает:" + emp.get(numberMaxYear).getFullName() + " "
                    + (maxYear / 31536000000l) + " лет"+"\n");
        }
        fw.close();
    }

    //Метод который выводит лучших в организации по зп
    public void topEmployees(ArrayList<Employee> employees) {
        ArrayList<Employee> topEmployees = new ArrayList<>(employees);
        topEmployees.sort((p1, p2) -> (int) (p1.getSalary() - p2.getSalary()));
        Collections.reverse(topEmployees);
        for (int i = 0; i < topEmployees.size(); i++) {
            System.out.println((i + 1) +"\nФИО:"+ topEmployees.get(i).getFullName() + "\nДолжность: " + topEmployees.get(i).getPosition()
                    + "\nОтдел"+topEmployees.get(i).getDepartment()+"\nЗарплата"+topEmployees.get(i).getSalary());
            System.out.println();
            if(i==9)
                break;

        }
    }
}




