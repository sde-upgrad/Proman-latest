/*
 * Copyright 2018-2019, https://beingtechie.io.
 *
 * File: UserAuthDaoImpl.java
 * Date: May 5, 2018
 * Author: Thribhuvan Krishnamurthy
 */
package apps.proman.service.user.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import apps.proman.service.common.dao.BaseDaoImpl;
import apps.proman.service.user.entity.*;

/**
 * Implementation of {@link UserAuthDao}.
 */
@Repository
public class UserAuthDaoImpl extends BaseDaoImpl<UserAuthTokenEntity> implements UserAuthDao {

    @Override
    public UserAuthTokenEntity findToken(final String accessToken) {
        try {
            return entityManager.createNamedQuery(UserAuthTokenEntity.BY_ACCESS_TOKEN, UserAuthTokenEntity.class).setParameter("accessToken", accessToken).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

}