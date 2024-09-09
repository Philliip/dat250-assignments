package hvl.dat_250.assignment_2.controllers;
import hvl.dat_250.assignment_2.dto.PollDTO;
import hvl.dat_250.assignment_2.domain.Poll;
import hvl.dat_250.assignment_2.service.PollService;
import hvl.dat_250.assignment_2.service.UserService;
import hvl.dat_250.assignment_2.service.VoteOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hvl.dat_250.assignment_2.domain.User;
import java.util.UUID;

import java.util.List;

@RestController
@RequestMapping("/polls")
public class PollController {

    @Autowired
    private PollService pollService;

    @Autowired
    private UserService userService;

    @Autowired
    private VoteOptionService voteOptionService;

    @PostMapping
    public ResponseEntity<Poll> createPoll(@RequestBody  PollDTO pollDTO) {
        User user = userService.getUserByUsername(pollDTO.getUsername());
        if (user == null) {
            return ResponseEntity.badRequest().body(null);
        }

        String pollId = UUID.randomUUID().toString();
        Poll poll = new Poll(pollId, pollDTO.getQuestion(), pollDTO.getPublishedAt(), pollDTO.getValidUntil(), user, pollDTO.getVoteOptions());
        pollService.createPoll(poll);

        return ResponseEntity.ok(poll);
    }

    @GetMapping
    public ResponseEntity<List<Poll>> getAllPolls() {
        return ResponseEntity.ok(pollService.getAllPolls());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Poll> deletePoll(@PathVariable String id) {
        pollService.deletePoll(id);
        return ResponseEntity.noContent().build();
    }

}