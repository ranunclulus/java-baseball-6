package controller;

import domain.BaseBallNumbers;
import domain.RandomNumbers;
import view.inputView;
import view.outputView;

public class BaseBallGameController {
    private static final String CONTINUE = "1";
    private static final String END = "2";
    private static final Integer THREE_STRIKE = 3;

    public static void start() {
        outputView.printGameStartMessage();
        playBaseBallGame();
        checkContinue();
    }

    // playBaseBallGame: 게임 진행
    private static void playBaseBallGame() {
        int strikeCnt = 0;
        int ballCnt = 0;
        RandomNumbers randomNumbers = new RandomNumbers();

        while (strikeCnt != THREE_STRIKE) {
            BaseBallNumbers baseBallNumbers = new BaseBallNumbers(inputView.getRequirePlayerBaseballNumbers());
            ballCnt = baseBallNumbers.calculateBallCount(randomNumbers.getRandomNumbers());
            strikeCnt = baseBallNumbers.calculateStrikeCount(randomNumbers.getRandomNumbers());
            System.out.println("ballCnt = " + ballCnt);
            System.out.println("strikeCnt = " + strikeCnt);
        }
    }

    // checkContinue: 게임을 계속할 것인지 확인
    private static void checkContinue() {
    }
}
