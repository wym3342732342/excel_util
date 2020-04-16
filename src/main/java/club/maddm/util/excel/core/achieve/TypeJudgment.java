package club.maddm.util.excel.core.achieve;

import club.maddm.util.excel.core.ITypeJudgment;
import club.maddm.util.excel.domain.SmartColumnMergeCell;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 判断类型
 * @author King
 * @version 1.0
 * @date 2020/4/15 16:07
 */
@Component
public class TypeJudgment {
    /**
     * 注入没有就不注入
     */
    @Autowired(required = false)
    private static ITypeJudgment iTypeJudgment;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static int judgType(Object object, SmartColumnMergeCell smartColumnMergeCell) {
        if (iTypeJudgment != null) {
            return iTypeJudgment.judgType(object,smartColumnMergeCell);
        }
        if (object instanceof Number) {
            //数字类型
            return Cell.CELL_TYPE_NUMERIC;
        } else if (object instanceof Date) {
            //时间的话格式化成字符串
            smartColumnMergeCell.setVal(simpleDateFormat.format((Date) object));
            return Cell.CELL_TYPE_STRING;
        }else {
            smartColumnMergeCell.setVal(object.toString());//装换成字符串
            return Cell.CELL_TYPE_STRING;//其他类型都以字符串形式输出
        }

    }
}
