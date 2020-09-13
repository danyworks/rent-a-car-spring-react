import { UPDATE_CUSTOMERS } from "./constants/constants"

export default function CustomerAction(value) {
    return {
        type: UPDATE_CUSTOMERS,
        payload: value
        
    };
}
