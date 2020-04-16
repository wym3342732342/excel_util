package club.maddm.util.excel.core;

import club.maddm.util.excel.domain.SmartColumnMergeCell;

/**
 * 类型判断接口
 * @author King
 * @version 1.0
 * @date 2020/4/15 16:05
 */
public interface ITypeJudgment {
    /**
     * 判断
     * @param object 值
     * @param smartColumnMergeCell 智能列合并对象
     * @return
     */
    int judgType(Object object, SmartColumnMergeCell smartColumnMergeCell);
}
