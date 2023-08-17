package com.example.mailbox.service;

import com.example.mailbox.model.MailBox;
import com.example.mailbox.repository.IMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService implements IMailService{
    @Autowired
    IMailRepository repository;
    @Override
    public void edit(int id, MailBox mail) {
        repository.edit(id,mail);
    }

    @Override
    public MailBox searchId(int id) {
        return repository.searchId(id);
    }

    @Override
    public List<MailBox> display() {
        return repository.display();
    }
}
