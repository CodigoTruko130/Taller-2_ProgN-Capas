import React from 'react';
import '../../styles/Profile.css';

const Profile = ({ username, email }) => {
  return (
    <div className="profile-container">
      <div className="profile-info">
        <h2 className="profile-title">Perfil</h2>
        <div className="profile-details">
          <div className="profile-detail">
            <span className="detail-label">Nombre de usuario:</span>
            <span className="detail-value">{username}</span>
          </div>
          <div className="profile-detail">
            <span className="detail-label">Correo electrónico:</span>
            <span className="detail-value">{email}</span>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Profile;