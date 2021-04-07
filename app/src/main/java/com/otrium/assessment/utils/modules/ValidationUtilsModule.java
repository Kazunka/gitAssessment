package com.otrium.assessment.utils.modules;

import android.text.TextUtils;

import dagger.Module;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

@Module
public class ValidationUtilsModule {

    public static boolean isValidUserName(String userName){
        return
//                userName.matches(REGEX_FOR_USERNAME_PATTERN) &&  or Single checks for each possible scenarios
//                userName.length() > USERNAME_MIN_LENGTH &&
                !TextUtils.isEmpty(userName) ;
    }

    public static boolean isValidPassword(String password){
        return
//                password.matches(REGEX_FOR_PASSWORD_PATTERN) &&   or Single checks for each possible scenarios
//                password.length() > PASSWORD_MIN_LENGTH &&
                !TextUtils.isEmpty(password) ;
    }
}
