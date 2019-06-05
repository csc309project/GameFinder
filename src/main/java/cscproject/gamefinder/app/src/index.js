import React from 'react';
import ReactDOM from 'react-dom';
import { Route, Link, BrowserRouter as Router, Switch } from 'react-router-dom'
import './index.css';
import App from './App';
import LikeButton from './like_button';
import LandingPage from './landingPage';
import SearchPage from './search';
import * as serviceWorker from './serviceWorker';
import 'bootstrap/dist/css/bootstrap.min.css';

const routing = (
    <Router>
        <div>
            <Route path="/" component={LandingPage} />
            <Route path="/app" component={App} />
            <Route path="/search" component={SearchPage} />
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
