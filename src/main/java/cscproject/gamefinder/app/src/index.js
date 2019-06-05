import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import LikeButton from './like_button';
import LandingPage from './landingPage';
import * as serviceWorker from './serviceWorker';
import 'bootstrap/dist/css/bootstrap.min.css';

/* jshint ignore:start */
//ReactDOM.render(<App/>, document.getElementById('root'));
ReactDOM.render(<LikeButton/>, document.getElementById('like_button_container'));
ReactDOM.render(<LandingPage/>, document.getElementById('landingPage'));
/* jshint ignore:end */

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
