package com.example.mailbox.repository;

import com.example.mailbox.model.MailBox;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MailRepository implements IMailRepository {
    static List<MailBox> list = new ArrayList<>();
    static {
        list.add(new MailBox("English", 10, "Strict", "John Doe"));
        list.add(new MailBox("Spanish", 20, "Moderate", "Maria Lopez"));
        list.add(new MailBox("French", 15, "Lenient", "Jean Dupont"));
        list.add(new MailBox("German", 12, "Strict", "Hans Müller"));
    }
    @Override
    public MailBox searchId(int id) {
        return list.get(id);
    }

    @Override
    public List<MailBox> display() {
        return list;
    }

    @Override
    public void edit(int id, MailBox mail) {
        list.set(id, mail);
    }
}
