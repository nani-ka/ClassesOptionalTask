package by.learn.optionaltask.entity;

import by.learn.optionaltask.action.AbiturientAction;
import by.learn.optionaltask.action.IdGenerator;

import java.util.HashMap;

public class Abiturient {

    private int id;
    private String surname;
    private String name;
    private String patronymic = "";
    private String address = "";
    private String phoneNumber = "";
    private HashMap<Subject, Integer> grades;

    public Abiturient(String surname, String name) {
        this.id = IdGenerator.generateId();
        this.surname = surname;
        this.name = name;
        grades = new HashMap<>();
        for (Subject subject : Subject.values()) {
            grades.put(subject, 0);
        }
    }

    public Abiturient(String surname, String name, String patronymic) {
        this(surname, name);
        this.patronymic = patronymic;
    }

    public Abiturient(String surname, String name, String address, String phoneNumber) {
        this(surname, name);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Abiturient(String surname, String name, String patronymic, String address, String phoneNumber) {
        this(surname, name, address, phoneNumber);
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public HashMap<Subject, Integer> getGrades() {
        return grades;
    }

    public void setGrade(Subject subject, int grade) {
        grades.put(subject, grade);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("ID %d, %s %s %s\n", id, surname, name, patronymic));
        sb.append("Address: " + address + "\n");
        sb.append("Phone number: " + phoneNumber + "\n");
        sb.append("Grades:\n");

        sb.append("    Mathematis - " + grades.get(Subject.MATHEMATICS) + "\n");
        sb.append("    Computer Science - " + grades.get(Subject.COMPUTER_SCIENCE) + "\n");
        sb.append("    Physics - " + grades.get(Subject.PHYSICS) + "\n");
        sb.append("    English - " + grades.get(Subject.ENGLISH) + "\n");
        sb.append("Total grade: " + AbiturientAction.countTotalGrade(this) + "\n");

        return sb.toString();
    }
}
