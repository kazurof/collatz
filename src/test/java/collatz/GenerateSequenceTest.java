package collatz;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class GenerateSequenceTest {

  static final Logger LOGGER = LogManager.getLogger(GenerateSequenceTest.class);

  @Test
  public void testFactorize() {
    assertThat(GenerateSequence.factorize(1L), is("1"));
    assertThat(GenerateSequence.factorize(2L), is("2"));
    assertThat(GenerateSequence.factorize(3L), is("3"));
    assertThat(GenerateSequence.factorize(4L), is("2x2"));
    assertThat(GenerateSequence.factorize(15L), is("3x5"));
    assertThat(GenerateSequence.factorize(100L), is("2x2x5x5"));
    assertThat(GenerateSequence.factorize(144L), is("2x2x2x2x3x3"));
    assertThat(GenerateSequence.factorize(455L), is("5x7x13"));
    assertThat(GenerateSequence.factorize(457L), is("457"));
  }

  @Test
  public void testFactorizeSquareNumber() {
    assertThat(GenerateSequence.factorize(49L), is("7x7"));

    assertThat(GenerateSequence.factorize(16L), is("2x2x2x2"));
  }


  @Test
  public void testFactorizeSpecialCase() {
    assertThat(GenerateSequence.factorize(3826L), is("2x1913"));
    assertThat(GenerateSequence.factorize(17494L), is("2x8747"));
  }

  @Test
  public void testDivide2pow() {
    assertThat(GenerateSequence.divide2pow(23753L), is(23753L));
    assertThat(GenerateSequence.divide2pow(5724247L), is(5724247L));
    assertThat(GenerateSequence.divide2pow(5724248L), is(353 * 2027L));
    assertThat(GenerateSequence.divide2pow(638512875L), is(638512875L));
  }
  @Test
  public void testFactorizeLargeCase() {

    assertThat(GenerateSequence.factorize(23753L), is("23753"));
    assertThat(GenerateSequence.factorize(5724247L), is("5724247"));
    assertThat(GenerateSequence.factorize(5724248L), is("2x2x2x353x2027"));
    assertThat(GenerateSequence.factorize(638512875L), is("3x3x3x3x3x3x5x5x5x7x7x11x13"));
  }

}
