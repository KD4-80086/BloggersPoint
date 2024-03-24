import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './YourBlog.css'
import ReadMore from './ReadMore';
import Navbar from './Navbar';
import Footer from './Footer';
function YourBlog() {
    const [blogs, setBlogs] = useState([]);
    const [blog, setBlog] = useState({});
    const [categories, setCategories] = useState([]);

    
    useEffect(() => {
        fetchRecords();
        getCategory();
    }, []);
    const getUserIdFromStorage =()=>{
        const uId=localStorage.getItem('userId');
        return uId;
};
    const getCategory = () => {
       
        axios.get("http://localhost:8080/catagory")
            .then((response) => {
                setCategories(response.data);
            })
            .catch((error) => {
                console.error('Error fetching data:', error);
            });
    };
    
    const fetchRecords = () => {
        const uId = getUserIdFromStorage();
        axios.get(`http://localhost:8080/login/user/${uId}`)
            .then((response) => {
                setBlogs(response.data);
            })
            .catch((error) => {
                console.error('Error fetching data:', error);
            });
    };

    return (
        <div className='home'>
        <Navbar/>
        <div className='Addpost'>
        <div className="hd">
            <br></br>
            <br></br>
            <div className='category'>
                <a class="nav-link"  href="/addpost">Add blog</a>
                <a class="nav-link"  href="/yourblog">Your blogs</a>
                <div className='dispcate'>{
                categories.map((catItem) => (
                    <ul>
                        <li>{catItem.catagoryName}</li>
                    </ul>
                    ))}
                </div>
            </div>
            <div className="main row row-cols-1 row-cols-md-3 g-4">
                {
                blogs.map((blogItem, index) => (
                    <div className="col" key={index}>
                    <div className="card" id={blogItem.id} >
                        <div className="card-body">
                            <h5 className="card-title">{blogItem.title}</h5>
                            <p className="card-text">
                                <ReadMore text={blogItem.body}/></p>
                        </div>
                    </div>
                </div>
                ))}
            </div>
        </div>
        <Footer/>
            </div>
        </div>
    );
}

export default YourBlog;