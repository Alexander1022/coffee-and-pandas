import React from 'react';
import Logo from '../assets/LogoShortBlack.png';
import { Link } from 'react-router-dom';
import HomeIcon from "../assets/HomeIcon.png";
import MapIcon from "../assets/MapIcon.png";
import { logout } from '../services/authService';

export const NavBar = (props:any) => {
    return (
        <nav className="flex justify-between bg-gradient-to-r from-[#F39C12] to-[#FF8C00] text-white w-full">
                        <div className="px-5 xl:px-3 py-3 flex w-full items-center">
                            <img className="h-10" src={Logo} alt="logo" />

                            <div className="flex px-10 w-full mx-auto space-x-2 justify-center">
                                <input type="text" className="w-[500px] outline-none rounded-full py-2 px-4 bg-[#000000] bg-opacity-50 text-white" placeholder="Search for people..." />
                                    <button className='text-black text-opacity-50'>
                                        {
                                            props.loc == "home" ?
                                            <button>
                                                <Link to="/home">
                                                    <img className='h-8 w-8' src={HomeIcon} />
                                                </Link>
                                            </button> 
                                            :
                                            <button>
                                                <Link to="/map">
                                                    <img className="h-8 w-8" src={MapIcon} />
                                                </Link>
                                            </button>
                                        }
                                    </button>
                            </div>
                        
                            <div className="flex flex-row items-center">
                                    <button className='text-black text-opacity-50 px-5'>
                                        <Link to="/map">
                                            <span className="relative inline-block ml-8">
                                            </span>
                                        </Link>
                                    </button>

                                    <button className='text-black px-5' onClick={logout}>
                                        <Link to="/signin">
                                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth="1.5" stroke="currentColor" className="w-10 h-10">
                                                <path strokeLinecap="round" strokeLinejoin="round" d="M15.75 9V5.25A2.25 2.25 0 0013.5 3h-6a2.25 2.25 0 00-2.25 2.25v13.5A2.25 2.25 0 007.5 21h6a2.25 2.25 0 002.25-2.25V15M12 9l-3 3m0 0l3 3m-3-3h12.75" />
                                            </svg>     
                                        </Link>
                                    </button>
                            </div>
                        </div>
                    </nav>
    )
}
