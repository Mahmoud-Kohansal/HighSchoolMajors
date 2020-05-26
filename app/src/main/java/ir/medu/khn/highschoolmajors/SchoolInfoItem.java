package ir.medu.khn.highschoolmajors;

public class SchoolInfoItem {
    private String provinceName;
    private String schoolName;
    private int genderImgSource;
    private String fields;
    private String address;

    public SchoolInfoItem(String provinceName, String schoolName, int genderImgSource, String fields, String address) {
        this.provinceName = provinceName;
        this.schoolName = schoolName;
        this.genderImgSource = genderImgSource;
        this.fields = fields;
        this.address = address;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setGenderImgSource(int genderImgSource) {
        this.genderImgSource = genderImgSource;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public int getGenderImgSource() {
        return genderImgSource;
    }

    public String getFields() {
        return fields;
    }

    public String getAddress() {
        return address;
    }
}
