import java.util.*;
public class nums {

    //this function stores all the special names in this project
    //eg: thousand, million,billion
    private static final String[] specialNames = {
            "",
            " thousand",
            " million",
            " billion",
            " trillion",
            " quadrillion",
            " quintillion"
    };

    //this functions stores all the tens names
    private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    //this function stores all the number names from 1-19
    private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    //this private function accesses all the other private functions and takes in an integer
    //this function then checks that integer and checks what catergory it goes in
    //only activates when integer is less than a thousand
    private static String LessThanOneThousand(int number) {
        String current;

        //checks if the number is in the 1-19 range
        if (number % 100 < 20){
            //adds the place to current variable by getting the position in the list by taking the
            //number and modulusing it by 100
            current = numNames[number % 100];
            number /= 100;
        }

        //if not in that range then do this
        else {
            //does the same thing but instead of 100 it is 10
            current = numNames[number % 10];
            number /= 10;

            //gets the 10s names
            current = tensNames[number % 10] + current;
            number /= 10;
        }

        if (number == 0) return current;
        return numNames[number] + " hundred" + current;
    }

    //this is the main convert function
    public static String convert(int number) {

        //if number equals zero return the word zero
        if (number == 0) { return "zero"; }

        //empty string
        String prefix = "";

        //this checks if the number is less than zero making it a negative
        if (number < 0) {
            number = -number;
            prefix = "negative";
        }

        //empty string
        String current = "";
        int place = 0;

        //do this always occurs and does the converting
        do {
            //n is the number modulo 1000
            int n = number % 1000;
            //if n is not zero do the following
            if (n != 0){
                //calls the convertLessThanOneThousand function
                String s = LessThanOneThousand(n);
                //adds the s variable plus the special names to current
                current = s + specialNames[place] + current;
            }

            //increments the place variable
            place++;
            number /= 1000;
        } while (number > 0);

        //returns the desired number word
        return (prefix + current).trim();
    }

    //main method
    public static void main(String[] args) {
        // propmts user to enter what they would like to enter
        System.out.println("enter the number you would like to see");
        //declare scanner
        Scanner sc = new Scanner(System.in);
        //take user input
        int Userinput = sc.nextInt();
        //print out the number and the word
        System.out.println(Userinput + ": " + convert(Userinput));

    }
}


