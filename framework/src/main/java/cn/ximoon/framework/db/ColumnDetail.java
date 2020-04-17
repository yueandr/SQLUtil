package cn.ximoon.framework.db;

/**
 * 集合类，用来查看对应关系
 */
public class ColumnDetail {

    /**
     * 列名
     */
    private String columnName;
    /**
     * 属性名
     */
    private String fieldName;
    /**
     * 定义名称，可以用来被调用的列名、表名的引用对象（及columnName值的引用对象）
     */
    private String relativeName;
    /**
     * SQLite类型
     */
    private String type;
    /**
     * 是否主键
     */
    private boolean isPrimaryKey;

    public ColumnDetail(String columnName, String fieldName, String connectName, String type, boolean isPrimaryKey) {
        this.columnName = columnName;
        this.fieldName = fieldName;
        this.relativeName = connectName;
        this.type = type;
        this.isPrimaryKey = isPrimaryKey;
    }

    public String getRelativeName() {
        return relativeName;
    }

    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        isPrimaryKey = primaryKey;
    }
}