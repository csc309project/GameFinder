import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

/* jshint ignore:start */
class App extends Component {
  state = {
    isLoading: true,
    games: []
  };

  async componentDidMount() {
    const response = await fetch('/api/game');
    const body = await response.json();
    this.setState({ games: body, isLoading: false });
  }

  render() {
    const {games, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div className="App-intro">
            <h2>Game List</h2>
            {games.map(game =>
              <div key={game.gid}>
                {game.name}
              </div>
            )}
          </div>
        </header>
      </div>
    );
  }
}
/* jshint ignore:end */
export default App;
