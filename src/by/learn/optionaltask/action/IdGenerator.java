package by.learn.optionaltask.action;

public class IdGenerator {
    private static int id = 1000;

    public static int generateId() {
        return ++id;
    }



}
