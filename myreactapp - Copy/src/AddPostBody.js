import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { useHistory } from 'react-router-dom/cjs/react-router-dom.min';


function AddPostBody() {
    const [categories, setCategories] = useState([]);
    const [blog, setBlog] = useState({userid :"",title: "", body: "", categoryId: "" });
    const history = useHistory(); // Initialize useHistory
    useEffect(() => {
        getCategory();
    }, []); 
    const getUserIdFromStorage =()=>{
            const userId=localStorage.getItem('userId');
            return userId;
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

    const onTextChange = (event, fieldName) => {
        const value = event.target.value;
        setBlog(prevState => ({
            ...prevState,
            [fieldName]: value
        }));
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        const userId = getUserIdFromStorage();
        setBlog(prevState => ({
            ...prevState,
            userid: userId
        }));
        axios.post("http://localhost:8080/blog",blog).then((response) => {
            console.log(response.data);
            history.push("/home");
        })
        .catch((error) => {
            console.error('Error fetching data:', error);
        });
    };
    
    useEffect(() => {
        console.log(blog);
    }, [blog]);

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="title" className="form-label">Blog title</label>
                    <input type="text" className="form-control" id="title" value={blog.title} onChange={(e) => onTextChange(e, 'title')} aria-describedby="title" style={{ height: '40px', width:'600px' }}/>
                </div>
                <div className="form-floating">
                    <textarea className="form-control" placeholder="Enter blog content" id="body" value={blog.body} onChange={(e) => onTextChange(e, 'body')} style={{ height: '200px', width:'600px' }}></textarea>
                    <label htmlFor="body">Enter blog content</label>
                </div>
                <br/>
                <select className="form-select" aria-label="Default select example" style={{ height: '40px', width:'600px' }} onChange={(e) => onTextChange(e, 'categoryId')}>
                    {categories.map((catItem) => (
                        <option key={catItem.id} value={catItem.id}  >{catItem.catagoryName}</option>
                    ))}
                </select>
                <br/>
                <button type="submit" className="btn btn-primary">Post</button>
            </form>
        </div>
    );
}

export default AddPostBody;
