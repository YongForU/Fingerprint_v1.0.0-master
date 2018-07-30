package zwh.com.lib.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by LSL on 2016/3/17.
 * ShapePreference配置工具类
 */
public class PreferenceUtil {
    private static SharedPreferences mSharedPreferences = null;
    private static SharedPreferences.Editor mEditor = null;

    public PreferenceUtil() {

    }

    public static void init(Context context) {
        if(null == mSharedPreferences) {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    /**
     * 移除指定key
     * @param key
     */
    public static void removeKey(String key) {
        mEditor = mSharedPreferences.edit();
        mEditor.remove(key);
        mEditor.apply();
    }

    /**
     * 移除所有
     */
    public static void removeAll() {
        mEditor = mSharedPreferences.edit();
        mEditor.clear();
        mEditor.apply();
    }

    /**
     * 保存字符串
     * @param key
     * @param value
     */
    public static void commitString(String key, String value) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(key, value);
        mEditor.apply();
    }

    /**
     * 获取字符串
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    /**
     * 保存Int
     * @param key
     * @param value
     */
    public static void commitInt(String key, int value) {
        mEditor = mSharedPreferences.edit();
        mEditor.putInt(key, value);
        mEditor.apply();
    }

    public static int getInt(String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    public static void commitLong(String key, long value) {
        mEditor = mSharedPreferences.edit();
        mEditor.putLong(key, value);
        mEditor.apply();
    }

    public static long getLong(String key, long defaultValue) {
        return mSharedPreferences.getLong(key, defaultValue);
    }

    public static void commitBoolean(String key, boolean value) {
        mEditor = mSharedPreferences.edit();
        mEditor.putBoolean(key, value);
        mEditor.apply();
    }

    public static Boolean getBoolean(String key, boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }
}

