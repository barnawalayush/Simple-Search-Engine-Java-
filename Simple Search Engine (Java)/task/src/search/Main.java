package search;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of people:");
        int total_people = sc.nextInt();
        sc.nextLine();

        String[] details = new String[total_people];

        System.out.println("Enter all people:");
        for(int i=0; i<total_people; i++){
            details[i] = sc.nextLine();
        }

        System.out.println("Enter the number of search queries:");
        int no_of_queries = sc.nextInt();
        sc.nextLine();

        while(no_of_queries!=0){
            System.out.println("Enter data to search people:");
            String data = sc.next();
            String check = sc.nextLine();
            if(check != ""){
                System.out.println("No matching people found");
                no_of_queries--;
                continue;
            }

            search(details, data.toLowerCase());
            no_of_queries--;
        }

    }

    private static void search(String[] details, String data){

        boolean first = true;
        for(int i=0; i<details.length; i++){
            String[] arr = details[i].split(" ");
            for(int j=0; j<arr.length; j++){
                if(find(arr[j].toLowerCase(), data)){
                    if(first){
                        System.out.println("Found people:");
                        first = false;
                    }
                    System.out.println(details[i]);
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
