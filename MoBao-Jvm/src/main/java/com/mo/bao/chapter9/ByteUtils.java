package com.mo.bao.chapter9;

/**
 * Created by hadoop on 2017/11/13.
 */
public class ByteUtils {

    public static byte[] int2Byte(int value, int len) {
        byte[] b = new byte[len];
        for (int i = 0; i < len; i++) {
            b[len - i - 1] = (byte) ((value >> 8 * i) & 0xff);
        }
        return b;
    }

    public static int bytes2Int(byte[] b, int start, int len) {
        int sum = 0;
        int end = start + len;
        for (int i = start; i < end; i++) {
            int n = ((int) b[i]) & 0xff;
            n <<= (--len) * 8;
            sum = n + sum;
        }
        return sum;
    }

    public static String bytes2String(byte[] b, int start, int len) {
        return new String(b, start, len);
    }

    public static byte[] string2Bytes(String str) {
        return str.getBytes();
    }

    public static byte[] bytesReplace(byte[] originalBytes, int offset, int len, byte[] replaceBytes) {
        byte[] newBytes = new byte[originalBytes.length + (replaceBytes.length - len)];
        //Object src,  int  srcPos,Object dest, int destPos,int length
        System.arraycopy(originalBytes,0,newBytes,0,offset);
        System.arraycopy(replaceBytes,0,newBytes,offset,replaceBytes.length);
        System.arraycopy(originalBytes,
                         offset+len,
                         newBytes,
                         offset+replaceBytes.length,
                         originalBytes.length-offset-len);
        return newBytes;
    }

    public static void main(String[] args) {
        byte[] bytes = int2Byte(100, 8);
        System.out.println(bytes);
        int result = bytes2Int(bytes, 0, 4);
        System.out.println(result);
    }

}
