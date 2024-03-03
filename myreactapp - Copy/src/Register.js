import { useEffect, useState } from "react";
import axios from "axios";
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { useHistory } from "react-router-dom/cjs/react-router-dom.min";
import "./Register.css"
import Navbar from "./Navbar";
import Footer from "./Footer";


function Register() {
    const history = useHistory();
    const [user, setUser] = useState({ firstName: "", lastName: "", email: "", password: "" })
    const [message, setMessage] = useState("");
    const url = "http://localhost:8080/login/register";

    const OnTextChange = (args) => {
        var user1 = { ...user }
        user1[args.target.name] = args.target.value;
        setUser(user1);
    }
    const showMessage = (msgText) => {
        setMessage(msgText);
        window.setTimeout(() => {
            setMessage("");
        }, 3000);
    }
    const AddUser = () => {
        axios.post(url, user)
            .then((result) => {
                if (result.data != null) {
                    console.log(result);
                    showMessage("Registered Successfully!!");
                    history.push("/login");
                }
            })
            .catch((error) => {
                console.error('Error adding user:', error);
                if (error.response) {

                    console.error('Response data:', error.response.data);
                    console.error('Response status:', error.response.status);
                    console.error('Response headers:', error.response.headers);
                } else if (error.request) {
                    console.error('No response received. Request:', error.request);
                } else {
                    console.error('Error setting up the request:', error.message);
                }
                showMessage("Error registering user. Please try again.");
            });
    };


    // const ClearBoxes = ()=>{
    //     setUser({ name: "", emailId: "", phoneNo: "", password: "" });
    // }

    return (
        <>
            <Navbar />
            <div className="outcontainer">
                <div className="container">
                    <div className="form">
                        <h2>Register</h2>
                        <div className="box1">

                            <input name="firstName" placeholder="First Name" value={user.firstName} onChange={OnTextChange} />

                            <input name="lastName" placeholder="Last Name" value={user.lastName} onChange={OnTextChange} />

                            <input name="email" placeholder="Email Id" value={user.email} onChange={OnTextChange} />

                            <input name="password" placeholder="Password" value={user.password} onChange={OnTextChange} />
                            <div className="box2">
                                <button className="btn btn-success" onClick={AddUser}>Add User</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <Footer />
        </>
    )
}

export default Register;