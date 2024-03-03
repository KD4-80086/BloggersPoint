import AddPostBody from "./AddPostBody";
import Footer from "./Footer";
import Navbar from "./Navbar";

function AddPost(){
    return (
        <div className='home'>
                <Navbar/>
            <div className='Addpost'>
                <AddPostBody/>
                <Footer/>
            </div>
        </div>
    )

}
export default AddPost;