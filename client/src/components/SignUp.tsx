import React from 'react';
import ReactDOM from 'react-dom/client';
import { Link } from 'react-router-dom';

const SignUp = () => {
    return (
    <div className="grid grid-cols-2 gap-4 bg-gradient-to-tl from-[#F9AC04] to-[#550E63]">
      <div className="flex flex-col justify-center min-h-screen max-w text-center">
        <div className='flex flex-col mt-36 mb-10'>
          <h1 className='text-white mb-3 text-6xl font-bold'>
            Welcome!
          </h1>

          <p className='text-white mx-5 px-20'>
            Connect with colleagues and build lasting relationships. 
            Chat with friends, play games, or collaborate on new projects
            Join now and discover amazing opportunities waiting for you!
          </p>
        </div>

        <div className='pt-10'>
          <p className='text-white'>
            Already have an account?
          </p>

          <Link to="/signin">
            <button className='text-xl text-white border-2 py-2 px-10 border-white rounded-full drop-shadow-lg mt-3 hover:bg-white hover:text-black'>
              Log In
            </button>
          </Link>
        </div>
      </div>

      <div className="flex flex-col justify-center min-h-screen max-w text-center bg-gradient-to-b from-[#D9D9D9] backdrop-blur-3xl ">
        <h1 className='text-[#550E63] text-5xl font-bold mb-10'>
          Sign Up
        </h1>

        <section className='flex flex-col content-center justify-center space-y-4 px-24 flex-wrap'>
          <hr className="w-120 h-0.5 border-[#550E63]"/>
            <input type="name" className="mt-10 opacity-50 px-3 py-2 bg-[#550E63] rounded-full max-w-sm outline-none text-white" placeholder="First Name" />
            <input type="name" className="mt-10 opacity-50 px-3 py-2 bg-[#550E63] rounded-full max-w-sm outline-none text-white" placeholder="Last Name" />
            <input type="email" className="w-full mt-10 opacity-50 px-3 py-2 bg-[#550E63] rounded-full max-w-sm outline-none text-white" placeholder="Email" />
            <input type="password" className="mt-10 opacity-50 px-3 py-2 bg-[#550E63] rounded-full max-w-sm outline-none text-white" placeholder="Password" />
            <input type="password" className="mt-10 opacity-50 px-3 py-2 bg-[#550E63] rounded-full max-w-sm outline-none text-white" placeholder="Confirm password" />
            <hr className="w-120 h-0.5 border-[#550E63]"/>
            <div className='flex flex-row justify-center space-x-3'>
              <input type="checkbox" className='outline-none'/>
              <label className='text-white text-sm'>I have read and agree with the <Link to="/tos">Terms of service</Link></label>
            </div>
        </section>
        <div className=''>
          <button className='text-xl text-white bg-[#550E63] py-2 px-10 rounded-full mt-2 drop-shadow-lg hover:text-[#550E63] hover:bg-white'>
              Sign Up
          </button>
        </div>      
      </div>
    </div>
);

}

export default SignUp;