# hackerrank
HackerRank 1 month preparation kit solutions

## Week 1
### [Plus Minus](https://www.hackerrank.com/challenges/one-month-preparation-kit-plus-minus/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one)
Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. Print the decimal value of each fraction on a new line with 6 places after the decimal. 
```Java
    public static void plusMinus(List<Integer> arr) {
        int size = arr.size();
        int positives = 0, negatives = 0, zeroes = 0;
        for (Integer num : arr) {
            if (num > 0)
                positives++;
            else if (num < 0)
                negatives++;
            else
                zeroes++;
        }
        System.out.println(String.format("%.6f", (float) positives / size));
        System.out.println(String.format("%.6f", (float) negatives / size));
        System.out.println(String.format("%.6f", (float) zeroes / size));
    }
```

[Java Solution](week1/plusminus/Solution.java) | 

### [Mini-Max Sum](https://www.hackerrank.com/challenges/one-month-preparation-kit-mini-max-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one)
Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers. 
```Java
    public static void miniMaxSum(List<Integer> arr) {
        long min = Long.MAX_VALUE, max = Long.MIN_VALUE, sum = 0;
        for (Integer num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum += num;
        }
        System.out.println((sum - max) + " " + (sum - min));
    }
```

[Java Solution](week1/minimax/Solution.java) |

### [Time Conversion](https://www.hackerrank.com/challenges/one-month-preparation-kit-time-conversion/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one)
Given a time in 12-hour AM/PM format, convert it to military (24-hour) time. 
```Java
    public static String timeConversion(String s) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm:ssa");
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            Date inputDate = inputFormat.parse(s);
            return outputFormat.format(inputDate);
        } catch (ParseException pex) { }
        return null;
    }
```

[Java Solution](week1/timeconversion/Solution.java) |

### [Sparse Arrays](https://www.hackerrank.com/challenges/one-month-preparation-kit-sparse-arrays/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one)
There is a collection of input strings and a collection of query strings. For each query string, determine how many times it occurs in the list of input strings. Return an array of the results. 
```Java
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> result = new ArrayList<>();
        for (String q : queries) {
            int freq = Collections.frequency(strings, q);
            result.add(freq);
        }
        return result;
    }
```

[Java Solution](week1/sparsearray/Solution.java) |

### [Lonely Integer](https://www.hackerrank.com/challenges/one-month-preparation-kit-lonely-integer/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one)
Given an array of integers, where all elements but one occur twice, find the unique element.
```Java
    public static int lonelyinteger(List<Integer> a) {
        int result = 0;
        for (Integer num : a) {
            result ^= num;
        }
        return result;
    }
```

[Java Solution](week1/lonlyinteger/Solution.java) |

### [Flipping bits](https://www.hackerrank.com/challenges/one-month-preparation-kit-flipping-bits/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one)
You will be given a list of 32 bit unsigned integers. Flip all the bits (1->0 and 0->1) and return the result as an unsigned integer. 
```Java
    public static long flippingBits(long n) {
        return n ^ 0xffffffffL;
    }
```

[Java Solution](week1/flippingbits/Solution.java) |

### [Diagonal difference](https://www.hackerrank.com/challenges/one-month-preparation-kit-diagonal-difference/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one)
Given a square matrix, calculate the absolute difference between the sums of its diagonals. 
```Java
    public static int diagonalDifference(List<List<Integer>> arr) {
        int sz = arr.size();
        int sum_lr = 0, sum_rl = 0;
        for (int i = 0; i < sz; i++) {
            sum_lr += arr.get(i).get(i);
            sum_rl += arr.get(i).get(sz - i - 1);
        }
        return Math.abs(sum_lr - sum_rl);
    }
```

[Java Solution](week1/diagonaldiff/Solution.java) |

### [Counting sort](https://www.hackerrank.com/challenges/one-month-preparation-kit-countingsort1/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one)
**Alternative Sorting:** Another sorting method, the counting sort, does not require comparison. Instead, you create an integer array whose index range covers the entire range of values in your array to sort. Each time a value occurs in the original array, you increment the counter at that index. At the end, run through your counting array, printing the value of each non-zero valued index that number of times.
```Java
    public static List<Integer> countingSort(List<Integer> arr) {
        // Create an array filled with 100 0's
        List<Integer> result = new ArrayList<>(Collections.nCopies(100, 0));
        for (int num : arr) {
            result.set(num, result.get(num) + 1);
        }
        return result;
    }
```

[Java Solution](week1/countingsort/Solution.java) |

### [Pangrams](https://www.hackerrank.com/challenges/one-month-preparation-kit-pangrams/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one)
A pangram is a string that contains every letter of the alphabet. Given a sentence determine whether it is a pangram in the English alphabet. Ignore case. Return either pangram or not pangram as appropriate.
```Java
    public static String pangrams(String s) {
        for (char letter = 'a'; letter <= 'z'; letter++) {
            if (s.toLowerCase().indexOf(letter) == -1)
                return "not pangram";
        }
        return "pangram";
    }
```

[Java Solution](week1/pangrams/Solution.java) |

### [Permute two arrays](https://www.hackerrank.com/challenges/one-month-preparation-kit-two-arrays/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one)
There are two n-element arrays of integers, A and B. Permute them into some A' and B' such that the relation A'[i] + B'[i] >= k holds for all i where 0<=i<=n. There will be q queries consisting of A, B, and k. For each query, return YES if some permutation A', B' satisfying the relation exists. Otherwise, return NO. 

```Java
  public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) + B.get(i) < k)
                return "NO";
        }
        return "YES";
    }
```

[Java Solution](week1/permutearrays/Solution.java) |

### [Subarray division](https://www.hackerrank.com/challenges/one-month-preparation-kit-the-birthday-bar/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one)
Two children, Lily and Ron, want to share a chocolate bar. Each of the squares has an integer on it.
Lily decides to share a contiguous segment of the bar selected such that:

    * The length of the segment matches Ron's birth month, and,
    * The sum of the integers on the squares is equal to his birth day.

Determine how many ways she can divide the chocolate.

```Java
    public static int birthday(List<Integer> s, int d, int m) {
        // Sliding window technique
        int ways = 0, sum = 0;
        int winSize = m - 1;
        for (int i = 0; i < s.size(); i++) {
            sum += s.get(i);
            if (i >= winSize) {
                if (sum == d)
                    ways++;
                sum -= s.get(i - winSize);
            }
        }
        return ways;
    }
```

[Java Solution](week1/subarraydivision/Solution.java) |


### [XOR Strings]()

```Java

```

[Java Solution]() |

