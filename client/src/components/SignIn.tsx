import React from 'react';
import ReactDOM from 'react-dom/client';
import { Link } from 'react-router-dom';

const SignIn = () => {
    return (
    <div className="grid grid-cols-2 gap-4 bg-gradient-to-tl from-[#F9AC04] to-[#550E63]">
        <div className="flex flex-col justify-center min-h-screen max-w text-center bg-gradient-to-b from-[#d9d9d9]">
            <h1 className='text-[#550E63] text-5xl font-bold mb-10'>
            Log in
            </h1>

            <section className='flex flex-col content-center justify-center space-y-4 px-24 flex-wrap'>
            <hr className="w-120 h-0.5 border-[#550E63]"/>
                <input type="email" className="w-full mt-10 opacity-50 px-3 py-2 bg-[#550E63] rounded-full max-w-sm outline-none text-white" placeholder="Email" />
                <input type="password" className="mt-10 opacity-50 px-3 py-2 bg-[#550E63] rounded-full max-w-sm outline-none text-white" placeholder="Password" />
                <hr className="w-120 h-0.5 border-[#550E63]"/>
                <div className='flex flex-row justify-center space-x-3'>
                <input type="checkbox" className='outline-none'/>
                <label className='text-white text-sm'>Keep me logged in</label>
                </div>
            </section>
        
            <div>
            <button className='text-xl text-white bg-[#550E63] py-2 px-10 rounded-full mt-2 drop-shadow-lg hover:text-[#550E63] hover:bg-white'>
                Log In
            </button>
            </div>      
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