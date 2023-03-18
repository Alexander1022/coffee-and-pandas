import React from 'react';
import { AddEvent } from './AddEvent';

const BuildingInfo = ({ info }) => {
    console.log('info', info);
    return (
        <div style={{ position: 'absolute', right: '0px', zIndex: 999, height: '100vh', width: '20vw' }}>
            <AddEvent></AddEvent>
        </div>
    )
}

export default BuildingInfo;