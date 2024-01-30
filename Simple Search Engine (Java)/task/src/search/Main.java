package search;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static String exit = "1";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        System.out.println("Enter the number of people:");
//        int total_people = sc.nextInt();
//        sc.nextLine();

        String input_file_name = null;
        for(int i=0; i< args.length; i=i+2){
            if(args[i].equals("--data")){
                input_file_name = args[i+1];
            }
        }

        ArrayList<String> list_of_people = new ArrayList<>();

        File file = new File(input_file_name);
        try(Scanner sc1 = new Scanner(file)){
            while(sc1.hasNext()){
                list_of_people.add(sc1.nextLine());
            }
        }catch(FileNotFoundException e){
            System.out.println("Wrong file entered");
        }

//
//        System.out.println("Enter all people:");
//        for(int i=0; i<total_people; i++){
//            list_of_input[i] = sc.nextLine();
//        }


        while(!exit.equals("0")){

            System.out.println("=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");

            int option_selected = sc.nextInt();
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
