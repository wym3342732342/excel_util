package club.maddm.util.excel.core;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 工作部构建器
 * @author King
 * @version 1.0
 * @date 2020/4/15 16:48
 */
public interface IWorkbookBuild {
    /**
     * 工作簿对象
     */
    interface IWorkbook{
        void setXSSFWorkbook(XSSFWorkbook workbook);

        /**
         * 保存到文件
         * @param path
         */
        void saveFile(String path);
    }

    /**
     * 构建工作簿
     * @param iSheets
     * @return
     */
    IWorkbook build(ISheet...iSheets);
}
