package ru.doubligis.kukarin.test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class WordReplacer {
    public static void main(String args[]) {



        if (args.length != 3) {
            System.out.println("Usage: path to input file, phrase, path to output file.");
            System.exit(1);
        }
        File inputFile = new File(args[0]);
        if (!(inputFile.canRead())) {
            System.out.println(String.format("File %s cannot be read.", inputFile.getAbsolutePath()));
            System.exit(1);
        }
        File outputFile = new File(args[2]);
        removePhraseFromFile(inputFile, args[1], outputFile);

    }

    /**
     * Функция, удаляющая из
     * @param inputFile
     * @param phrase
     * @param outputFile
     */
    private static void removePhraseFromFile(File inputFile, String phrase, File outputFile) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(inputFile);
            outputStream = new FileOutputStream(outputFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(inputStream,
                Charset.forName("cp1251")));
        BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        String line = null;
        try {
            while ((line = inputReader.readLine()) != null) {
                String processedLine = processLine(line, phrase);
                outputWriter.write(processedLine);
                outputWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            inputReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Функция, удаляющая заданную подстроку из строки
     * @param line
     * @param phrase
     * @return
     */
    private static String processLine(String line, String phrase) {
        String newLine = line.replaceAll(phrase, "");
        return newLine;
    }

}