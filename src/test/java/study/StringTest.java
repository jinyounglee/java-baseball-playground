package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @DisplayName("split 테스트 인자가 1, 2 일 때")
    @Test
    void splitTest() {
        String actual = "1,2";
        String[] split = actual.split(",");
        assertThat(split).containsExactly("1", "2");
    }

    @DisplayName("split 테스트 인자가 하나일 때")
    @Test
    void splitTestOnly1() {
        String actual = "1";
        String[] split = actual.split(",");
        assertThat(split).containsExactly("1");
    }

    @DisplayName("괄호 제거")
    @Test
    void replaceRemoveParenthesis() {
        String actual = "(1,2)";
        String replace = actual.substring(1, 4);

        assertThat(replace).isEqualTo("1,2");
    }

    @DisplayName("특정 문자 위치 테스트")
    @Test
    void charAtTest() {
        String abc = "abc";
        char actual = abc.charAt(0);
        assertThat(actual).isEqualTo('a');
    }

    @DisplayName("특정 문자 위치 테스트 OutOfBoundsException")
    @Test
    void charAtExceptionTest() {
        assertThatThrownBy(() -> {
            String abc = "abc";
            char actual = abc.charAt(3);
            assertThat(actual).isEqualTo('a');
        }).hasMessage("String index out of range: 3");
    }

    @DisplayName("assertThatExceptionOfType 사용")
    @Test
    void charAtExceptionOfType() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    String abc = "abc";
                    char actual = abc.charAt(3);
                    assertThat(actual).isEqualTo('a');
                }).withMessageMatching("String index out of range: \\d+");
    }

    @DisplayName("illegalArgumentsException 테스트")
    @Test
    void illegalArgumentsTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    throw new IllegalArgumentException();
                });
    }

}
