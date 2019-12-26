package com.tech.auth.common.util;

public class StringUtil {

    public static boolean isNullorEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }
    public static boolean isNotEmpty(final CharSequence cs) {
        return !isNullorEmpty(cs);
    }
    public static int compare(final String str1, final String str2) {
        return compare(str1, str2, true);
    }

    public static int compare(final String str1, final String str2, final boolean nullIsLess) {
        if (str1 == str2) {
            return 0;
        }
        if (str1 == null) {
            return nullIsLess ? -1 : 1;
        }
        if (str2 == null) {
            return nullIsLess ? 1 : - 1;
        }
        return str1.compareTo(str2);
    }

    public static boolean contains(final CharSequence seq, final CharSequence searchSeq) {
        if (seq == null || searchSeq == null) {
            return false;
        }
        return CharSequenceUtil.indexOf(seq, searchSeq, 0) >= 0;
    }
}
