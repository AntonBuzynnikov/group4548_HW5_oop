package lesson4.view;

public enum SortType {
    NONE("Сортировка по умолчанию"),
    NAME("Сортировка по имени"),
    ID("Сортировка по айди");

    private final String sortName;

    @Override
    public String toString() {
        return sortName;
    }

    SortType(String sortName) {
        this.sortName = sortName;
    }

    /*    String NONE = "NONE";
    String NAME = "NAME";
    String ID = "ID";*/
}
