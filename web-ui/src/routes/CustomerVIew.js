import React, { useEffect, useState } from 'react';
import Axios from "axios";
import { Table } from "react-bootstrap";


function CustomerView(props) {
    const [customers, setCustomers] = useState([])

    useEffect(() => {
        Axios.get(`http://localhost:8085/customer/get/all`)
            .then(res => setCustomers(customers.concat(res.data)))
        // eslint-disable-next-line
    }, []);



    console.log(customers)

    return (
        <>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th>Phone</th>
                        <th>Address</th>
                    </tr>
                </thead>
                <tbody>
    {customers.map(cus =><tr key={cus.id} value={cus}><td>{cus.first_Name}</td><td>{cus.last_Name}</td><td>{cus.email}</td><td>{cus.password}</td><td>{cus.phone_Number}</td><td>{cus.address}</td></tr>)}
                </tbody>
            </Table>
        </>
    );
}

export default CustomerView;