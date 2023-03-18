import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import UserInterface from '../types/user.type';
import { register } from '../services/authService';

const SignUp = () => {
  const [fName, setFName] = useState<string>('');
  const [lName, setLName] = useState<string>('');
  const [email, setEmail] = useState<string>('');
  const [password, setPassword] = useState<string>('');
  const [rPassword, setRPassword] = useState<string>('');

  const [alright, setAlright] = useState<boolean>(false);

  const navigate = useNavigate();

  const initialUser:UserInterface = {
    firstName: '',
    lastName: '',
    username: '',
    email: '',
    password: '',
  }

  const handleChangeFName = (event:any) => {
    setFName(event.target.value);
  };

  const handleChangeLName = (event:any) => {
    setLName(event.target.value);
  };

  const handleChangeEmail = (event:any) => {
    setEmail(event.target.value);
  };

  const handleChangePassword = (event:any) => {
    setPassword(event.target.value);
  };

  const handleChangeRPassword = (event:any) => {
    setRPassword(event.target.value);
  };

  const handleSubmit = (event:any) => {
    event.preventDefault();

    setFName('');
    setLName('');
    setEmail('');
    setPassword('');
    setRPassword('');
    
    if(password !== rPassword) {
      console.log("Two passwords are note the same!");
      return;
    }

    register(fName, lName, email, password).then(
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

  };

    return (
    <div className="grid grid-cols-2 gap-4 bg-gradient-to-tl from-[#F9AC04] to-[#F39C12]">
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
            <button className='text-xl text-white border-2 py-2 px-10 border-white rounded-full drop-shadow-lg mt-3 hover:bg-white hover:text-[#FF5722]'>
              Log In
            </button>
          </Link>
        </div>
      </div>

      <div className="flex flex-col justify-center min-h-screen max-w text-center bg-gradient-to-b from-[#D9D9D9] backdrop-blur-3xl ">
        <h1 className='text-[#FF5722] text-5xl font-bold mb-10'>
          Sign Up
        </h1>

        <form className='flex flex-col content-center justify-center space-y-4 px-24 flex-wrap' onSubmit={handleSubmit}>
          <hr className="w-120 h-0.5 border-white"/>
            <input required type="name" value={fName} onChange={handleChangeFName} className="mt-10 opacity-50 px-3 py-2 bg-white rounded-full max-w-sm outline-none text-black" placeholder="First Name" />
            <input required type="name" value={lName} onChange={handleChangeLName} className="mt-10 opacity-50 px-3 py-2 bg-white rounded-full max-w-sm outline-none text-black" placeholder="Last Name" />
            <input required type="email" value={email} onChange={handleChangeEmail} className="w-full mt-10 opacity-50 px-3 py-2 bg-white rounded-full max-w-sm outline-none text-black" placeholder="Email" />
            <input required type="password" minLength={8} value={password} onChange={handleChangePassword} className="mt-10 opacity-50 px-3 py-2 bg-white rounded-full max-w-sm outline-none text-black" placeholder="Password" />
            <input required type="password" minLength={8} value={rPassword} onChange={handleChangeRPassword} className="mt-10 opacity-50 px-3 py-2 bg-white rounded-full max-w-sm outline-none text-black" placeholder="Confirm password" />
            <hr className="w-120 h-0.5 border-white"/>
            <div className='flex flex-row justify-center space-x-3'>
              <input required type="checkbox" className='outline-none'/>
              <label className='text-white text-sm'>I have read and agree with the <Link to="/tos">Terms of service</Link></label>
            </div>

            <button type="submit" className='text-xl text-white bg-[#FF5722] py-2 px-10 rounded-full mt-2 drop-shadow-lgx hover:text-[#FF5722] hover:bg-white'>
              Sign Up
          </button>
        </form>     
      </div>
    </div>
);

}

export default SignUp;