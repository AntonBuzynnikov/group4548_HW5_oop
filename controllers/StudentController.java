package lesson4.controllers;

import lesson4.models.Student;
import lesson4.services.UserService;

import java.util.List;

public class StudentController implements UserController<Student> {

    private final UserService<Student> userService;

    public StudentController(UserService<Student> userService) {
        this.userService = userService;
    }

    //@PostMethod("/students")
    @Override
    public void create(String fullName, Integer age, String phoneNumber, String groupTitle) {
        userService.create(fullName, age, phoneNumber, groupTitle);
    }

    //@GetMethod("/students")
    @Override
    public List<Student> getAll() {
        return userService.getAll();
    }

    //@DeleteMethod("/students")
    @Override
    public int remove(String fullName) {
        return userService.remove(fullName);
    }

    @Override
    public List<Student> getAllSortByFullName() {
        return userService.getAllSortByFullName();
    }

    @Override
    public List<Student> getAllSortById() {
        return userService.getAllSortById();

    }
    @Override
    public String getStudent(String fullName){
        return userService.getStudentName(fullName);
    }


    @Override
    public void edit(Long ID, String group) {
        userService.edit(ID, group);
    }

}
