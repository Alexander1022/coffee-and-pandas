import React from 'react'
import { useNavigate } from "react-router-dom";

export const AddEvent = () => {
    const navigate = useNavigate();
    const addEvent = () => {
        navigate("/events")
    }

    return (
        <button onClick={addEvent}>AddEvent</button>
    )
}