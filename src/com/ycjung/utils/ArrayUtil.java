package com.ycjung.utils;

import java.lang.reflect.Array;
import java.util.List;

/**
 * 배열 관련 Util 클래스
 *
 * @author ycjung
 *
 */
public class ArrayUtil {

    /**
    * list -> Array 변환
    *
    * @param clazz
    * @param list
    * @return
    */
   public static Object[] listToArray(Class<?> clazz, List<?> list) {
       //생성하길 원하는 객체의 Class
       if (clazz == null) return null;
       //데이터가 들어있는 List
       if (list == null || list.size() == 0) return null;

       //원하는 Class로 배열 생성

       //파리미터로 Class, 배열 사이즈 입력
       Object[] objects = (Object[])Array.newInstance(clazz, list.size());

       //배열에 List의 값 할당

       for (int i=0, j=list.size(); i < j; i++) {

           //파라미터로 객체 배열, 인덱스, 데이터 입력
           Array.set(objects, i, list.get(i));
       }

       //배열 리턴
       return objects;
   }
}
