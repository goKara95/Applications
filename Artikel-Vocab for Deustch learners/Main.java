import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> artikel = new ArrayList<>();
        ArrayList<String> meaning = new ArrayList<>();
        ArrayList<String> word = new ArrayList<>();
        ArrayList<ArrayList<String>> verben = new ArrayList<>();
        ArrayList<String> verbMeaning = new ArrayList<>();
        try {
            File myObj = new File("test.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] params = data.split(" ");
                if(params[0].equals("K")){
                    artikel.add(params[1]);
                    word.add(params[2]);
                    meaning.add(params[3]);
                }
                else{
                    ArrayList<String> conj = new ArrayList<>();
                    conj.add(params[1]);
                    conj.add(params[2]);
                    conj.add(params[3]);
                    conj.add(params[4]);
                    conj.add(params[5]);
                    conj.add(params[6]);
                    verbMeaning.add(params[7]);
                    verben.add(conj);
                }
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select mode: " + "\n" + "fiil çekimi: f" + "\n" + "kelime bilgisi: k");
        String mod = scanner.nextLine();
        Random random = new Random();
        if(mod.equals("k")){
            while (word.size() > 0){
               int number = random.nextInt(word.size());
               System.out.println(word.get(number) + " artikeli nedir?: ");
               String ans1 = scanner.nextLine();
                if(!(ans1.equals(artikel.get(number)))){
                    System.out.println("Wrong. True answer: " + artikel.get(number));
                }
               else if(ans1.equals(artikel.get(number))){
                    System.out.println("CORRECT");
                }
               System.out.println(word.get(number) + " Türkçesi nedir?: ");
               String ans2 = scanner.nextLine();
               if(!(ans2.equals(meaning.get(number)))){
                    System.out.println("Wrong. True answer: " + meaning.get(number));
                }
               else if ((ans2.equals(meaning.get(number)))){
                    System.out.println("Correct");
                }
               artikel.remove(number);
               meaning.remove(number);
               word.remove(number);
            }
        }
        else if(mod.equals("f")){
            while (!(verben.isEmpty())){
                int number = random.nextInt(verben.size());
                System.out.println("Verilen kelime için çekimleri yazın" + "\n" + verben.get(number).get(5) + " :");
                System.out.print("Ich: ");
                String ans1 = scanner.nextLine();
                if(!(ans1.equals(verben.get(number).get(0)))){
                    System.out.println("Wrong. True answer: " + verben.get(number).get(0));
                }
                else{
                    System.out.println("CORRECT");
                }
                System.out.print("Du: ");
                String ans2 = scanner.nextLine();
                if(!(ans2.equals(verben.get(number).get(1)))){
                    System.out.println("Wrong. True answer: " + verben.get(number).get(1));
                }
                else{
                    System.out.println("Correct");
                }
                System.out.print("er/sie/es: ");
                String ans3 = scanner.nextLine();
                if(!(ans3.equals(verben.get(number).get(2)))){
                    System.out.println("Wrong. True answer: " + verben.get(number).get(2));
                }
                else{
                    System.out.println("Correct");
                }
                System.out.print("Wir: ");
                String ans4 = scanner.nextLine();
                if(!(ans4.equals(verben.get(number).get(3)))){
                    System.out.println("Wrong. True answer: " + verben.get(number).get(3));
                }
                else{
                    System.out.println("Correct");
                }
                System.out.print("Ihr/ihr: ");
                String ans5 = scanner.nextLine();
                if(!(ans5.equals(verben.get(number).get(4)))){
                    System.out.println("Wrong. True answer: " + verben.get(number).get(4));
                }
                else{
                    System.out.println("Correct");
                }
                System.out.print("Sie/sie: ");
                String ans6 = scanner.nextLine();
                if(!(ans6.equals(verben.get(number).get(5)))){
                    System.out.println("Wrong. True answer: " + verben.get(number).get(5));
                }
                else{
                    System.out.println("Correct");
                }
                System.out.print("And the meaning?: ");
                String ans7 = scanner.nextLine();
                if(!(ans7.equals(verbMeaning.get(number)))){
                    System.out.println("Wrong. True answer: " + verbMeaning.get(number));
                }
                else{
                    System.out.println("Correct");
                }

                verben.remove(number);
                verbMeaning.remove(number);
            }

        }
        else{
            System.out.println("You should write either \"k\" or \"f\"(without quotes)");
        }

    }
}
