package club.maddm.util.excel.core.achieve;

import club.maddm.util.excel.core.ITableRule;

/**
 * 智能列合并表规则
 * @author King
 * @version 1.0
 * @date 2020/4/16 12:44
 */
public class SmartColumnMergeTableRule implements ITableRule {
    @Override
    public int leftOffset() {
        return 0;
    }

    @Override
    public int topOffset() {
        return 0;
    }

    @Override
    public void setLeftOff(int leftOff) {

    }

    @Override
    public void setTopOff(int topOff) {

    }
}
