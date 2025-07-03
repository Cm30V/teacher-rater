import java.util.*;


public class Main {
    public static boolean use = true;
    public static ArrayList<Teacher> listedNames = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        while(use) {
            System.out.println("Welcome to Teacher Ratings");
            System.out.println("Would you like to check ratings or provide a rating? (c/p): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("c")) {
                checkRatings();
            } else if (input.equalsIgnoreCase("p")) {
                provideRating();
            }
        }
    }

    public static void provideRating(){

        System.out.println("Please input the name of the teacher you would like to leave a review on: ");
        System.out.print("(enter first and last e.g. 'John Doe'):  ");
        String name = scanner.nextLine();
        System.out.print("Now please enter your rating 1-10: ");
        double rating = scanner.nextDouble();
        scanner.nextLine();
        while (rating > 10 || rating < 0) {
            System.out.println("Please reenter a rating between 1-10: ");
            rating = scanner.nextDouble();
            scanner.nextLine();

        }
        Teacher name_rating = new Teacher(name, rating);
        listedNames.add(name_rating);
        System.out.println("Rating successfully added thank you!");
        System.out.print("Would you like to continue using Teacher rater? (y/n): ");
        if(scanner.nextLine().equalsIgnoreCase("n")){
            use = false;
        }

    }

    public static void checkRatings(){
        double total = 0.0;
        int counter = 0;
        System.out.print("Please enter the full name of the teacher e.g 'John Doe': ");
        String name = scanner.nextLine();
        for(Teacher x: listedNames){
            if(x.name.equalsIgnoreCase(name)){
                total+= x.rating;
                counter++;
            }
        }



        if(counter==0) {
            System.out.println("No ratings found for " + name);
        }
        else{
            double average = total/counter;
            System.out.println("The average rating for the teacher " + name + " is " + average + "/10" );
        }
        System.out.print("Would you like to continue using Teacher rater? (y/n): ");
        if(scanner.nextLine().equalsIgnoreCase("n")){
            use = false;
        }
    }
}


class Teacher{
    String name;
    double rating;

    public Teacher(String name, double rating){
        this.name = name;
        this.rating = rating;
    }
}
