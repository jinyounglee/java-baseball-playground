package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("set 사이즈를 구한다.")
    @Test
    void setSize() {
        Assertions.assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void contains() {
        Assertions.assertThat(numbers).contains(1);
        Assertions.assertThat(numbers).contains(2);
        Assertions.assertThat(numbers).contains(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsWithParameter(Integer param) {
        Assertions.assertThat(numbers).contains(param);
    }
}
