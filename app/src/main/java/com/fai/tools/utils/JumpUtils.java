package com.fai.tools.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by PVer on 2018/7/1.
 */

public class JumpUtils {

    public static void jumpFromMain(Context context,Class cls)
    {
        Intent intent = new Intent(context,cls);
        context.startActivity(intent);
    }
}
