import React from 'react'
import { useState, useEffect } from 'react';
import axios from 'axios';
import { legendDefaults } from './legendDefaults';

const main_place = "51fa72b0485d52374059f0294a534e594540f00101f901dd5a410000000000c00208920305536f666961";
const limit = 150;
const apikey = "0bc6411c4b634b248bd37daa0881d26f";

export const usePlaces = () => {
    const [places, setPlaces] = useState(null);

    useEffect(() => {
        for (const legend of legendDefaults) {
            const config = {
                method: 'get',
                url: `https://api.geoapify.com/v2/places?categories=${legend.category}&filter=place:${main_place}&limit=${limit}&apiKey=${apikey}`,
                headers: {}
            };

            axios(config)
                .then(function (response) {
                    setPlaces((prev) => {
                        return {
                            ...prev,
                            [legend.name]: response.data.features
                        }
                    });
                })
                .catch(function (error) {
                    console.log(error);

                });
        }
    }, []);

    return (
        { places }
    )
}
