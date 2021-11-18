package com.appdeveloperblog.app.ws.userservice;

import com.appdeveloperblog.app.ws.ui.model.request.UserDetailRequestModel;
import com.appdeveloperblog.app.ws.ui.model.response.UserRest;

public abstract class UserService {
    public abstract UserRest createUser(UserDetailRequestModel userDetails);
}
