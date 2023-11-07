package lotto.domain;

import static lotto.error.ErrorMessage.DUPLICATED_LOTTO_NUMBER;
import static lotto.error.ErrorMessage.INVALID_LOTTO_NUMBER_LENGTH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final Integer PRICE = 1000;
    public static final Integer MAX_NUMBER = 45;
    public static final Integer MIN_NUMBER = 1;
    public static final Integer NUMBER_LENGTH = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_LENGTH);
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        List<Integer> validDuplicate = new ArrayList<>();
        for (Integer number : numbers) {
            if (validDuplicate.contains(number)) {
                throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER);
            }
        }
    }
}
