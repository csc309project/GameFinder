import React from 'react';
import ReactDOM from 'react-dom';
import { Route, Link, BrowserRouter as Router, Switch } from 'react-router-dom'
import './index.css';
import App from './App';
import LikeButton from './like_button';
import LandingPage from './landingPage';
import SearchPage from './search';
import LogInPage from './LogInPage';
import AboutUs from './AboutUs';
import * as serviceWorker from './serviceWorker';
import 'bootstrap/dist/css/bootstrap.min.css';
import SearchResultPage from "./SearchResultsPage";

const routing = (
    <Router>
        <div>
            <Route path="/" component={LandingPage} />
            <Route path="/app" component={App} />
            <Route path="/search" component={SearchPage} />
            <Route path="/login" component={LogInPage} />
            <Route path="/aboutUs" component={AboutUs} />
            <Route path="/searchResults" component={SearchResultPage} />
        </div>
    </Router>
);


/* jshint ignore:start */
ReactDOM.render(routing, document.getElementById('root'));

/* jshint ignore:end */

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
