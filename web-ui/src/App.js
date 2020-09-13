import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import Home from "./routes/Home";
import About from "./routes/About";
import CarsView from "./routes/CarsView";
import EmployeeView from "./routes/EmployeeView";
import CustomerView from "./routes/CustomerView";


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
              <Link to="/employees" style={{textDecoration:"none",color:"white",fontSize:"x-large"}}>Employees View</Link>
            </li>
            <li style={{display:"inline-block",marginLeft:"5vw"}}>
              <Link to="/customers" style={{textDecoration:"none",color:"white",fontSize:"x-large"}}>Customers View</Link>
            </li>
            <li style={{display:"inline-block",marginLeft:"5vw"}}>
              <Link to="/cars" style={{textDecoration:"none",color:"white",fontSize:"x-large"}}>Cars View</Link>
            </li>
            <li style={{display:"inline-block",marginLeft:"5vw"}}>
              <Link to="/about" style={{textDecoration:"none",color:"white",fontSize:"x-large"}}>About</Link>
            </li>
          </ul>
        </nav>

        {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
        <Switch>
          
        <Route path="/cars">
            <CarsView/>
          </Route>
          <Route path="/customers">
            <CustomerView />
          </Route>
          <Route path="/employees">
            <EmployeeView />
          </Route>
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