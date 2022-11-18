package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridgeBlocks;

    public Bridge(List<String> bridgeBlocks) {
        this.bridgeBlocks = bridgeBlocks;
    }

    public boolean isPossibleToMove(String bridgePosition, int order) {
        return bridgeBlocks.get(order).equals(bridgePosition);
    }
}
