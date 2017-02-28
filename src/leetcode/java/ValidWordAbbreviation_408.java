package leetcode.java;

public class ValidWordAbbreviation_408 {
  public boolean validWordAbbreviation(String word, String abbr) {
    char[] wordChars = word.toCharArray();
    char[] abbrChars = abbr.toCharArray();
    if (abbrChars.length > wordChars.length) return false;
    int i = 0;
    int num, fac;
    for (int j = 0; j < abbrChars.length; j++) {
      fac = 1;
      num = 0;
      while (j < abbrChars.length && Character.isDigit(abbrChars[j])) {
        num = num * fac + abbrChars[j] - '0';
        j++;
        fac *= 10;
        if (num == 0) break;
      }
      i += num;
      if (j < abbrChars.length && Character.isLetter(abbrChars[j])) {
        if (i >= wordChars.length) return false;
        if (abbrChars[j] == wordChars[i]) i++;
        else return false;
      }
    }
    return i == wordChars.length;
  }
}
