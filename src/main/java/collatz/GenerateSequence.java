package collatz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateSequence {
  static final Logger LOGGER = LogManager.getLogger(GenerateSequence.class);

  public static void main(String[] args) {
    long start = 1L;
    if (args.length != 0) {
      start = Long.parseLong(args[0]);
    }

    long i = start;

    long round = 0;
    String message = genMessage(i, round, "init ");
    LOGGER.info(message);
    while (i != 1L) {
      round++;
      if (i % 2L == 1L) {
        i = i * 3L + 1L;
        message = genMessage(i, round, "odd  ");
      } else {
        i = i / 2L;
        message = genMessage(i, round, "even ");
      }
      LOGGER.info(message);

    }
  }

  static String genMessage(long i, long round, String type) {
    String format = "%10d  %20s  %10s %s %s round %4d";
    return String.format(format, i, factorize(i), divide2pow(i), type, new PrimeIndexValue(i), round);
  }

  /**
   * factorize the contractedValue.
   * return "2x2x5x5" for 100.
   */
  static String factorize(long val) {
    if (val == 1L) {
      return "1";
    }
    List<Long> result = new ArrayList<>();
    BigInteger bi = BigInteger.ONE;
    double root = Math.sqrt(val);
    while (bi.doubleValue() <= root && val != 1L) {
      long prime = bi.nextProbablePrime().longValue();
      while (val % prime == 0L) {
        result.add(prime);
        val = val / prime;
      }
      bi = BigInteger.valueOf(prime);
    }
    if (1L < val) {
      result.add(val);
    }
    return result.stream().map(String::valueOf).collect(Collectors.joining("x"));
  }


  static long divide2pow(long val) {
    if (val == 1L) {
      return 1L;
    }
    long result = val;
    while (result % 2 == 0) {
      result /= 2;
    }
    return result;
  }


}
