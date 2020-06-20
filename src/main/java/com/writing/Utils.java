import java.util.Random;
import java.lang.Character;

public class Utils {
    
    static Random random = new Random();
    static final char[] consonants = { 'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
    static final char[] vowels = {'a', 'e', 'i', 'o', 'u'};


    public static String randomNameGenerator(){
        String result = "";
        boolean vowelFirst = random.nextInt(2) == 0 ? true: false;
        boolean capitalize = true;        
        int length = random.nextInt(8);
        //Minimum length should be 1 or 2 respectively
        length = vowelFirst? length + 1 : length + 2;

        for (int i = vowelFirst? 0 : 1; i <= length; i ++){
            if (i % 2 == 1){
                char value = consonants[random.nextInt(consonants.length)];
                value = capitalLetter(value, capitalize);
                result += value;
                
            } else {
                char value = vowels[random.nextInt(vowels.length)];
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
}