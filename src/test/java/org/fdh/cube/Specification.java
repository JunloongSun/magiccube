/** 
 * @Description: (用一句话描述该文件做什么) 
 * @author heliang 
 * @date 2018-7-6 下午6:43:42 
 * @version V2.1 
 */

package org.fdh.cube;

import java.util.List;

import org.fdh.cube.ObjectHelper;

/**
 * @ClassName: Specification
 * @Description: (这里用一句话描述这个类的作用)
 * @author heliang
 * @date 2018-7-6 下午6:43:42
 * @version V2.1 * Update Logs: * Name: * Date: * Description: 初始化
 */

public class Specification {

    private StringBuilder where = new StringBuilder();
    private String groupBy;
    private String having;
    private String orderBy;
    private String limit;

    public StringBuilder getWhere() {
        return where;
    }

    public void setWhere(StringBuilder where) {
        this.where = where;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public String getHaving() {
        return having;
    }

    public void setHaving(String having) {
        this.having = having;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Specification addOrderBy(String columns, String order) {
        if (!isEmpty(columns) && !isEmpty(order)) {
            this.orderBy = ObjectHelper.underscoreName(columns) + " " + order;
        }
        return this;
    }

    public Specification limit(Integer... rows) {
        if (rows != null) {
            if (rows.length == 1) {
                limit = " limit " + rows[0];
            } else if (rows.length == 2) {
                limit = " limit " + rows[0] + "," + rows[1];
            } else {
                limit = "";
            }
        }
        return this;
    }

    public Specification orLike(String value, String... columns) {
        if (!isEmpty(value)) {
            StringBuffer strBuf = new StringBuffer("");
            for (String column : columns) {
                strBuf.append(ObjectHelper.underscoreName(column) + " like '%"
                        + value + "%' or ");
            }
            String orLikeStr = strBuf.substring(0, strBuf.lastIndexOf("or"));
            where.append(" and (" + orLikeStr + ")");
        }
        return this;
    }

    public Specification eq(String column, String value) {
        if (!isEmpty(value)) {
            where.append(" and " + ObjectHelper.underscoreName(column) + " = '"
                    + sqlParam(value) + "'");
        }
        return this;
    }

    public Specification eq(String column, int value) {
        where.append(" and " + ObjectHelper.underscoreName(column) + " = "
                + value + "");
        return this;
    }

    public Specification ne(String column, String value) {
        if (!isEmpty(value)) {
            where.append(" and " + ObjectHelper.underscoreName(column)
                    + " != '" + sqlParam(value) + "'");
        }
        return this;
    }

    public Specification notNull(String column) {
        where.append(" and " + ObjectHelper.underscoreName(column)
                + " is not null");
        return this;
    }

    public Specification isNull(String column) {
        where.append(" and " + ObjectHelper.underscoreName(column) + " is null");
        return this;
    }

    public Specification eqOrIsNull(String column, String eqValue) {
        where.append(" and (" + ObjectHelper.underscoreName(column) + " = "
                + eqValue + "");
        where.append(" or " + ObjectHelper.underscoreName(column) + " is null)");
        return this;
    }

    public Specification like(String column, String value) {
        if (!isEmpty(value)) {
            where.append(" and " + ObjectHelper.underscoreName(column)
                    + " like '%" + sqlParam(value) + "%'");
        }
        return this;
    }

    public Specification notLike(String column, String value) {
        if (!isEmpty(value)) {
            where.append(" and " + ObjectHelper.underscoreName(column)
                    + " not like '%" + sqlParam(value) + "%'");
        }
        return this;
    }

    public Specification in(String column, String... values) {
        if (!isEmpty(values)) {
            where.append(" and " + ObjectHelper.underscoreName(column)
                    + " in (" + inValuesString(values) + ")");
        }
        return this;
    }

    public Specification in(String column, List list) {
        if (ObjectHelper.isNotEmpty(list)) {
            where.append(" and " + ObjectHelper.underscoreName(column)
                    + " in (" + inValuesString(list) + ")");
        }
        return this;
    }

    public Specification notIn(String column, String... values) {
        if (!isEmpty(values)) {
            where.append(" and " + ObjectHelper.underscoreName(column)
                    + " not in (" + inValuesString(values) + ")");
        }
        return this;
    }

    public Specification gt(String column, String value) {
        if (!isEmpty(value)) {
            where.append(" and " + ObjectHelper.underscoreName(column) + " > '"
                    + sqlParam(value) + "'");
        }
        return this;
    }

    public Specification gte(String column, String value) {
        if (!isEmpty(value)) {
            where.append(" and " + ObjectHelper.underscoreName(column)
                    + " >= '" + sqlParam(value) + "'");
        }
        return this;
    }

    public Specification lt(String column, String value) {
        if (!isEmpty(value)) {
            where.append(" and " + ObjectHelper.underscoreName(column) + " < '"
                    + sqlParam(value) + "'");
        }
        return this;
    }

    public Specification lte(String column, String value) {
        if (!isEmpty(value)) {
            where.append(" and " + ObjectHelper.underscoreName(column)
                    + " <= '" + sqlParam(value) + "'");
        }
        return this;
    }

    public Specification between(String column, String from, String to) {
        if (isEmpty(from) && isEmpty(to)) {
            return this;
        }
        if (isEmpty(to)) {
            where.append(" and " + ObjectHelper.underscoreName(column)
                    + " >= '" + sqlParam(from) + "'");
        } else if (isEmpty(from)) {
            where.append(" and " + ObjectHelper.underscoreName(column)
                    + " <= '" + sqlParam(to) + "'");
        } else {
            where.append(" and " + ObjectHelper.underscoreName(column)
                    + " between '" + sqlParam(from) + "' and '" + sqlParam(to)
                    + "'");
        }
        return this;
    }

    public String sql() {
        StringBuilder sql = new StringBuilder("");
        final int a = 4;
        final int b = 5;
        if (where.length() > a) {
            sql.append(" " + where.substring(b));
        }
        if (!isEmpty(groupBy)) {
            sql.append(" group by " + groupBy);
        }
        if (!isEmpty(having)) {
            sql.append(" having " + having);
        }
        if (!isEmpty(orderBy)) {
            sql.append(" order by " + orderBy);
        }
        if (!isEmpty(limit)) {
            sql.append(" " + limit);
        }
        return sql.toString();
    }

    public String toString() {
        return sql();
    }

    private static boolean isEmpty(String value) {
        return value == null || "".equals(value) || value.trim().length() == 0;
    }

    private static boolean isEmpty(String[] values) {
        if (values == null || values.length == 0) {
            return true;
        }
        for (String value : values) {
            if (!isEmpty(value)) {
                return false;
            }
        }
        return true;
    }

    private static String inValuesString(String[] values) {
        StringBuilder string = new StringBuilder();
        for (String value : values) {
            if (isEmpty(value)) {
                continue;
            }
            string.append('\'');
            string.append(value);
            string.append('\'');
            string.append(',');
        }
        if (string.length() > 0) {
            string.deleteCharAt(string.length() - 1);
        }
        return string.toString();
    }

    private static String inValuesString(List values) {
        StringBuilder string = new StringBuilder();
        for (Object valueObj : values) {
            String value = ObjectHelper.objectToStr(valueObj);
            if (isEmpty(value)) {
                continue;
            }
            string.append('\'');
            string.append(value);
            string.append('\'');
            string.append(',');
        }
        if (string.length() > 0) {
            string.deleteCharAt(string.length() - 1);
        }
        return string.toString();
    }

    private static String sqlParam(String sqlParam) {
        return sqlParam.replaceAll("([';]+|(--)+)", "");
    }
}
