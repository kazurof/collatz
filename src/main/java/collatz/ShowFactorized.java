package collatz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Stream;


public class ShowFactorized {
  static final Logger LOGGER = LogManager.getLogger(ShowFactorized.class);

  public static void main(String[] args) {
    Stream.iterate(1L, i -> i + 1L).limit(100).forEach(
      i -> {
        long target = 2 * i +1;

        long m3 = target * 3;

        PrimeIndexValue piv = new PrimeIndexValue(m3);
        PrimeIndexValue piv2 = new PrimeIndexValue(m3+1);

        LOGGER.info(String.format("%2d  %-30s ",m3,  piv.getValue()));
        LOGGER.info(String.format("%2d  %-30s ",m3+1,  piv2.getValue()));
        LOGGER.info("----------------------------------------------------");
      }

    );
  }
}
