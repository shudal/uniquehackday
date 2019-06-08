package moe.perci.hackday.util;

import java.security.MessageDigest;
import java.util.Formatter;

public class MyEncrypt {
    public static MessageDigest sha1Crypt;

    // sha1加密
    public static String sha1(String s) throws Exception{
        sha1Crypt = MessageDigest.getInstance("SHA-1");
        sha1Crypt.reset();
        sha1Crypt.update(s.getBytes("UTF-8"));
        return byteToHex(sha1Crypt.digest());
    }

    public static String byteToHex (final byte[] hash)
    {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
