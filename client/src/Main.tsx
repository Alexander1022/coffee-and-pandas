import { Routes, Route } from 'react-router-dom';
import './index.css';
import Home from './components/Home';
import SignUp from './components/SignUp';
import SignIn from './components/SignIn';
import TOS from './components/TOS';
import Map from './components/Map';
import { AddEventPage } from './components/AddEventPage';
import { PrivateRoute } from './components/PrivateRoute';

const Main = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path='/signup' element={<SignUp />} />
      <Route path='/signin' element={<SignIn />} />
      <Route path='/tos' element={<TOS />} />
      <Route element={<PrivateRoute />}>
        <Route path="/home" element={<Home />} />
        <Route path='/map' element={<Map />} />
        <Route path='/events/add' element={<AddEventPage />} />
      </Route>
    </Routes >
  );
}

export default Main;