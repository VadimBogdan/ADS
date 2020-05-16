package Lab2_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

//        String filePath = "C:\\Users\\my comp1\\Desktop\\NAU\\ADS\\2_2Regex.txt";
//        ArrayList<String> content = ReadFile(filePath);
//        String regular = "\\+[0-9]+\\$%\\+[0-9]+";
//        Pattern pattern = Pattern.compile(regular);
//        Matcher matcher;
//        for (String s : content) {
//            matcher = pattern.matcher(s);
//            System.out.println(s);
//            if (matcher.find()) {
//                System.out.println("Matches:");
//                matcher.reset();
//                while (matcher.find())
//                    System.out.println(matcher.group());
//            } else {
//                System.out.println("Not matched.");
//            }
//        }
        // Lvl2
//        Automat automat = new Automat(new Scanner(System.in).nextLine());
//        if (automat.scanner()) {
//            System.out.println("Патерн виявленно");
//        } else {
//            System.out.println("Патерн не виявленно");
//        }
        String filePath2 = "C:\\Users\\my comp1\\Desktop\\NAU\\ADS\\2_2-3_transitiontable.txt";
        ArrayList<String> content = ReadFile(filePath2);
        for (var s : content) {
            for (var s1 : s.split("\\s|\\$|#")) {
                System.out.println("Слово "+s1);
                TransitionTable table = new TransitionTable(s1);
                if (table.scanner()) {
                    System.out.println("Вірне");
                } else {
                    System.out.println("Невірне");
                }

            }
        }
        // TransitionTable table = new TransitionTable();
    }

    public static ArrayList<String> ReadFile(String file){
        ArrayList<String> array = new ArrayList<String>();
        try(FileInputStream fis = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(fis);
            BufferedReader read = new BufferedReader(reader)){
            String line = read.readLine();
            while(line!=null){
                array.add(line);
                line = read.readLine();
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return array;
    }
}
