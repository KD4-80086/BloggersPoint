import React from "react";
import TourNestImage from "./images/BlogLogo.png";
import './Navbar.css';

function Navbar() {
    return (
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src={TourNestImage} alt="TourNest" width="85" height="85" />
                </a>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/about">About Us</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/account">Account</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link"  href="/login">Logout</a>
                        </li>
                    </ul>
                </div>
                <ul className="nav justify-content-end">
                    <li className="nav-item">
                        <a className="nav-link active" href="/login">Login</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="/register">Register</a>
                    </li>
                </ul>
            </div>
        </nav>
    );
}

export default Navbar;

