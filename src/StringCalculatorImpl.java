
public class StringCalculatorImpl implements StringCalculator {
    @Override
    public int add(String numbers) {
        if (numbers.equals(""))
            return 0;

        String delimiter = ",";
        if (!numbers.contains(delimiter)) {
            return Integer.parseInt(numbers);
        } else {
            int sum = 0;
            String nums[] = numbers.split(delimiter);
            for (String num : nums) {
                sum += Integer.parseInt(num);
            }
            return sum;
        }
    }
}
