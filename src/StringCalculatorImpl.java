
public class StringCalculatorImpl implements StringCalculator {
    @Override
    public int add(String numbers) {
        if (numbers.equals(""))
            return 0;

        String delimiter = ",";
        if (!numbers.contains(delimiter) && !numbers.contains("\n")) {
            return Integer.parseInt(numbers);
        } else {
            int sum = 0;
            String nums[] = numbers.split(delimiter);
            for (String numsWithNewLine : nums) {
                String newNums[] = numsWithNewLine.split("\n");
                for (String num : newNums)
                    sum += Integer.parseInt(num);
            }
            return sum;
        }
    }
}
