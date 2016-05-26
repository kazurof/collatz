package collatz;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * factorize the contractedValue.
 * return [ 2, <1>, 2 ] to represent "2x2x5x5" for 100.
 * return [ 2, <4>, 1 ] to represent "2x2x13" for 52.
 */
class PrimeIndexValue {


  String contractedValue = "";
  List<Long> indexValues = new ArrayList<>();


  PrimeIndexValue(long originalValue) {
    if(originalValue == 0){
      throw new IllegalArgumentException();
    }
    BigInteger bi = BigInteger.ONE;
    int primePos = 0;


    while (originalValue != 1L) {
      long prime = bi.nextProbablePrime().longValue();
      while (originalValue % prime == 0L) {
        while (indexValues.size() < primePos + 1) {
          indexValues.add(0L);
        }
        indexValues.set(primePos, indexValues.get(primePos) + 1L);
        originalValue = originalValue / prime;
      }
      primePos++;
      bi = BigInteger.valueOf(prime);
    }

    StringJoiner sj = new StringJoiner(", ", "[ ", " ]");
//    System.out.println(indexValues);
    for (int i = 0; i < indexValues.size(); i++) {
      long val = indexValues.get(i);
      if (val != 0) {
        sj.add(String.valueOf(val));
      } else {
        int span = 0;
        while (val == 0) {
          span++;
          i++;
          val = indexValues.get(i);
        }
        sj.add(String.format("<%d>", span));
        sj.add(String.valueOf(val));
      }
    }
    contractedValue = sj.toString();
  }

  public String getContractedValue() {
    return contractedValue;
  }
  public String getValue() {
    return indexValues.toString();
  }

  @Override
  public String toString() {
    return contractedValue;
  }
}
