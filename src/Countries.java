import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Countries {
    public static void main(String[] args) throws IOException {
        ArrayList<Country> countries = new ArrayList<>();
        HashMap<String, ArrayList<Country>> countryList = new HashMap<>();

        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);

        String firstLetter;
        String lastLetter = "#";

        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Country country = new Country(columns[1], columns[0]);
            firstLetter = String.valueOf(country.getName().charAt(0));
            countries.add(country);

            // test last letter, if last letter is different than this letter, put it into the map
            if (firstLetter != lastLetter) {
                countryList.put(firstLetter, countries);
            } else {
                lastLetter = firstLetter;
                countries = new ArrayList<>();
            }
        }
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter a letter");
            String letter = scanner.nextLine().toLowerCase();
            if (countryList.containsKey(letter)) {
                ArrayList<Country> saveCountries = countryList.get(letter);
                File file = new File(letter.toUpperCase() + "_countries.txt");
                FileWriter fw = new FileWriter(file);
                fw.write(saveCountries.toString());
                fw.close();
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

