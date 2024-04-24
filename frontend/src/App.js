import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import './App.css';
import Login from './components/pages/Login';
import Register from './components/pages/Register'
import Profile from './components/pages/Profile'

function App() {
  return (
    <>
    <Router>
      <Routes>
        <Route path='/'element={<Login/>} ></Route>
        <Route path='/Register'element={<Register/>} ></Route>
        <Route path='/Profile'element={<Profile/>} ></Route>
      </Routes>
    </Router>
    </>
  );
}

export default App;
