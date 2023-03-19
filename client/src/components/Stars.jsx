import React from 'react';
import EmptyStar from '../assets/Site_Icons/Star.png';
import HalfStar from '../assets/Site_Icons/StarHalf.png';
import StarFull from '../assets/Site_Icons/StarFull.png';
import { useState } from 'react';
import { useMemo } from 'react';

const starsConfig = [
    {
        rating: 0.5,
        stars: [
            {
                src: EmptyStar
            },
            {
                src: EmptyStar
            },
            {
                src: EmptyStar
            },
            {
                src: EmptyStar
            },
            {
                src: EmptyStar
            },
        ]
    },
    {
        rating: 1,
        stars: [
            {
                src: HalfStar
            },
            {
                src: EmptyStar
            },
            {
                src: EmptyStar
            },
            {
                src: EmptyStar
            },
            {
                src: EmptyStar
            },
        ]
    },
    {
        rating: 1.5,
        stars: [
            {
                src: StarFull
            },
            {
                src: EmptyStar
            },
            {
                src: EmptyStar
            },
            {
                src: EmptyStar
            },
            {
                src: EmptyStar
            },
        ],
    },
    {
        rating: 2,
        stars: [
            {
                src: StarFull
            },
            {
                src: HalfStar
            },
            {
                src: EmptyStar
            },
            {
                src: EmptyStar
            },
            {
                src: EmptyStar
            },
        ]
    },
    {
        rating: 2.5,
        stars: [
            {
                src: StarFull
            },
            {
                src: StarFull
            },
            {
                src: EmptyStar
            },
            {
                src: EmptyStar
            },
            {
                src: EmptyStar
            },
        ]
    },
    {
        rating: 3,
        stars: [
            {
                src: StarFull
            },
            {
                src: StarFull
            },
            {
                src: HalfStar
            },
            {
                src: EmptyStar
            },
            {
                src: EmptyStar
            },
        ]
    },
    {
        rating: 3.5,
        stars: [
            {
                src: StarFull
            },
            {
                src: StarFull
            },
            {
                src: StarFull
            },
            {
                src: EmptyStar
            },
            {
                src: EmptyStar
            },
        ]
    },
    {
        rating: 4,
        stars: [
            {
                src: StarFull
            },
            {
                src: StarFull
            },
            {
                src: StarFull
            },
            {
                src: HalfStar
            },
            {
                src: EmptyStar
            },
        ]
    },
    {
        rating: 4.5,
        stars: [
            {
                src: StarFull
            },
            {
                src: StarFull
            },
            {
                src: StarFull
            },
            {
                src: StarFull
            },
            {
                src: EmptyStar
            },
        ]
    },
    {
        rating: 5,
        stars: [
            {
                src: StarFull
            },
            {
                src: StarFull
            },
            {
                src: StarFull
            },
            {
                src: StarFull
            },
            {
                src: HalfStar
            },
        ]
    },
    {
        rating: 5.5,
        stars: [
            {
                src: StarFull
            },
            {
                src: StarFull
            },
            {
                src: StarFull
            },
            {
                src: StarFull
            },
            {
                src: StarFull
            },
        ]
    }
]


const StarContainer = ({ children }) => <div style={{ display: 'flex', height: "1.5rem" }}>{children}</div>
const StarImage = ({ src, onClick, onMouseOver, onMouseOut }) => <img onClick={onClick} onMouseOver={onMouseOver} onMouseOut={onMouseOut} style={{ height: '100%' }} src={src} />

const getStars = (rating, setChosenRating, setHoverRating) => {

    const correctConfig = starsConfig.find((c) => rating < c.rating);

    return <StarContainer>
        {correctConfig.stars.map((star, i) => <StarImage onMouseOver={() => setHoverRating(i + 1)} onMouseOut={() => setHoverRating(0)} key={i} src={star.src} onClick={() => setChosenRating(i + 1)}></StarImage>)}
    </StarContainer>
}

export const Stars = ({ rating, selectable }) => {
    const [chosenRating, setChosenRating] = useState(0);
    const [hoverRating, setHoverRating] = useState(0);

    const starRating = useMemo(() => {
        return selectable ? hoverRating > 0 ? hoverRating : chosenRating : rating
    }, [selectable, hoverRating, chosenRating, rating])

    return (
        getStars(starRating, setChosenRating, setHoverRating)
    )
}
