import { Marker } from 'react-leaflet';
import { useState } from 'react';
import axios from 'axios';
import 'leaflet/dist/leaflet.css';
import icon from 'leaflet/dist/images/marker-icon.png';
import L from 'leaflet';
// let counter = 0;



let legendState = [
    {
        name: "Bar", 
        category: "catering.bar",
        selected: true
    },
    {
        name: "Beach", 
        category: "beach",
        selected: true
    },
    {
        name: "Casino", 
        category: "adult.casino",
        selected: true
    },
    {
        name: "Cinema",
        category: "entertainment.cinema",
        selected: true
    },
    {
        name: "Disco",
        category: "adult.nightclub",
        selected: true
    },
    {
        name: "Erotic",
        category: "commercial.erotic",
        selected: true
    },
    {
        name: "Food",
        category: "commercial.food_and_drink",
        selected: true
    },
    {
        name: "Gallery",
        category: "commercial.art",
        selcted: true
    },
    {
        name: "Gaming",
        category: "adult.adult_gaming_center",
        selected: true
    },
    {
        name: "Gym",
        category: "sport.fitness",
        selected: true
    },
    {
        name: "Hotel",
        category: "accomodation.hotel",
        selected: true
    },
    {
        name: "Museum",
        category: "entertainment.museum",
        selected: true
    },
    {
        name: "Park",
        category: "leisure.park",
        selected: true
    },
    {
        name: "Playground",
        category: "leisure.playground",
        selected: true
    },
    {
        name: "Sport",
        category: "building.sport",
        selected: true
    },
    {
        name: "Mall",
        category: "commercial.shopping_mall",
        selected: true
    },
    {
        name: "Zoo",
        category: "entertainment.zoo",
        selected: true
    }];

//main_place = SOFIA
const main_place = "51fa72b0485d52374059f0294a534e594540f00101f901dd5a410000000000c00208920305536f666961";
const limit = 50;
const apikey = "853231c3392a4db79eaf71e4a8ee8dc0";
const category = legendState[0].category;

const config = {
    method: 'get',
    url: `https://api.geoapify.com/v2/places?categories=${category}&filter=place:${main_place}&limit=${limit}&apiKey=${apikey}`,
    headers: { }
};


const Markers = () => {
    const DefaultIcon = L.icon({
        iconUrl: icon
    });
    L.Marker.prototype.options.icon = DefaultIcon;
    const [places, setPlaces] = useState([]);

    const handleMarkers = (places) => {
        setPlaces(places);
    }

    axios(config)
        .then(function (response) {
            // counter++;
            // console.log(counter);
            handleMarkers(response.data.features);
        })
        .catch(function (error) {
            console.log(error);
        });   

    return(
        <div>
            <div>

            </div>
            <div>
                {places.map(item => (
                    <Marker key = {item.geometry.coordinates} position = {[item.geometry.coordinates[1] , item.geometry.coordinates[0]]} iconUrl = {DefaultIcon}/>
                ))}
            </div>
        </div>
    );
}

export default Markers;