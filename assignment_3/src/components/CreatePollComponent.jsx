import { useState } from "react";
import { TextField, Button, Container, Box, Typography } from "@mui/material";
import axiosInstance from '../axios';
import DatePicker from "react-datepicker";
import { useNavigate } from 'react-router-dom';
import "react-datepicker/dist/react-datepicker.css";

const CreatePollComponent = () => {
    const [pollTitle, setPollTitle] = useState("");
    const [questions, setQuestions] = useState([""]);
    const [publishedAt, setPublishedAt] = useState("");
    const [validUntil, setValidUntil] = useState("");
    const [voteOptions, setVoteOptions] = useState([{ caption: "", presentationOrder: 1 }]); // Vote options
    // Handle poll title input change
    const handleTitleChange = (e) => {
        setPollTitle(e.target.value);
    };
    const navigate = useNavigate()

    // Handle publishedAt input change
    const handlePublishedAtChange = (e) => {
        setPublishedAt(e.target.value);
    };

    // Handle validUntil input change
    const handleValidUntilChange = (e) => {
        setValidUntil(e.target.value);
    };

    // Handle vote options input change
    const handleVoteOptionChange = (index, e) => {
        const newVoteOptions = [...voteOptions];
        newVoteOptions[index][e.target.name] = e.target.value;
        setVoteOptions(newVoteOptions);
    };

    // Add a new vote option field
    const addVoteOption = () => {
        setVoteOptions([...voteOptions, { caption: "", presentationOrder: voteOptions.length + 1 }]);
    };

    // Handle poll submission
    const handleSubmitPoll = async () => {


        const pollData = {
            username: localStorage.getItem('username'),
            question: pollTitle,
            publishedAt,
            validUntil,
            voteOptions: voteOptions.map(option => ({
                caption: option.caption,
                presentationOrder: option.presentationOrder
            }))
        };

        try {
            const response = await axiosInstance.post("/polls", pollData);
            if (response.status === 200) {
                console.log(response.data)
                navigate('vote');
            }
        } catch (error) {
            console.error("Error creating poll:", error);
        }
    };

    return (
        <Container maxWidth="sm" sx={{ mt: 4 }}>
            <Typography variant="h4" align="center" gutterBottom>
                {localStorage.getItem('username') ? `Create Poll for ${localStorage.getItem('username')}` : "Create Poll"}
            </Typography>

            <TextField
                fullWidth
                name="pollTitle"
                label="Poll Title"
                variant="outlined"
                value={pollTitle}
                onChange={handleTitleChange}
                required
            />

            <Box sx={{ mt: 3 }}>
                <Typography variant="h6" gutterBottom>
                    Published At
                </Typography>
                <DatePicker
                    selected={publishedAt}
                    onChange={(date) => setPublishedAt(date)}
                    showTimeSelect
                    dateFormat="Pp"
                    placeholderText="Select a date"
                    className="form-control"
                />
            </Box>

            <Box sx={{ mt: 3 }}>
                <Typography variant="h6" gutterBottom>
                    Valid Until
                </Typography>
                <DatePicker
                    selected={validUntil}
                    onChange={(date) => setValidUntil(date)}
                    showTimeSelect
                    dateFormat="Pp"
                    placeholderText="Select a date"
                    className="form-control"
                />
            </Box>

            <Typography variant="h6" gutterBottom>
                Vote Options
            </Typography>

            {voteOptions.map((option, index) => (
                <Box key={index} sx={{ mb: 2 }}>
                    <TextField
                        fullWidth
                        name="caption"
                        label={`Option ${index + 1} Caption`}
                        variant="outlined"
                        value={option.caption}
                        onChange={(e) => handleVoteOptionChange(index, e)}
                        required
                    />
                </Box>
            ))}

            <Button variant="outlined" color="secondary" onClick={addVoteOption} sx={{ mt: 2 }}>
                Add Another Option
            </Button>

            <Button
                fullWidth
                variant="contained"
                color="primary"
                sx={{ mt: 3 }}
                onClick={handleSubmitPoll}
            >
                Submit Poll
            </Button>
        </Container>
    );
};

export default CreatePollComponent;