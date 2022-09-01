package com.ycjung.utils;

/**
 * String 관련 Util 클래스
 *
 * @author ycjung
 *
 */
public class StringUtil {

    /**
     * 문자열을 DB 입력시에 맞도록 byte로 길이를 확인
     *
     * @param str
     * @return
     */
    public static int getByteLength(final String str) {

        if(ValidationUtil.isEmpty(str)) {
            return 0;
        }
        byte[] bt = str.getBytes();

        return bt.length;
    }
}
