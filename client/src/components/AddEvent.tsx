import { useState } from 'react';
import { Dialog } from '@headlessui/react';

const AddEvent = (props:any) => {
    let [isOpen, setIsOpen] = useState(true);

    return (
        <button style = {{position: 'fixed', width: '8rem' , height: '2.5rem' , backgroundColor: 'orange' , bottom: '1rem', borderRadius: '20px'}}>
          Event
        </button>   
    );
}

export default AddEvent;