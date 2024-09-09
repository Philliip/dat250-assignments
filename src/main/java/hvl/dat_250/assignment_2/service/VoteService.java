package hvl.dat_250.assignment_2.service;

import hvl.dat_250.assignment_2.domain.User;
import hvl.dat_250.assignment_2.domain.Vote;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VoteService {

    private final Map<String, Vote> votes = new HashMap<>();

    public Vote createVote(Vote vote) {
        votes.put(vote.getId(), vote);
        return vote;
    }

    public Vote updateVote(String voteId, String updatedVote) {
        votes.get(voteId).setVoteOption(updatedVote);
        return votes.get(voteId);

    }

    public List<Vote> getVotesForPoll(String pollId) {
        List<Vote> pollVotes = new ArrayList<>();
        for (Vote vote : votes.values()) {
            if (vote.getPoll().getId().equals(pollId)) {
                pollVotes.add(vote);
            }
        }
        return pollVotes;
    }
}
