
public class StringCalculatorImpl implements StringCalculator {
    @Override
    public int add(String numbers) {
        if (numbers.equals(""))
            return 0;

        String delimiter = ",";

        if (numbers.startsWith("//")) {
            delimiter = numbers.substring(2, numbers.indexOf("\n"));
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
        }


        if (numbers.endsWith(delimiter) || numbers.endsWith("\n")) throw new NumberFormatException();

        if (!numbers.contains(delimiter) && !numbers.contains("\n")) {
            return Integer.parseInt(numbers);
        } else {
            int sum = 0;
            String nums[] = numbers.split(delimiter);
            for (String numsWithNewLine : nums) {
                if (numsWithNewLine.startsWith("\n") || numsWithNewLine.equals("")) throw new NumberFormatException();
                String newNums[] = numsWithNewLine.split("\n");
                for (String num : newNums) {
                    sum += Integer.parseInt(num);
                }
            }
            return sum;
        }
    }
}
