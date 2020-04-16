package club.maddm.util.excel.core.achieve;

import club.maddm.util.excel.core.IWorkbookBuild;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 智能行合并的工作簿
 * @author King
 * @version 1.0
 * @date 2020/4/15 17:12
 */
public class SmartColumnMergeWorkbook implements IWorkbookBuild.IWorkbook {

    private XSSFWorkbook workbook;

    @Override
    public void setXSSFWorkbook(XSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    @Override
    public void saveFile(String path) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("写入文件失败");
        }
    }
}
