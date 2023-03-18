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

    const DefaultIcon = L.icon({
        iconUrl: icon
    });

    L.Marker.prototype.options.icon = DefaultIcon;


    const { legend, setSelected } = useLegend()
    const { places } = usePlaces();

    return (
        <div>
            {
                legend.map((item) => {
                    return item.selected && places && places[item.name] && places[item.name].map((place) => {
                        return <Marker key={place.geometry.coordinates} position={[place.geometry.coordinates[1], place.geometry.coordinates[0]]} iconUrl={DefaultIcon} eventHandlers={{
                            click: (e) => {
                                onMarkerSelect(true);
                            },
                        }} />
                    })
                })
            }
            <div style={{ position: 'absolute', display: 'flex', flexDirection: 'column', width: '100px', height: 'fit-content', zIndex: 999, top: '100px', left: '0px', backgroundColor: 'white' }}>
                {
                    legend.map((item) => {
                        return <Checkbox key={item.name} label={item.name} checked={item.selected} onChange={() => setSelected(item.name, !item.selected)}></Checkbox>
                    })
                }
            </div>

        </div>
    );
}

export default Markers;