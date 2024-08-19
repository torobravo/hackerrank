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

---
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

---
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

---
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

---
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

---
### [Flipping bits](https://www.hackerrank.com/challenges/one-month-preparation-kit-flipping-bits/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one)
You will be given a list of 32 bit unsigned integers. Flip all the bits (1->0 and 0->1) and return the result as an unsigned integer. 
```Java
    public static long flippingBits(long n) {
        return n ^ 0xffffffffL;
    }
```

[Java Solution](week1/flippingbits/Solution.java) |

---
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

---
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

---
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

---
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

---
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

---
### [XOR Strings](https://www.hackerrank.com/challenges/one-month-preparation-kit-strings-xor/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one)
Given two strings consisting of digits 0 and 1 only, find the XOR of the two strings.

```Java
    public static String stringsXOR(String s, String t) {
        String res = new String("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i))
                res += "0";
            else
                res += "1";
        }
        return res;
    }
```

[Java Solution](week1/xorstrings/Solution.java) |

---
### Mock Test

#### [Find the median]
The median of a list of numbers is essentially its middle element after sorting. The same number of
elements occur after it as before. Given a list of numbers with an odd number of elements, find the median?

```Java
    public static int findMedian(List<Integer> arr) {
        Collections.sort(arr);
        int mid = arr.size() / 2;
        return arr.get(mid);
    }
```

#### [Flipping the Matrix]
Sean invented a game involving a **2n x 2n** matrix where each cell of the matrix contains an integer. He
can reverse any of its rows or columns any number of times. The goal of the game is to maximize the sum
of the elements in the **n x n** submatrix located in the upper-left quadrant of the matrix.
Given the initial configurations for **q** matrices, help Sean reverse the rows and columns of each matrix in the
best possible way so that the sum of the elements in the matrix's upper-left quadrant is maximal.

```Java
    public static int flippingMatrix(List<List<Integer>> matrix) {
        int totalSum = 0;
        int size = matrix.size();
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size / 2; j++) {
                totalSum += Math.max(
                    Math.max(matrix.get(i).get(j), matrix.get(i).get(size-1-j)),
                    Math.max(matrix.get(size-1-i).get(j), matrix.get(size-1-i).get(size-1-j))
                );
            }
        }
        return totalSum;
    }
```
---
## Week 2

### [Sales by Match](https://www.hackerrank.com/challenges/one-month-preparation-kit-sock-merchant/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-two)
There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

```Java
    public static int sockMerchant(int n, List<Integer> ar) {
        int pairs = 0;
        Collections.sort(ar);
        for (int i = 1; i < n; i++) {
            if (ar.get(i) == ar.get(i - 1)) {
                pairs++;
                i++; // jump to next pair
            }
        }
        return pairs;
    }
```

[Java Solution](week2/salesbymatch/Solution.java) |

---
### [Zig Zag Sequence](https://www.hackerrank.com/challenges/one-month-preparation-kit-zig-zag-sequence/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-two)
In this challenge, the task is to debug the existing code to successfully execute all provided test files.
Given an array of distinct integers, transform the array into a zig zag sequence by permuting the array elements. A sequence will be called a zig zag sequence if the first elements in the sequence are in increasing order and the last elements are in decreasing order, where *k=(n+1)/2* . You need to find the lexicographically smallest zig zag sequence of the given array.

```Java
    public static void findZigZagSequence(int[] a, int n) {
        Arrays.sort(a);
        int mid = (n) / 2; // Change 1
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2; // Change 2
        while (st <= ed) {
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1; // Change 3
        }
        for (int i = 0; i < n; i++) {
            if (i > 0)
                System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
```

[Java Solution](week2/zigzag/Main.java) |

---
### [Drawing Book](https://www.hackerrank.com/challenges/one-month-preparation-kit-drawing-book/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-two)
A teacher asks the class to open their books to a page number. A student can either start turning pages from the front of the book or from the back of the book. They always turn pages one at a time. When they open the book, page 1 is always on the right side:

When they flip page 1, they see pages 2 and 3. Each page except the last page will always be printed on both sides. The last page may only be printed on the front, given the length of the book. If the book is n pages long, and a student wants to turn to page p, what is the minimum number of pages to turn? They can start at the beginning or the end of the book.

Given n and p, find and print the minimum number of pages that must be turned in order to arrive at page p. 

```Java
    public static int pageCount(int n, int p) {
        int front = p / 2;
        int back = (n - p) / 2;
        if (n % 2 == 0) // if even pages
            back = (n + 1 - p) / 2; // add 1 page
        return Math.min(front, back);
    }
```

[Java Solution](week2/drawingbook/Solution.java) |

---
### [Tower Breakers](https://www.hackerrank.com/challenges/one-month-preparation-kit-tower-breakers-1/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-two)
Two players are playing a game of Tower Breakers! Player 1 always moves first, and both players always play optimally.The rules of the game are as follows:
- Initially there are *n* towers.
- Each tower is of height *m*. 
- The players move in alternating turns. 
- In each turn, a player can choose a tower of height *x* and reduce its height to *y*, where *1 <= y < x* and *y* evenly divides *x*.
- If the current player is unable to make a move, they lose the game.

Given the values of *n* and *m*, determine which player will win. If the first player wins, return 1. Otherwise, return 2.

```Java
    public static int towerBreakers(int n, int m) {
        // if height(m)=1 player 1 has no moves, so player 2 wins
        // if number of towers(n) is even player 2 wins
        // player 2 will copy every move of player 1
        // if number of towers(n) is odd player 1 wins
        return m == 1 || n % 2 == 0 ? 2 : 1;
    }
```

[Java Solution](week2/towerbreaker/Solution.java) |

---
### [Caesar Cipher](https://www.hackerrank.com/challenges/one-month-preparation-kit-caesar-cipher-1/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-two)
Julius Caesar protected his confidential information by encrypting it using a cipher. Caesar's cipher shifts each letter by a number of letters. If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet. In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.

```Java
    public static String caesarCipher(String s, int k) {
        String result = new String("");
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                char start = Character.isUpperCase(ch) ? 'A' : 'a';
                result += (char) (start + (ch - start + k) % 26);
            } else {
                result += ch;
            }
        }
        return result;
    }
```

[Java Solution](week2/caesarcipher/Solution.java) |

---
### [Max Min](https://www.hackerrank.com/challenges/one-month-preparation-kit-angry-children/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-two)
You will be given a list of integers,`arr` , and a single integer `k`. You must create an array of length `k` from elements of `arr` such that its unfairness is minimized. Call that array `arr'`. Unfairness of an array is calculated as `max(arr') - min(arr')`

```Java
    public static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        int minUnfairness = Integer.MAX_VALUE;
        for (int i = k - 1; i < arr.size(); i++) {
            int min = arr.get(i - k + 1);
            int max = arr.get(i);
            minUnfairness = Math.min(minUnfairness, max - min);
        }
        return minUnfairness;
    }
```

[Java Solution](week2/maxmin/Solution.java) |

---
### [Dynamic Array](https://www.hackerrank.com/challenges/one-month-preparation-kit-dynamic-array/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-two)
- Declare a 2-dimensional array,`arr` , of `n` empty arrays. All arrays are zero indexed. 
- Declare an integer, `lastAnswer`, and initialize it to 0
- There are 2 types of queries, given as an array of strings for you to parse:
    1. Query: 1 x y
        1. Let `idx = ((x XOR lastAnswer) % n)`
        2. Append the integer y to `arr[idx]`
    2. Query: 2 x y
    	1. Let `idx = ((x XOR lastAnwswer) % n)`
    	2. Assign the value `arr[idx][y % size(arr[idx])]` to `lastAnswer`.
        3. Store the new value of `lastAnswer` to an answers array.

Finally, size(arr[idx]) is the number of elements in arr[idx] 

```Java
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>(n);
        int lastAnswer = 0;

        // fill 2d array with empty arrays
        for (int i = 0; i < n; i++)
            arr.add(new ArrayList<>());

        for (List<Integer> query : queries) {
            int q = query.get(0);
            int x = query.get(1);
            int y = query.get(2);
            int idx = ((x ^ lastAnswer) % n);
            switch (q) {
                case 1:
                    arr.get(idx).add(y);
                    break;
                case 2:
                    lastAnswer = arr.get(idx).get(y % arr.get(idx).size());
                    result.add(lastAnswer);
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}
```

[Java Solution](week2/dynamicarray/Solution.java) |

---
### [Grid Challenge](https://www.hackerrank.com/challenges/one-month-preparation-kit-grid-challenge/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-two)
Given a square grid of characters in the range ascii[a-z], rearrange elements of each row alphabetically, ascending. Determine if the columns are also in ascending alphabetical order, top to bottom. Return YES if they are or NO if they are not.

```Java
    public static String gridChallenge(List<String> grid) {
        char[] previousRow = grid.get(0).toCharArray();
        Arrays.sort(previousRow);
        for (int i = 1; i < grid.size(); i++) {
            char[] currentRow = grid.get(i).toCharArray();
            Arrays.sort(currentRow);
            for (int j = 0; j < previousRow.length; j++) {
                if (previousRow[j] > currentRow[j])
                    return "NO";
            }
            previousRow = currentRow;
        }
        return "YES";
    }
```

[Java Solution](week2/gridchallange/Solution.java) |

---
### [Prime Dates](https://www.hackerrank.com/challenges/one-month-preparation-kit-prime-date/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-two)
In this challenge, the task is to debug the existing code to successfully execute all provided test files. 
Given two dates each in the format dd-mm-yyyy, you have to find the number of lucky dates between them (inclusive). To see if a date is lucky,
 - Firstly, sequentially concatenate the date, month and year, into a new integer x erasing the leading zeroes.
 - Now if x is divisible by either 4 or 7, then we call the date a lucky date.
For example, let's take the date "02-08-2024". After concatinating the day, month and year, we get
x = 2082024. As x is divisible by 4 so the date "02-08-2024" is called a lucky date.

Debug the given function findPrimeDates and/or other lines of code, to find the correct lucky dates from the given input.

Note: You can modify at most five lines in the given code and you cannot add or remove lines to the code.

```Java
    public static void updateLeapYear(int year) {
        if (year % 400 == 0) {
            month[2] = 29; // change 1
        } else if (year % 100 == 0) {
            month[2] = 28; // change 2
        } else if (year % 4 == 0) {
            month[2] = 29;
        } else {
            month[2] = 28;
        }
    }

    public static void storeMonth() {
        month[1] = 31;
        month[2] = 28;
        month[3] = 31;
        month[4] = 30;
        month[5] = 31;
        month[6] = 30;
        month[7] = 31;
        month[8] = 31;
        month[9] = 30;
        month[10] = 31;
        month[11] = 30;
        month[12] = 31;
    }

    public static int findPrimeDates(int d1, int m1, int y1, int d2, int m2, int y2) {
        storeMonth();

        int result = 0;

        while (true) {
            int x = d1;
            x = x * 100 + m1;
            x = x * 10000 + y1; // change 3
            if (x % 4 == 0 || x % 7 == 0) { // change 4
                result = result + 1;
            }
            if (d1 == d2 && m1 == m2 && y1 == y2) {
                break;
            }
            updateLeapYear(y1);
            d1 = d1 + 1;
            if (d1 > month[m1]) {
                m1 = m1 + 1;
                d1 = 1;
                if (m1 > 12) {
                    y1 = y1 + 1;
                    m1 = 1; // change 5
                }
            }
        }
        return result;
    }
```

[Java Solution](week2/primedate/Main.java) |

---
### [Sherlock and Array](https://www.hackerrank.com/challenges/one-month-preparation-kit-sherlock-and-array/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-two)
Watson gives Sherlock an array of integers. His challenge is to find an element of the array such that the sum of all elements to the left is equal to the sum of all elements to the right.

```Java
    public static String balancedSums(List<Integer> arr) {
        int totalSum = 0, currentSum = 0;
        for (Integer num : arr)
            totalSum += num;

        for (int i = 0; i < arr.size(); i++) {
            totalSum -= arr.get(i);
            if (currentSum == totalSum) {
                return "YES";
            }
            currentSum += arr.get(i);
        }
        return "NO";
    }
```

[Java Solution](week2/sherlockarray/Solution.java) |

---
### [Recursive Digit Sum](https://www.hackerrank.com/challenges/one-month-preparation-kit-recursive-digit-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-two)
We define super digit of an integer x using the following rules:

Given an integer, we need to find the super digit of the integer.
 - If x has only 1 digit, then its super digit is x
 - Otherwise, the super digit of x is equal to the super digit of the sum of the digits of x.
   
The number p is created by concatenating the string n k times so the initial 
```Java
    public static int superDigit(String n, int k) {
        if (n.length() == 1)
            return Integer.parseInt(n);

        long sum = 0;
        for (char digit : n.toCharArray()) {
            sum += Long.parseLong(String.valueOf(digit));
        }

        return superDigit(String.valueOf(sum * k), 1);
    }
```

[Java Solution](week2/recursivedigitsum/Solution.java) |

---
### [Counter game](https://www.hackerrank.com/challenges/one-month-preparation-kit-counter-game/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-two)
Louise and Richard have developed a numbers game. They pick a number and check to see if it is a power of 2. If it is, they divide it by 2. If not, they reduce it by the next lower number which is a power of 2. Whoever reduces the number to 1 wins the game. Louise always starts.

Given an initial value, determine who wins the game.

```Java
    public static String counterGame(long n) {
        int turn = 0;
        while (n > 1) {
            if ((n & (n - 1)) == 0) { // check if it's a power of 2
                n = n >> 1; // division by 2
            } else {
                int p = 0;
                long v = n;
                while ((v = v >> 1) > 0) // divide by 2 up to 1
                    p++;
                n = n - (1l << p); // 2 raised to power p
            }
            turn++;
        }
        return turn % 2 == 0 ? "Richard" : "Louise";
    }
```

[Java Solution](week2/countergame/Solution.java) |

---
### [Sum vs XOR](https://www.hackerrank.com/challenges/one-month-preparation-kit-sum-vs-xor/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-two)
Given an integer n, find each x such that:
- 0 <= x <= n 
- n + x = n XOR x

Return the number of x's satisfying the criteria.

```Java
    public static long sumXor(long n) {
        // Since (n + x) = (n OR X) = (n XOR x) except when both bits are 1
        // n     x    n|x    n^x     n&x
        // ---------------------------------
        // 0     0     0      0       0
        // 0     1     1      1       0
        // 1     0     1      1       0
        // 1     1     1      0 <---  1
        //
        // The strategy is to only consider when (n OR x) = (n XOR x),
        // and that only occurs when (n AND 1) == 0
        // The way we do that is to loop through all bits and drop the right
        // bit (right shift) in very iteration (n>>1). We count how many times
        // the condition (n AND 1) == 0 is met.
        // Finally we rise the counter to power of 2 to obtain the result.
        // Why power of 2? Because we have 2 possible combination for very bit
        // of n.
        //
        int counter = 0;
        while (n > 0) {
            if ((n & 1) == 0) // count only when n|x == n^x
                counter++;
            n = n >> 1; // drop right-most digit (cut the number in half)
        }

        return 1l << counter; // a nice way to rise a number to power of 2
    }
```

[Java Solution](week2/sumxor/Solution.java) |

---
### Mock Test

#### [Palindrome Index]
Given a string of lowercase letters in the range ascii[a-z], determine the index of a character that can be
removed to make the string a palindrome. There may be more than one solution, but any will do. If the word
is already a palindrome or there is no solution, return -1. Otherwise, return the index of a character to
remove.

```Java
    public static int palindromeIndex(String s) {
        int start = 0;
        int end = s.length() - 1;
        do {
            if (s.charAt(start) != s.charAt(end)) {
                if (isPalindrome(s, start + 1, end))
                    return start;

                return end;
            }
        } while (start++ < end--);

        return -1;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        do {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        } while (start++ < end--);

        return true;
    }
```

[Java Solution](week2/mock/palindromeIndex/Solution.java)

---
#### [Between Two Sets]
There will be two arrays of integers. Determine all integers that satisfy the following two conditions:
1. The elements of the first array are all factors of the integer being considered
2. The integer being considered is a factor of all elements of the second array
These numbers are referred to as being between the two arrays. Determine how many such numbers exist.

```Java
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int lcm = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            lcm = LCM(lcm, a.get(i));
        }

        int gcd = b.get(0);
        for (int i = 1; i < b.size(); i++) {
            gcd = GCD(gcd, b.get(i));
        }

        int result = 0;
        for (int factor = lcm; factor <= gcd; factor += lcm) {
            if (gcd % factor == 0)
                result += 1;
        }

        return result;
    }

    static int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }

    static int LCM(int a, int b) {
        return (a * b) / GCD(a, b);
    }
```

[Java Solution](week2/mock/betweentwosets/Solution.java)

---
#### [Anagram]
Two words are anagrams of one another if their letters can be rearranged to form the other word.
Given a string, split it into two contiguous substrings of equal length. Determine the minimum number of
characters to change to make the two substrings into anagrams of one another

```Java
    public static int anagram(String s) {
        if (s.length() % 2 != 0)
            return -1;
        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2);

        for (Character c : s1.toCharArray()) {
            if (s2.indexOf(c) != -1) //if s2 contains c, remove it
                s2 = s2.replaceFirst(String.valueOf(c), "");
        }

        return s2.length();
    }
```

[Java Solution](week2/mock/anagram/Solution.java)








