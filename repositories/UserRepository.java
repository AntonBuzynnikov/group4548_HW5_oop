package lesson4.repositories;

import lesson4.models.Student;
import lesson4.models.Teacher;
import lesson4.models.User;

import java.util.List;

public interface UserRepository <T extends User> {
    void create(T user);

    List<T> getAll();

    int remove(String fullName);

    List<T> getAllByGroupTitle(String groupTitle);
    String getStudentName(String fullName);
    void edit(Long ID, String group);
}
