package com.ibcs.security.model;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ronnie
 * Date: 12/30/13
 * Time: 7:07 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class LoginLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @Column(name = "ip_address")
    private String ipAddress;

    @Temporal(TemporalType.DATE)
    @Column(name = "log_date")
    private Date logDate;

    @Temporal(TemporalType.TIME)
    @Column(name = "log_time_in")
    private Date logTimeIn;

    @Temporal(TemporalType.TIME)
    @Column(name = "log_time_out")
    private Date logTimeOut;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public Date getLogTimeIn() {
        return logTimeIn;
    }

    public void setLogTimeIn(Date logTimeIn) {
        this.logTimeIn = logTimeIn;
    }

    public Date getLogTimeOut() {
        return logTimeOut;
    }

    public void setLogTimeOut(Date logTimeOut) {
        this.logTimeOut = logTimeOut;
    }
}
