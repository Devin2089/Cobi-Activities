import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {
    private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
    private static ArrayList<String> posAdjectives = new ArrayList<String>();
    private static ArrayList<String> negAdjectives = new ArrayList<String>();
    private static final String SPACE = " ";
    
    static{
        try {
            Scanner input = new Scanner(new File("cleanSentiment.csv"));
            while(input.hasNextLine()){
                String[] temp = input.nextLine().split(",");
                sentiment.put(temp[0],Double.parseDouble(temp[1]));
                //System.out.println("added "+ temp[0]+", "+temp[1]);
            }
            input.close();
        }
        catch(Exception e){
            System.out.println("Error reading or parsing cleanSentiment.csv");
        }
    }
  
    /** 
    * returns a string containing all of the text in fileName (including punctuation), 
    * with words separated by a single space 
    */
    public static String textToString( String fileName )
    {  
        String temp = "";
        try {
            Scanner input = new Scanner(new File(fileName));

            //add 'words' in the file to the string, separated by a single space
            while(input.hasNext()){
                temp = temp + input.next() + " ";
            }
            input.close();
        }
        catch(Exception e){
            System.out.println("Unable to locate " + fileName);
        }
        //make sure to remove any additional space that may have been added at the end of the string.
        return temp.trim();
    }
  
    /**
       * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment) 
       */
    public static double sentimentVal( String word )
    {
        try
        {
            return sentiment.get(word.toLowerCase());
        }
        catch(Exception e)
        {
            return 0;
        }
    }
    
    /*
    * Q1. Complete the totalSentiment method.
    * Method to determine the total sentiment value of a review.
    */
    // 
    public static double totalSentiment(String fileName) {
     String review = textToString(fileName);
     double totalSentiment = 0;
     while (review.length()>0){
        //find the next space
        int posOfSpace = review.indexOf(" ");
        String wordToScore= review.substring(0, posOfSpace);
        String sanitizedWord = removePunctuation(wordToScore);
        System.out.println(sanitizedWord);
        Double score = sentimentVal(sanitizedWord);
        totalSentiment += score;
       review = review.substring(posOfSpace + 1);
      }
      return totalSentiment;
    }
    
    /**
       * Q3. Complete the starRating method.
       * Method to determine the star rating of a review found in the text file provided
       * by the parameter.
       * 
       * @param fileName - the name of the file containing the review
       * @return the star rating of the review, which is an integer value between 0 and 4
       */
    public static int starRating( String fileName ){
        int totalSentiment = (int) totalSentiment(fileName);
        if (totalSentiment < -5){
            return 0;
        } else if (totalSentiment < 0){
            return 1;
        } else if (totalSentiment < 5){
            return 2;
        } else if (totalSentiment < 15){
            return 3;
        } else {
            return 4;
        }
    }

    /**
       * Returns the word after removing any beginning or ending punctuation
       */
    public static String removePunctuation( String word )
    {
        while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
        {
            word = word.substring(1);
        }
        while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
        {
            word = word.substring(0, word.length()-1);
        }

        return word;
    }

    /**
       * Returns the ending punctuation of a string, or the empty string if there is none 
       */
    public static String getPunctuation( String word )
    { 
        String punc = "";
        for(int i=word.length()-1; i >= 0; i--){
            if(!Character.isLetterOrDigit(word.charAt(i))){
                punc = punc + word.charAt(i);
            } else {
                return punc;
            }
        }
        return punc;
    }
}
