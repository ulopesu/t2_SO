package src;

public class Message {
    private int priority;
    private String content;

    public Message (int priority, String content) {
        this.priority = priority;
        this.content = content;
    }

    public int getPriority() {
        return this.priority;
    }
    public String getContent() {
        return this.content;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    public void setContent(String content) {
        this.content = content;
    }
    

}