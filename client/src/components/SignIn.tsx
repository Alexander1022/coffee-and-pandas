import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { login } from '../services/authService';

const SignIn = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const [alright, setAlright] = useState(true);

    const navigate = useNavigate();

    const handleChangeEmail = (event:any) => {
        setEmail(event.target.value);
    }

    const handleChangePassword = (event:any) => {
        setPassword(event.target.value);
    }

    const handleSubmit = (event:any) => {
        event.preventDefault();

        setEmail('');
        setPassword('');

        login(email, password).then(
            (response) => {
                console.log(response.data);
                setAlright(true);
                navigate('/home');
            },
            (error) => {
                console.log(error);
                setAlright(false);
            }
        );
    }

    return (
    <div className="grid grid-cols-2 gap-4 bg-gradient-to-tl from-[#F9AC04] to-[#FF5722]">
        <div className="flex flex-col justify-center min-h-screen max-w text-center bg-gradient-to-b from-[#d9d9d9]">
            <h1 className='text-white text-5xl font-bold mb-10'>
            Log in
            </h1>

            <form className='flex flex-col content-center justify-center space-y-4 px-24 flex-wrap' onSubmit={handleSubmit}>
            <hr className="w-120 h-0.5 border-white"/>
                <input required type="email" value={email} onChange={handleChangeEmail} className="w-full mt-10 opacity-50 px-3 py-2 bg-white rounded-full max-w-sm outline-none text-black" placeholder="Email" />
                <input required type="password" value={password} onChange={handleChangePassword} className="mt-10 opacity-50 px-3 py-2 bg-white rounded-full max-w-sm outline-none text-black" placeholder="Password" />
                <hr className="w-120 h-0.5 border-white"/>
                <div className='flex flex-row justify-center space-x-3'>
                    <input type="checkbox" className='outline-none'/>
                    <label className='text-white text-sm'>Keep me logged in</label>
                </div>
                <button type="submit" className='text-xl text-white bg-[#FF5722] py-2 px-10 rounded-full mt-2 drop-shadow-lg hover:text-[#FF5722] hover:bg-white'>
                    Log In
                </button>
            </form>   
        </div>

        <div className="flex flex-col justify-center min-h-screen max-w text-center">
            <div className='flex flex-col mt-12 mb-10'>
                <h1 className='text-white mb-3 text-6xl font-bold'>
                    Get Entertized! 
                </h1>

                <p className='text-white mx-5 px-20'>
                    Ready to share your favorite spots and discover new ones?
                    Find out what your friends and neighbors recommend?
                    Log in to get started!
                </p>
            </div>

            <div className='pt-10'>
                <p className='text-white'>
                    Don't have an account?
                </p>

                <Link to="/signup">
                    <button className='text-xl text-white border-2 py-2 px-10 border-white rounded-full drop-shadow-lg mt-3 hover:bg-white hover:text-black'>
                        Sign Up
                    </button>
                </Link>
            </div>
        </div>
    </div>
);

}

export default SignIn;