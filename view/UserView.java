package lesson4.view;

public interface UserView {
    void sendOnConsole(); //GET
    void sendOnConsole(SortType sortType); //GET
    void create(String fullName, Integer age, String phoneNumber, String groupTitle);//POST
    void removeUser(String fullName); //DELETE
    void sendStudent(String fullName);
    void edit(Long ID, String group);

}
