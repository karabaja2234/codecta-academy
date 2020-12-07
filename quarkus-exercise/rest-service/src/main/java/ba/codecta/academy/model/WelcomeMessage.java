package ba.codecta.academy.model;

public class WelcomeMessage {
    private String title;
    private String message;
    private String openTime;

    public WelcomeMessage(String title, String message, String opentime) {
        this.title = title;
        this.message = message;
        this.openTime = opentime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }
}
