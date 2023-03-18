import FMIImage from '../assets/fmi.jpeg';

const EventCard = () => {
    return (
        <>
            <div className="lg:max-w-full lg:flex">
                <div className="h-36 lg:h-auto lg:w-48 flex-none bg-cover rounded-t lg:rounded-t-none lg:rounded-l text-center overflow-hidden">
                    <img className="object-fit" src={FMIImage} />
                </div>

                <div className="border-r border-b border-l border-gray-400 lg:border-l-0 lg:border-t lg:border-gray-400 bg-white rounded-b lg:rounded-b-none lg:rounded-r p-4 flex flex-col justify-between leading-normal">
                    <div className="mb-8">
                        <div className="text-gray-900 font-bold text-xl mb-2">FMI Event 1</div>
                            <p className="text-gray-700 text-base">Information 1</p>
                        </div>

                        <div className="flex items-center">
                            <div className="text-sm">
                                <p className="text-gray-900 leading-none">John Smith</p>
                                <p className="text-gray-600">March 18</p>
                            </div>
                        </div>
                    </div>
                </div>
        </>
    );
}

export default EventCard;