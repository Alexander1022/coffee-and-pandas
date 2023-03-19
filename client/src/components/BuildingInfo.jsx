import AddEvent from "./AddEvent";
import Fmi from "../assets/fmi.jpeg";
import { Stars } from "./Stars";
import Xbutton from "../assets/Site_Icons/XButton.png"

const BuildingInfo = ({info, onClose}) => {
    const name = info.properties.address_line1;
    const address = info.properties.formatted;
    const stars = "3.5";

    return (
        <div style={{ position: 'absolute', display: 'flex', flexDirection: 'column', backgroundColor: '#e5e5e5', opacity: '0.9', width: '18rem', height: '100%', right: '0px', zIndex: '999' }}>
            <div style={{ display: 'flex', flexDirection: 'column', justifyContent: 'center', textAlign: 'center', alignItems: 'center', color: "black", opacity: 1 }}>
                <img src = {Xbutton} onClick={onClose} style = {{position: 'absolute' , top: '0px', left: '0px' , width: '1.5rem' , cursor: 'pointer'}}/>
                <label style={{ fontSize: '2rem' , marginTop: '1rem'}}>{name}</label>

                <div style={{ position: 'relative', width: '100%' }}>
                    <img src={Fmi} style={{ width: '100%', height: '80%', position: 'relative', marginTop: '1.5rem' }} alt="blue"></img>
                    <div style={{ position: 'absolute', display: 'flex', right: '0.5rem', bottom: '2rem' }}>
                        <Stars rating={stars} />
                    </div>
                </div>



                <p style={{ marginTop: '0.5rem' }}>{address}</p>
                <div style={{ width: '60%', borderBottom: '3px solid black', marginTop: '1rem' }}></div>
                <div style={{ display: 'flex', width: '100%', justifyContent: 'space-around', alignItems: 'center', marginTop: '1rem' }}>
                    <label>Leave a review: </label>
                    <div style={{ cursor: 'pointer' }}>
                        <Stars rating={0} selectable />
                    </div>
                </div>
                <input type = "text" style = {{width: `90%`, marginTop: '0.5rem', height: '2rem', backgroundColor: 'gray', borderRadius: '15px'}}></input>
                <button style = {{backgroundColor: 'orange' , width: '6rem' , height: '2rem', alignSelf: 'end' , marginRight: '1rem', borderRadius: '15px', marginTop: '0.5rem'}}>Submit</button>
                <AddEvent />
            </div>
        </div>
    )
}

export default BuildingInfo;