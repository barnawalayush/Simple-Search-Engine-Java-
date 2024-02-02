package search.Strategy;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public interface FindStrategy {

    void find(String strategy, ArrayList<String> listOfPeople, Scanner sc, Map<String, ArrayList<Integer>> wordToLineNumber);

}
