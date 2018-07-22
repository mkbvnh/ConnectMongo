import org.bson.internal.Base64;

import java.io.*;

public class Utils {
    /**
     * Get Image from text
     */
    /**
     * Encodes the byte array into base64 string
     */
//Doan nay co phan su dung GridFS, ma no' lang nhang` hon nhieu`
    //http://mongodb.github.io/mongo-java-driver/3.4/driver/tutorials/gridfs/
    //Cai nay chi su dung cho cac tap tin vuot qua' 16mb. dung luong lon hon file document bson binh thuong

    public static String encodeImage(File file) throws IOException {
        FileInputStream imageInFile = new FileInputStream(file);
        byte imageData[] = new byte[(int) file.length()];
        imageInFile.read(imageData);
        imageInFile.close();
        return Base64.encode(imageData);
    }

    /**
     * Decodes the base64 string into byte array
     *

     */
    public static byte[] decodeImage(String imageDataString) {
        return Base64.decode(imageDataString);
    }


    public Utils() {
    }
}
