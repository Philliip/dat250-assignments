package hvl.dat_250.assignment_2.dto;

import java.time.Instant;

public class VoteDTO {
    private String username;
    private String pollId;
    private String voteOptionId;

    // Default constructor
    public VoteDTO() {}

    // Parameterized constructor
    public VoteDTO(String username, String pollId, String voteOptionId) {
        this.username = username;
        this.pollId = pollId;
        this.voteOptionId = voteOptionId;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPollId() {
        return pollId;
    }

    public void setPollId(String pollId) {
        this.pollId = pollId;
    }

    public String getVoteOptionId() {
        return voteOptionId;
    }

    public void setVoteOptionId(String voteOptionId) {
        this.voteOptionId = voteOptionId;
    }


}