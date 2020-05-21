package ir.medu.khn.highschoolmajors;

public class MajorsRcVwItem {

    private int mImageResourceCardRcVwMajors;
    private String mHeaderTextCardRcVwMajors;
    private String mSubTextCardRcVwMajors;

    public MajorsRcVwItem(int imageResource, String headerText, String subText) {
        this.mImageResourceCardRcVwMajors = imageResource;
        this.mHeaderTextCardRcVwMajors = headerText;
        this.mSubTextCardRcVwMajors = subText;
    }

    public int getImageResource() {
        return mImageResourceCardRcVwMajors;
    }

    public String getHeaderText() {
        return mHeaderTextCardRcVwMajors;
    }

    public String getSubText() {
        return mSubTextCardRcVwMajors;
    }
}
