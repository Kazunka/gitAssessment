package com.otrium.assessment.view.main;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

import androidx.annotation.NonNull;

interface MainActivityView {

    /**
     *
     * @param name
     * @param id
     * @param email
     * @param followers
     */
    void setHeaderDetails(@NonNull String name, @NonNull String id, @NonNull String email, @NonNull int followers, @NonNull int following);
}
