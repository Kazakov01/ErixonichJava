
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rnd = Random();
        int num = sc.nextInt();

        if (num < 101) {
            System.out.println(Compare(rnd, num));
        } else {
            throw new RuntimeException("What an idiot");
        }
    }

    public static int Random (){
        return (int)(Math.random() * 101);
    }

    public static String Compare (int rnd, int num){
        if (num > rnd)
            return "Your number is higher";
        if (num < rnd)
            return "Your number is less";
        if (num == rnd)
            return "THATS A MATCH!";
        return "";
    }
}