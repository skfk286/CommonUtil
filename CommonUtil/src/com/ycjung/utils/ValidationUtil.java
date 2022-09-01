package com.ycjung.utils;

public class ValidationUtil {

    /**
     * 대상 문자열이 "", <code>null</code> 인지를 확인한다.
     *
     * @param propertyValue 대상 값
     * @return null, "" 인 경우 <code>true</code>, 아니면 <code>false</code>
     */
    public static boolean isEmpty(final CharSequence propertyValue) {

        return (propertyValue == null || propertyValue.length() <= 0);
    }
}
