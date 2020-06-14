package ir.medu.khn.highschoolmajors;

public class MajorInfoItem {
    private String majorName;
    private String majorDescription;
    private String majorCategory;

    public MajorInfoItem() {
    }

    public MajorInfoItem(String majorName, String majorDescription, String majorCategory) {
        this.majorName = majorName;
        this.majorDescription = majorDescription;
        this.majorCategory = majorCategory;
    }

    public String getMajorName() {
        return majorName;
    }

    public String getMajorDescription() {
        return majorDescription;
    }

    public String getMajorCategory() {
        return majorCategory;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public void setMajorDescription(String majorDescription) {
        this.majorDescription = majorDescription;
    }

    public void setMajorCategory(String majorCategory) {
        this.majorCategory = majorCategory;
    }
}
