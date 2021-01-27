public class MathApplicationMockito {
    private CalculatorService calcService;

    public void setCalService(CalculatorService calcService) {
        this.calcService = calcService;
    }

    public double add(double number1, double number2) {
        return calcService.add(number1,number2);
    }

    public double subtract(double number1, double number2) {
        return calcService.subtract(number1,number2);
    }

    public double multiply(double number1, double number2) {
        return calcService.multiply(number1,number2);
    }

    public double divide(double number1, double number2) {
        return calcService.divide(number1, number2);
    }
}
