import React, { Component } from 'react';
import ReactDOM from 'react-dom';

class Card extends Component {
  constructor() {
    super();
    
    this.state = {
      showMenu: false,
    }
    
    this.showMenu = this.showMenu.bind(this);
  }
  
  showMenu(event) {
    event.preventDefault();
    
    this.setState({
      showMenu: true,
    });
  }

  render() {
    return e(
      <div>
        <button onClick={this.showMenu}>
          Show menu
        </button>
        
        {
          this.state.showMenu
            ? (
              <div className="menu">
                <button> Action </button>
                <button> Adventure </button>
                <button> Strategy </button>
                <button> Free to play </button>
                <button> Sports </button>
                <button> Racing </button>
                <button> Multiplayer </button>
                <button> Sci-fi </button>
                <button> Arcade </button>
                <button> Retro </button>
                <button> Classic </button>
                <button> 3D Platformer </button>
              </div>
            )
            : (
                'button',
                { onClick: () => fetch('/api/game') }
            )
        }
      </div>
    );
  }
}

const domContainer = document.querySelector('#genre-drop-down');
ReactDOM.render(e(Card), domContainer);