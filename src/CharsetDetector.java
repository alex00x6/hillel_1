

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * тело класса честно украдено у:
 * @author Georgios Migdos <cyberpython@gmail.com>
 * как работает - не знаю, назовем это "magic"
 */
class CharsetDetector {

    private Charset detectCharset(File f, String[] charsets) {

        Charset charset = null;

        for (String charsetName : charsets) {
            charset = detectCharset(f, Charset.forName(charsetName));
            if (charset != null) {
                break;
            }
        }

        return charset;
    }

    private Charset detectCharset(File f, Charset charset) {
        try {
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(f));

            CharsetDecoder decoder = charset.newDecoder();
            decoder.reset();

            byte[] buffer = new byte[512];
            boolean identified = false;
            while ((input.read(buffer) != -1) && (!identified)) {
                identified = identify(buffer, decoder);
            }

            input.close();

            if (identified) {
                return charset;
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }

    private boolean identify(byte[] bytes, CharsetDecoder decoder) {
        try {
            decoder.decode(ByteBuffer.wrap(bytes));
        } catch (CharacterCodingException e) {
            return false;
        }
        return true;
    }

    static Charset  Detector(String fullPathToFile) {
        File f = new File(fullPathToFile);
        if (f.exists())
            System.out.println("File exists, detecting...");
        else {
            System.out.println("Error. File doesn't exists.");

        }

        String[] charsetsToBeTested = {"UTF-8", "cp1251", "ISO-8859-7", "KOI8-R"};

        CharsetDetector cd = new CharsetDetector();
        Charset charset = cd.detectCharset(f, charsetsToBeTested);

        if (charset != null) {
            System.out.println("===============================================");
            System.out.println("Charset is: "+charset);
            System.out.println("===============================================");
            return charset;
        }else{
            System.out.println("Unrecognized charset, using default charset.");
            return Charset.defaultCharset();
        }
    }
}