import Footer from "./Footer";
import Navbar from "./Navbar";
import './Account.css'
import { useEffect, useState } from "react";
import axios from "axios";

function Account(){
    const [user,setUser]=useState({id:"",firstName:"",lastName:"",email:""});
    const getUser = () => {
        debugger;
        const uId=getUserIdFromStorage();
        axios.get(`http://localhost:8080/login/currentu/${uId}`)
            .then((response) => {
                setUser(response.data);
            })
            .catch((error) => {
                console.error('Error fetching data:', error);
            });
    };
    const getUserIdFromStorage =()=>{
        const uId=localStorage.getItem('userId');
        return uId;
};
    useEffect(() => {
     getUser();   
    });
    
    return (
        <center>
            <div className='home'>
            <Navbar/>
            <div className='about'>
            <div className='account-container'>
            <div className='account-content'>
                <h2>User Profile</h2>
                <div className='profile-details'>
                    <p><strong>First name:</strong>{user.firstName}</p>
                    <p><strong>last Name:</strong>{user.lastName}</p>
                    <p><strong>Email:</strong> {user.email}</p>
                </div>
            </div>
            <Footer/>
            </div>
        </div>
        </div>
        </center>
        
    )
}

export default Account;
