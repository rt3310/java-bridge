package bridge.view;

import bridge.util.BridgeBlock;
import bridge.util.InformationMessage;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> movementsInUpBridge, List<String> movementsInDownBridge) {
        printUpBridgeMap(movementsInUpBridge);
        printDownBridgeMap(movementsInDownBridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> movementsInUpBridge, List<String> movementsInDownBridge,
                            int trialCount, InformationMessage successOrNot) {
        printEndMessage();
        printMap(movementsInUpBridge, movementsInDownBridge);
        System.out.println(InformationMessage.GAME_IS_SUCCESSFUL.getMessage() + successOrNot.getMessage());
        System.out.println(InformationMessage.TRIAL_COUNT.getMessage() + trialCount);
    }

    private void printUpBridgeMap(List<String> movementsInUpBridge) {
        System.out.println(BridgeBlock.BRIDGE_START.getBlock()
                + String.join(BridgeBlock.BLOCK_DIVISOR.getBlock(), movementsInUpBridge)
                + BridgeBlock.BRIDGE_END.getBlock());
    }

    private void printDownBridgeMap(List<String> movementsInDownBridge) {
        System.out.println(BridgeBlock.BRIDGE_START.getBlock()
                + String.join(BridgeBlock.BLOCK_DIVISOR.getBlock(), movementsInDownBridge)
                + BridgeBlock.BRIDGE_END.getBlock());
    }

    public void printStartMessage() {
        System.out.println(InformationMessage.START.getMessage());
    }

    public void printEndMessage() {
        System.out.println(InformationMessage.END.getMessage());
    }

    public void printBridgeSizeInputMessage() {
        System.out.println(InformationMessage.BRIDGE_LENGTH.getMessage());
    }

    public void printPositionSelectionMessage() {
        System.out.println(InformationMessage.POSITION_SELECTION.getMessage());
    }

    public void printGameCommandSelectionMessage() {
        System.out.println(InformationMessage.GAME_COMMAND_SELECTION.getMessage());
    }
}
