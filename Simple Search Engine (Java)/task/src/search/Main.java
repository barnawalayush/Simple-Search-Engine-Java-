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
    private static int option_selected = -1;

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
                    if(word_to_line_number.get(word) == null){
                        word_to_line_number.put(word, new ArrayList<>());
                    }
                    word_to_line_number.get(word).add(i);
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

            while(true){
                try{
                    option_selected = sc.nextInt();
                    break;
                }
                catch(InputMismatchException e){
                    System.out.print("Please enter number among 0,1,2: ");
                    continue;
                }
            }

            if(option_selected >= 3 || option_selected<0){
                System.out.println("Incorrect option! Try again.");
                continue;
            }else if(option_selected == 1){
                find_person(list_of_people, sc, word_to_line_number);
               // find_a_person(list_of_people, sc);
            }else if(option_selected == 2){
                print_all_people(list_of_people);
            }else{
                System.out.println("Bye!");
                exit = "0";
            }

        }

    }

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
