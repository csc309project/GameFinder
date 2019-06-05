import React from 'react';

class LogInPage extends React.Component {

    render() {
        return (
            <div>
              {/*
                  Spectral by HTML5 UP
                  html5up.net | @ajlkn
                  Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
               */}
              <title>Game Finder - Log In</title>
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
                    <h2>Log In</h2>
                    <p>Log in to your Game Finder account so we can start finding you games.</p>
                  </header>
                  <section id="one" className="wrapper style1 special">
                    <div className="inner">
                      <header className="major">
                        <h2>
                          <div className="row">
                            <form className="col s12">
                              <div className="row">
                                <div className="input-field col s12">
                                  <input placeholder="email" id="user_email" type="email" className="validate" />
                                  <label htmlFor="user_email">Email</label>
                                </div>
                                <div className="input-field col s12">
                                  <input placeholder="password" id="user_password" type="password" className="validate" />
                                  <label htmlFor>Password</label>
                                </div>
                              </div>
                            </form>
                          </div>
                          <ul className="actions special">
                            <li>
                              <a href="index.html" className="button primary">Log In</a>
                            </li>
                          </ul>
                        </h2>
                        <p>Or log in directly through your Steam account.</p>
                      </header>
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

export default LogInPage;