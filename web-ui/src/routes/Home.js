import React from 'react';
import CustomerData from "../components/CustomerData";

function Home(props) {
    return (
        <div>
            <h1 style={{textAlign:"center"}}>Home</h1>
            <CustomerData/>
        </div>
    );
}

export default Home;