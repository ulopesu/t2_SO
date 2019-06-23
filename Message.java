public class Message {
    private int priority;
    private String content;

    // CONSTRUTOR DA CLASSE MESSAGE.
    public Message (int priority, String content) {
        this.priority = priority;
        this.content = content;
    }

    // RETORNA A PRIORIDADE DA MENSAGEM.
    public int getPriority() {
        return this.priority;
    }

    // RETORNA O CONTEUDO DA MENSAGEM.
    public String getContent() {
        return this.content;
    }

    // ALTERA A PRIORIDADE DA MENSAGEM.
    public void setPriority(int priority) {
        this.priority = priority;
    }

    // ALTERA O CONTEUDO DA MENSAGEM.
    public void setContent(String content) {
        this.content = content;
    }
}