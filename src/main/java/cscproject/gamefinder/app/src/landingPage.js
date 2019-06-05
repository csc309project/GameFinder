import React from 'react';

class LandingPage extends React.Component {

    render() {
        return (
            <div>
                <title>Game Finder</title>
                <meta charSet="utf-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
                <link rel="stylesheet" href="assets/css/main.css" />
                <noscript>&lt;link rel="stylesheet" href="assets/css/noscript.css" /&gt;</noscript>
                {/* Page Wrapper */}
                <div id="page-wrapper">
                    {/* Header */}
                    <header id="header" className="alt">
                        <h1><a href="index.html">Game Finder</a></h1>
                        <nav id="nav">
                            <ul>
                                <li className="special">
                                    <a href="#menu" className="menuToggle"><span>Menu</span></a>
                                    <div id="menu">
                                        <ul>
                                            <li><a href="index.html">Home</a></li>
                                            <li><a href="about_us.html">About Us</a></li>
                                            <li><a href="search.html">Find Games</a></li>
                                            <li><a href="log_in.html">My Account</a></li>
                                            <li><a href="sign_up.html">Sign Up</a></li>
                                            <li><a href="log_in.html">Log In</a></li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </nav>
                    </header>
                    {/* Banner */}
                    <section id="banner">
                        <div className="inner">
                            <h2>Game Finder</h2>
                            <p>We look at games<br />
                                that you have enjoyed<br />
                                to find your next one</p>
                            <ul className="actions special">
                                <li><a href="search.html" className="button primary">Find Games</a></li>
                            </ul>
                        </div>
                        <a href="#one" className="more scrolly">Learn More</a>
                    </section>
                    {/* One */}
                    <section id="one" className="wrapper style1 special">
                        <div className="inner">
                            <header className="major">
                                <h2>What we do</h2>
                                <p>We go into your Steam library and we find the games that you have played.<br />
                                    We then ask you how you felt about each of them and create a customized recommendation on your next game.</p>
                            </header>
                            <ul className="icons major">
                                <li><span className="icon fa-steam major style1"><span className="label">Steam</span></span></li>
                                <li><span className="icon fa-desktop major style2"><span className="label">Desktop</span></span></li>
                                <li><span className="icon fa-twitch major style3"><span className="label">Twitch</span></span></li>
                            </ul>
                        </div>
                    </section>
                    {/* Two */}
                    <section id="two" className="wrapper alt style2">
                        <section className="spotlight">
                            <div className="image"><img src="images/steam.png" alt /></div><div className="content">
                            <h2>Use your Steam Library<br />
                                to Find Games</h2>
                            <p>We will go through your Steam library and find the games that you have played. Based on those games, we find some new games that you might enjoy.</p>
                        </div>
                        </section>
                        <section className="spotlight">
                            <div className="image"><img src="images/steam-games.png" alt /></div><div className="content">
                            <h2>Search for New Games</h2>
                            <p>You give us the search fields, we find new games.</p>
                        </div>
                        </section>
                    </section>
                    {/* CTA */}
                    <section id="cta" className="wrapper style4">
                        <div className="inner">
                            <header>
                                <h2>Like what you found?</h2>
                                <p>Hit the Sign Up button to get started on the path to playing more games. <br/>If you want to know more about us, hit the About Us button.</p>
                        </header>
                        <ul className="actions stacked">
                            <li><a href="sign_up.html" className="button fit primary">Sign Up</a></li>
                            <li><a href="about_us.html" className="button fit">More About Us</a></li>
                        </ul>
                </div>
            </section>
            {/* Footer */}
                <footer id="footer">
                    <ul className="icons">
                        <li><a href="https://twitter.com" className="icon fa-twitter"><span className="label">Twitter</span></a></li>
                        <li><a href="https://store.steampowered.com/" className="icon fa-steam"><span className="label">Steam</span></a></li>
                        <li><a href="https://www.instagram.com" className="icon fa-instagram"><span className="label">Instagram</span></a></li>
                    </ul>
                    <ul className="copyright">
                        <li>© Game Finder</li>
                    </ul>
                </footer>
            </div>
            </div>
        );
    }
}

export default LandingPage;