package com.fai.tools.utils;

import android.util.Log;
import com.fai.tools.BuildConfig;

/**
 * Created by PVer on 2018/4/1.
 */

public class Logger {
    private static final String TAG = "Logger";

    /**
     * The override method of Logger.
     *
     * The default level of any tag is set to LOGLEVEL 5. This means that any
     * level log will be logged. if your set the LOGLEVEL to 0 , no log will be
     * print out.
     */
    public static int LOGLEVEL = BuildConfig.DEBUG? 5 : 0;
    public static boolean VERBOSE = LOGLEVEL > 4;
    public static boolean DEBUG = LOGLEVEL > 3;
    public static boolean INFO = LOGLEVEL > 2;
    public static boolean WARN = LOGLEVEL > 1;
    public static boolean ERROR = LOGLEVEL > 0;

    public static void setDebugMode(boolean debugMode) {
        LOGLEVEL = debugMode ? 5 : 0;
        VERBOSE = LOGLEVEL > 4;
        DEBUG = LOGLEVEL > 3;
        INFO = LOGLEVEL > 2;
        WARN = LOGLEVEL > 1;
        ERROR = LOGLEVEL > 0;
    }

    public static void v(String tag, String msg) {
        if (DEBUG)
            Log.v(tag, msg == null ? "" : msg);
    }

    public static void v(String tag, String msg, Throwable tr) {
        if (DEBUG)
            Log.v(tag, msg == null ? "" : msg, tr);
    }

    public static void v(String msg) {
        if (DEBUG)
            Log.v(TAG, msg == null ? "" : msg);
    }

    public static void v(String msg, Throwable tr) {
        if (DEBUG)
            Log.v(TAG, msg == null ? "" : msg, tr);
    }

    public static void d(String tag, String msg) {
        if (DEBUG)
            Log.d(tag, msg == null ? "" : msg);
    }

    public static void d(String tag, String msg, Throwable tr) {
        if (DEBUG)
            Log.d(tag, msg == null ? "" : msg, tr);
    }

    public static void d(String msg) {
        if (DEBUG)
            Log.d(TAG, msg == null ? "" : msg);
    }

    public static void d(String msg, Throwable tr) {
        if (DEBUG)
            Log.d(TAG, msg == null ? "" : msg, tr);
    }

    public static void e(String tag, String msg) {
        if (ERROR)
            Log.e(tag, msg == null ? "" : msg);
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (ERROR)
            Log.e(tag, msg == null ? "" : msg, tr);
    }

    public static void e(String msg) {
        if (ERROR)
            Log.e(TAG, msg == null ? "" : msg);
    }

    public static void e(String msg, Throwable tr) {
        if (ERROR)
            Log.e(TAG, msg == null ? "" : msg, tr);
    }

}
