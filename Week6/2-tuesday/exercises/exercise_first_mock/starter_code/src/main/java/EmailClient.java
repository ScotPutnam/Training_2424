/**
 * Sends emails. A collaborator you will mock so tests never hit a real
 * mail server.
 */
public interface EmailClient {

    void send(String to, String subject, String body);
}
