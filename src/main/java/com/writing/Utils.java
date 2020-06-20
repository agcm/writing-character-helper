import java.util.Random;
import java.lang.Character;
import java.lang.Math;

public class Utils {
    //remove seed for pseudo randomness
    static final Long SEED = 20L;
    static final Random RANDOM = new Random(SEED);
    static final char[] CONSONANTS = { 'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
    static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};
    static final int MAX_RANDOM_LENGTH = 8;

    public static boolean coinFlip(){
        return RANDOM.nextBoolean();
    }

    public static int diceRoll (int sided){
       
        return RANDOM.nextInt(sided);
    }

    public static int distribution(int numberDice, int sided){
        int result = 1;
        int count = numberDice;
        while (count > 0){
            result  *= diceRoll(sided);
            count--;
        }
        return result / (numberDice * sided);

    }

    

    public static String randomNameGenerator(){
        
        
        String result = "";
        boolean vowelFirst = RANDOM.nextBoolean();
        boolean capitalize = true;        
        int length = RANDOM.nextInt(MAX_RANDOM_LENGTH);
        //Minimum length should be 1 or 2 respectively
        length = vowelFirst? length + 1 : length + 2;

        for (int i = vowelFirst? 0 : 1; i <= length; i ++){
            if (i % 2 == 1){
                char value = CONSONANTS[RANDOM.nextInt(CONSONANTS.length)];
                value = capitalLetter(value, capitalize);
                result += value;
                
            } else {
                char value = VOWELS[RANDOM.nextInt(VOWELS.length)];
                value = capitalLetter(value, capitalize);
                result += value;
            }
            capitalize = false;
        }
        return result;

        
    }
    private static char capitalLetter(char value, boolean capitalize){
        if (capitalize){
            return Character.toUpperCase(value);
        }
        return value;
    }

    public static long permutations(){
        // worst case scenario is MAX_RANDOM_LENGTH + 2  and then interlacing multiplication starting with CONSONANTS.

        return (long) Math.pow(CONSONANTS.length, Math.round(MAX_RANDOM_LENGTH / 2.0)) 
             * (long) Math.pow(VOWELS.length, MAX_RANDOM_LENGTH/ 2); 
        
        

    }   
}