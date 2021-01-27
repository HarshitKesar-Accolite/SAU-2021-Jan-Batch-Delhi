import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MathApplicationLog4j2 {
    private static final Logger LOGGER = LogManager.getLogger(MathApplicationLog4j2.class);

    private static MathApplicationJunit mathApplicationJunit = new MathApplicationJunit();

    public static void logCalculator(Double num1, Double num2){
        System.out.println("Arithmetic Operations : Num1 = " + num1 + ", Num2 = " + num2);
        LOGGER.info("Addition: " + mathApplicationJunit.add(num1, num2));
        LOGGER.info("Subtraction: "+ mathApplicationJunit.subtract(num1, num2));
        LOGGER.info("Multiplication: " + mathApplicationJunit.multiply(num1, num2));
        LOGGER.info("Division: " + mathApplicationJunit.divide(num1, num2));
    }

    public static void main(String[] args)
    {
        Double num1 = 40.0, num2 = 20.0;
        logCalculator(num1, num2);
    }
}
