package com.otrium.assessment.utils;

import androidx.annotation.IntDef;

import com.otrium.assessment.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

public interface ColorUtils {

    // Declare the @ IntDef for these constants:
    @IntDef({ERROR, SUCCESS, WARNING, INFO})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AlertColor {}
    // Constants
    public static final int ERROR   = R.color.alert_error;
    public static final int SUCCESS = R.color.alert_success;
    public static final int WARNING = R.color.alert_warning;
    public static final int INFO    = R.color.alert_info;
}
