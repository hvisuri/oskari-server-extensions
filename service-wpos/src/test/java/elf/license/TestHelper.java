package elf.license;

import java.io.*;

/**
 * Created by SMAKINEN on 3.2.2015.
 */
public class TestHelper {

    public static final String DEFAULT_CHARSET = "UTF-8";
    /**
     * Reads the given input stream and converts its contents to a string using #DEFAULT_CHARSET
     * @param is
     * @return
     * @throws IOException
     */
    public static String readString(InputStream is) throws IOException {
        return readString(is, DEFAULT_CHARSET);
    }
    /**
     * Reads the given input stream and converts its contents to a string using given charset
     * @param is
     * @param charset
     * @return
     * @throws java.io.IOException
     */
    public static String readString(InputStream is, final String charset)
            throws IOException {
        /*
         * To convert the InputStream to String we use the Reader.read(char[]
         * buffer) method. We iterate until the Reader return -1 which means
         * there's no more data to read. We use the StringWriter class to
         * produce the string.
         */

        if (is == null) {
            return "";
        }
        final Writer writer = new StringWriter();
        final char[] buffer = new char[1024];
        try {
            final Reader reader = new BufferedReader(new InputStreamReader(is,
                    charset));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
            is.close();
        }
        return writer.toString();
    }
}