import { MagnifyingGlassIcon } from '@heroicons/react/24/solid'
import { useState } from 'react';

const Home = () => {
    const [search, setSearch] = useState<string>('');
    const [searchResults, setSearchResults] = useState<string[]>([]);
    
    return (
        <div>
            <div className="flex flex-wrap place-items-center h-full">
                <section className="relative mx-auto">
                    <nav className="flex justify-between bg-gray-900 text-white w-screen">
                        <div className="px-5 xl:px-12 py-6 flex w-full items-center">
                            <img className="h-9" src="logo.png" alt="logo" />
                            <ul className="hidden md:flex px-4 mx-auto font-semibold font-heading space-x-12">
                                <input type="text" className="outline-none rounded-full p-2 w-64" placeholder="Search" />
                                <button>
                                    <MagnifyingGlassIcon className="p-auto w-8 h-8" />
                                </button>

                            </ul>
                        
                            <div className="hidden xl:flex items-center space-x-5">
                                <img className="w-10 h-10 rounded" src="https://img.freepik.com/free-vector/businessman-character-avatar-isolated_24877-60111.jpg?w=1060&t=st=1679104585~exp=1679105185~hmac=59febdc7d33b3fa9e236472ede6ba521f8647496f3e8d1e9680c7e0917d0329c" />
                            </div>
                        </div>
                    </nav>
                </section>
            </div>

            <div className="grid grid-cols-3">

            </div>
        </div>
    );
}

export default Home;