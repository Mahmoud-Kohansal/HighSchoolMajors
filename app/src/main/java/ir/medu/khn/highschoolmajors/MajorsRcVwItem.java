package ir.medu.khn.highschoolmajors;

public class MajorsRcVwItem {

    private int mImageResourceCardRcVwMain;
    private String mHeaderTextCardRcVwMain;
    private String mSubTextCardRcVwMain;

    public MajorsRcVwItem(int imageResource, String text, String grayText) {
        this.mImageResourceCardRcVwMain = imageResource;
        this.mHeaderTextCardRcVwMain = text;
        this.mSubTextCardRcVwMain = grayText;
    }

    public int getImageResource() {
        return mImageResourceCardRcVwMain;
    }

    public String getHeadeText() {
        return mHeaderTextCardRcVwMain;
    }

    public String getSubText() {
        return mSubTextCardRcVwMain;
    }
}
