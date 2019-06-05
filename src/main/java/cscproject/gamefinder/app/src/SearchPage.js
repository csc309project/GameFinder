import React from 'react';

class SearchPage extends React.Component {

    render() {
        return (
            <div>
                <title>Game Finder - Search</title>
                <meta charSet="utf-8"/>
                <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
                <link rel="stylesheet" href="assets/css/main.css"/>
                <noscript>
                    &lt;link rel="stylesheet" href="assets/css/noscript.css" /&gt;
                </noscript>
                {/* Page Wrapper */}
                <div id="page-wrapper">
                    {/* Header */}
                    <header id="header">
                        <h1>
                            <a href="index.html">Game Finder</a>
                        </h1>
                        <nav id="nav">
                            <ul>
                                <li className="special">
                                    <a href="#menu" className="menuToggle">
                                        <span>Menu</span>
                                    </a>
                                    <div id="menu">
                                        <ul>
                                            <li>
                                                <a href="index.html">Home</a>
                                            </li>
                                            <li>
                                                <a href="about_us.html">About Us</a>
                                            </li>
                                            <li>
                                                <a href="search.html">Find Games</a>
                                            </li>
                                            <li>
                                                <a href="sign_up.html">Sign Up</a>
                                            </li>
                                            <li>
                                                <a href="log_in.html">Log In</a>
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </nav>
                    </header>
                    {/* Main */}
                    <article id="main">
                        <header>
                            <h2> Search </h2>
                            <div className="topnav">
                                <input type="text" placeholder="Search.."/>
                            </div>
                            <style
                                dangerouslySetInnerHTML={{__html: "\n            .bottom-two {\n               margin-bottom: 2cm;\n            }\n          "}}/>
                            <p className="bottom-two">
                            </p><h4>
                            <a href="search_results.html" className="button fit primary">Search</a>
                        </h4>
                            <p/>
                        </header>
                        <section className="wrapper style5">
                            {/* Comment out current nodes */}
                            <div className="row">
                                <div className="dropdown">
                                    <button className="dropbtn">Genre</button>
                                    <div className="dropdown-content">
                                        <a href="localhost:3000">Action</a>
                                        <a href="#">Adventure</a>
                                        <a href="#">Strategy</a>
                                        <a href="#">Free to Play</a>
                                        <a href="#">Sports</a>
                                        <a href="#">Racing</a>
                                        <a href="#">Multiplayer</a>
                                        <a href="#">Sci-fi</a>
                                        <a href="#">Arcade</a>
                                        <a href="#">Retro</a>
                                        <a href="#">Classic</a>
                                        <a href="#">3D Platformer</a>
                                    </div>
                                </div>
                                <div id="genre-drop-down"/>
                                <div id="rating-drop-down"/>
                                <div id="price-slider"/>
                                <div id="like_button_container"/>
                                <div className="dropdown">
                                    <button className="dropbtn">Steam Rating</button>
                                    <div className="dropdown-content">
                                        <a href="#">Overwhelmingly Positive</a>
                                        <a href="#">Positive</a>
                                        <a href="#">Mostly Positive</a>
                                        <a href="#">Mixed</a>
                                        <a href="#">Mostly Negative</a>
                                        <a href="#">Negative</a>
                                        <a href="#">Overwhelmingly Negative</a>
                                    </div>
                                </div>
                                <form className="col s12">
                                    <label htmlFor="first_name">Set Max Price</label>
                                    <input placeholder="Max Price" type="text" className="validate"/>
                                </form>
                            </div>
                        </section>
                    </article>
                    {/* Footer */}
                    <footer id="footer">
                        <ul className="icons">
                            <li>
                                <a href="https://twitter.com" className="icon fa-twitter">
                                    <span className="label">Twitter</span>
                                </a>
                            </li>
                            <li>
                                <a href="https://store.steampowered.com/" className="icon fa-steam">
                                    <span className="label">Steam</span>
                                </a>
                            </li>
                            <li>
                                <a href="https://www.instagram.com" className="icon fa-instagram">
                                    <span className="label">Instagram</span>
                                </a>
                            </li>
                        </ul>
                        <ul className="copyright">
                            <li>© Game Finder</li>
                        </ul>
                    </footer>
                </div>
                {/* Scripts */}
            </div>
        );
    }
}

export default SearchPage;