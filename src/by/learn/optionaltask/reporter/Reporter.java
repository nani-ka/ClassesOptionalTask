package by.learn.optionaltask.reporter;

import by.learn.optionaltask.entity.Abiturient;

import java.util.ArrayList;

public class Reporter {

    public static void printAbiturients(ArrayList<Abiturient> abiturients){
        for(Abiturient abiturient : abiturients){
            System.out.println(abiturient);
        }
    }

    public static void printAbiturients(ArrayList<Abiturient> abiturients, int n){
        for (int i = 0; i < n; ++i) {
            System.out.println(abiturients.get(i));
        }
    }

}
