import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import './App.css';
import Login from './components/pages/Login';
import Register from './components/pages/Register'

function App() {
  return (
    <>
    <Router>
      <Routes>
        <Route path='/'element={<Login/>} ></Route>
      </Routes>
    </Router>
    </>
  );
}

export default App;