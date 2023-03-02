package com.auth;

import com.auth.pojo.Menu;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.ArrayList;
import java.util.List;

public class Ceshi {

    public static void main(String[] arge){
        List<Menu> menus = new ArrayList<>();
        Menu menu = new Menu();
        menu.setId(1l);
        menu.setComponent("急急急急急急打的费");
        menus.add(menu);

        JdkSerializationRedisSerializer j = new JdkSerializationRedisSerializer();


//        byte[] bytes = j.serialize(menus);
//
//        for(int i = 0; i < bytes.length; i++){
//            byte b = bytes[i];
////            System.out.println(b);
//        }


//        System.out.println(str);
////        System.out.println( "ms,序列化后的长度：" + bytesJ.length);
//        System.out.println(j.deserialize(bytes));
        String bytees = "���\u0005sr�\u0011java.util.HashMap\u0005\u0007���\u0016`�\u0003�\u0002F�loadFactorI�\tthresholdxp?@�����\fw\b���\u0010���\u0002sr�\u0011java.lang.Integer\u0012⠤���8\u0002�\u0001I�\u0005valuexr�\u0010java.lang.Number���\u001D\u000B���\u0002��xp���\u0001sq�~��?@�����\fw\b���\u0010���\u0005sr�\u000Ejava.lang.Long;��̏#�\u0002�\u0001J�\u0005valuexq�~�\u0003�������\u0013sq�~�\u0002����sq�~�\u0006�������\u0014q�~�\bsq�~�\u0006�������\u0015q�~�\bsq�~�\u0006�������\u0018q�~�\bsq�~�\u0006�������\u0019q�~�\bxsq�~�\u0002���\u0002q�~�\u0005x";
//        byte[] bytesJ = hexStringToByteArray("ACED0005");
//        for (int i = 0; i < bytesJ.length; i++){
//            System.out.println(bytesJ[i]);
//
//        }
        byte[] bytesJ = bytees.getBytes();

//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        byte[] bytesJ = stringRedisSerializer.serialize(bytees);
//
////        System.out.println(bytesJ);
        System.out.println(j.deserialize(bytesJ));
    }

    /**
     * 16进制表示的字符串转换为字节数组
     *
     * @param hexString 16进制表示的字符串
     * @return byte[] 字节数组
     */
    public static byte[] hexStringToByteArray(String hexString) {
        hexString = hexString.replaceAll(" ", "");
        int len = hexString.length();
        byte[] bytes = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个字节
            bytes[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4) + Character
                    .digit(hexString.charAt(i+1), 16));
        }
        return bytes;
    }



    private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length);
        byte[] var3 = bytes;
        int var4 = bytes.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            byte aByte = var3[var5];
            String temp = Integer.toHexString(255 & aByte);
            if (temp.length() < 2) {
                sb.append(0);
            }

            sb.append(temp);
        }

        return sb.toString();
    }
}
