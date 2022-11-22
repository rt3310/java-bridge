package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.User;
import bridge.util.InformationMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameProcessor {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameProcessor(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGame(BridgeMaker bridgeMaker) {
        outputView.printStartMessage();
        BridgeGame bridgeGame = startBridgeGame(setUser(setBridge(bridgeMaker)));

        while (!isOver(bridgeGame)) {
        }
    }

    private boolean isOver(BridgeGame bridgeGame) {
        if (!isContinueMoving(bridgeGame)) {
            outputView.printResult(bridgeGame.getUpBridgeMoveResult(), bridgeGame.getDownBridgeResult(), bridgeGame.getTrialCount(), InformationMessage.FAILURE);
            return true;
        }
        if (bridgeGame.isFinished()) {
            outputView.printResult(bridgeGame.getUpBridgeMoveResult(), bridgeGame.getDownBridgeResult(), bridgeGame.getTrialCount(), InformationMessage.SUCCESS);
            return true;
        }
        return false;
    }

    private boolean isContinueMoving(BridgeGame bridgeGame) {
        boolean isSuccessMoving = isSuccessMoving(bridgeGame);
        outputView.printMap(bridgeGame.getUpBridgeMoveResult(), bridgeGame.getDownBridgeResult());
        if (isSuccessMoving) {
            return true;
        }

        return isRetry(bridgeGame);
    }

    private boolean isRetry(BridgeGame bridgeGame) {
        while (true) {
            try {
                outputView.printGameCommandSelectionMessage();
                return bridgeGame.retry(inputView.readGameCommand());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean isSuccessMoving(BridgeGame bridgeGame) {
        while (true) {
            try {
                outputView.printPositionSelectionMessage();
                return bridgeGame.move(inputView.readMoving());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BridgeGame startBridgeGame(User user) {
        return new BridgeGame(user);
    }

    private Bridge setBridge(BridgeMaker bridgeMaker) {
        while (true) {
            try {
                outputView.printBridgeSizeInputMessage();
                return new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private User setUser(Bridge bridge) {
        return new User(bridge);
    }
}
