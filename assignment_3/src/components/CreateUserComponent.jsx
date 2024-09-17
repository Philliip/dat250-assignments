import { useState } from "react";
import { TextField, Button, Container, Box, Typography } from "@mui/material";
import axiosInstance from "../axios.jsx";
import { useNavigate } from 'react-router-dom';

const CreateUserComponent = () => {
    const [formData, setFormData] = useState({
        username: "",
        email: "",
    });
    const navigate = useNavigate();
    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = async () => {
        try {
            const response = await axiosInstance.post('/users', formData);
            console.log('User created successfully:', response.data);
            localStorage.setItem('username', response.data.username);
            navigate('poll')
        } catch (error) {
            console.error('Error creating user:', error);
        }

    };

    return (
        <Container maxWidth="sm" sx={{ mt: 4 }}>
            <Typography variant="h4" align="center" gutterBottom>
                Create User
            </Typography>

            <Box
                component="div"
                sx={{
                    display: "flex",
                    flexDirection: "column",
                    gap: 3,
                    alignItems: "stretch",
                }}
            >
                <TextField
                    fullWidth
                    name="username"
                    label="Username"
                    variant="outlined"
                    value={formData.username}
                    onChange={handleInputChange}
                    required
                />

                <TextField
                    fullWidth
                    name="email"
                    label="Email"
                    variant="outlined"
                    value={formData.email}
                    onChange={handleInputChange}
                    required
                />

                <Button
                    fullWidth
                    variant="contained"
                    color="primary"
                    sx={{ paddingY: 2 }}
                    onClick={handleSubmit} // Handle button click
                >
                    Submit
                </Button>
            </Box>
        </Container>
    );
};

export default CreateUserComponent;