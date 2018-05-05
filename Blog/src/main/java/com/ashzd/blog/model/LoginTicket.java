package com.ashzd.blog.model;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LoginTicket {
    private int id;
    private int userId;
    private Date expired;
    private int status;
    private String ticket;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public int getStatus() {
        return status;
    }

    public String getTicket() {
        return ticket;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
