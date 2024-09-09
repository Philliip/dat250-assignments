package hvl.dat_250.assignment_2.domain;

import java.time.Instant;
import java.util.List;
import java.util.ArrayList;

public class Poll {
    private String id;
    private String question;
    private Instant publishedAt;
    private Instant validUntil;
    private User user;
    private List<VoteOption> voteOptions;


    public Poll() {
        this.voteOptions = new ArrayList<>();
    }


    public Poll(String id, String question, Instant publishedAt, Instant validUntil, User user, List<VoteOption> voteOptions) {
        this.id = id;
        this.question = question;
        this.publishedAt = publishedAt;
        this.validUntil = validUntil;
        this.user = user;
        this.voteOptions = voteOptions;
    }


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public Instant getPublishedAt() { return publishedAt; }
    public void setPublishedAt(Instant publishedAt) { this.publishedAt = publishedAt; }

    public Instant getValidUntil() { return validUntil; }
    public void setValidUntil(Instant validUntil) { this.validUntil = validUntil; }

    public List<VoteOption> getVoteOptions() { return voteOptions; }
    public void setVoteOptions(List<VoteOption> voteOptions) { this.voteOptions = voteOptions; }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

