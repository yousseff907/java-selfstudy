public class BadAPI
{
	static private	int IsBad = 4;

	public static boolean isBadVersion(int num)
	{
		return num >= IsBad;
	}

	public static int firstBadVersion(int n)
	{
		int	right = n;
		int	left = 0;

		while (left < right)
		{
			int	m = left + (right - left) / 2;

			if (isBadVersion(m))
				right = m;
			else
				left = m + 1;
		}

		return (left);
	}

	public static void main(String[] args)
	{
		int	API = 7990;

		System.out.println(firstBadVersion(API));
	}
}
