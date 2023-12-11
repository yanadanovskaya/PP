package Parsing;

import java.util.ArrayList;

public class Singleton {

    private static Singleton instance;
    public static ArrayList<Double> Data;

    private Singleton(ArrayList<Double> resultList){
        Data = resultList;
    }

    public static Singleton getInstance(ArrayList<Double> resultList) {
        if(instance == null) {
            instance = new Singleton(resultList);
        }
        return instance;
    }

}
