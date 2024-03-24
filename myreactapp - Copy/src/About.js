import Footer from "./Footer";
import Navbar from "./Navbar";
import './About.css';

function About(){
    return (
        <div className='home'>
            <Navbar/>
            <br></br>
            <div className='about'>
                <center><h2>About us</h2></center>
                <p>
                Welcome to our student project bloggerspoint page!
                We are a group of passionate students dedicated to learning and applying 
                our skills in creating, managing and sharing your content effortlessly. 
                </p>
                <p>
                Our journey began with a simple idea:
 	            To provide individuals and businesses with the tools they need to bring their ideas to life online.
                </p>
                <p>
                    Meet the talented individuals who make up our team:
                </p>
                <ul>
                    <li><strong>Rutvik Gulhane</strong></li>
                    <li><strong>Varad somawar</strong></li>
                    <li><strong>Jagdish chavan</strong></li>
                    <li><strong>Abhijeeet koturwar</strong></li>
                   
                </ul>
                <p>
                    Have questions or want to learn more about our student project? Reach out to us!
                </p>
                <p>
                    Email: bloggerspoint@gmail.com <br />
                    Phone: +91 0000000000 <br />
                    Address: [Sunbeam]
                </p>
                <br></br>
                <br></br>
                <br></br>
                <Footer/>
            </div>
        </div>
    )
}

export default About;
