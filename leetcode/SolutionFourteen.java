
import java.util.*;

/*
Merge overlapping intervals.
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
*/

public class SolutionFourteen {
    public static int[][] merge(int[][] intervals)
	{
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int	len = intervals.length;
		int	i = 0;

		List<int[]> list = new ArrayList<>(Arrays.asList(intervals));

		while (i < len)
		{
			if (i != len - 1 && intervals[i][1] >= intervals[i + 1][0])
			{
				intervals[i][1] = Math.max(intervals[i + 1][1], intervals[i][1]);
				list.remove(i + 1);
				intervals = list.toArray(new int[list.size()][]);
				len = intervals.length;
				i--;
			}
			i++;
		}
		int	newIntervals[][] = list.toArray(new int[list.size()][]);
        return (newIntervals);
	}

	public static void main(String[] args)
	{
		int[][] intervals = {{1,3},{2,6},{6, 8},{8,10},{15,18}};

		System.out.println(Arrays.deepToString(merge(intervals)));
				
		int[][] intervals_two = {{1,3},{2,4},{3,5},{6,7}};

		System.out.println(Arrays.deepToString(merge(intervals_two)));
	}
}