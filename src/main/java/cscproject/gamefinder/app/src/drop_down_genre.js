'use strict';

<Dropdown>
  <Dropdown.Toggle variant="success" id="dropdown-basic">
    Dropdown Button
  </Dropdown.Toggle>

  <Dropdown.Menu>
    <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
    <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
    <Dropdown.Item href="#/action-3">Something else</Dropdown.Item>
  </Dropdown.Menu>
</Dropdown>

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
      'div',
        'button', { onClick: () => {this.showMenu}
        
        {
          this.state.showMenu(
               'div', {className="menu"},
               'button': Action, { onClick: () => {fetch("/api/games");},
               'button': Adventure, { onClick: () => {fetch("/api/games");},
               'button': Strategy { onClick: () => {fetch("/api/games");},
               'button': Free, { onClick: () => {fetch("/api/games");},
               'button': Sports, { onClick: () => {fetch("/api/games");},
               'button': Racing, { onClick: () => {fetch("/api/games");},
               'button': Multiplayer, { onClick: () => {fetch("/api/games");},
               'button': Sci-fi, { onClick: () => {fetch("/api/games");},
               'button': Arcade, { onClick: () => {fetch("/api/games");},
               'button': Retro, { onClick: () => {fetch("/api/games");},
               'button': Classic, { onClick: () => {fetch("/api/games");},
               'button': ThreeDim, { onClick: () => {fetch("/api/games");}
            )
            : (
                'button',
                { onClick: () => fetch('/api/game') }
            )
        }
    );
  }
}

const domContainer = document.querySelector('#genre-drop-down');
ReactDOM.render(e(Card), domContainer);