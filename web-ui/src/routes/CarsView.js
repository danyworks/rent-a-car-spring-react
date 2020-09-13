import React, { useEffect, useState } from 'react';
import Axios from "axios";
import { Table } from "react-bootstrap";


function CarsView(props) {
    const [cars, setCars] = useState([])

    useEffect(() => {
        Axios.get(`http://localhost:8085/car/get/all`)
            .then(res => setCars(cars.concat(res.data)))
        // eslint-disable-next-line
    }, []);



    console.log(cars)

    return (
        <>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Car Name</th>
                        <th>Price</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tbody>
                {cars.map(cus =><tr key={cus.id} value={cus}><td>{cus.name}</td><td>{cus.price_Per_Day}</td><td>{cus.description}</td></tr>)}
                </tbody>
            </Table>
        </>
    );
}

export default CarsView;