package com.otrium.service.listeners;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

public interface OnSuccessResponse <T> extends OnServerErrorResponse{
    void onSuccessResponse(T t);
}
