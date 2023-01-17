package com.ycjung.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * String 관련 Util 클래스
 *
 * @author ycjung
 *
 */
public class StringUtil extends StringUtils{

    /**
     * <pre>
     * 지정한 길이만큼 문자열을 생략한다.
     * StringUtil.omit("aaaa", 2) -> returns "aa.."
     * </pre>
     *
     * @param String omitStr
     * @param int omitLength
     */
    public static String omit(final String omitStr, int omitLength) {
        int length = omitLength;

        if(ValidationUtil.isEmpty(omitStr)) {
            return EMPTY;
        }

        if(length <= 0) {
            length = 60;
        }

        String omittee = omitStr;
        if(getUnicodeLength(omittee) > length) {
            omittee = fixUnicodeLength(omittee, length, "..");
        }

        return omittee;
    }

    /**
     * 스트링을 지정한 길이만큼 자른 뒤 지정한 문자열을 추가한다. (한글처리)
     *
     * @param str 대상 문자열
     * @param limit 자를 길이의 최대값
     * @param postFix 뒤에 추가할 문자열
     * @return 지정한 길이만큼 잘려진 문자열
     */
    public static String fixUnicodeLength(final String str, int limit, String postFix) {

        if(str == null) {
            return EMPTY;
        }

        char[] charArray = str.toCharArray();

        if(limit >= charArray.length) {
            return str;
        }

        if(postFix == null) {
            return new String(charArray, 0, limit);
        } else {
            return new String(charArray, 0, limit).concat(postFix);
        }
    }

    /**
     * 지정 문자열의 길이를 얻는다. (한글처리)
     *
     * @param str 대상 문자열
     * @return 문자열 길이
     */
    public static int getUnicodeLength(final String str) {

        if(str == null) {
            return 0;
        }

        return str.toCharArray().length;
    }

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

    /**
     * DB는 byte를 기준으로 하므로(일반적으로) UTF-8 문자를 3byte로 계산하여 길이를 조절한다.
     *
     * @param str
     * @param limit 제한길이 수치
     * @param postFix 문자열을 자른 후 붙일 문자 또는 null
     * @return
     */
    public static String fixByteLength(final String str, int limit, String postFix) {

        if(ValidationUtil.isEmpty(str)) {
            return "";
        }

        int length = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < str.length() ; i++) {
            char ch = str.charAt(i);
            if((ch < '0' || ch > '9') && (ch < 'A' || ch > 'Z') && ((ch > 255) || (ch < 0))) {
                length += 3;
            } else {
                length += 1;
            }
            if(length <= limit) {
                sb.append(ch);
            }
        }
        if(postFix != null) {
            sb.append(postFix);
        }
        return sb.toString();
    }

    /**
     * <pre>
     * 캐릭터('\n')을 '&lt;br&gt;'태그로 변환.
     *
     * StringUtil.translateBR("ABCD\nABCD") = "ABCD&lt;br/&gt;ABCD"
     * StringUtil.translateBR("ABCD\n\nABCD") = "ABCD&lt;br/&gt;&lt;br/&gt;ABCD";
     * </pre>
     *
     * @param src 대상 문자열.
     * @return 변환된 문자열.
     */
    public static String translateBR(String src) {

        if(src == null || src.length() == 0) {
            return "";
        }

        return StringUtils.replace(src, "\n", "<br />");
    }

    /**
     * <pre>
     * HTML 태그를 제거한 문자열을 반환한다.
     * StringUtil.cleanHtml("<a href='#'>Hello world</a>") = "Hello world";
     * </pre>
     *
     * @param src 대상 문자열.
     * @return 변환된 문자열.
     */
    public static String cleanHtml(String src) {

        if(src == null || src.length() == 0) {
            return "";
        }

        return src.replaceAll("</?[a-zA-Z][a-zA-Z0-9]*[^<>]*>?", "");
    }

    /**
     * <pre>
     * HTML 태그와 HTML 주석 문장을 제거한 문자열을 반환한다.
     * </pre>
     *
     * @param src
     * @return
     */
    public static String cleanHtmlAndComment(String src) {

        return cleanHtml(src).replaceAll("(?s)<!--.*?-->", "");
    }

    /**
     * XXX_YYY_ZZZ 형식의 컬럼명을 JAVA 맴버변수 형식인 Camel Case 표기법으로 변경한다.
     *
     * @param str
     * @return
     */
    public static String camelCase(String str) {

        if (str.indexOf('_') < 0 && Character.isLowerCase(str.charAt(0))) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        boolean nextUpper = false;
        int len = str.length();

        for (int i = 0; i < len; i++) {
            char currentChar = str.charAt(i);
            if (currentChar == '_') {
                nextUpper = true;
            } else {
                if (nextUpper) {
                    result.append(Character.toUpperCase(currentChar));
                    nextUpper = false;
                } else {
                    result.append(Character.toLowerCase(currentChar));
                }
            }
        }
        return result.toString();
    }

    /**
     * <p>
     * 문자열중 첫문자를 대문자로 변환하는 메소드
     * </p>
     * @param data 입력 문자열
     * @return String 변환 문자열
     */
    public static String toUpperFirstLetter(String data) {
        String retString;
        if (data!=null && data.length()>0) {
            String firstLetter = data.substring(0, 1).toUpperCase();
            String restLetters = data.substring(1);
            retString = firstLetter + restLetters;
        }
        else {
            retString = data;
        }
        return retString;
    }

    /**
     * <p>
     * 문자열중 첫문자를 소문자로 변환하는 메소드
     * </p>
     * @param data 입력 문자열
     * @return String 변환 문자열
     */
    public static String toLowerFirstLetter(String data) {
        String retString;
        if (data!=null && data.length()>0) {
            String firstLetter = data.substring(0, 1).toLowerCase();
            String restLetters = data.substring(1);
            retString = firstLetter + restLetters;
        }
        else {
            retString = data;
        }
        return retString;
    }

    /* 사용법 예시 */
    public static void main(String[] args) {

    }
}
