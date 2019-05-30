package by.learn.optionaltask.main;

import by.learn.optionaltask.action.AbiturientAction;
import by.learn.optionaltask.entity.Abiturient;
import by.learn.optionaltask.entity.Subject;
import by.learn.optionaltask.reporter.Reporter;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Abiturient abiturient1 = new Abiturient("Artykbayev", "Abay",
                "Random address 1", "87059110434");
        abiturient1.setGrade(Subject.MATHEMATICS, 100);
        abiturient1.setGrade(Subject.COMPUTER_SCIENCE, 100);
        abiturient1.setGrade(Subject.PHYSICS, 100);
        abiturient1.setGrade(Subject.ENGLISH, 100);

        Abiturient abiturient2 = new Abiturient("Ivanov", "Ivan",
                "Ivanovich", "Random address 2", "8-777-555-44-44");
        abiturient2.setGrade(Subject.MATHEMATICS, 45);
        abiturient2.setGrade(Subject.PHYSICS, 36);
        abiturient2.setGrade(Subject.ENGLISH, 65);
        abiturient2.setGrade(Subject.COMPUTER_SCIENCE, 35);

        Abiturient abiturient3 = new Abiturient("RandomSurname", "RandomForest");
        abiturient3.setGrade(Subject.MATHEMATICS, 10);
        abiturient3.setGrade(Subject.PHYSICS, 20);
        abiturient3.setGrade(Subject.ENGLISH, 15);
        abiturient3.setGrade(Subject.COMPUTER_SCIENCE, 32);

        Abiturient abiturient4 = new Abiturient("Support", "Vector",
                "Machine");
        abiturient4.setGrade(Subject.MATHEMATICS, 100);
        abiturient4.setGrade(Subject.PHYSICS, 98);
        abiturient4.setGrade(Subject.ENGLISH, 100);
        abiturient4.setGrade(Subject.COMPUTER_SCIENCE, 94);

        ArrayList<Abiturient> abiturients = AbiturientAction.createAbiturientsList();

        abiturients.add(abiturient1);
        abiturients.add(abiturient2);
        abiturients.add(abiturient3);
        abiturients.add(abiturient4);


        System.out.println("Abiturinets:\n");
        Reporter.printAbiturients(abiturients);

        System.out.println("\nCписок абитуриентов, имеющих неудовлетворительные оценки:");
        Reporter.printAbiturients(AbiturientAction.unsatisfactoryAbiturients(abiturients));

        System.out.println("\nCписок абитуриентов, у которых сумма баллов выше заданной:");
        int k = 380;
        System.out.println("Заданная сумма баллов: " + k + "\n");
        Reporter.printAbiturients(AbiturientAction.abiturientsWithGrade(abiturients, k));


        System.out.println("\nВыбрать заданное число n абитуриентов, имеющих самую высокую сумму баллов");
        int n = 3;
        AbiturientAction.sortByGrade(abiturients);
        Reporter.printAbiturients(abiturients, n);


        System.out.println("\nВывести также полный список абитуриентов, имеющих полупроходную сумму");
        Reporter.printAbiturients(AbiturientAction.halfSatisfactoryAbiturients(abiturients));
    }
}
