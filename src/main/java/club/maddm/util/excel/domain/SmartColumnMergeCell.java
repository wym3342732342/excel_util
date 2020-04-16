package club.maddm.util.excel.domain;

import club.maddm.util.excel.core.achieve.TypeJudgment;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * 单元格实体类【支持行合并】
 * @author King
 * @version 1.0
 * @date 2020/4/15 15:47
 */
public class SmartColumnMergeCell {

    private Integer row;
    private Integer column;

    private Object value;

    private int type;

    private CellRangeAddress cellRangeAddress;//单元格合并信息【智能进行行合并】

    public CellRangeAddress getCellRangeAddress() {
        return cellRangeAddress;
    }

    /**
     * 设置列合并开始结束位置
     * @param starCol
     * @param endCol
     */
    public void setCellRangeAddress(int starCol, int endCol) {
        this.cellRangeAddress = new CellRangeAddress(row, row, starCol, endCol);
    }

    /**
     * 设置value时判断其类型
     * @param value
     */
    public void setValue(Object value) {
        this.value = value;
        this.setType(TypeJudgment.judgType(value, this));
    }

    /**
     * 设置val
     * @param object
     */
    public void setVal(Object object) {
        value = object;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Object getValue() {
        return value;
    }

    public int getType() {
        return type;
    }

    private void setType(int type) {
        this.type = type;
    }
}
