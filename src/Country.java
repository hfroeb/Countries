import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by halleyfroeb on 9/9/16.
 */
public class Country {
    private String name;
    private String abbreviation;


    public Country(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }
    @Override
    public String toString() {
        return String.format("%s | %s\n", abbreviation, name);
    }

    public String getName() {
        return name;
    }
    
}


