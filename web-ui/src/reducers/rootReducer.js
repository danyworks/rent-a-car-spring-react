import { UPDATE_CUSTOMERS,UPDATE_CARS } from "../actions/constants/constants"

const initialState = {
  customers: [],
  cars:[]
};

function rootReducer(state = initialState, action) {
  console.log("action: ",action.type," payload: ", action.payload)
  if (action.type === UPDATE_CUSTOMERS){
    return { ...state, customers: action.payload }
  }if (action.type === UPDATE_CARS){
    return { ...state, cars: action.payload }
  }

  else {
    return {...state}
  }

}

export default rootReducer;
