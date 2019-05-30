package by.learn.optionaltask.action;

import by.learn.optionaltask.entity.Abiturient;
import by.learn.optionaltask.entity.Subject;

import java.util.*;

public class AbiturientAction {
    private static int SATISFACTORY_GRADE = 300;

    public static ArrayList<Abiturient> createAbiturientsList() {
        return new ArrayList<>();
    }

    public static int countTotalGrade(Abiturient abiturient) {
        HashMap<Subject, Integer> grades = abiturient.getGrades();

        int sum = 0;

        for (int i : grades.values()) {
            sum += i;
        }

        return sum;
    }

    public static boolean hasGrade(Abiturient abiturient, int grade) {
        return countTotalGrade(abiturient) >= grade;
    }

    public static boolean hasSatisfactoryGrade(Abiturient abiturient) {
        return hasGrade(abiturient, SATISFACTORY_GRADE);
    }

    public static boolean hasHalfSatisfactoryGrade(Abiturient abiturient) {
        return hasGrade(abiturient, SATISFACTORY_GRADE % 2 == 1 ? SATISFACTORY_GRADE / 2 + 1 : SATISFACTORY_GRADE / 2);
    }

    public static void sortByGrade(ArrayList<Abiturient> abiturients) {
        Collections.sort(abiturients, Comparator.comparingInt(abiturient -> countTotalGrade(abiturient)));
        Collections.reverse(abiturients);
    }

    public static ArrayList<Abiturient> unsatisfactoryAbiturients(ArrayList<Abiturient> abiturients) {
        ArrayList<Abiturient> temp = new ArrayList<>();

        for (Abiturient abiturient : abiturients) {
            if (!hasSatisfactoryGrade(abiturient))
                temp.add(abiturient);
        }
        return temp;
    }

    public static ArrayList<Abiturient> abiturientsWithGrade(ArrayList<Abiturient> abiturients, int grade) {
        ArrayList<Abiturient> temp = new ArrayList<>();

        for (Abiturient abiturient : abiturients) {
            if (hasGrade(abiturient, grade))
                temp.add(abiturient);
        }
        return temp;
    }

    public static ArrayList<Abiturient> halfSatisfactoryAbiturients(ArrayList<Abiturient> abiturients) {
        ArrayList<Abiturient> temp = new ArrayList<>();

        for (Abiturient abiturient : abiturients) {
            if (hasHalfSatisfactoryGrade(abiturient))
                temp.add(abiturient);
        }
        return temp;
    }

    public static int getSatisfactoryGrade() {
        return SATISFACTORY_GRADE;
    }

    public static void setSatisfactoryGrade(int satisfactoryGrade) {
        SATISFACTORY_GRADE = satisfactoryGrade;
    }
}
