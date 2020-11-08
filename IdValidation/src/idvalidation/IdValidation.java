package idvalidation;

/**
 *
 * @author Tzvika
 */
public class IdValidation { 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int id = 123456782;
        System.out.println(isIdValid(id) ? "The ID is valid": "The ID not is valid");
    }
    
    /**
     * @param id full id
     * @return if the input id valid
     */
    public static boolean isIdValid(int id) {
        return id%10 == calculateLastDigit(id/10);
    }

    /**
     * @param shortId id without the last digit
     * @return the last digit
     */
    public static int calculateLastDigit(int shortId) {
        int sum = 0;
        for (int i = 0; shortId >0; i++) {
            //Multiply the values in the odd places by two:
            int var = ((i % 2 ==0)? (shortId % 10)*2 : shortId % 10);
            
            //connecting all digits of var
            sum += var % 10 + var / 10;
            
            shortId /= 10;
        }
        return 10 - sum % 10;
    }
}

