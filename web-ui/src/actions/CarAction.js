import { UPDATE_CARS } from "./constants/constants"

export default function CarAction(value) {
    return {
        type: UPDATE_CARS,
        payload: value
        
    };
}
