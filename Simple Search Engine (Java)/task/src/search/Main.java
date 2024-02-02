package search;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    private static String exit = "1";
 //   private static int option_selected = -1;

    public static void main(String[] args) {

        Map<String, ArrayList<Integer>> word_to_line_number = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        String input_file_name = null;
        for(int i=0; i< args.length; i=i+2){
            if(args[i].equals("--data")){
                input_file_name = args[i+1];
            }
        }

        ArrayList<String> list_of_people = new ArrayList<>();

        try {
            String content = new String(Files. readAllBytes(Paths. get(input_file_name)));
            String[] all_people = content.split("\n");

            for(int i=0; i<all_people.length; i++){
                list_of_people.add(all_people[i]);

                String[] each_word = all_people[i].split(" ");

                for(String word: each_word){
                    if(word_to_line_number.get(word.toLowerCase()) == null){
                        word_to_line_number.put(word.toLowerCase(), new ArrayList<>());
                    }
                    word_to_line_number.get(word.toLowerCase()).add(i);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(!exit.equals("0")){

            System.out.println("=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");

//            while(true){
//                try{
//                    option_selected = sc.nextInt();
//                    break;
//                }
//                catch(InputMismatchException e){
//                    System.out.print("Please enter number among 0,1,2: ");
//                    continue;
//                }
//            }
            int option_selected = sc.nextInt();
            sc.nextLine();

            if(option_selected >= 3 || option_selected<0){
                System.out.println("Incorrect option! Try again.");
                continue;
            }else if(option_selected == 1){
                System.out.println("Select a matching strategy: ALL, ANY, NONE");

                String strategy_selected = sc.nextLine();

//                if(strategy_selected.equals("ALL")){
//                  //  find_all(list_of_people, sc, word_to_line_number, strategy_selected);
//                    find_all(list_of_people, sc, word_to_line_number);
//                }else if(strategy_selected.equals("ANY")){
//                    find_any(list_of_people, sc, word_to_line_number);
//                }else if(strategy_selected.equals("NONE")){
//                    find_none(list_of_people, sc, word_to_line_number);
//                }
                //find_person(list_of_people, sc, word_to_line_number);
               // find_a_person(list_of_people, sc);

                ComputeSearch computeSearch;
                if(strategy_selected.equals("ALL")){
                    computeSearch = new AllWords();
                    computeSearch.find("ALL", list_of_people, sc, word_to_line_number);
                }else if(strategy_selected.equals("ANY")){
                    computeSearch = new AnyOrNoneWords();
                    computeSearch.find("ANY", list_of_people, sc, word_to_line_number);
                }else{
                    computeSearch = new AnyOrNoneWords();
                    computeSearch.find("NONE", list_of_people, sc, word_to_line_number);
                }
            }else if(option_selected == 2){
                print_all_people(list_of_people);
            }else{
                System.out.println("Bye!");
                exit = "0";
            }
        }

    }

//    private static void find_none(ArrayList<String> listOfPeople, Scanner sc, Map<String, ArrayList<Integer>> wordToLineNumber) {
//
//        int total_people = listOfPeople.size();
//
//        HashSet<Integer> setOfLines = new HashSet<>();
//
//        System.out.println("Enter a name or email to search all suitable people.");
//        String wordsToSearch = sc.nextLine();
//
//        String[] listOfWordsToSearch = wordsToSearch.split(" ");
//
//        for(String word_to_search: listOfWordsToSearch){
//            if(wordToLineNumber.get(word_to_search.toLowerCase()) != null){
//                List<Integer> list_of_line_no_having_word = wordToLineNumber.get(word_to_search.toLowerCase());
//                for(int line_number: list_of_line_no_having_word){
//                    setOfLines.add(line_number);
//                }
//            }
//        }
//
//        for(int i=0; i<total_people; i++){
//            if(!setOfLines.contains(i)){
//                System.out.println(listOfPeople.get(i));
//            }
//        }
//
//    }

//    private static void find_any(ArrayList<String> listOfPeople, Scanner sc, Map<String, ArrayList<Integer>> wordToLineNumber) {
//
//        HashSet<Integer> setOfLines = new HashSet<>();
//
//        System.out.println("Enter a name or email to search all suitable people.");
//        String wordsToSearch = sc.nextLine();
//
//        String[] listOfWordsToSearch = wordsToSearch.split(" ");
//
//        for(String word_to_search: listOfWordsToSearch){
//            if(wordToLineNumber.get(word_to_search.toLowerCase()) != null){
//                List<Integer> list_of_line_no_having_word = wordToLineNumber.get(word_to_search.toLowerCase());
//                for(int line_number: list_of_line_no_having_word){
//                    setOfLines.add(line_number);
//                }
//            }
//        }
//        if(setOfLines.size() == 0){
//            System.out.println("No matching people found");
//            return;
//        }
//        for(int lineNumber: setOfLines){
//            System.out.println(listOfPeople.get(lineNumber));
//        }
//    }



//    private static void find_all(ArrayList<String> listOfPeople, Scanner sc, Map<String, ArrayList<Integer>> wordToLineNumber, String strategy_selected) {
//
//        String[] arr = strategy_selected.split(" ");
//        for(String str: arr){
//            find_all_sub(listOfPeople, sc, wordToLineNumber);
//        }
//        HashSet<String> h = new HashSet<>();
//
//
//    }

//    private static void find_all(ArrayList<String> listOfPeople, Scanner sc, Map<String, ArrayList<Integer>> wordToLineNumber) {
//
//        HashMap<Integer, Integer> setOfLines = new HashMap<>();
//
//        System.out.println("Enter a name or email to search all suitable people.");
//        String wordsToSearch = sc.nextLine();
//
//        String[] listOfWordsToSearch = wordsToSearch.split(" ");
//
//        int total_word = listOfWordsToSearch.length;
//
//        for(String word_to_search: listOfWordsToSearch){
//            if(wordToLineNumber.get(word_to_search.toLowerCase()) == null){
//                System.out.println("No matching people found");
//                return;
//            }
//            List<Integer> list_of_line_no_having_word = wordToLineNumber.get(word_to_search.toLowerCase());
//            for(int line_number: list_of_line_no_having_word){
//                if(setOfLines.get(line_number) == null){
//                    setOfLines.put(line_number, 1);
//                }else{
//                    int x = setOfLines.get(line_number);
//                    setOfLines.put(line_number, x+1);
//                }
//            }
//        }
//
//        for(int key: setOfLines.keySet()){
//            int numberOfOccurrence = setOfLines.get(key);
//            if(numberOfOccurrence == total_word)System.out.println(listOfPeople.get(key));
//        }
//    }

    private static void print_all_people(ArrayList<String> list_of_people) {

        for(String one_person_detail: list_of_people){
            System.out.println(one_person_detail);
        }

    }

    // Here searching is done using HashMap
    private static void find_person(ArrayList<String> list_of_people, Scanner sc, Map<String, ArrayList<Integer>> word_to_line_number) {
        System.out.println("Enter a name or email to search all suitable people.");
        String word_to_search = sc.next();
        String check = sc.nextLine();
        if(check != ""){
            System.out.println("No matching people found");
        }

        if(word_to_line_number.get(word_to_search) == null){
            System.out.println("No matching people found");
            return;
        }
        List<Integer> list_of_line_no_having_word = word_to_line_number.get(word_to_search);
        for(int line_number: list_of_line_no_having_word){
            System.out.println(list_of_people.get(line_number));
        }
    }

    // Here searching is done through array list
    private static void find_a_person(ArrayList<String> list_of_people, Scanner sc) {
        System.out.println("Enter a name or email to search all suitable people.");
        String data = sc.next();
        String check = sc.nextLine();
        if(check != ""){
            System.out.println("No matching people found");
        }

        search(list_of_people, data.toLowerCase());
    }

    private static void search(ArrayList<String> details, String data){

        boolean first = true;
        for(String one_person_detail: details){
            String[] arr = one_person_detail.split(" ");
            for(int j=0; j<arr.length; j++){
                if(find(arr[j].toLowerCase(), data)){
                    first = false;
                    System.out.println(one_person_detail);
                    break;
                }
            }
        }
        if(first) System.out.println("No matching people found");
    }

    public static boolean find(String word, String word_to_search){
        int i=0, j=0;
        while(i<word.length()){
            int k=i;
            while(k<word.length() && j<word_to_search.length() && word.charAt(k) == word_to_search.charAt(j)){
                k++;
                j++;
            }
            if(j == word_to_search.length()){
                return true;
            }else{
                j=0;
                i++;
            }
        }
        return false;
    }
}
