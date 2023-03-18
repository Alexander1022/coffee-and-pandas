import React from 'react'

export const Checkbox = (props) => {
    return (
        <div style={{ display: 'flex' , marginLeft: '1rem' , marginTop: '0rem' }}>
            <input type='checkbox' checked={props.checked} onChange={props.onChange} style = {{width: '17px' , height: '17px' , marginTop: '4px'}}></input>
            <label style = {{marginLeft: '0.3rem' , fontSize: '0.85rem'}}>{props.label}</label>
        </div>
    )
}
