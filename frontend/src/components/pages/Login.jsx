import React from 'react'
import '../../styles/Login.css'

function Login() {
  return (
    <>
        <div className='login-container'>
            <div className='login'>
              <p className='title'>Welcome back, Login.</p>
              <div>
                <p className='subtitle'>Email</p>
                <input type="text" name="email" id="email" className='input' placeholder='rosita@gmail.com'/>
              </div>
              <div>
                <p className='subtitle'>Password</p>
                <input type="text" name="password" id="password" className='input' placeholder='rositaPass'/>
              </div>

              <center><input type="submit" name='submit' className='button' value="Login"/></center>

              <div className='register-part'>
                <p className='register-text'>Don't have an acount?</p> <a href="/Register" className='href'>Sign up</a>
              </div>
            </div>
        </div>
    </>
  )
}

export default Login