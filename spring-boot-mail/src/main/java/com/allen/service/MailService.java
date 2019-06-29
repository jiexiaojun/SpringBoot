package com.allen.service;

/**
 * Created by allen on 2019/6/29.
 */
public interface MailService {

	public void sendSimpleMail(String to, String subject, String content);

	public void sendHtmlMail(String to, String subject, String content);

	public void sendAttachmentsMail(String to, String subject, String content, String filePath);

	public void sendInlineResourceMail(String to, String subject, String content, String rscPath,
			String rscId);

}
