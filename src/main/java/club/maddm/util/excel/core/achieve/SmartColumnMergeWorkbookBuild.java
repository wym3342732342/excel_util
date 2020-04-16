package club.maddm.util.excel.core.achieve;

import club.maddm.util.excel.core.ISheet;
import club.maddm.util.excel.core.ITableRule;
import club.maddm.util.excel.core.ITitleRule;
import club.maddm.util.excel.core.IWorkbookBuild;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 智能行分类构建器
 * @author King
 * @version 1.0
 * @date 2020/4/15 17:14
 */
public class SmartColumnMergeWorkbookBuild implements IWorkbookBuild {
    /**
     * 构建数据部
     * @param iSheets
     * @return
     */
    @Override
    public IWorkbook build(ISheet... iSheets) {
        IWorkbook workbook = new SmartColumnMergeWorkbook();
        XSSFWorkbook xssfSheets = new XSSFWorkbook();
        for (ISheet iSheet : iSheets) {
            XSSFSheet sheet = xssfSheets.createSheet();
            buildSheet(sheet, iSheet);
        }
        workbook.setXSSFWorkbook(xssfSheets);
        return workbook;
    }

    /**
     * 构建单元格
     * @param sheet
     * @param iSheet
     */
    private void buildSheet(XSSFSheet sheet, ISheet iSheet) {
        ITableRule iTableRule = iSheet.getiTableRule();
        //获取表格偏移量
        int tableLeftOff = 0;
        int tableTopOff = 0;

        if (iTableRule != null) {
            tableLeftOff = iTableRule.leftOffset();
            tableTopOff = iTableRule.topOffset();
        }

        XSSFRow xssfRow;//行

        XSSFCell xssfCell;//单元格

        //判断是否有标题
        LinkedList<List<Object>> titleRows = iSheet.getTitleRows();
        Map<String, ITitleRule> titleRule = iSheet.getTitleRule();

        int titleRow = 0;
        if (titleRows != null && titleRows.size() > 0) {
            //创建标题相关信息
            for (int i = 0; i < titleRows.size(); i++, titleRow = i) {
                //取出当前标题的规则
                ITitleRule rule = null;
                if (titleRule != null) {
                    rule = titleRule.get(i+"");
                }
                int leftOffset = 0;
                int rightOffset = 0;
                List<Integer> occupy = null;
                if (rule != null) {
                    leftOffset = rule.leftOffset();
                    rightOffset = rule.rightOffset();
                    occupy = rule.getOccupy();
                }
                List<Object> list = titleRows.get(i);
                if (occupy != null && occupy.size() > 0) {//存在合并规则
                    int last = 0;
                    for (int j = 0; j < list.size(); j++) {
                        //合并单元格
                        CellRangeAddress cellRangeAddress = new CellRangeAddress(i + tableTopOff, i + tableTopOff, last + leftOffset + tableLeftOff, last + leftOffset + tableLeftOff + occupy.get(j) - 1);
                        last += occupy.get(j);//计算上次占据的位置
                        sheet.addMergedRegion(cellRangeAddress);//合并
                    }
                    //添加内容[添加到合并后的单元格]
                    xssfRow = sheet.createRow(i + tableTopOff);
                    last = 0;
                    for (int j = 0; j < list.size(); j++) {
                        //计算偏移量后的第一个单元格
                        xssfCell = xssfRow.createCell(leftOffset + tableLeftOff + last);
                        xssfCell.setCellValue(list.get(j).toString());//设置单元格内容
                        last += occupy.get(j);
                    }
                }else{//不存在合并规则
                    //从规定偏移后的第一行开始写入
                    xssfRow = sheet.createRow(i + tableTopOff);
                    for (int j = 0; j < list.size(); j++) {
                        //计算偏移量后的第一个单元格
                        xssfCell = xssfRow.createCell(j + leftOffset + tableLeftOff);
                        xssfCell.setCellValue(list.get(j).toString());//设置单元格内容
                    }
                }
            }
        }

        //创建数据行相关内容

        List<List<Object>> dataRows = iSheet.getDataRows();

        if (dataRows != null && dataRows.size() > 0) {
            for (int i = 0; i < dataRows.size(); i++) {
                //从规定偏移后的第一行开始写入
                xssfRow = sheet.createRow(i + tableTopOff + titleRow);
                List<Object> list = dataRows.get(i);
                for (int j = 0; j < list.size(); j++) {
                    //计算偏移量后的第一个单元格
                    xssfCell = xssfRow.createCell(j + tableLeftOff);
                    xssfCell.setCellValue(list.get(j).toString());//设置单元格内容
                }
            }
        }
    }
}
