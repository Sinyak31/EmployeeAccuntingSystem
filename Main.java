import java.io.IOException;
import java.sql.SQLOutput;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        EmployeeManagmentSystem em =  new EmployeeManagmentSystem();
        EmployeeRegistration e = new EmployeeRegistration();
        e.departments.add("Юридический");
        e.departments.add("Бухгалтерия");
        e.departments.add("Отдел продаж");
        e.departments.add("Хозяйственный");
        em.addEmployee(new Employee("Петров Иван Олегович",new GregorianCalendar(1993,3,12),"М", 89176123456L,
                "Помощник Юриста","Юридический","Иванова Татьяна Ивановна",new GregorianCalendar(2020,2,3),25000));
        em.addEmployee(new Employee("Бананов Антон Дмитриевич",new GregorianCalendar(1982,2,10),"М",89126133456l,
                "Юрист","Юридический","Иванова Татьяна Ивановна",new GregorianCalendar(2021,4,4),51000));
        em.addEmployee(new Employee("Сидорова Дарья Андреевна",new GregorianCalendar(1983,11,11),"Ж",89176113456l,
                "Менеджер","Отдел продаж","Мышкин Иван Игоревич",new GregorianCalendar(1999,10,22),30000));

        em.addEmployee(new Employee("Носов Игорь Петрович",new GregorianCalendar(2000,1,9),"М",89176123856l,
                "Уборщик","Хозяйственный","Петров Антон Олегович",new GregorianCalendar(2022,28,8),21000));

        em.addEmployee(new Employee("Цветаева Мария Сергеевна",new GregorianCalendar(1975,1,5),"Ж",89176123256l,
                "Бухгалтер","Бухгалтерия","Сидоренко Татьяна Вячеславовна",new GregorianCalendar(1995,02,25),90000));

        em.addEmployee(new Employee("Велосипедов Максим Анатольевич",new GregorianCalendar(1983,2,12),"М",89164123456l,
                "Юрист","Юридический","Иванова Татьяна Ивановна",new GregorianCalendar(2019,2,2),70000));

        em.addEmployee(new Employee("Ляпина Людмила Васильевна",new GregorianCalendar(1991,6,5),"Ж",89176123856l,
                "Уборщик складских помещений","Хозяйственный","Петров Антон Олегович",new GregorianCalendar(2011,22,7),21000));

        em.addEmployee(new Employee("Ларин Игорь Максимович",new GregorianCalendar(1992,12,2),"М",89176443456l,
                "Юрист","Юридический","Иванова Татьяна Ивановна",new GregorianCalendar(2023,6,2),76859));

        em.addEmployee(new Employee("Петров Иван Олегович",new GregorianCalendar(1993,3,12),"М",89176199456l,
                "Юрист","Юридический","Иванова Татьяна Ивановна",new GregorianCalendar(2021,4,4),98765));

        em.addEmployee(new Employee("Петров Иван Олегович",new GregorianCalendar(1993,3,12),"М",89176123456l,
                "Юрист","Юридический","Иванова Татьяна Ивановна",new GregorianCalendar(2021,4,4),98297));

        em.addEmployee(new Employee("Петров Иван Олегович",new GregorianCalendar(1993,3,12),"М",89176123459l,
                "Юрист","Юридический","Иванова Татьяна Ивановна",new GregorianCalendar(2021,4,4),23541));

        em.addEmployee(new Employee("Петров Иван Олегович",new GregorianCalendar(1993,3,12),"М",89175123446l,
                "Юрист","Юридический","Иванова Татьяна Ивановна",new GregorianCalendar(2021,4,4),90900));

        em.addEmployee(new Employee("Петров Иван Олегович",new GregorianCalendar(1993,3,12),"М",89176123676l,
                "Юрист","Юридический","Иванова Татьяна Ивановна",new GregorianCalendar(2021,4,4),42422));
        boolean bool = true;
       int choice;






       while (true) {
           if (em.logToInProgram())
               break;
       }
       while (bool){
        System.out.println("  ---Основное меню---");
        System.out.println("""
                    ❶Информация о сотрудниках
                    ❷Добавление нового сотрудника
                    ❸Увольнение сотрудника
                    ❹Редактирование информации о сотруднике
                    ❺Поиск сотрудников
                    ❻Информация об организации
                    ❼Выход
                    \s""");
        choice=scanner.nextInt();
        scanner.nextLine();
           if (choice == 1) {
               em.InformationEmployee();
           } else if (choice == 2) {
               em.addEmployee(e.registration());
           } else if (choice == 3) {
               em.removeEmployee();
           } else if (choice == 4) {
               em.changingEmployeeInformation();
           } else if (choice == 5) {
               em.search();
           } else if (choice == 6) {
               em.reportingOrganization(e.departments);
           } else if (choice == 7) {
               bool = false;
           } else {
               throw new IllegalStateException("Unexpected value: " + choice);
           }

        }



    }
}