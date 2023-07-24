class Solution {
  public double myPow(double x, long n) {
      //base condition for the recursive
      //where if x^0 or x^1 then ans = 1
    if (n == 0)
      return 1;
      //for negative numbers
    if (n < 0)
      return 1 / myPow(x, -n);
    if (n % 2 == 1)
      return x * myPow(x, n - 1);
      //else reducing the number of steps dividind it in even power
    return myPow(x * x, n / 2);
  }
}