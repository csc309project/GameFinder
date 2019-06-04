import React, { Component } from 'react';
import ReactDOM from 'react-dom';

class Rating extends Component {
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
    return (
      <div>
        <button onClick={this.showMenu}>
          Show menu
        </button>
        
        {
          this.state.showMenu
            ? (
              <div className="menu">
                <button> Overwhelmingly Postitve </button>
                <button> Postive </button>
                <button> Mostly Postive </button>
                <button> Miexed </button>
                <button> Mostly Negative </button>
                <button> Negative </button>
                <button> Overwhelmingly Negative </button>
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

const domContainer = document.querySelector('#rating-drop-down');
ReactDOM.render((Rating), domContainer);