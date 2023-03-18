import { MagnifyingGlassIcon } from '@heroicons/react/24/solid'
import { useState } from 'react';
import MapImage from '../assets/map.png';
import EventCard from './EventCard';
import FriendComponent from './FriendComponents';
import CenteredCard from './CenteredCard';
import { NavBar } from './NavBar';

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
                    <NavBar/>
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
                        <div className='bg-[#333333] px-10 space-y-3'>
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