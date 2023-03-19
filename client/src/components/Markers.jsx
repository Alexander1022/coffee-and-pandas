import { Marker } from 'react-leaflet';
import React from 'react';
import 'leaflet/dist/leaflet.css';
import icon from 'leaflet/dist/images/marker-icon.png';
import L from 'leaflet';
import { usePlaces } from '../hooks/usePlaces';
import { useLegend } from '../hooks/useLegend';
import { Checkbox } from './Checkbox';
// let counter = 0;




//main_place = SOFIA

const Markers = ({ onMarkerSelect }) => {

    document.getElementsByClassName("leaflet-control-zoom")[0].style.left = "12rem";
    document.getElementsByClassName("leaflet-control-zoom")[0].style.display = "none";

    const { legend, setSelected } = useLegend()
    const { places } = usePlaces();

    return (
        <div>
            {
                legend.map((item) => {
                    return item.selected && places && places[item.name] && places[item.name].map((place) => {
                        return <Marker key={place.geometry.coordinates} position={[place.geometry.coordinates[1], place.geometry.coordinates[0]]} icon={item.icon} eventHandlers={{
                            click: () => {
                                onMarkerSelect(place);
                            },
                        }} />
                    })
                })
            }
            <div style={{ position: 'absolute', display: 'flex', flexDirection: 'column', width: '12rem', height: '100%', zIndex: 999, backgroundColor: '#f39c12', opacity: '0.9' }}>
                <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', flexDirection: 'column', borderBottom: '1px dashed black', padding: '0.5rem', margin: '0.5rem' }}>
                    <h1 style={{ fontSize: '1.3rem', fontWeight: 'bold' }}>Enter Exploring</h1>
                    <p style={{ fontSize: '0.75rem' }}> Discover the best entertainment venues in your area with our interactive map!</p>
                </div>
                <div className='justify-center text-center flex flex-col align-center'>
                    <label style={{ fontSize: '1.3rem', marginBottom: '0.2rem', fontWeight: 'bold' }}>Destinations</label>
                    {
                        legend.map((item) => {
                            return (
                                <div key={item.name} style = {{ display: 'flex' , justifyContent: 'flex-start' , gap: '2' , width: '25px', marginLeft: '1rem'}}>
                                    {item.img}
                                    <Checkbox
                                        label={item.name}
                                        checked={item.selected}
                                        onChange={() => setSelected(item.name, !item.selected)}>

                                    </Checkbox>
                                </div>
                            )
                        })
                    }
                </div>

            </div>

        </div>
    );
}

export default Markers;