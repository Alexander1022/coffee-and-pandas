import AddEvent from "./AddEvent";
import Fmi from "../assets/fmi.jpeg";
import { Stars } from "./Stars";
import Xbutton from "../assets/Site_Icons/XButton.png"
import { Link } from "react-router-dom";

const BuildingInfo = ({info, onClose}) => {
    const name = info.properties.address_line1;
    const address = info.properties.formatted;
    const stars = "3.5";

    return (
        <div style={{ position: 'absolute', display: 'flex', flexDirection: 'column', backgroundColor: '#e5e5e5', opacity: '0.9', width: '18rem', height: '100%', right: '0px', zIndex: '999' }}>
            <div style={{ display: 'flex', flexDirection: 'column', justifyContent: 'center', textAlign: 'center', alignItems: 'center', color: "black", opacity: 1 }}>
                <img src = {Xbutton} onClick={onClose} style = {{position: 'absolute' , top: '0px', left: '0px' , width: '1.5rem' , cursor: 'pointer'}}/>
                <label className="flex flex-col font-semibold text-black text-xl text-ellipsis" style={{marginTop: '1rem'}}>
                    {name}
                </label>

                <div style={{ position: 'relative', width: '100%' }}>
                    <img src={Fmi} style={{ width: '100%', height: '80%', position: 'relative', marginTop: '1.5rem' }} alt="blue"></img>
                    <div style={{ position: 'absolute', display: 'flex', right: '0.5rem', bottom: '2rem', boxShadow: "10px 10px 10px #ffffff" }}>
                        <Stars rating={stars} />
                    </div>
                </div>



                <p className="text-black text-md font-semibold text-ellipsis" style={{ marginTop: '0.5rem' }}>
                    {address}
                </p>
                <div style={{ width: '60%', borderBottom: '3px solid black', marginTop: '1rem' }}></div>
                <div style={{ display: 'flex', width: '100%', justifyContent: 'space-around', alignItems: 'center', marginTop: '1rem' }}>
                    <label>Leave a review: </label>
                    <div style={{ cursor: 'pointer' }}>
                        <Stars className="transition ease-in-out" rating={0} selectable />
                    </div>
                </div>

                <input type = "text" className="p-2 text-white " style = {{backgroundColor: 'white', width: `90%`, marginTop: '0.5rem', height: '2rem', backgroundColor: 'gray', borderRadius: '15px'}}></input>
                <button className="text-white bg-[#ff5722]" style = {{backgroundColor: '#ff5722' , width: '6rem' , height: '2rem', alignSelf: 'end' , marginRight: '1rem', borderRadius: '15px', marginTop: '0.5rem'}}>Submit</button>
                <Link className="flex align-middle justify-center" to="/events/add">
                    <AddEvent />
                </Link>
            </div>
        </div>
    )
}

export default BuildingInfo;