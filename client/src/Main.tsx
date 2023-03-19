import { Routes, Route } from 'react-router-dom';
import Home from './components/Home';
import SignUp from './components/SignUp';
import SignIn from './components/SignIn';
import TOS from './components/TOS';
import Map from './components/Map';
import './index.css';
import { AddEventPage } from './components/AddEventPage';

const Main = () => {
    return (         
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/home" element={<Home />} />
          <Route path='/signup' element={<SignUp/>} />
          <Route path='/signin' element={<SignIn/>} />
          <Route path='/tos' element={<TOS/>} />
          <Route path='/map' element={<Map/>} />
          <Route path='/events/add' element={<AddEventPage/>} />
      </Routes>
    );
}

export default Main;