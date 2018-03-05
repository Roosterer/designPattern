package com.gk;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtils extends org.apache.commons.lang.StringUtils {

    /**包含所有英文字母和10个数字的字符数组*/
    public static final char[] ALPHA_NUMERIC = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};

    /**
     * 检查字符串是否由 数字、中文、英文、-、_ 4中符号组成 str = ""; return true; str = "  "; return
     * false; str = "中文_";return true;
     *
     * @param str
     * @return
     */
    public static boolean isAlphaUnderscoreMinus(String str) {
        // String all ="/[^u4E00-u9FA5]/g";
        String all = "([\\u4E00-\\uFA29]|[\\uE7C7-\\uE7F3]|[\\w]|[\\-]|[\\_])*";// {2,10}表示字符的长度是2-10
        Pattern pattern = Pattern.compile(all);
        return pattern.matcher(str).matches();
    }

    public static String escapeHtml(String html) {
        return StringEscapeUtils.escapeHtml(html);
    }

    /**
     * 检查字符串是否符合邮箱格式
     *
     * @param str
     * @return
     */
    public static boolean isEmail(String str) {
        String all = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
        Pattern pattern = Pattern.compile(all);
        return pattern.matcher(str).matches();
    }

    /**
     * 手机号正则不做严格校验
     * @param str
     * @return
     */
    public static boolean isMobile(String str){
        String all = "^(?:0?\\d{11})$"; //手机正则
        Pattern pattern = Pattern.compile(all);
        return pattern.matcher(str).matches();
    }

    public static boolean isInternetURL(String str) {
        String all = "^(http)?(://)?(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*((:\\d+)?)(/(\\w+(-\\w+)*))*(\\.?(\\w)*)(\\?)?(((\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&amp;)*(\\w*-)*(\\w*=)*(\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&amp;)*(\\w*-)*(\\w*=)*)*(\\w*)*)$";
        Pattern pattern = Pattern.compile(all);
        return pattern.matcher(str).matches();
    }

    public static String replaceTag(String input) {
        if (isEmpty(input)) {
            return input;
        }
        StringBuilder filtered = new StringBuilder(input.length());
        char c;
        for (int i = 0; i <= input.length() - 1; i++) {
            c = input.charAt(i);
            switch (c) {
                case '<':
                    filtered.append("&lt;");
                    break;
                case '>':
                    filtered.append("&gt;");
                    break;
                case '"':
                    filtered.append("&quot;");
                    break;
                case '&':
                    filtered.append("&amp;");
                    break;
                default:
                    filtered.append(c);
            }
        }
        return (filtered.toString());
    }

    /**
     * 根据黑名单替换字符串中的html标签
     *
     * @param input
     * @param blackListTags
     *            例如 a,script,img
     * @return
     */
    public static String replaceTag(String input, String... blackListTags) {
        if (blackListTags == null || isBlank(input)) {
            return input;
        }
        String regex = "";
        Pattern pattern = null;
        Matcher matcher = null;
        String replacement = null;
        String replaceTarget = null;
        int blackListTagsLength = blackListTags.length;
        for (int i = 0; i < blackListTagsLength; i++) {
            regex = "</?" + blackListTags[i] + "[^>]*>";
            pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(input);
            while (matcher.find()) {
                replaceTarget = matcher.group();
                replacement = "&lt;"
                        + replaceTarget.substring(1).substring(0,
                        replaceTarget.length() - 2) + "&gt;";
                input = input.replaceFirst(replaceTarget, replacement);
            }
        }
        return input;
    }

    /**
     * 根据白名单替换字符串中的html标签
     *
     * @param input
     * @param whiteListTags
     * @return
     */
    public static String replaceTagWhitelist(String input,
                                             String... whiteListTags) {
        if (whiteListTags == null || isBlank(input)) {
            return input;
        }
        String regex = "";
        Pattern pattern = null;
        Matcher matcher = null;
        String replacement = null;
        String replaceTarget = null;
        String tag = null;
        regex = "</?[^>]*>";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(input);
        List<String> whiteTagsList = Arrays.asList(whiteListTags);
        while (matcher.find()) {
            replaceTarget = matcher.group();
            tag = replaceTarget.substring(1, replaceTarget.length() - 1).split(
                    " ")[0];
            if (tag.startsWith("/")) {
                tag = tag.substring(1);
            }
            tag = tag.toLowerCase();
            if (!whiteTagsList.contains(tag)) {
                replacement = "&lt;"
                        + replaceTarget.substring(1).substring(0,
                        replaceTarget.length() - 2) + "&gt;";
                input = input.replace(replaceTarget, replacement);
            }
        }
        return input;
    }

    /**
     * 截取字符串中间内容用**代替
     * 例如 “我就是shop04”返回“我就**4”
     * @param str
     * @return
     */
    public static String cutMidString(String str) {
        if (isEmpty(str)) {
            return null;
        }
        String subStr = null;
        if (str.length() <= 3) {
            subStr = str;
        } else {
            subStr = str.substring(0, 2);
            subStr += "**";
            subStr += str.substring(str.length() - 1, str.length());
        }
        return subStr;
    }

    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0;) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 返回url的域名
     * 如 “"http://anotherbug.blog.chinajavaworld.com/entry/4545/0/” 返回 anotherbug.blog.chinajavaworld.com
     */
    public static String getUrlDomain(String url) {
        URL networkUrl = null;
        try {
            networkUrl = new URL(url);
        } catch (MalformedURLException e) {
            return null;
        }
        return networkUrl.getHost();
    }

    /**
     * 根据编码规则获取字符串长度
     * 例如： str为“测试”，encode为UTF-8，则返回6，如果encode为GBK则返回4
     * @param str
     * @param encode  编码格式
     * @return
     * @throws java.io.UnsupportedEncodingException
     */
    public static int length(String str, String encode) throws UnsupportedEncodingException {
        if (isEmpty(str)) {
            return 0;
        }
        return str.getBytes(encode).length;
    }

    /**
     * 生成指定长度的随机字符串
     * @param limit
     * @return
     */
    public static String randomGenerate(int limit) {
        if (limit < 1) {
            return null;
        }
        int max = ALPHA_NUMERIC.length - 1;
        StringBuilder aesKey = new StringBuilder(limit);
        for (int i = 0; i < limit; i++) {
            int s = Long.valueOf(Math.round(Math.random() * max)).intValue();
            aesKey.append(ALPHA_NUMERIC[s]);
        }
        return aesKey.toString();
    }

    /**
     * 支持手机号，邮箱，和其他字符串的截取后展示
     * 手机号，中间四位截取
     * 邮箱@符号之前的和字符串一致
     * 例如：“我是shop4” 返回“我是**4”
     * 例如手机号：“15903670102” 截取后 “159****0102”
     * 例如邮箱：erere@jd.com 截取后 er**e@jd.com
     * @param str
     * @return
     */
    public static String hiddenPartStringForVarious(String str){
        String afterStr = null;
        if (isEmpty(str)) {
            return null;
        }

        if(isEmail(str)){ // 如果是邮箱，只隐藏@前面的部分
            afterStr = str.substring(0,str.indexOf("@"));
            String lastStr = str.substring(str.indexOf("@"));
            return cutMidString(afterStr)+lastStr;
        }
        if(isMobile(str)){ // 如果是手机号
            afterStr = str.substring(0, 3);
            afterStr += "****";
            afterStr += str.substring(str.length()-4);
            return afterStr;
        }

        return cutMidString(str);
    }

    public static void main(String[] args){
        System.out.println(hiddenPartStringForVarious("15903670102"));
        System.out.println(hiddenPartStringForVarious("mengzaizheli@jd.com"));
        System.out.println(hiddenPartStringForVarious("旺旺的店铺"));
    }
}

