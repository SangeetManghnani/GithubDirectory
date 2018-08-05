package com.lovejeet.spring.common;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sessionUtility")
public class SessionUtility {

    /** Initializing logger for HibernateUtility class. */
    private static final Logger log = Logger.getLogger(SessionUtility.class);

    /** Hibernate Session Factory, spring initialization. */
    @Autowired
    private SessionFactory sessionFactory;

    /** Fetches the Session from Hibernate Session Factory.
     * @return {@link Session} */
    public Session getSession() {
        log.debug("A new session is being returned to the requester");
        return sessionFactory.getCurrentSession();
    }

}