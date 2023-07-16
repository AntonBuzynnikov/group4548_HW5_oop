package lesson4;

import lesson4.controllers.GroupController;
import lesson4.controllers.StudentController;
import lesson4.controllers.TeacherController;
import lesson4.repositories.StudentRepository;
import lesson4.repositories.TeacherRepository;
import lesson4.services.GroupService;
import lesson4.services.StudentService;
import lesson4.services.TeacherService;
import lesson4.view.GroupView;
import lesson4.view.StudentView;
import lesson4.view.TeacherView;

import java.util.Scanner;

public class UniversityApp {
        private static StudentRepository studentRepository;
        private static StudentService studentService;
        private static StudentController studentController;
        private static TeacherRepository teacherRepository;
        private static TeacherService teacherService;
        private static TeacherController teacherController;

    private static Scanner scanner;
    public static void run(){
        StudentView view = getStudentController();
        TeacherView teacherView = getTeacherController();
        GroupView groupView = getGroupView();
        boolean run = true;
        while (run){
            System.out.println(
                    "|=================================================================|");
            System.out.println("|==========================Список " +
                    "команд==========================|");
            System.out.println("|1. Показать список всех студентов " +
                    "\"get-student\"                  |");
            System.out.println("|2. Найти студента по именни " +
                    "\"get-student name\"                   |");
            System.out.println("|3. Показать студентов из группы " +
                    "\"get-group ...\"                  |");
            System.out.println("|4. Добавить студента \"create-student " +
                    "Ivan_Morozov 18 999 11A\"    |");
            System.out.println("|5. Установить группу для студента " +
                    "\"set-group-student-by-id 5 11Б\"|");
            System.out.println("|6. Закрыть приложение \"EXIT\"              " +
                    "                       |");
            System.out.println(
                    "|=================================================================|");
            scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            String[] commandArr = command.split(" ");
            switch (commandArr[0]) {
                case "get-student":
                    if(commandArr.length>1) {
                        try {
                            view.sendStudent(commandArr[1].replace("_", " "));
                        } catch (Exception e) {
                            System.out.println("Введите правильную команду");
                        }
                    }else{
                        view.sendOnConsole();
                    }
                    System.out.println("Нажмите Enter для продолжения");
                    scanner.nextLine();
                    break;
                case "create-student":
                    try{
                        view.create(commandArr[1].replace("_"," "),
                                Integer.parseInt(commandArr[2]),commandArr[3]
                                ,commandArr[4]);

                    } catch (Exception e){
                        System.out.println("Введите правильную команду");
                    }finally {
                        System.out.println("Нажмите Enter для продолжения");
                        scanner.nextLine();
                    }
                    break;
                case "set-group-student-by-id":
                    try{
                        view.edit(Long.parseLong(commandArr[1]),commandArr[2]);
                    }catch (Exception e){
                        System.out.println("Введите правильную команду");
                    }finally {
                        System.out.println("Нажмите Enter для продожения");
                        scanner.nextLine();
                    }
                    break;
                case "get-group":
                    try {
                        groupView.printAllFromGroup(commandArr[1]);
                    }catch (Exception e){
                        System.out.println("Введите правильную команду");
                    }finally {
                        System.out.println("Нажмите Enter для продолжения");
                        scanner.nextLine();
                    }
                    break;
                case "EXIT":
                    run = false;
                    scanner.close();
                    break;

            }
        }
    }
        private static StudentView getStudentController() {
            studentRepository = new StudentRepository();
            studentService = new StudentService(studentRepository);
            studentController = new StudentController(studentService);
            return new StudentView(studentController);
        }
        private static TeacherView getTeacherController(){
            teacherRepository = new TeacherRepository();
            teacherService = new TeacherService(teacherRepository);
            teacherController = new TeacherController(teacherService);
            return new TeacherView(teacherController);
        }

        private static GroupView getGroupView() {
            GroupService groupService = new GroupService(studentService, teacherService);
            GroupController groupController = new GroupController(groupService);
            return new GroupView(groupController);
        }
}
