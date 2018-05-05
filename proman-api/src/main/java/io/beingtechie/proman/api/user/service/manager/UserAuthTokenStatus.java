/*
 * Copyright 2018-2019, https://beingtechie.io.
 *
 * File: UserAuthTokenStatus.java
 * Date: May 5, 2018
 * Author: Thribhuvan Krishnamurthy
 */
package io.beingtechie.proman.api.user.service.manager;

/**
 * TODO: Provide javadoc
 */
public enum UserAuthTokenStatus {

    NOT_FOUND, ACTIVE, EXPIRED, LOGGED_OUT, CONCURRENT_LOGIN;

}