import axios from 'axios';
import EventInterface from '../types/event.type';

const BACKEND_URL:string | undefined = process.env.REACT_APP_API_URL;
const BACKEND_PORT:string | undefined = process.env.REACT_APP_API_PORT;

const API_URL:string = `http://${BACKEND_URL}:${BACKEND_PORT}/events/add`;

export const addEvent = (newEvent: EventInterface) => {
    console.log('I am trying to register a new user to ' + API_URL);

    return axios.post(API_URL, {
        name: newEvent.name,
        description: newEvent.description,
        date: newEvent.date,
        creatorId: newEvent.creatorId,
        placeDto: {
            name: newEvent.placeDto.name,
            description: newEvent.placeDto.description,
            placeType: newEvent.placeDto.placeType,
            coordinates: newEvent.placeDto.coordinates
        }
    });
}
