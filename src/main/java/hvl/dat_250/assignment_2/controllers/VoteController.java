package hvl.dat_250.assignment_2.controllers;

import hvl.dat_250.assignment_2.domain.Poll;
import hvl.dat_250.assignment_2.domain.User;
import hvl.dat_250.assignment_2.domain.Vote;
import hvl.dat_250.assignment_2.domain.VoteOption;
import hvl.dat_250.assignment_2.dto.VoteDTO;
import hvl.dat_250.assignment_2.service.PollService;
import hvl.dat_250.assignment_2.service.UserService;
import hvl.dat_250.assignment_2.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @Autowired
    private UserService userService;

    @Autowired
    private PollService pollService;


    @PostMapping
    public ResponseEntity<Vote> createVote(@RequestBody VoteDTO voteDTO) {
        User user = userService.getUserByUsername(voteDTO.getUsername());
        if (user == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Poll poll = pollService.getPoll(voteDTO.getPollId());
        if (poll == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Instant publishedAt = Instant.now();
        String voteId = UUID.randomUUID().toString();
        Vote vote = new Vote(voteId, publishedAt, user, poll, voteDTO.getVoteOptionId());
        voteService.createVote(vote);


        return ResponseEntity.ok(voteService.createVote(vote));
    }

    @PutMapping("/{voteId}")
    public ResponseEntity<Vote> updateVote(@PathVariable String voteId, @RequestBody VoteOption voteOptionId) {
        return ResponseEntity.ok(voteService.updateVote(voteId, voteOptionId.getCaption()));
    }

    @GetMapping("/polls/{pollId}/votes")
    public ResponseEntity<List<Vote>> getVotesForPoll(@PathVariable String pollId) {
        return ResponseEntity.ok(voteService.getVotesForPoll(pollId));
    }
}
