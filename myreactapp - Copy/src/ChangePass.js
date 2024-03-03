import React from 'react';
import { useEffect, useState } from "react";
import { Link, useHistory } from "react-router-dom";
import axios from "axios";
import "./ChangePass.css"
import Navbar from './Navbar';
import Footer from './Footer';

function ChangePass() {
    const history = useHistory(); // Initialize useHistory
    const [user, setUser] = useState({ email: "", password: "" });
    const [message, setMessage] = useState("");
    const url = "http://localhost:8080/login/changepassword";

    const onTextChange = (args) => {
        var usr1 = { ...user };
        usr1[args.target.name] = args.target.value;
        setUser(usr1);
    }

    const showMessage = (msgText) => {
        setMessage(msgText);
        window.setTimeout(() => {
            setMessage("");
        }, 3000);
    }

    const resetPass = () => {
        debugger;
        axios.put("http://localhost:8080/login/changepassword", user).then((result) => {
            if (result.data != null) {
                showMessage("Password Changed!!");
                history.push("/login");
            }
        })
            .catch(error => {
                console.error("Axios request failed", error);
                // You can log the error details or handle it appropriately
            });
    }



    return (
        <>
            <Navbar />
            <div className="outcontainer">
                <div className="container">
                    <div className="form">
                        <h2>Change Password</h2>
                        <div className="box1">
                            <input type="email" name="email" placeholder='Email' value={user.email} onChange={onTextChange}></input>

                            <input type="password" name="password" placeholder='New Password' value={user.password} onChange={onTextChange}></input>
                            <div className="box2">
                                <input className="btn" type="submit" onClick={resetPass} value="Reset"></input>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <Footer />
        </>
    );
}

export default ChangePass;
