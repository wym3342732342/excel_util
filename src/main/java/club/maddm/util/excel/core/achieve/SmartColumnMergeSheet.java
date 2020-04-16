package club.maddm.util.excel.core.achieve;

import club.maddm.util.excel.core.ISheet;
import club.maddm.util.excel.core.ITableRule;
import club.maddm.util.excel.core.ITitleRule;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 智能行合并工作簿
 * @author King
 * @version 1.0
 * @date 2020/4/15 16:58
 */
public class SmartColumnMergeSheet implements ISheet {

    private int row;//行大小可不设置

    private List<List<Object>> dataRows;//数据行

    private LinkedList<List<Object>> titleRows;//标题行

    private Map<String, ITitleRule> titleRuleMap;//标题规则

    private ITableRule iTableRule;//表格规则

    /**
     * 私有化构造方法
     */
    private SmartColumnMergeSheet(int row) {
        this.row = row;
        this.titleRows = new LinkedList<>();
    }

    public static ISheet build() {
        return build(0);
    }
    public static ISheet build(int row) {
        return new SmartColumnMergeSheet(row);
    }

    @Override
    public int getRow() {
        return this.row;
    }

    /**
     * 设置数据行
     * @param lists
     */
    @Override
    public ISheet setDateRow(List<List<Object>> lists) {
        this.dataRows = lists;
        if (row == 0 && lists != null && lists.size() > 0) {
            //推算最长行
            int bigRowSize = 0;
            for (List<Object> list : lists) {
                if (list.size() > bigRowSize) {
                    bigRowSize = list.size();
                }
            }
        }
        return this;
    }

    /**
     * 标题首部添加标题行
     * @param list
     */
    @Override
    public ISheet addTilteRowFirst(List<Object> list) {
        if (list != null && list.size() > 0) {
            this.titleRows.addFirst(list);
        }
        return this;
    }

    /**
     * 标题尾部添加标题行
     * @param list
     */
    @Override
    public ISheet addTilteRowEnd(List<Object> list) {
        if (list != null && list.size() > 0) {
            this.titleRows.addLast(list);
        }
        return this;
    }


    /**
     * 定义行规则
     * @param titleRuleMap
     */
    @Override
    public ISheet addTitleRule(Map<String, ITitleRule> titleRuleMap) {
        this.titleRuleMap = titleRuleMap;
        return this;
    }

    /**
     * 定义表格规则
     * @param iTableRule
     */
    @Override
    public ISheet addTableRule(ITableRule iTableRule) {
        this.iTableRule = iTableRule;
        return this;
    }

    @Override
    public Map<String, ITitleRule> getTitleRule() {
        return this.titleRuleMap;
    }

    @Override
    public ITableRule getTableRule() {
        return this.iTableRule;
    }

    public ITableRule getiTableRule() {
        return iTableRule;
    }

    public LinkedList<List<Object>> getTitleRows() {
        return titleRows;
    }

    public List<List<Object>> getDataRows() {
        return dataRows;
    }
}
