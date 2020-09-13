import { createStore } from "redux";
import rootReducer from "../reducers/rootReducer";
import * as Constants from "../actions/constants/constants";


const store = createStore(rootReducer,window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__())

window.store = store;
window.constants = Constants;

export default store;