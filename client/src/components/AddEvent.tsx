import { useState } from 'react';
import { Dialog } from '@headlessui/react';

const AddEvent = (props:any) => {
    let [isOpen, setIsOpen] = useState(true);

    return (
        <Dialog
          open={isOpen}
          onClose={() => setIsOpen(false)}
          className="relative z-50"
        >
          <div className="fixed inset-0 flex items-center justify-center p-4">
            <Dialog.Panel className="w-full max-w-sm rounded bg-white">
                <Dialog.Title>Add new event on this location!</Dialog.Title>
                
                <Dialog.Description>
                    You will add a new event on {props.lat + ", " + props.lng}
                </Dialog.Description>
                
                </Dialog.Panel>
          </div>
        </Dialog>
      );
}

export default AddEvent;