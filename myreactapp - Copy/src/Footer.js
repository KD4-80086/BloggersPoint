import React from 'react'
import BlogLogo from "./images/BlogLogo.png";
import './Footer.css';
import { FaTwitter, FaInstagram, FaFacebook } from "react-icons/fa";


export function Footer() {
    return (
        <>
            <footer class="d-flex flex-wrap justify-content-center align-items-center py-1 my-2 border-top">
                <a href="/" class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
                    <img src={BlogLogo} alt="TourNest" width="60" height="60" />
                </a>
                <div class="col-md-4 d-flex align-items-center">
                    <p class="copyright">© 2021 &nbsp; BloggersPoint, &nbsp; All rights reserved.</p>
                </div>

                <div class="icons">
                    <a href="https://twitter.com/" target="_blank"><FaTwitter /></a>
                    <a href="https://www.facebook.com/" target="_blank"><FaFacebook /></a>
                    <a href="https://www.instagram.com/" target="_blank"><FaInstagram /></a>
                </div>
            </footer>
        </>
    )
}
export default Footer;