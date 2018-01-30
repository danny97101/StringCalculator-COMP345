
public class StringCalculatorImpl implements StringCalculator {
    @Override
    public int add(String numbers) {
        if (numbers.equals(""))
            return 0;

        String delimiter = ",";
        if (!numbers.contains(delimiter)) {
            return Integer.parseInt(numbers);
        }

        return -1;
    }
}
