package hvl.dat_250.assignment_2.domain;
import java.time.Instant;

public class Vote {
    private String id;
    private Instant publishedAt;
    private User user;
    private Poll poll;
    private String voteOption;

    public Vote() {
    }

    // Parameterized constructor
    public Vote(String id, Instant publishedAt, User user, Poll poll, String voteOption) {
        this.id = id;
        this.user = user;
        this.poll = poll;
        this.publishedAt = publishedAt;
        this.voteOption = voteOption;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public String getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(String voteOption) {
        this.voteOption = voteOption;
    }
}


