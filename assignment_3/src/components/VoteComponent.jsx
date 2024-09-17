import { useEffect, useState } from "react";
import { Container, Box, Typography, Button, RadioGroup, FormControlLabel, Radio, CircularProgress } from "@mui/material";
import axiosInstance from '../axios';

const VoteComponent = () => {
    const [polls, setPolls] = useState([]);
    const [loading, setLoading] = useState(true);
    const [selectedVote, setSelectedVote] = useState({});
    const [votedPolls, setVotedPolls] = useState(new Set());

    useEffect(() => {
        const fetchPolls = async () => {
            try {
                const response = await axiosInstance.get("/polls");
                setPolls(response.data);
            } catch (error) {
                console.error("Error fetching polls:", error);
            } finally {
                setLoading(false);
            }
        };

        fetchPolls();
    }, []);

    const handleVoteChange = (pollId, optionId) => {
        setSelectedVote(prev => ({
            ...prev,
            [pollId]: optionId
        }));
    };

    const handleVoteSubmit = async (pollId) => {
        const selectedOptionId = selectedVote[pollId];
        if (!selectedOptionId) {
            alert("Please select an option to vote");
            return;
        }

        const username = localStorage.getItem('username');

        if (!username) {
            alert("User not logged in");
            return;
        }

        const voteData = {
            username: username,
            pollId: pollId,
            voteOptionId: selectedOptionId
        };

        try {
            const response = await axiosInstance.post(`/votes`, voteData);
            if (response.status === 200) {
                setVotedPolls(prev => new Set(prev).add(pollId));
                alert("Vote submitted successfully");
            }
        } catch (error) {
            console.error("Error submitting vote:", error);
            alert("Something went wrong. Please try again.");
        }
    };

    if (loading) {
        return <CircularProgress />;
    }

    return (
        <Container maxWidth="md" sx={{ mt: 4 }}>
            {polls.length === 0 ? (
                <Typography variant="h6" align="center">
                    No polls available
                </Typography>
            ) : (
                polls.map((poll) => (
                    <Box key={poll.id} sx={{ mb: 4, p: 2, border: '1px solid #ddd', borderRadius: '8px' }}>
                        <Typography variant="h6" gutterBottom>
                            {poll.question}
                        </Typography>
                        <Typography variant="body2" color="textSecondary" gutterBottom>
                            Published At: {new Date(poll.publishedAt).toLocaleString()}
                        </Typography>
                        <Typography variant="body2" color="textSecondary" gutterBottom>
                            Valid Until: {new Date(poll.validUntil).toLocaleString()}
                        </Typography>

                        <RadioGroup
                            value={selectedVote[poll.id] || ""}
                            onChange={(e) => handleVoteChange(poll.id, e.target.value)}
                        >
                            {poll.voteOptions.map((option) => (
                                <FormControlLabel
                                    key={option.caption}
                                    value={option.caption}
                                    control={<Radio />}
                                    label={option.caption}
                                />
                            ))}
                        </RadioGroup>

                        <Button
                            variant="contained"
                            color="primary"
                            onClick={() => handleVoteSubmit(poll.id)}
                            sx={{ mt: 2 }}
                            disabled={votedPolls.has(poll.id)}
                        >
                            Submit Vote
                        </Button>
                    </Box>
                ))
            )}
        </Container>
    );
};

export default VoteComponent;