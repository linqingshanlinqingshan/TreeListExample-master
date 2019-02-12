package com.example.administrator.treelistexample;

import android.text.TextUtils;

import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OtherUtil {


    /**
     *  * 判断 字符串 是否 都为数字
     *  *
     *  * @param temp
     *  * @return
     *  
     */
    public static boolean isIntOfString(String temp) {


        Pattern pattern = Pattern.compile("[0-9]{1,}");
        Matcher matcher = pattern.matcher((CharSequence) temp);


        return matcher.matches();
    }


    /**
     *  * @param temp
     *  * @return trur 数字  false 字符
     *  
     */
    public static boolean isNumOfString(String temp) {
        if (temp != null && temp.matches("^[0.0-9.0]+$")) {  // [0-9]没办法识别小数，[0.0-9.0]可以识别小数和整数
            return true;
        } else {
            return false;
        }
    }


    /**
     *  * 判断字符串是否是 json 格式
     *  *
     *  * @param json
     *  * @return true 是
     *  
     */
    public static boolean isJson(String json) {
        if (TextUtils.isEmpty(json)) {
            return false;
        }
        JsonParser jsonParser = null;
        try {
            if (jsonParser == null) {
                jsonParser = new JsonParser();
            }
            jsonParser.parse(json);
            return true;
        } catch (JsonSyntaxException e) {
            return false;
        } catch (JsonParseException e) {
            return false;
        }
    }


}
