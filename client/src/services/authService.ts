import axios from 'axios';

const BACKEND_URL:string | undefined = process.env.REACT_APP_API_URL;
const BACKEND_PORT:string | undefined = process.env.REACT_APP_API_PORT;

const API_URL:string = `http://${BACKEND_URL}:${BACKEND_PORT}/users/`;

export const register = (firstName: string, lastName: string, email: string, password: string) => {
    console.log('connecting to: ' + API_URL + 'register');
    console.log('Ivo: ' + process.env.REACT_APP_IVO);
    return axios.post(API_URL + 'add', {
        firstName,
        lastName,
        email,
        password
    });
};

export const login = (email: string, password: string) => {
    console.log('connecting to: ' + API_URL + 'login');

    return axios.post(API_URL + 'login', {
        email,
        password
    });
};

export const getCurrentUser = () => {
    const userToken = localStorage.getItem('token');

    if (userToken) {
        return JSON.parse(userToken);
    }

    return null;
}

export const logout = () => {
    localStorage.removeItem('user');
}