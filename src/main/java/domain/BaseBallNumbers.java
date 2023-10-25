package domain;

import exception.InvalidBaseBallLengthException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BaseBallNumbers {
    private static final int BASEBALL_LENGTH = 3;
    private static List<BaseBall> playerBaseBallNumbers;

    public BaseBallNumbers(String playerBaseballNumbers) {
        validateNumberLength(playerBaseballNumbers);
        this.playerBaseBallNumbers = convertBaseBallNumbers(playerBaseballNumbers);
    }

    // convertBaseBallNumbers: 사용자의 공 입력값을 BaseBallNumber 객체로 변환
    private List<BaseBall> convertBaseBallNumbers(String playerBaseballNumbers) {
        List<BaseBall> playerBaseBallList = new ArrayList<>();
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            playerBaseBallList.add(new BaseBall(convertCharToInt(playerBaseballNumbers.charAt(i))));
        }
        return playerBaseBallList;
    }

    // validateNumberLength: 사용자가 입력한 공이 세 개인지 확인
    private void validateNumberLength(String playerBaseballNumbers) {
        if (playerBaseballNumbers.length() != BASEBALL_LENGTH) {
            throw new InvalidBaseBallLengthException();
        }
    }

    // convertCharToInt: 공에 대한 문자열 입력값 중 자리마다 정수로 전환
    private int convertCharToInt(Character baseballNumber) {
        return Character.getNumericValue(baseballNumber);
    }

    // calculateBallCount: Ball의 개수 계산
    public int calculateBallCount(List<BaseBall> randomNumbers) {
        return (int) IntStream.range(0, BASEBALL_LENGTH)
               .filter(index -> isBall(index, randomNumbers))
               .count();
    }

    // isBall: targetIndex에 해당하는 공이 Ball인지 판별
    private boolean isBall(int targetIndex, List<BaseBall> randomNumbers) {
        BaseBall randomBaseBall = randomNumbers.get(targetIndex);
        BaseBall playerBaseBall = playerBaseBallNumbers.get(targetIndex);
        return (!randomBaseBall.equals(playerBaseBall) &&
                containsNumber(randomBaseBall));
    }

    private boolean containsNumber(BaseBall randomBaseBall) {
        return playerBaseBallNumbers.stream()
                .anyMatch(baseBall -> baseBall.equals(randomBaseBall));
    }
}
