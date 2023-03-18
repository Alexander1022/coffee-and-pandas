import { MagnifyingGlassIcon } from '@heroicons/react/24/solid'
import { useState } from 'react';
import MapImage from '../assets/map.png';
import Logo from '../assets/LogoShortBlack.png';
import EventCard from './EventCard';
import FriendComponent from './FriendComponents';
import CenteredCard from './CenteredCard';

 const Home = () => {
    const [search, setSearch] = useState<string>('');
    const [searchResults, setSearchResults] = useState<string[]>([]);
    
    const handleSearchResults = (res:string[]) => {
        setSearchResults(res);
    }

    const handleSearch = (res:string) => {
        setSearch(res);
    }

    return (
        <>
            <div className="flex flex-wrap place-items-center h-full w-screen">
                <section className="flex mx-auto w-full">
                    <nav className="flex justify-between bg-gradient-to-r from-[#F39C12] to-[#FF8C00] text-white w-full">
                        <div className="px-5 xl:px-12 py-6 flex w-full items-center">
                            <img className="h-9" src={Logo} alt="logo" />
                            <ul className="hidden md:flex px-4 mx-auto font-semibold font-heading space-x-12">
                                <input type="text" className="outline-none rounded-full p-2 w-64 bg-[#000000] bg-opacity-50 text-white" placeholder="Search for people..." />
                                <button className='text-black text-opacity-50'>
                                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" className="w-8 h-8">
                                        <path fillRule="evenodd" d="M8.161 2.58a1.875 1.875 0 011.678 0l4.993 2.498c.106.052.23.052.336 0l3.869-1.935A1.875 1.875 0 0121.75 4.82v12.485c0 .71-.401 1.36-1.037 1.677l-4.875 2.437a1.875 1.875 0 01-1.676 0l-4.994-2.497a.375.375 0 00-.336 0l-3.868 1.935A1.875 1.875 0 012.25 19.18V6.695c0-.71.401-1.36 1.036-1.677l4.875-2.437zM9 6a.75.75 0 01.75.75V15a.75.75 0 01-1.5 0V6.75A.75.75 0 019 6zm6.75 3a.75.75 0 00-1.5 0v8.25a.75.75 0 001.5 0V9z" clipRule="evenodd" />
                                    </svg>
                                </button>
                            </ul>
                        
                            <div className="hidden xl:flex items-center space-x-5">
                                <button className='text-black text-opacity-50'>
                                    <span className="relative inline-block ml-8">
                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" className="w-8 h-8">
                                            <path d="M5.85 3.5a.75.75 0 00-1.117-1 9.719 9.719 0 00-2.348 4.876.75.75 0 001.479.248A8.219 8.219 0 015.85 3.5zM19.267 2.5a.75.75 0 10-1.118 1 8.22 8.22 0 011.987 4.124.75.75 0 001.48-.248A9.72 9.72 0 0019.266 2.5z" />
                                            <path fillRule="evenodd" d="M12 2.25A6.75 6.75 0 005.25 9v.75a8.217 8.217 0 01-2.119 5.52.75.75 0 00.298 1.206c1.544.57 3.16.99 4.831 1.243a3.75 3.75 0 107.48 0 24.583 24.583 0 004.83-1.244.75.75 0 00.298-1.205 8.217 8.217 0 01-2.118-5.52V9A6.75 6.75 0 0012 2.25zM9.75 18c0-.034 0-.067.002-.1a25.05 25.05 0 004.496 0l.002.1a2.25 2.25 0 11-4.5 0z" clipRule="evenodd" />
                                        </svg>
                                        <span className="animate-pulse absolute top-0 right-0 inline-block w-4 h-4 transform translate-x-1/2 -translate-y-1/2 bg-red-600 rounded-full"></span>
                                    </span>
                                </button>
                                <img className="w-10 h-10 rounded" src="https://img.freepik.com/free-vector/businessman-character-avatar-isolated_24877-60111.jpg?w=1060&t=st=1679104585~exp=1679105185~hmac=59febdc7d33b3fa9e236472ede6ba521f8647496f3e8d1e9680c7e0917d0329c" />
                            </div>
                        </div>
                    </nav>
                </section>
            </div>

            <div className="p-5 bg-[#333333] h-full">
                <div className="flex flex-row auto-cols-max gap-x-2 justify-center">
                    <div className="bg-transparent w-1/4 space-y-10 h-full">
                        <div className='border-0 p-5 bg-[#F6970D] rounded-3xl'>
                            <div className='bg-[#F6970D]'>
                                <h1 className='text-center font-bold text-3xl text-white'>Search on map</h1>
                            </div>
                            <div className='mt-10 bg-[#AF741E]'>
                                <img src={ MapImage } />
                            </div>
                        </div>

                        <div className='border-0 p-5 bg-[#F6970D] rounded-3xl'>
                            <div className='bg-[#F6970D]'>
                                <h1 className='text-center font-bold text-3xl text-white'>Recent events</h1>
                            </div>

                            <div className='bg-blend-multiply space-y-10'>
                                <EventCard />
                                <EventCard />
                                <EventCard />
                            </div>
                        </div>

                    </div>

                    <div className="bg-white w-1/2 h-full">
                        <div className='bg-[#333333] px-10'>
                            <CenteredCard title="Рождения ден на Ивака" desc="Елате на моя рожден ден, правя 23 години, ще има яки момичета, може би..."/>

                            <CenteredCard title="Клуб 33 на 24 Март" desc="Ще бъде мазало!"/>

                            <CenteredCard title="Луди котки, биещи се в космоса" desc="Това е новият филм на Иван Иванов"/>

                            <CenteredCard title="Маратон от ФМИ до Филиповци" desc="Run, run, ruuun! 🦶🏻"/>

                        </div>
                    </div>

                    <div className="w-1/4 bg-blend-multiply h-screen">
                        <div className="flex flex-col w-full space-y-10 bg-transparent m-10">
                            <div className="h-screen overflow-y-none sm:w-64 w-screen bg-[#333333]">
                                <h2 className="px-5 text-3xl font-extrabold text-center mb-5 text-white">Friends</h2>
                                <div className='flex justify-center rounded-xl space-x-2'>
                                    <input type="text" className='rounded-full border-2 border-black text-center outline-none focus:border-red-600 focus:border-2' placeholder='Search a friend...'/>

                                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={2.5} stroke="white" className="w-6 h-6">
                                        <path strokeLinecap="round" strokeLinejoin="round" d="M21 21l-5.197-5.197m0 0A7.5 7.5 0 105.196 5.196a7.5 7.5 0 0010.607 10.607z" />
                                    </svg>

                                </div>
                                <div className="mt-8 space-y-3">
                                    <FriendComponent name="Alex"/>
                                    <FriendComponent name="Ivo"/>
                                    <FriendComponent name="Mihail"/>
                                    <FriendComponent name="Krasimir"/>
                                    <FriendComponent name="Ivan"/>
                                    <FriendComponent name="Ahil"/>
                                    <FriendComponent name="Detelin"/>
                                    <FriendComponent name="Boril"/>
                                    <FriendComponent name="Mustafa"/>
                                    <FriendComponent name="Gunter"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default Home;