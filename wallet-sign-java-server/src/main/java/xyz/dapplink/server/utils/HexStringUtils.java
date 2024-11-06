package xyz.dapplink.server.utils;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class HexStringUtils {

    private static final char[] HEX_CHAR_TABLE = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static final Map<Character, Byte> HEX_BYTE_MAP = new HashMap<>();

    static {
        for (int i = 0; i < HEX_CHAR_TABLE.length; i++) {
            char c = HEX_CHAR_TABLE[i];
            HEX_BYTE_MAP.put(c, (byte) i);
        }
    }

    /**
     * 将byte数组转换为表示16进制值的字符串
     *
     * @param byteArray 需要转换的byte数组
     * @return 转换后的字符串（16进制值）
     */
    public static String byteArrayToHexString(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : byteArray) {
            sb.append(HEX_CHAR_TABLE[(b & 0xf0) >> 4]);
            sb.append(HEX_CHAR_TABLE[b & 0x0f]);
        }
        return sb.toString();
    }

    /**
     * 将表示16进制值的字符串转换为byte数组
     *
     * @param hexString 需要转换的字符串（16进制值）
     * @return 转换后的byte数组
     */
    public static byte[] hexStringToByteArray(String hexString) {
        if (StringUtils.hasLength(hexString)) {
            return null;
        }
        // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
        byte[] byteArray = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length() / 2; i++) {
            char hi = hexString.charAt(i * 2);
            char lo = hexString.charAt(i * 2 + 1);
            byteArray[i] = (byte) ((HEX_BYTE_MAP.get(hi) << 4) + HEX_BYTE_MAP.get(lo));
        }
        return byteArray;
    }

}
