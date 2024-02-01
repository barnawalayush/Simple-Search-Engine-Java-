package search;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static String exit = "1";
    private static int option_selected = -1;

    public static void main(String[] args) {
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
            String[] str = content.split("\n");
            for(String st: str)list_of_people.add(st);
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
                find_a_person(list_of_people, sc);
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
