import {
  MapContainer , 
  TileLayer,
} from 'react-leaflet';
// import L from 'leaflet';
import 'leaflet/dist/leaflet.css';
import Markers from './Markers';
// import Legend from './Legend';

const center = [42.696071, 23.330727];

function Map() {
    return (
        <div>
            {/* <Legend/> */}
            <MapContainer center = {center} zoom = {16} scrollWheelZoom = {true} style = {{width : '100vw' , height: '100vh'}}>
                
                <TileLayer
                url = "https://api.maptiler.com/maps/streets-v2/256/{z}/{x}/{y}.png?key=UfhKDL4DZ5XjnlKLlq3N"
                attribution = '<a href="https://www.maptiler.com/copyright/" target="_blank">&copy; MapTiler</a> <a href="https://www.openstreetmap.org/copyright" target="_blank">&copy; OpenStreetMap contributors</a>' 
                />
    
                <Markers/>
            </MapContainer>
        </div>
        
    );
}

export default Map;