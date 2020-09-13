import React, { useState } from 'react';
import axios from "axios";

function EmployeeView(props) {
    
    
    
    const [firstname , setFirstName] = useState('');
    const [lastname , setLastName] = useState('');
    const [email , setEmail] = useState('');
    const [password , setPassword] = useState('');
    const [phone , setPhone] = useState('');
    const [address, setAddress] = useState('');
    
    
    const [carname , setCarName] = useState('');
    const [carprice , setCarPrice] = useState('');
    const [description , setDescription] = useState('');


    const handleSubmit = async () => {
        let res = await axios({
            method: 'post',
            url: 'http://localhost:8085/customer/create',
            headers: {}, 
            data: {
                first_Name: firstname,
                last_Name: lastname,
                email: email,
                address: address,
                password: password,
                phone_Number: phone
            }
          }).then(res=> alert(res)).catch(e=>console.log(e));
    
        console.log(`Status code: ${res.status}`);
        console.log(`Status text: ${res.statusText}`);
        console.log(`Request method: ${res.request.method}`);
        console.log(`Path: ${res.request.path}`);
        console.log(`Date: ${res.headers.date}`);
        console.log(`Data: ${res.data}`);
    }

    const handleFirstNameChange = (e) => {
        setFirstName(e.target.value)
    }
    const handleLastNameChange = (e) => {
        setLastName(e.target.value)
    }
    const handleEmailChange = (e) => {
        setEmail(e.target.value)
    }
    const handlePasswordChange = (e) => {
        setPassword(e.target.value)
    }
    const handleAddressChange = (e) => {
        setAddress(e.target.value)
    }
    const handlePhoneChange = (e) => {
        setPhone(e.target.value)
    }

    const handleCarSubmit = async () => {
        let res = await axios({
            method: 'post',
            url: 'http://localhost:8085/car/create',
            headers: {}, 
            data: {
                name: carname,
                price_Per_Day: carprice,
                description: description,
            }
          }).then(res=> alert(res)).catch(e=>console.log(e));
    
        console.log(`Status code: ${res.status}`);
        console.log(`Status text: ${res.statusText}`);
        console.log(`Request method: ${res.request.method}`);
        console.log(`Path: ${res.request.path}`);
        console.log(`Date: ${res.headers.date}`);
        console.log(`Data: ${res.data}`);
    }
    const handleCarNameChange = (e) => {
        setCarName(e.target.value)
    } 
    const handleCarPriceChange = (e) => {
        setCarPrice(e.target.value)
    } 
    const handledescriptionChange = (e) => {
        setDescription(e.target.value)
    }
    return (
        <div>
            <h1>Create a Customer</h1>
            <form id="contact-form" onSubmit={handleSubmit} >
                        <div className="form-group">
                            <label htmlFor="name">First Name</label>
                            <input value={firstname}  onChange={e=>handleFirstNameChange(e)} type="text" className="form-control" />
                        </div>
                        <div className="form-group">
                            <label htmlFor="subject">Last Name</label>
                            <input value={lastname} onChange={e=>handleLastNameChange(e)}   type="text" className="form-control" />
                        </div>
                        <div className="form-group">
                            <label htmlFor="exampleInputEmail1">Email address</label>
                            <input value={email} onChange={e=>handleEmailChange(e)}  type="email" className="form-control" aria-describedby="emailHelp" />
                        </div>
                        
                        <div className="form-group">
                            <label htmlFor="exampleInputEmail1">Password </label>
                            <input value={password} onChange={e=>handlePasswordChange(e)}  type="password" className="form-control" aria-describedby="emailHelp" />
                        </div>
                        <div className="form-group">
                            <label htmlFor="exampleInputEmail1">Phone Number</label>
                            <input value={phone} onChange={e=>handlePhoneChange(e)}  type="number" className="form-control" aria-describedby="emailHelp" />
                        </div>
                        <div className="form-group">
                            <label htmlFor="exampleInputEmail1">Address</label>
                            <input value={address} onChange={e=>handleAddressChange(e)}  type="text" className="form-control" aria-describedby="emailHelp" />
                        </div>
                        <button type="submit" className="btn btn-primary">Submit</button>
                    </form>
                    <h1>Create a Car</h1>
            <form id="contact-form" onSubmit={handleCarSubmit} >
                        <div className="form-group">
                            <label htmlFor="name">Car Name</label>
                            <input value={carname}  onChange={e=>handleCarNameChange(e)} type="text" className="form-control" />
                        </div>
                        <div className="form-group">
                            <label htmlFor="subject">Price Per Day</label>
                            <input value={carprice} onChange={e=>handleCarPriceChange(e)}   type="text" className="form-control" />
                        </div>
                        <div className="form-group">
                            <label htmlFor="subject">Description</label>
                            <input value={description} onChange={e=>handledescriptionChange(e)}   type="text" className="form-control" />
                        </div>
           
                        <button type="submit" className="btn btn-primary">Submit</button>
                    </form>
        </div>
    );
}

export default EmployeeView;