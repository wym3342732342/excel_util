package club.maddm.util.excel;

import club.maddm.util.excel.core.ISheet;
import club.maddm.util.excel.core.IWorkbookBuild;
import club.maddm.util.excel.core.achieve.SmartColumnMergeSheet;
import club.maddm.util.excel.core.achieve.SmartColumnMergeTitleRule;
import club.maddm.util.excel.core.achieve.SmartColumnMergeWorkbookBuild;
import club.maddm.util.excel.domain.TestObj;
import club.maddm.util.excel.util.ExcelObjectUtil;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author King
 * @version 1.0
 * @date 2020/4/15 15:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @org.junit.Test
    public void test1(){
        String path = "/Volumes/Macuntosh Info/test.xlsx";
        SmartColumnMergeTitleRule titleRule = new SmartColumnMergeTitleRule();
        titleRule.setLeftOff(1);
        titleRule.setOccupy(Arrays.asList(2, 2, 2));
        ISheet iSheet = SmartColumnMergeSheet.build()
                .addTitleRule(Collections.singletonMap("0", titleRule))
                .addTilteRowFirst(Arrays.asList("123", "456", "789"))
                .addTilteRowEnd(Arrays.asList(1,2,3,4,5,6,7))
                .setDateRow(Arrays.asList(
                        Arrays.asList("小小王","是","世界上","最帅的人","后","来","他"),
                        Arrays.asList("吃胖了","然后","就不再帅","了","。","。","。"),
                        Arrays.asList("这可怎么办呢","凉拌","大葱","就","打算","哈哈","哈"),
                        Arrays.asList("！","！","！","！","！","！","！"),
                        Arrays.asList("小毛子","是谁","，一个","。","。","。","的"),
                        Arrays.asList("女人","！","真的","。","。","。","。"),
                        Arrays.asList("1","2","3","4","5","6","7")
                ));

        IWorkbookBuild.IWorkbook iWorkbook
                = new SmartColumnMergeWorkbookBuild().build(iSheet);
        iWorkbook.saveFile(path);
    }

    @org.junit.Test
    public void testObj() {
            TestObj obj = new TestObj("小小王", 18, "1115-1");
            TestObj obj1 = new TestObj("小小王", 128, "1115-1");
            TestObj obj2 = new TestObj();
            TestObj obj3 = new TestObj("小小王", 158, "1115-1");
        List<List<Object>> lists = ExcelObjectUtil.objListToLList(Arrays.asList(
                obj, obj1, obj2, obj3), Arrays.asList("name", "age", "clasz"));
        lists.forEach(
                item ->
                        item.forEach(System.out::println)
        );

        SmartColumnMergeTitleRule titleRule = new SmartColumnMergeTitleRule();
        titleRule.setOccupy(Arrays.asList(2, 1));
        ISheet iSheet = SmartColumnMergeSheet.build()
                .addTilteRowFirst(Arrays.asList("姓名", "年龄", "班级"))
                .addTilteRowFirst(Arrays.asList("个人信息", "班级信息"))
                .addTitleRule(Collections.singletonMap("0", titleRule))
                .setDateRow(lists);
        IWorkbookBuild.IWorkbook build = new SmartColumnMergeWorkbookBuild().build(iSheet);
        build.saveFile("/Volumes/Macuntosh Info/test.xlsx");
    }
}
