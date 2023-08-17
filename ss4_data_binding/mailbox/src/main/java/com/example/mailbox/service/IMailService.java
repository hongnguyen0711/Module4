package com.example.mailbox.service;

import com.example.mailbox.model.MailBox;

import java.util.List;

public interface IMailService {
    public void edit(int id, MailBox mail);
    public MailBox searchId(int id);
    public List<MailBox> display();
}
