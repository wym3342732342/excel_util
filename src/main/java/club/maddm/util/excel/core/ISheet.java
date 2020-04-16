package club.maddm.util.excel.core;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 工作表构建器
 */
public interface ISheet {
    /**
     * 获取行大小
     * @return
     */
    int getRow();

    /**
     * 设置数据行
     * @param lists
     */
    ISheet setDateRow(List<List<Object>> lists);

    /**
     * 在顶部增加标题
     */
    ISheet addTilteRowFirst(List<Object> list);

    /**
     * 在底部增加标题
     * @param list
     */
    ISheet addTilteRowEnd(List<Object> list);

    /**
     * 定义标题规则
     */
    ISheet addTitleRule(Map<String, ITitleRule> titleRuleMap);

    /**
     * 定义表格规则
     */
    ISheet addTableRule(ITableRule iTableRule);

    /**
     * 获取标题规则
     * @return
     */
    Map<String, ITitleRule> getTitleRule();

    /**
     * 获取表格规则
     * @return
     */
    ITableRule getTableRule();

    public ITableRule getiTableRule();

    public LinkedList<List<Object>> getTitleRows();

    public List<List<Object>> getDataRows();
}