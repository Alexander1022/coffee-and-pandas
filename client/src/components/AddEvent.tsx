import { useState } from 'react';
import { Link } from 'react-router-dom';

const AddEvent = (props:any) => { 
    return (
        <button className="text-white bg-[#ff5722] " style = {{position: 'fixed', width: '8rem' , color: 'white', height: '2.5rem' , bottom: '1rem', borderRadius: '20px'}}>
            Add Event
        </button>   
    );
}

export default AddEvent;