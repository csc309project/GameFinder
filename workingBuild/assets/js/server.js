// Server.js (includes all Steam API calls)
const express = require('express'),
request = require('request'),
fs = require('fs'),
XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest,
{ steamKey, steamBaseURL, exampleProfileID } = require('./config');
var app = express(),
getAppListURL = steamBaseURL + 'ISteamApps/GetAppList/v2/?key=' + steamKey;
if (fs.existsSync('output.json')) {
    return;
}
var xhr = new XMLHttpRequest();
xhr.open('GET', getAppListURL, true);
xhr.send();
xhr.addEventListener("readystatechange", processRequest, false);
xhr.onreadystatechange = processRequest;
function processRequest(e) {
    if (xhr.readyState == 4 && xhr.status == 200) {
        var response = JSON.parse(xhr.responseText);
        response.applist.apps.sort(function(a, b) {
            return ('' + a.name.trim()).localeCompare(b.name.trim());
        });
        fs.writeFile('output.json', JSON.stringify(response, null, 4), (err) => {
            // In case of a error throw err.
            if (err) throw err;
        })
    }
    else if(xhr.readyState == 4 && xhr.status != 200) {
        console.log("HTTP request did not return with code 200");
    }
}
