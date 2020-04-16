package club.maddm.util.excel.core;

import java.util.List;

/**
 * 标题规则
 * @author King
 * @version 1.0
 * @date 2020/4/16 11:16
 */
public interface ITitleRule {
    /**
     * 左侧偏移
     * @return
     */
    int leftOffset();

    /**
     * 右侧偏移
     * @return
     */
    int rightOffset();

    /**
     * 设置左偏移
     * @param leftOff
     */
    void setLeftOff(int leftOff);

    /**
     * 设置右偏移
     * @param rightOff
     */
    void setRightOff(int rightOff);

    /**
     * 设置单元格占据
     * @param occupy
     */
    void setOccupy(List<Integer> occupy);

    /**
     *返回单元格占据信息
     * @return
     */
    List<Integer> getOccupy();
}
