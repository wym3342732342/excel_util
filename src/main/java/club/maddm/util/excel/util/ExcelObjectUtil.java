package club.maddm.util.excel.util;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * excel用对象工具类
 * @author King
 * @version 1.0
 * @date 2020/4/16 14:38
 */
public class ExcelObjectUtil {
    /**
     * 根据顺序转换为list
     * @param obj
     * @param list
     * @return
     */
    public static List<Object> objToList(Object obj, List<String> list) {
        if (obj == null || list == null || list.size() == 0) {
            return null;
        }
        try {
            ArrayList<Object> objects = new ArrayList<>();
            Map<String, String> map = BeanUtils.describe(obj);
            for (String key : list) {
                String val = map.getOrDefault(key, "");
                if (val != null) {
                    objects.add(val);
                }else {
                    objects.add("");
                }
            }
            return objects;
        } catch (Exception e) {
            System.out.println("属性转换异常");
            throw new RuntimeException(e);
        }
    }

    /**
     * 对象数组转list【会过滤空行】
     * @param objectList
     * @param list
     * @return
     */
    public static List<List<Object>> objListToLList(List<Object> objectList, List<String> list) {
        List<List<Object>> lists = null;
        if (objectList != null && list != null) {
            lists = new ArrayList<>();
            for (Object o : objectList) {
                List<Object> toList = objToList(o, list);
                if (toList!=null) lists.add(toList);
            }
        }
        return lists;
    }
}
