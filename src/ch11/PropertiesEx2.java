package ch11;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEx2 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Ch11.Properties.PropertiesEx2 Inputfilename");
            System.exit(0);
        }

        Properties prop = new Properties();
        String inputFile = args[0];

        try {
            prop.load(new FileInputStream(inputFile));
        } catch (IOException e) {
            System.out.println("file not found");
            System.exit(0);
        }

        String name = prop.getProperty("name");
        String[] data = prop.getProperty("data").split(",");
        int max = 0;
        int min = 0;
        int sum = 0;

        for(int i = 0; i < data.length; i++) {
            int intValue = Integer.parseInt(data[i]);
            if (i == 0) {
                min = intValue;
                max = intValue;
            }

            if (max < intValue) {
                max = intValue;
            } else if (min > intValue) {
                min = intValue;
            }

            sum += intValue;
        }

        System.out.println("name : " + name);
        System.out.println("max : " + max);
        System.out.println("min : " + min);
        System.out.println("sum : " + sum);
        System.out.println("average : " + sum * 100.0 / (double)data.length / 100.0);
    }
}

