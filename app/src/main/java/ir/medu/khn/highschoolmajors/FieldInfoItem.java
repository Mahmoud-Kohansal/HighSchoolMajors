package ir.medu.khn.highschoolmajors;

public class FieldInfoItem {
    private String fieldName;
    private String fieldDescription;

    public FieldInfoItem() {
    }

    public FieldInfoItem(String fieldName, String fieldDescription) {
        this.fieldName = fieldName;
        this.fieldDescription = fieldDescription;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setFieldDescription(String fieldDescription) {
        this.fieldDescription = fieldDescription;
    }
}
