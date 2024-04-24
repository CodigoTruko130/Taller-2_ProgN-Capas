import React, { useState } from 'react';
import '../../styles/Register.css';
import axios from 'axios';

function Register() {
  const [formData, setFormData] = useState({
    username: '',
    password: '',
    email: ''
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const formData = {
      username: e.target.username.value,
      password: e.target.password.value,
      email: e.target.email.value,
    };
  
    try {
      const response = await axios.post('/api/auth/save', formData);
      console.log(response.data);
    } catch (error) {
      console.error('Error al crear:', error);
    }
  };

  return (
    <>
      <div className='login-container'>
        <div className='login'>
          <p className='titler'>Create an account to get started</p>
          <form onSubmit={handleSubmit}>
            <div className='row-register'>
              <div className='input-container'>
                <p className='subtitle'>Name</p>
                <input
                  type="text"
                  name="username"
                  id="username"
                  className='inputr'
                  placeholder='Rosita'
                  value={formData.username}
                  onChange={handleChange}
                />
              </div>
              <div className='input-container'>
                <p className='subtitle'>Email</p>
                <input
                  type="text"
                  name="email"
                  id="email"
                  className='inputr'
                  placeholder='rosita@gmail.com'
                  value={formData.email}
                  onChange={handleChange}
                />
              </div>
            </div>
            <div className='pass-div'>
              <p className='subtitle'>Password</p>
              <input
                type="password"
                name="password"
                id="password"
                className='input'
                placeholder='Rositapass'
                value={formData.password}
                onChange={handleChange}
              />
            </div>
            <center>
              <input type="submit" name='signup' className='buttonr' value="Sign up" />
            </center>
          </form>
          <div className='register-part'>
            <p className='register-text'>Already have an account?</p>
            <a href="/" className='href'>Login</a>
          </div>
        </div>
      </div>
    </>
  );
}

export default Register;