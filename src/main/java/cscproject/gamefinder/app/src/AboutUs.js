import React from 'react';

class AboutUsPage extends React.Component {

    render() {
        return (
            <div>
              <title>Game Finder - About Us</title>
              <meta charSet="utf-8" />
              <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
              <link rel="stylesheet" href="assets/css/main.css" />
              <noscript>&lt;link rel="stylesheet" href="assets/css/noscript.css" /&gt;</noscript>
              {/* Page Wrapper */}
              <div id="page-wrapper">
                {/* Header */}
                <header id="header">
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
                            <li><a href="sign_up.html">Sign Up</a></li>
                            <li><a href="log_in.html">Log In</a></li>
                          </ul>
                        </div>
                      </li>
                    </ul>
                  </nav>
                </header>
                {/* Main */}
                <article id="main">
                  <header>
                    <h2>About Us</h2>
                    <p>We're determined to help you find the perfect game for you to play.</p>
                  </header>
                  <section className="wrapper style5">
                    <div className="inner">
                      <h3>Ethan Agranoff</h3>
                      <p>Morbi mattis mi consectetur tortor elementum, varius pellentesque velit convallis. Aenean tincidunt lectus auctor mauris maximus, ac scelerisque ipsum tempor. Duis vulputate ex et ex tincidunt, quis lacinia velit aliquet. Duis non efficitur nisi, id malesuada justo. Maecenas sagittis felis ac sagittis semper. Curabitur purus leo, tempus sed finibus eget, fringilla quis risus. Maecenas et lorem quis sem varius sagittis et a est. Maecenas iaculis iaculis sem. Donec vel dolor at arcu tincidunt bibendum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Fusce ut aliquet justo. Donec id neque ipsum. Integer eget ultricies odio. Nam vel ex a orci fringilla tincidunt. Aliquam eleifend ligula non velit accumsan cursus. Etiam ut gravida sapien.</p>
                      <p>Vestibulum ultrices risus velit, sit amet blandit massa auctor sit amet. Sed eu lectus sem. Phasellus in odio at ipsum porttitor mollis id vel diam. Praesent sit amet posuere risus, eu faucibus lectus. Vivamus ex ligula, tempus pulvinar ipsum in, auctor porta quam. Proin nec dui cursus, posuere dui eget interdum. Fusce lectus magna, sagittis at facilisis vitae, pellentesque at etiam. Quisque posuere leo quis sem commodo, vel scelerisque nisi scelerisque. Suspendisse id quam vel tortor tincidunt suscipit. Nullam auctor orci eu dolor consectetur, interdum ullamcorper ante tincidunt. Mauris felis nec felis elementum varius.</p>
                      <hr />
                      <h3>Nick Ryan</h3>
                      <p>I'm a 5th year software engineer at Cal Poly who--shockingly--loves to play games. I love playing Apex Legends, Rocket League, and other first person shooter games. I'm also a sucker for amazing single player games like Portal, The Talos Principle, and Legend of Zelda: Breath of the Wild. If I'm not gaming or working, I'll be either watching or playing hockey.</p>
                      <p>I also love creating games. I've already made an endless runner game called Space Run that allows you to pilot a ship through an asteroid field. I was also a part of GrappleNaut, a speed-run Spiderman-style game where the character can grapple on to space debris and fly through the air, collecting coins. I plan to continue my passion for creating games by working on a single player game in the future.</p>
                      <hr />
                      <h3>Davin Johnson</h3>
                      <p>Nam sapien ante, varius in pulvinar vitae, rhoncus id massa. Donec varius ex in mauris ornare, eget euismod urna egestas. Etiam lacinia tempor ipsum, sodales porttitor justo. Aliquam dolor quam, semper in tortor eu, volutpat efficitur quam. Fusce nec fermentum nisl. Aenean erat diam, tempus aliquet erat.</p>
                      <p>Etiam iaculis nulla ipsum, et pharetra libero rhoncus ut. Phasellus rutrum cursus veli</p>
                      <hr />
                      <h3>Jeremy Whorton</h3>
                      <p>I'm a 3rd year software engineer at Cal Poly. I generally play sports games on console, such as Fifa, NHL, and NBA 2k. I will occasionally dabble in story mode games, such as Spiderman or Red Dead Redemption. I definetly can use some reccomendations to find new games that I would like that are slightly outside of my comfort zone.</p>
                      <p>When I am not writing code, I enjoy playing sports, mainly basketball and soccer. I also enjoy spending time with friends and family.</p>
                      <hr />
                      <h3>Justin To</h3>
                      <p>Nam sapien ante, varius in pulvinar vitae, rhoncus id massa. Donec varius ex in mauris ornare, eget euismod urna egestas. Etiam lacinia tempor ipsum, sodales porttitor justo. Aliquam dolor quam, semper in tortor eu, volutpat efficitur quam. Fusce nec fermentum nisl. Aenean erat diam, tempus aliquet erat.</p>
                      <p>Etiam iaculis nulla ipsum, et pharetra libero rhoncus ut. Phasellus rutrum cursus veli</p>
                    </div>
                  </section>
                </article>
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
              {/* Scripts */}
              {/* Load React. */}
              {/* Note: when deploying, replace "development.js" with "production.min.js". */}
              {/* Load our React component. */}
            </div>
        );
    }
}

export default AboutUsPage;