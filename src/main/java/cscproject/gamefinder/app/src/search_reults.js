import React from 'react';

class SearchResultPage extends React.Component {

    render() {
        return (
            <div>
              <title>Game Finder - Results</title>
              <meta charSet="utf-8" />
              <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
              <link rel="stylesheet" href="assets/css/main.css" />
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
                    <h2>Results</h2>
                    <p>Here's what we recommend that you play next. Hope you enjoy.</p>
                  </header>
                  <section className="wrapper style5">
                    <div className="inner">
                      <h4>
                        <a href="search.html"> &lt; Back to search</a>
                      </h4>
                      <table style={{width: '100%'}}>
                        <tbody><tr align="center">
                            <td>
                              <a href="single_game.html">RocketLeague</a>
                            </td>
                            <td>Play soccer with cars.</td> 
                            <td>
                              <img style={{height: '100px'}} src="images/rocket_league.jpg" alt="RocketLeague" />
                            </td>
                          </tr>
                          <tr align="center">
                            <td>
                              <a href="single_game.html">Grand Theft Auto</a>
                            </td>
                            <td>Steal Cars and Break the Law.</td> 
                            <td>
                              <img style={{height: '100px'}} src="images/gta.jpg" alt="GTA" />
                            </td>
                          </tr>
                          <tr align="center">
                            <td>
                              <a href="single_game.html">Formula 1</a>
                            </td>
                            <td>Race fast cars through beautiful landscapes.</td> 
                            <td>
                              <img style={{height: '100px'}} src="images/f1.jpg" alt="GTA" />
                            </td>
                          </tr>
                        </tbody></table>
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

export default SearchResultPage;