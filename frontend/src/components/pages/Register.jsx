import React from 'react'
import '../../styles/Register.css'

function Register() {
  return (
    <>
        <div className='login-container'>
            <div className='login'>
              <p className='titler'>Create an acount to get started</p>
              <div className='row-register'>
                <div className='input-container'>
                    <p className='subtitle'>Name</p>
                    <input type="text" name="name" id="name" className='inputr' placeholder='Rosita'/>
                </div>
                <div className='input-container'>
                    <p className='subtitle'>Email</p>
                    <input type="text" name="email" id="email" className='inputr' placeholder='rosita@gmail.com'/>
                </div>
              </div>
                    
                <div className='pass-div'>
                    <p className='subtitle'>Password</p>
                    <input type="text" name="password" id="password" className='input' placeholder='Rositapass'/>
                </div>
              <center><input type="submit" name='signup' className='buttonr' value="Sign up"/></center>

              <div className='register-part'>
                <p className='register-text'>Already have an acount ?</p> <a href="/" className='href'>Login</a>
              </div>
            </div>
        </div>
    </>
  )
}

export default Register