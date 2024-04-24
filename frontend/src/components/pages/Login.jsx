import React, { useState } from 'react';
import '../../styles/Login.css';
import axios from 'axios';

function Login() {
  const [formData, setFormData] = useState({
    username: '',
    password: '',
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/api/auth/login', formData);
      console.log(response.data);
    } catch (error) {
      console.error('Error al iniciar:', error);
    }
  };

  return (
    <>
      <div className="login-container">
        <div className="loginr">
          <p className="title">Welcome back, Login.</p>
          <form onSubmit={handleSubmit}>
            <div>
              <p className="subtitle">Username</p>
              <input
                type="text"
                name="username"
                id="username"
                className="input"
                placeholder="Username"
                value={formData.username}
                onChange={handleChange}
              />
            </div>
            <div>
              <p className="subtitle">Password</p>
              <input
                type="password"
                name="password"
                id="password"
                className="input"
                placeholder="Password"
                value={formData.password}
                onChange={handleChange}
              />
            </div>
            <center>
              <input type="submit" name="submit" className="button" value="Login" />
            </center>
          </form>
          <div className="register-part">
            <p className="register-text">Don't have an account?</p>
            <a href="/Register" className="href">
              Sign up
            </a>
          </div>
        </div>
      </div>
    </>
  );
}

export default Login;