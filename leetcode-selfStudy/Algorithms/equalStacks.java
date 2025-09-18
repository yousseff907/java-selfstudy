

/*
You have three stacks of cylinders. Find the maximum possible height at which 
all stacks have equal height by removing cylinders from the top.

Input: 
h1 = [3,2,1,1,1]  (heights: 8 total)
h2 = [4,3,2]      (heights: 9 total)  
h3 = [1,1,4,1]    (heights: 7 total)

Output: 5 (remove elements to make all stacks height 5)
*/

public class equalStacks
{
	private static int sum(int[] nums)
	{
		int	s = 0;

		for (int n : nums)
		{
			s += n;
		}

		return (s);
	}

    public static int equalStacks(int[] h1, int[] h2, int[] h3)
	{
		int	sum1 = sum(h1);
		int	sum2 = sum(h2);
		int	sum3 = sum(h3);

		int	i1 = 0;
		int	i2 = 0;
		int	i3 = 0;

		while (i1 < h1.length && i2 < h2.length && i3 < h3.length)
		{
			int max = Math.max(sum1, Math.max(sum2, sum3));

			if (sum1 == sum2 && sum2 == sum3)
				return (sum1);
			
			if (sum1 == max)
				sum1 -= h1[i1++];
			else if (sum2 == max)
				sum2 -= h2[i2++];
			else if (sum3 == max)
				sum3 -= h3[i3++];
		}

		return (0);
    }

	public static void main(String[] args)
	{
		int[] h1 = {3, 2, 1, 1, 1};
		int[] h2 = {4, 3, 2};
		int[] h3 = {1, 1, 4, 1};

		int result = equalStacks(h1, h2, h3);
		System.out.println("Equal height = " + result);
	}
}