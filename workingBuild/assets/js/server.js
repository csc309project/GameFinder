// Server.js (includes all Steam API calls)
const express = require('express'),
request = require('request'),
{ steamKey, steamBaseURL, exampleProfileID } = require('./config');
var app = express(),
getAppListURL = steamBaseURL + 'ISteamApps/GetAppList/v2/?key=' + steamKey;
console.log(getAppListURL);
request(getAppListURL, { json: true }, (err, res, body) => {
    if (err) {
        return console.log(err);
    }
    console.log(body.url);
    console.log(body.explanation);
});
