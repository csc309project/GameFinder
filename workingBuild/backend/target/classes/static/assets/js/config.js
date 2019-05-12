// config.js
const dotenv = require('dotenv');
dotenv.config();
module.exports = {
    steamKey: process.env.STEAM_API_KEY,
    steamBaseURL: process.env.STEAM_BASE_URL,
    exampleProfileID: process.env.ETHANS_STEAM_PROFILE_ID
};
