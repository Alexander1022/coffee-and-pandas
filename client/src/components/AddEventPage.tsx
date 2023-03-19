import React from 'react';
import { NavBar } from './NavBar';
import { useState } from 'react';
import FriendComponent from './FriendComponents';
import EventInterface from '../types/event.type';
import { getCurrentUser } from '../services/authService';
import { addEvent } from '../services/eventService';

export const AddEventPage = () => {
  const [eventName, setEventName] = useState('');
  const [eventDescription, setEventDescription] = useState('');
  const [eventDate, setEventDate] = useState('');
  const [eventTime, setEventTime] = useState('');
  const [eventLocation, setEventLocation] = useState('');

  const [inputType, setInputType] = useState('text');
  const [inputType2, setInputType2] = useState('text');
  
  const initialEvent: EventInterface = {
    id: null,
    name: '',
    description: '',
    date: '',
    creatorId: '1',
    placeDto: {
      name: '',
      description: '',
      placeType: '',
      coordinates: '',
    }

  }
  const hadnleChangeInputType = () => {
    setInputType("date");
  };

  const hadnleChangeInputType2 = () => {
    setInputType2("time");
  };

  const handleNameChange = (e: any) => {
    setEventName(e.target.value);
  }

  const handleDescriptionChange = (e: any) => {
    setEventDescription(e.target.value);
  }

  const handleDateChange = (e: any) => {
    setEventDate(e.target.value);
  }

  const handleTimeChange = (e: any) => {
    setEventTime(e.target.value);
  }

  const handleLocationChange = (e: any) => {
    setEventLocation(e.target.value);
  }
  
  const handleSumbit = (e:any) => {
    e.preventDefault();

    const event: EventInterface = {
      id: null,
      name: eventName,
      description: eventDescription,
      date: eventDate,
      creatorId: getCurrentUser(),
      placeDto: {
        name: eventLocation,
        description: eventDescription,
        placeType: 'CINEMA',
        coordinates: eventLocation
      }
  }
  console.log("event" + JSON.stringify(event));

  addEvent(event).then(
    (response) => {
      console.log(response.data);
    },

    (error) => {
      console.log(error);
    }
  );
}

  return (
    <>
      <NavBar loc="map"/>

      <div className="p-5 bg-[#333333] h-full">
        <div className="flex flex-row auto-cols-max gap-x-2 justify-center">
          <div className="bg-transparent w-1/4 space-y-10 h-full">
          <div className="flex flex-col w-full space-y-10 bg-transparent m-10">
              <div className="h-screen overflow-y-none sm:w-64 w-screen bg-[#333333]">
                <h2 className="text-2xl text-center mb-5 leading-none text-white">Friends to participate</h2>
                  <div className="mt-8 space-y-3">
                        <FriendComponent name="Gunter"/>
                        <FriendComponent name="Ivo"/>
                  </div>
              </div>
            </div>
          </div>

          <div className="bg-transparent w-1/2 h-full">
            <h1 className='text-white text-4xl text-center my-6'>Create a new event</h1>
            <form onSubmit={handleSumbit} className='flex flex-col space-y-6 w-full items-center'>
              <input type="text" value={eventLocation} onChange={handleLocationChange} placeholder="Place" className='outline-none rounded-xl h-12 p-2 w-full'/>
              <input type="text" value={eventName} onChange={handleNameChange} placeholder="Title" className='outline-none rounded-xl h-12 p-2 w-full'/>
              <input type="text" value={eventDescription} onChange={handleDescriptionChange} placeholder="Description" className='outline-none rounded-xl p-2 w-full h-36'/>
              <div className='flex flex-rol w-full space-x-2'>
                <input type={inputType} value={eventDate} onChange={handleDateChange} className='outline-none rounded-xl h-12 p-2 w-screen' placeholder='Date' onFocus={hadnleChangeInputType}/>
                <input type={inputType2} value={eventTime} onChange={handleTimeChange} className='outline-none rounded-xl h-12 p-2 w-screen' placeholder="Time" onFocus={hadnleChangeInputType2}/>  
              </div>

              <button type="submit" className='text-center py-3 w-36 rounded-full bg-[#FF5722] text-white'>
                Create
              </button>
            </form>
          </div>

          <div className="w-1/4 bg-blend-multiply h-screen">
            <div className="flex flex-col w-full space-y-10 bg-transparent m-10">
              <div className="h-screen overflow-y-none sm:w-64 w-screen bg-[#333333]">
                <h2 className="px-5 text-3xl text-center mb-5 text-white">Friends</h2>
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
  )
}
