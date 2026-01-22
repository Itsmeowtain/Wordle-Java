import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
public static void main(String[] args) throws IOException {
   
   FileInputStream inputWordList = null;
   Scanner scanner = null;
   Scanner userInput = null;
   
String userInputWord = "";
String correctWord = "";
int numWords = 0;
int randomNum = 0;
int tries = 0;
ArrayList<String> wordList = new ArrayList<>();


inputWordList = new FileInputStream("wordleList.txt");
scanner = new Scanner(inputWordList);
userInput = new Scanner(System.in);

System.out.println("Welcome to Wordle! - Code by Daniel T.");
System.out.println("~~~~~~~~~");

while(scanner.hasNext()){
   numWords++;
   wordList.add(scanner.nextLine());
}

System.out.println("Number of 5-letter words in the list: " + numWords);
System.out.println("-------");

randomNum = (int)(Math.random() * (numWords) + 1);
correctWord = wordList.get(randomNum);
//System.err.println("*DEBUG --> correctWord: " + correctWord + " | Index:" + randomNum);
System.out.println("A random 5-letter word has been selected by the program - take your first guess: ");


userInputWord = userInput.nextLine();
wordCheck checker = new wordCheck();

if(checker.correctLength(userInputWord) == false){
    System.out.println("That is not a 5 letter word");
}

while(checker.checkWord(userInputWord,correctWord) == false){
 System.out.println("The word you guessed is incorrect. Try again");
 if(checker.correctLength(userInputWord) == false){
    System.out.println("That is not a 5 letter word");}
 checker.explain(userInputWord,correctWord);    
 userInputWord = userInput.nextLine();
 tries++;
   //Tell the user which letters are in the right spot
   //And which letters are somewhere in the correct Word
}

if(checker.checkWord(userInputWord,correctWord)){
  System.out.println("Congratulation! You guessed the correct word!");
  System.out.println("Attempts made:" + tries);
}

System.out.println("Closing file numFile.txt.");
inputWordList.close();
}
}
