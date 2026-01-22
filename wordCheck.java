import java.util.ArrayList;

public class wordCheck {

    ArrayList<String> correctWordChars = new ArrayList<>();
    ArrayList<String> inputChars = new ArrayList<>();

    public boolean checkWord(String input, String correctWord){
        return input.equals(correctWord);
    }

    public boolean correctLength(String input){
        for (int i = 0; i < input.length(); i++) {
            char s = input.charAt(i);
            if (!Character.isLetter(s)) {
                return false;
            }
        }
        return input.length() == 5;
    }

    public void explain(String input, String correctWord){
        // Use local lists for results
        ArrayList<String> matchingCharacters = new ArrayList<>();
        ArrayList<String> correctSpotCharacters = new ArrayList<>();

        inputChars.clear();
        correctWordChars.clear();

        for (int i = 0; i < input.length(); i++) {
            inputChars.add(String.valueOf(input.charAt(i)));
        }
        for (int l = 0; l < correctWord.length(); l++) {
            correctWordChars.add(String.valueOf(correctWord.charAt(l)));
        }

        int len = Math.min(inputChars.size(), correctWordChars.size());

        for (int k = 0; k < len; k++) {
            if (inputChars.get(k).equals(correctWordChars.get(k))) {
                correctSpotCharacters.add(inputChars.get(k));
            }
        }

        // Matching characters (anywhere)
        for (int p = 0; p < len; p++) {
            for (int m = 0; m < correctWordChars.size(); m++) {
                if (inputChars.get(p).equals(correctWordChars.get(m))) {
                    if (!matchingCharacters.contains(inputChars.get(p))) {
                        matchingCharacters.add(inputChars.get(p));
                    }
                }
            }
        }

        System.out.println("Characters in the right spot: " + correctSpotCharacters);
        System.out.println("Matching characters: " + matchingCharacters);
    }
}
