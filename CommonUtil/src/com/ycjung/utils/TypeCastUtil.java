package com.ycjung.utils;

/**
 * 타입 변환 관련 Util 클래스
 *
 * @author ycjung
 *
 */
public class TypeCastUtil {

    /**
     * 안전 타입 캐스팅 작업
     *
     * @param o
     * @param clazz
     * @return
     */
    public static <T> T safeCast(Object object, Class<T> clazz) {
        return clazz != null && clazz.isInstance(object) ? clazz.cast(object) : null;
    }
}
