package hvl.dat_250.assignment_2.service;

import hvl.dat_250.assignment_2.domain.VoteOption;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@Service
public class VoteOptionService {

    private final Map<String, VoteOption> voteOptions = new HashMap<>();

    public VoteOption creteVoteOption(VoteOption voteOption) {
        voteOptions.put(voteOption.getCaption(), voteOption);
        return voteOption;
    }

    public List<VoteOption> getAllVoteOptions() {
        return new ArrayList<>(voteOptions.values());
    }

    public VoteOption getVoteOptionByCaption(String caption) {
        return voteOptions.get(caption);
    }
}