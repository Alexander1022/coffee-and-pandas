import axios from 'axios';
import { sha256 } from 'js-sha256';

const BACKEND_URL:string | undefined = process.env.REACT_APP_API_URL;
const BACKEND_PORT:string | undefined = process.env.REACT_APP_API_PORT;

const API_URL:string = `http://${BACKEND_URL}:${BACKEND_PORT}/users/`;

export const register = (firstName: string, lastName: string, email: string, password: string) => {
    console.log('I am trying to register a new user to ' + API_URL);
    return axios.post(API_URL + 'register', {
        firstName,
        lastName,
        email,
        password: sha256(password)
    });
};

export const login = (email: string, password: string) => {
    console.log('I am trying to login a new user to ' + API_URL);
    return axios.post(API_URL + 'login', {
        email,
        password: sha256(password)
    });
};

export const setUserID = (userID:string) => {
    localStorage.setItem('userID', userID);
    console.log("I am setting the user ID to " + userID);
}

export const getCurrentUser = () => {
    const userToken = localStorage.getItem('userID');
    
    if (userToken) {
        return JSON.parse(userToken);
    }

    return null;
}

export const logout = () => {
    localStorage.removeItem('userID');
}