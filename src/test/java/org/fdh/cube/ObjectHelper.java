package org.fdh.cube;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Object帮助类 功能：此类提供处理 <Object>对象一系列方法
 * 
 * @author 贺亮
 * 
 */
public class ObjectHelper {

    /**
     * 将id数组转换为id集合
     * 
     * @param ids
     * @return
     */
    public static List<Long> initIds(String[] ids) {
        List<Long> list = new ArrayList<Long>();
        list.add(-1L);
        for (int i = 0; i < ids.length; i++) {
            list.add(Long.valueOf(ids[i]));
        }
        return list;
    }

    /**
     * 组装条件
     * 
     * @param str
     * @return
     */
    public static List<String> strToList(String str) {
        if (isEmpty(str)) {
            return null;
        }
        String[] strs = str.split(",");
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i]);
        }
        return list;
    }

    /**
     * 判断这个Object是否为Null或长度为0
     * 
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof Collection) {
            return ((Collection<?>) obj).isEmpty();
        }

        if (obj instanceof String) {
            return ((String) obj).equalsIgnoreCase("null")
                    | ((String) obj).trim().toString().equals("");
        }

        if (obj instanceof StringBuffer) {
            return ((StringBuffer) obj).length() == 0;
        }

        if (obj.getClass().isArray()) {
            try {
                Object[] a = (Object[]) obj;

                boolean b = true;
                for (Object o : a) {
                    b = b & isEmpty(o);

                    if (!b) {
                        break;
                    }
                }

                return b;
            } catch (ClassCastException e) {
            }
        }
        return false;
    }

    /**
     * 判断这个Object是否不为Null或长度不为0
     * 
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 返回首字母大写单词
     * 
     * @param str
     * @return
     */
    public static String lcyFirstLetterToUpper(String str) {
        return str.replaceFirst(str.substring(0, 1), str.substring(0, 1)
                .toUpperCase());
    }

    /**
     * 转换为下划线
     * 
     * @param camelCaseName
     * @return
     */
    public static String underscoreName(String camelCaseName) {
        StringBuilder result = new StringBuilder();
        if (camelCaseName != null && camelCaseName.length() > 0) {
            result.append(camelCaseName.substring(0, 1).toLowerCase());
            for (int i = 1; i < camelCaseName.length(); i++) {
                char ch = camelCaseName.charAt(i);
                if (Character.isUpperCase(ch)) {
                    result.append("_");
                    result.append(Character.toLowerCase(ch));
                } else {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }

    /**
     * 转换为驼峰
     * 
     * @param underscoreName
     * @return
     */
    public static String camelCaseName(String underscoreName) {
        StringBuilder result = new StringBuilder();
        if (underscoreName != null && underscoreName.length() > 0) {
            boolean flag = false;
            for (int i = 0; i < underscoreName.length(); i++) {
                char ch = underscoreName.charAt(i);
                if ("_".charAt(0) == ch) {
                    flag = true;
                } else {
                    if (flag) {
                        result.append(Character.toUpperCase(ch));
                        flag = false;
                    } else {
                        result.append(ch);
                    }
                }
            }
        }
        return result.toString();
    }

    /**
     * 
     * @Title: objectToStr
     * @Description: TODO(对象转字符串)
     * @author Mrwang
     * @param obj
     */
    public static String objectToStr(Object obj) {
        if (isEmpty(obj)) {
            return "";
        } else {
            return obj.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(underscoreName("loginName"));
    }
}
