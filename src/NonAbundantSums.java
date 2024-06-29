import java.util.HashSet;
import java.util.Set;

public class NonAbundantSums
{
    public static int sumOfProperDivisors(int num)
    {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++)
        {
            if (num % i == 0) sum += i;
        }
        return sum;
    }

    public static Set<Integer> findAbundantNumbers(int limit)
    {
        Set<Integer> abundantNumbers = new HashSet<>();
        for (int i = 1; i <= limit; i++)
        {
            if (sumOfProperDivisors(i) > i) abundantNumbers.add(i);
        }
        return abundantNumbers;
    }

    public static long sumOfNonAbundantNumbers(int limit)
    {
        Set<Integer> abundantNumbers = findAbundantNumbers(limit);
        boolean[] canBeWrittenAsAbundantSum = new boolean[limit + 1];

        for (int a : abundantNumbers)
        {
            for (int b : abundantNumbers)
            {
                if (a + b <= limit) canBeWrittenAsAbundantSum[a + b] = true;
            }
        }

        long sum = 0;
        for (int i = 1; i <= limit; i++)
        {
            if (!canBeWrittenAsAbundantSum[i]) sum += i;
        }

        return sum;
    }

    public static void main(String[] args)
    {
        System.out.println(sumOfNonAbundantNumbers(28123));
    }
}