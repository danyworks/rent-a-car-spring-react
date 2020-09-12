import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import Home from "./routes/Home";
import About from "./routes/About";



export default function App() {
  return (
    <Router>
      <div>
        <nav>
          <ul style={{listStyleType:"none",textAlign:"center"}}>
            <li style={{display:"inline-block",marginRight:"5vw"}}>
              <Link to="/" style={{textDecoration:"none",color:"white",fontSize:"x-large"}}>Home</Link>
            </li>
            <li style={{display:"inline-block",marginLeft:"5vw"}}>
              <Link to="/about" style={{textDecoration:"none",color:"white",fontSize:"x-large"}}>About</Link>
            </li>
          </ul>
        </nav>

        {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
        <Switch>
          <Route path="/about">
            <About />
          </Route>
          
          <Route path="/">
            <Home />
          </Route>
        </Switch>
      </div>
    </Router>
  );
}