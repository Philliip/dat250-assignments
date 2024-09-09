package hvl.dat_250.assignment_2.service;

import  hvl.dat_250.assignment_2.domain.Poll;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class PollService {

    private final Map<String, Poll> polls = new HashMap<>();

    public Poll createPoll(Poll poll) {
        polls.put(poll.getId(), poll);
        return poll;
    }

    public List<Poll> getAllPolls() {
        return new ArrayList<>(polls.values());
    }

    public Poll getPoll(String id) {
        return polls.get(id);
    }

    public void deletePoll(String id) {
        polls.remove(id);
    }


}
