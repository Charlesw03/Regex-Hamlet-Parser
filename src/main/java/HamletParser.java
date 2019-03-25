import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamlet = "hamlet";
    private String horatio = "horatio";
    private Pattern pattern;
    private Matcher matcher;
    private String hamletData;


    public HamletParser() {

        this.hamletData = loadFile();
    }

    private String loadFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
               String newStr = replace(hamlet,"Leon",line);
               String newstr1 = replace(horatio,"Tariq",newStr);

                result.append(newstr1)
                        .append("\n");


            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData() {
        return hamletData;
    }


    public Boolean find(String wordToFind, String line) {
        String strPattern = ".*" + wordToFind + ".*";
        pattern = Pattern.compile(strPattern,Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(line);
        return matcher.matches();

        //return line.contains(hamlet);
    }

    public String replace(String wordToFind, String wordChangingTo, String line) {
        String strPattern = "(" + wordToFind + ")";
        pattern = Pattern.compile(strPattern,Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(line);

        return matcher.replaceAll(wordChangingTo);
    }

    public static void main(String[] args) {
        HamletParser hamletParser = new HamletParser();

//        Boolean answer= hamletParser.find("marshilla" ,"Hello my name is Marshilla Brahma");
//        String answer1 = hamletParser.replace("marshilla","Mama","Hello my name is Marshilla Brahma");
//        System.out.print(answer);
//        System.out.println(answer1);

        System.out.println(hamletParser.getHamletData());
    }
}






