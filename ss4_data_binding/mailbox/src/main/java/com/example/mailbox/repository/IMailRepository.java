package com.example.mailbox.repository;

import com.example.mailbox.model.MailBox;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IMailRepository {
     MailBox searchId(int id);
     List<MailBox> display();
     void edit(int id, MailBox mail);
}
