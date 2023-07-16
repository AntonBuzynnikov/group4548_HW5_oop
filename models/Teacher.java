package lesson4.models;

public class Teacher extends User {
    public Teacher(String fullName, Integer age, String phoneNumber, String groupTitle) {
        super(fullName, age, phoneNumber, groupTitle);
    }

    @Override
    public String toString() {
        return String.format("Преподаватель имеет следующие свойства: id: %s, name %s, age %s, phone number %s, groupTitle %s",
                getId(),
                getFullName(), getAge(), getPhoneNumber(), getGroupTitle());
    }
}
