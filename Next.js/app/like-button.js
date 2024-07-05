'use client';
import { useState } from 'react';

export default function LikeButton() {
    const [likes, setLikes] = useState(0); /* default number of likes is 0; setLikes is for updating the state */ 

    function handleClick() {
        setLikes(likes + 1);
      }  
      return (
        <button onClick={handleClick}>Like ({likes})</button>
      )
    }