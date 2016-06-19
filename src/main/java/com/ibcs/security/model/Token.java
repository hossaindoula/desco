package com.ibcs.security.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.security.DESEDE;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "token")
public class Token extends BaseModel<Token> {

	private static final long serialVersionUID = -2020752748932592756L;
	public static final String PASSWORD_PATTERN = "^.*(?=.{8,})(?=.*\\d)(?=.*[a-zA-Z]).*$";
	public static final String EMAIL_PATTERN = "^.*(?=.{8,})(?=.*\\d)(?=.*[a-zA-Z]).*$";

	@Column(name = "username", unique=true)
	private String username;
	private String password;

    @OneToOne(mappedBy = "token")
    private User user;

	@JsonIgnore
	@Column(nullable = true)
	private String oneTimeToken;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
        DESEDE desede = new DESEDE(this.username);
        this.password = desede.encrypt(password);
	}

	public String getOneTimeToken() {
		return oneTimeToken;
	}

	public void setOneTimeToken(String oneTimeToken) {
		this.oneTimeToken = oneTimeToken;
	}

	public User withOneTimeToken(String oneTimeToken) {
		setOneTimeToken(oneTimeToken);
		return new User();
	}

}
