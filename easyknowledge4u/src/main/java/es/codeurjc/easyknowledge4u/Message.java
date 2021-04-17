package es.codeurjc.easyknowledge4u;

public class Message {

    private String email;
    private String messageText;

    public Message(String email, String message) {
        this.email = email;
        this.messageText = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String message) {
        this.messageText = message;
    }

}
