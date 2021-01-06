import React from "react";
import {BrowserRouter, Switch, Route} from "react-router-dom";
import Navbar from "./components/navbar/Navbar";
import Home from "./components/home/Home";
import Orders from "./components/orders/Orders";
import Footer from "./components/footer/Footer";

function Routes() {
    return (
        <BrowserRouter>
            <Navbar/>
            <Switch>
                <Route path="/orders">
                    <Orders/>
                </Route>
                <Route path="/">
                    <Home/>
                </Route>
            </Switch>
            <Footer/>
        </BrowserRouter>
    )
}

export default Routes;