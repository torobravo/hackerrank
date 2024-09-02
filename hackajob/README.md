# Hackajob Practice

### [FizzBuzz](https://www.hackerrank.com/challenges/fizzbuzz/problem)

Write a short program that prints each number from N to M.

- For each multiple of 3, print "Fizz" instead of the number.
- For each multiple of 5, print "Buzz" instead of the number.
- For numbers which are multiples of both 3 and 5, print "FizzBuzz" instead of the number.

```Java
    public static void printFizzBuzz(int N, int M) {
        String sequence = "";
        for (int i = N; i <= M; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                sequence += "FizzBuzz";
            else if (i % 3 == 0)
                sequence += "Fizz";
            else if (i % 5 == 0)
                sequence += "Buzz";
            else
                sequence += Integer.toString(i);

            sequence += ",";
        }

        System.out.println(
                sequence.substring(0, sequence.length() - 1));
    }
```

[Java Solution]()

---

### [The Longest Increasing Sequence](https://www.hackerrank.com/challenges/longest-increasing-subsequent/problem)

The task is to find the length of the longest subsequence in a given array of integers such that all elements of the subsequence are sorted in strictly ascending order. This is called the Longest Increasing Subsequence (LIS) problem.

For example, the length of the LIS for [15,27, 14, 38, 26, 55,46,65, 85] is 6 since the longest increasing subsequence is [15, 27, 38,55, 65, 85].

```Java
    public static int LIS(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return 0;

        int n = sequence.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++)
            dp[i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int maxLength = 0;
        for (int length : dp)
            maxLength = Math.max(maxLength, length);

        return maxLength;
    }
```

[Java Solution]()

---

### [Common Ancestor]()

Find the lowest common ancestor of two nodes in a binary tree without allocating any tree data structure in memory. Consider the binary tree's indexes startingfrom 1 in the root, increasing from the leftmost node to the right at each level.

```Java
    private static int findLCA(int n1, int n2) {
        // Loop until both nodes coverage to the same ancestor
        while (n1 != n2) {
            if (n1 > n2)
                n1 /= 2; // Move n1 up to its parent
            else
                n2 /= 2; // Move n2 up to its parent
        }

        return n1;
    }
```

[Java Solution]()

---

### [Maximun Subarray]()

For an array with n elements, a = (a1, a2, a3, … , an), find the maximum possible sum of a contiguous subarray. If the maximum element is bigger than the sum, return that element.

```Java
    public static int run(int[] a) {
        int maximum_sum = Integer.MIN_VALUE;
        int current = 0;
        for (int num : a) {
            current += num;
            if (current < num)
                current = num;

            if (maximum_sum < current)
                maximum_sum = current;
        }
        return maximum_sum;
    }
```

[Java Solution]()

---

### [Roman Numbers]()

Given a natural number n, translate and return it into a roman numeral string, knowing that:

Numbers are formed by combining symbols and adding the values, so II is two (two ones) and XIII is thirteen (a ten and three ones). Because each numeral has a fixed value rather than representing multiples of ten, one hundred and so on, according to position, there is no need for "place keeping" zeros, as in numbers like 207 or 1066; those numbers are written as CCVII (two hundreds, a five and two ones) and MLXVI (a thousand, a fifty, a ten, a five and a one).

Symbols are placed from left to right in order of value, starting with the largest. However, in a few specific cases, to avoid four characters being repeated in succession (such as IIII or XXXX), subtractive notation is used as in this table.

Number: 4 9 40 90 400 900

Notation: IV IX XL XC CD CM

For example, MCMIV is one thousand nine hundred and four, 1904 (M is a thousand, CM is nine hundred and IV is four).

```Java
    public static String run(int n) {
        int[] values = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String[] symbols = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };

        String output = "";

        for (int i = values.length - 1; i >= 0; i--) {

            while (n >= values[i]) {
                output += symbols[i];
                n -= values[i];
            }
        }

        return output;
    }
```

[Java Solution]()

---

### [Find the Singleton]()

A class of students have a project to work on in pairs. Everyone in the class found a partner, apart from one student.
Using the list provided (which details every student in the class represented by the number of their team), find the student with no partner.

Note that the number of teams can represent either: only two students or the single student.
Try to find the most efficient solution!

```Java
	public static int run(int[] student_list) {
		int res = 0;
		for(int num: student_list) {
			res ^= num;
		}

		return res;
	}
```

[Java Solution]()

---

### [Movie Collection]()

Your task is to create an application for a client that has a big movie collection. He organises the collection in a big stack. When he wants to watch a movie he locates it in the stack and removes it. After he is finished watching the movie, he places it back at the top. Since the stack of movies is big, he will need to know the position of each movie.

He likes to know for each movie how many other movies are above it in the stack and, with this information he can calculate the position in the stack. Each movie is identified by a number printed on the box.

Implement a program that will keep track of the position for each movie. Each time he removes a movie from the stack, your program should print the number of movies that were placed above it before it was removed. After the movie is watched it is placed at the top of the stack.

EXAMPLE 1
Input
3
3
[3,1,1]

Output
"2,1,0"

EXAMPLE 2
Input
5
3
[4,4,5]

Output
"3,0,4"

```Java
	public static String run(int n, int m, int[] movies) {
		String movies_array = "";
		java.util.Stack<Integer> tower = new java.util.Stack<>();
		java.util.Stack<Integer> temp = new java.util.Stack<>();

		for(int i=n; i>0; i--)
			tower.push(i);

		for(int movie: movies) {
			int cntr = 0;
			int top = tower.pop();
			while(movie != top) {
				temp.push(top);
				top = tower.pop();
				cntr++;
			}

			movies_array += Integer.toString(cntr) + ",";

			while(!temp.empty())
				tower.push(temp.pop());

			tower.push(top);
		}

		return movies_array.substring(0, movies_array.length() - 1);
	}
```

[Java Solution]()

---
