package ir.medu.khn.highschoolmajors;

import android.content.Context;
import android.os.Bundle;
import java.io.IOException;
import java.io.InputStream;


public class FileExtension {
    private static final FileExtension fileExtensionInstance = new FileExtension();

    public static FileExtension getInstance() {
        return fileExtensionInstance;
    }

    private FileExtension() {
    }
    public String readJSONFile(Context context, String fileNameInAssets) {
        String json = null;
        try {
            // Opening data.json file
            //InputStream inputStream = getAssets().open(fileNameInAssets);
            InputStream inputStream = context.getAssets().open(fileNameInAssets);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            // read values in the byte array
            inputStream.read(buffer);
            inputStream.close();
            // convert byte to string
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return json;
        }
        return json;
    }
}
