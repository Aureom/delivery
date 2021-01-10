import axios from "axios";
import {OrderPayLoad} from "./components/orders/types";

const API_URL = process.env["REACT_APP_API_URL"]
const mapboxToken = process.env["REACT_APP_ACCESS_TOKEN_MAPBOX"]

export function fetchProducts() {
    return axios(`${API_URL}/products`)
}

export function fetchLocalMapBox(local: String) {
    return axios(`https://api.mapbox.com/geocoding/v5/mapbox.places/${local}.json?access_token=${mapboxToken}`)
}

export function saveOrder(payLoad: OrderPayLoad) {
    return axios.post(`${API_URL}/orders`, payLoad)
}