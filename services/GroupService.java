package lesson4.services;

import lesson4.models.Student;
import lesson4.models.Teacher;
import lesson4.models.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupService {
    private final UserService<Student> studentService;
    private final UserService<Teacher> teacherService;

    public GroupService(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    public List<User> getAllUsersFromGroup(String groupTitle) {
        List<User> users =
                new ArrayList<>(studentService.getAllByTitile(groupTitle));
        List<User> teach = new ArrayList<>(teacherService.getAll());
        if(teach.size()!= 0)
            users.addAll(teach);

        return  users;
    }
}
