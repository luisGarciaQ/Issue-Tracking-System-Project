package IssueTrackerApp;

public class TheTicket {

    private int ID = 0;
    private String title;
    private String date;
    private String owner;
    private String description;

    public TheTicket() {
        this.title = "";
        this.date = "";
        this.owner = "";
        this.description = "";
    }

    public TheTicket(int ID, String title, String date, String owner, String description) {

        this.ID = ID;
        this.title = title;
        this.date = date;
        this.owner = owner;
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
