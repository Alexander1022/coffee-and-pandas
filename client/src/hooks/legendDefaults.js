import L from 'leaflet';
import Bar from "../assets/Tags/Bar.png";
import Beach from "../assets/Tags/Beach.png";
import Casino from "../assets/Tags/Casino.png";
import Cinema from "../assets/Tags/Cinema.png";
import Disco from "../assets/Tags/Disco.png";
import Erotic from "../assets/Tags/Erotic.png";
import Food from "../assets/Tags/Food.png";
import Gallery from "../assets/Tags/Gallery.png";
import Gaming from "../assets/Tags/Gaming.png";
import Gym from "../assets/Tags/Gym.png";
import Hotel from "../assets/Tags/Hotel.png";
import Museum from "../assets/Tags/Museum.png";
import Mountain from "../assets/Tags/Mountain.png";
import Park from "../assets/Tags/Park.png";
import Playground from "../assets/Tags/Playground.png";
import Sport from "../assets/Tags/Sport.png";
import Mall from "../assets/Tags/Mall.png";
import Zoo from "../assets/Tags/Zoo.png";

import BarMark from "../assets/MapPoints/bar.png";
import BeachMark from "../assets/MapPoints/beach.png";
import CasinoMark from "../assets/MapPoints/casino.png";
import CinemaMark from "../assets/MapPoints/cinema.png";
import DiscoMark from "../assets/MapPoints/disco.png";
import EroticMark from "../assets/MapPoints/erotic.png";
import FoodMark from "../assets/MapPoints/Food.png";
import GalleryMark from "../assets/MapPoints/gallery.png";
import GamingMark from "../assets/MapPoints/gaming.png";
import GymMark from "../assets/MapPoints/gym.png";
import HotelMark from "../assets/MapPoints/hotel.png";
import MountainMark from "../assets/MapPoints/mountain.png";
import MuseumMark from "../assets/MapPoints/museum.png";
import ParkMark from "../assets/MapPoints/park.png";
import PlaygroundMark from "../assets/MapPoints/playground.png";
import SportMark from "../assets/MapPoints/sport.png";
import StoreMark from "../assets/MapPoints/store.png";
import ZooMark from "../assets/MapPoints/zoo.png";

// L.Marker.prototype.options.icon = DefaultIcon;

export const legendDefaults = [
    {
        name: "Bar",
        category: "catering.bar",
        selected: true,
        img: <img src = {Bar}/>,
        icon: L.icon({
            iconUrl: BarMark,
            iconSize: [25, 41],
        })    
    },
    {
        name: "Beach",
        category: "beach",
        selected: true,
        img: <img src = {Beach}/>,
        icon: L.icon({
            iconUrl: BeachMark,
            iconSize: [25, 41],
        })    
    },
    {
        name: "Casino",
        category: "adult.casino",
        selected: true,
        img: <img src = {Casino}/>,
        icon: L.icon({
            iconUrl: CasinoMark,
            iconSize: [25, 41],
        })    
    },
    {
        name: "Cinema",
        category: "entertainment.cinema",
        selected: true,
        img: <img src = {Cinema}/>,
        icon: L.icon({
            iconUrl: CinemaMark,
            iconSize: [25, 41],
        })    
    },
    {
        name: "Disco",
        category: "adult.nightclub",
        selected: true,
        img: <img src = {Disco}/>,
        icon: L.icon({
            iconUrl: DiscoMark,
            iconSize: [25, 41],
        })    
    },
    {
        name: "Erotic",
        category: "commercial.erotic",
        selected: true,
        img: <img src = {Erotic}/>,
        icon: L.icon({
            iconUrl: EroticMark,
            iconSize: [25, 41],
        })    
    },
    {
        name: "Food",
        category: "commercial.food_and_drink",
        selected: true,
        img: <img src = {Food}/>,
        icon: L.icon({
            iconUrl: FoodMark,
            iconSize: [25, 41],
        })    
    },
    {
        name: "Gallery",
        category: "commercial.art",
        selected: true,
        img: <img src = {Gallery}/>,
        icon: L.icon({
            iconUrl: GalleryMark,
            iconSize: [25, 41],
        })    
    },
    {
        name: "Gaming",
        category: "adult.adult_gaming_centre",
        selected: true,
        img: <img src = {Gaming}/>,
        icon: L.icon({
            iconUrl: GamingMark,
            iconSize: [25, 41],
        })    
    },
    {
        name: "Gym",
        category: "sport.fitness",
        selected: true,
        img: <img src = {Gym}/>,
        icon: L.icon({
            iconUrl: GymMark,
            iconSize: [25, 41],
        })    
    },
    {
        name: "Hotel",
        category: "accommodation.hotel",
        selected: true,
        img: <img src = {Hotel}/>,
        icon: L.icon({
            iconUrl: HotelMark,
            iconSize: [25, 41],
        })    
    },
    {
        name: "Museum",
        category: "entertainment.museum",
        selected: true,
        img: <img src = {Museum}/>,
        icon: L.icon({
            iconUrl: MuseumMark,
            iconSize: [25, 41],
        })    
    },
    {
        name: "Mountain",
        category: "natural.mountain",
        selected: true,
        img: <img src = {Mountain}/>,
        icon: L.icon({
            iconUrl: MountainMark,
            iconSize: [25, 41],
        })    
    },
    {
        name: "Park",
        category: "leisure.park",
        selected: true,
        img: <img src = {Park}/>,
        icon: L.icon({
            iconUrl: ParkMark,
            iconSize: [25, 41],
        })    
    },
    {
        name: "Playground",
        category: "leisure.playground",
        selected: true,
        img: <img src = {Playground}/>,
        icon: L.icon({
            iconUrl: PlaygroundMark,
            iconSize: [25, 41],
        })    
    },
    {
        name: "Sport",
        category: "building.sport",
        selected: true,
        img: <img src = {Sport}/>,
        icon: L.icon({
            iconUrl: SportMark,
            iconSize: [25, 41],
        })    
    },
    {
        name: "Mall",
        category: "commercial.shopping_mall",
        selected: true,
        img: <img src = {Mall}/>,
        icon: L.icon({
            iconUrl: StoreMark,
            iconSize: [25, 41],
        })    
    },
    {
        name: "Zoo",
        category: "entertainment.zoo",
        selected: true,
        img: <img src = {Zoo}/>,
        icon: L.icon({
            iconUrl: ZooMark,
            iconSize: [25, 41],
        })    
    }];