package club.maddm.util.excel.core.achieve;

import club.maddm.util.excel.core.ITitleRule;

import java.util.List;

/**
 * 智能列合并表头规则
 * @author King
 * @version 1.0
 * @date 2020/4/16 12:45
 */
public class SmartColumnMergeTitleRule implements ITitleRule {

    private int leftOffset;

    private int rightOffset;

    private List<Integer> occupy;

    @Override
    public int leftOffset() {
        return leftOffset;
    }

    @Override
    public int rightOffset() {
        return rightOffset;
    }

    @Override
    public void setLeftOff(int leftOff) {
        this.leftOffset = leftOff;
    }

    @Override
    public void setRightOff(int rightOff) {
        this.rightOffset = rightOff;
    }

    @Override
    public void setOccupy(List<Integer> occupy) {
        this.occupy = occupy;
    }

    @Override
    public List<Integer> getOccupy() {
        return this.occupy;
    }
}
