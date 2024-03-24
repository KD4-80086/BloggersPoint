import React from 'react';
import { Route, Switch, Redirect } from 'react-router-dom';
import Login from './Login';
import Home from './Home'; // Import the Home component correctly
import Register from './Register';
import ChangePass from './ChangePass';
import AddPost from './AddPost';
import About from './About';
import Account from './Account';
import YourBlog from './YourBlog';

function App() {
  return (
    <div>
      <Switch>
        <Route exact path="/" component={Home} />
        <Route exact path="/home" component={Home} />
        <Route exact path="/login" component={Login} />
        <Route exact path="/register" component={Register} />
        <Route exact path="/changepass" component={ChangePass} />
        <Route exact path="/addpost" component={AddPost}/>
        <Route exact path="/about" component={About}/>
        <Route exact path="/account" component={Account}/>
        <Route exact path="/yourblog" component={YourBlog}/>
        <Redirect to="/" />
      </Switch>
    </div>
  );
}

export default App;
