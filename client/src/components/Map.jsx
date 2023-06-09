import {
    MapContainer,
    TileLayer,
} from 'react-leaflet';
// import L from 'leaflet';
import 'leaflet/dist/leaflet.css';
import Markers from './Markers';
import BuildingInfo from './BuildingInfo';
import { useState } from 'react';
import { NavBar } from './NavBar';
const center = [42.696071, 23.330727];

function Map() {
    const [markerSelected, setMarkerSelected] = useState(null);
    const customStyle = {
        width: '100vw',
        height: '100vh'
    }

    return (
        <div>
            <NavBar loc="home"/>
            <MapContainer center={center} zoom={16} scrollWheelZoom={true} style={customStyle}>

                <TileLayer
                    url="https://api.maptiler.com/maps/streets-v2/256/{z}/{x}/{y}.png?key=UfhKDL4DZ5XjnlKLlq3N"
                    attribution='&copy; Entertizer</a></a>'
                />

                <Markers onMarkerSelect={setMarkerSelected} />
                {
                    markerSelected &&
                    <BuildingInfo info={markerSelected} onClose={() => setMarkerSelected(null)} />
                }
            </MapContainer>

        </div>

    );
}

export default Map;