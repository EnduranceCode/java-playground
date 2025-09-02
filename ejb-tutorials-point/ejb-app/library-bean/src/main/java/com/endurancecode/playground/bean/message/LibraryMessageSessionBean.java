package com.endurancecode.playground.bean.message;

import com.endurancecode.playground.bean.persistence.LibraryPersistenceSessionBeanRemote;
import com.endurancecode.playground.entity.Book;
import jakarta.annotation.Resource;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.EJB;
import jakarta.ejb.MessageDriven;
import jakarta.ejb.MessageDrivenContext;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.ObjectMessage;

@MessageDriven(
        name = "BookMessageHandler",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "/queue/BookQueue")
        })
public class LibraryMessageSessionBean implements MessageListener {

    @Resource
    private MessageDrivenContext messageDrivenContext;

    @EJB
    LibraryPersistenceSessionBeanRemote libraryBean;

    public LibraryMessageSessionBean() {
        super();
    }

    public void onMessage(Message message) {
        ObjectMessage objectMessage = null;
        try {
            objectMessage = (ObjectMessage) message;
            Book book = (Book) objectMessage.getObject();
            libraryBean.addBook(book);

        } catch (JMSException ex) {
            messageDrivenContext.setRollbackOnly();
        }
    }
}
