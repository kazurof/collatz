package collatz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrimeIndexValueTest {

  @Test
  public void testGetValue() throws Exception {
    PrimeIndexValue piv = new PrimeIndexValue(22L);

    System.out.println(piv.getContractedValue());
    assertThat(piv.getContractedValue(), is("[ 1, <3>, 1 ]"));
    assertThat(new PrimeIndexValue(52L).getContractedValue(), is("[ 2, <4>, 1 ]"));
    assertThat(new PrimeIndexValue(100L).getContractedValue(), is("[ 2, <1>, 2 ]"));

  }
}
