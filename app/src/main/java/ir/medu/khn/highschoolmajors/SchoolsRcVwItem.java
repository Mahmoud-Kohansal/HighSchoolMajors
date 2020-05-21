package ir.medu.khn.highschoolmajors;

public class SchoolsRcVwItem {

    private int mImageResourceCardRcVwSchools;
    private String mHeaderTextCardRcVwSchools;
    private String mSubTextCardRcVwSchools;


    public SchoolsRcVwItem(int imageResource, String headerText, String subText) {
        this.mImageResourceCardRcVwSchools = imageResource;
        this.mHeaderTextCardRcVwSchools = headerText;
        this.mSubTextCardRcVwSchools = subText;
    }

    public int getImageResource() {
        return mImageResourceCardRcVwSchools;
    }

    public String getHeaderText() {
        return mHeaderTextCardRcVwSchools;
    }

    public String getSubText() {
        return mSubTextCardRcVwSchools;
    }
}
