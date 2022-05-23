package jwjung.spring.remind.singleton;

public class EmailSenderService {

    // 상태를 공유하는 필드가 있으면 안된다.
    private String userEmail;

    public void send(String userEmail) {
        System.out.println("[EMAIL SEND LOGIC] " + userEmail);
        // Stateful Code
        this.userEmail = userEmail;
    }

    public String getResult() {
        return "[EMAIL SEND LOG] " + this.userEmail;
    }

}
