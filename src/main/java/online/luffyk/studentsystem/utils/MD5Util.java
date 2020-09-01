package online.luffyk.studentsystem.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    public static String getMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest mdi = MessageDigest.getInstance("MD5");
        byte[] input = str.getBytes("UTF-8");
        byte[] hash = mdi.digest(input);
        String d = "";
        for (int i = 0; i < hash.length; i++) {
            int v = hash[i] & 0xFF;//作用应该是将字符串前面清零 因为转换为int 时 高位会补位 负数就会产生不一样的效果.
            if (v < 16) d += "0";
//            System.out.println(" v :" + v);
            d += Integer.toString(v, 16).toLowerCase();
        }
        return d;
    }

    public static void main(String[] args) {
        try {
            String md5 = getMD5("student");
            System.out.println(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}