package misc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ResourceLoader {

    private static ResourceLoader resourceLoader = null;

    private ResourceLoader() {
        File data = new File("data");
        if(!data.exists()) {
            if(!data.mkdir()) {
                System.out.println("Failed to create data folder.");
            }
        }
    }

    public static ResourceLoader getResourceLoader() {
        if(resourceLoader == null) {
            resourceLoader = new ResourceLoader();
        }
        return resourceLoader;
    }

    private ArrayList<String> readFile(String filePath, String defaultData) throws IOException {
        File file = new File(filePath);

        if (file.createNewFile()) {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(defaultData);
            fileWriter.close();
        }

        Scanner scanner = new Scanner(file);
        ArrayList<String> fileContents = new ArrayList<>();
        while (scanner.hasNextLine()) {
            fileContents.add(scanner.nextLine());
        }

        return fileContents;
    }

    public int getHighScore() throws IOException {
        int highScore;

        ArrayList<String> fileContents = readFile("data/highscore.txt", "0");
        highScore = Integer.parseInt(fileContents.get(0));

        return highScore;
    }

}
