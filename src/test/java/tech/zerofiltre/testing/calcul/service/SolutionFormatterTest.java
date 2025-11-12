package tech.zerofiltre.testing.calcul.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

@Disabled
class SolutionFormatterTest {

  private SolutionFormatter solutionFormatter;

  @BeforeEach
  void initFormatter() {
    solutionFormatter = new SolutionFormatterImpl();
  }

  @Test
  void format_shouldFormatAnyBigNumber() {
    // GIVEN
    final int number = 1234567890;

    // WHEN
    final String result = new String(solutionFormatter.format(number).getBytes(), StandardCharsets.UTF_8);

    // THEN
    assertThat(result).isEqualTo("1 234 567 890");
  }

}
