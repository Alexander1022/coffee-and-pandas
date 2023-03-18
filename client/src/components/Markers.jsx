import { Marker } from 'react-leaflet';
import { useState } from 'react';
import axios from 'axios';
import 'leaflet/dist/leaflet.css';
import icon from 'leaflet/dist/images/marker-icon.png';
import L from 'leaflet';
let counter = 0;

const apikey = "51fa72b0485d52374059f0294a534e594540f00101f901dd5a410000000000c00208920305536f666961";
const config = {
    method: 'get',
    url: `https://api.geoapify.com/v2/places?categories=commercial.supermarket&filter=place:${apikey}&limit=50&apiKey=853231c3392a4db79eaf71e4a8ee8dc0`,
    headers: { }
};

const center = [42.696071, 23.330727];

const Markers = () => {
    const DefaultIcon = L.icon({
        iconUrl: icon
    });
    L.Marker.prototype.options.icon = DefaultIcon;
    // console.log("here");
    const [places, setPlaces] = useState([]);

    const handleMarkers = (places) => {
        setPlaces(places);
    }

    axios(config)
        .then(function (response) {
            // console.log(response.data.features[0].geometry.coordinates[1] , response.data.features[0].geometry.coordinates[0])
            counter++;
            console.log(counter);
            handleMarkers(response.data.features);
            // console.log(response.data)
        })
        .catch(function (error) {
            console.log(error);
        });   

    return(
        <div>
            {places.map(item => (
                <Marker key = {item.geometry.coordinates} position = {[item.geometry.coordinates[1] , item.geometry.coordinates[0]]} iconUrl = {DefaultIcon}/>
            ))}
      </div>
    );
}

export default Markers;