package com.yesserp.sessionbean.mail;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.mail.Provider;

@Local
public interface MailCRUDLocal {

	List<Provider> consulter();

	Provider consulter(String name);

	void delete(Provider provider);

	void create(Provider provider);

}
