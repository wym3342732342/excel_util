package club.maddm.util.excel.core;

/**
 * 表格规则
 * @author King
 * @version 1.0
 * @date 2020/4/16 11:16
 */
public interface ITableRule {
    /**
     * 左侧偏移
     * @return
     */
    int leftOffset();

    /**
     * 上部偏移
     * @return
     */
    int topOffset();

    /**
     * 设置左偏移
     * @param leftOff
     */
    void setLeftOff(int leftOff);

    /**
     * 设置上偏移
     * @param topOff
     */
    void setTopOff(int topOff);
}
