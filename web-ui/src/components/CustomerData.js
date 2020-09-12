import React, { useState, useEffect } from 'react';
import axios from "axios";
import { Form, Input, Button, Radio } from 'antd';


function CustomerData(props) {
    const [customerForm, setCustomerForm] = useState({});

    const [form] = Form.useForm();
    

    useEffect(() => {
        axios({
            method: 'post',
            url: `localhost:8085/customer/create`,
            headers: {},
            data: customerForm
        });
        // eslint-disable-next-line
    }, []);

    const handleFileChange = (event) => {
        console.log(event.target.value)
    }

    
    const onSubmit = (event) => {
        console.log(event.target.value)
    }
    return (
        <div>
            <>
                <Form
                    layout="inline"
                    form={form}
                    onValuesChange={handleFileChange}
                    onSubmitCapture={onSubmit}
                >
                    <Form.Item label="F" value="name">
                     
                    </Form.Item>
                    <Form.Item label="Field A" value="email">
                        <Input placeholder="input placeholder" />
                    </Form.Item>
                    <Form.Item label="Field B" value="password">
                        <Input placeholder="input placeholder" />
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary">Submit</Button>
                    </Form.Item>
                </Form>
            </>
        </div>

    );
}

export default CustomerData;