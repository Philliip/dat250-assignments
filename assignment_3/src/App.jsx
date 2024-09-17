import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import CreateUserComponent from './components/CreateUserComponent';
import CreatePollComponent from './components/CreatePollComponent.jsx';
import VoteComponent from './components/VoteComponent.jsx';

function App() {
    return (
        <Router>
            <div>
                <Routes>
                    <Route path="/" element={<CreateUserComponent/>} />
                    <Route path="/poll" element={<CreatePollComponent/>} />
                    <Route path="/poll/vote" element={<VoteComponent/>} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;