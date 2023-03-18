import React, { useState } from 'react'
import { legendDefaults } from './legendDefaults'


export const useLegend = () => {
    const [legend, setLegend] = useState(legendDefaults);


    const setSelected = (name, value) => {
        const foundLegend = legend.find(l => l.name === name);

        foundLegend.selected = value;

        const newLegend = [
            ...legendDefaults.filter((l => l.name !== name)),
            foundLegend
        ]

        const sorted = newLegend.sort((a, b) => a.name.localeCompare(b.name))

        setLegend(sorted);
    }

    return (
        { legend, setSelected }
    )
}