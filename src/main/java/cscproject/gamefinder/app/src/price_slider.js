import React from "react";
import Slider from "react-slick";
import ReactDOM from 'react-dom';

class PriceSlider extends React.Component {
  render() {
    var settings = {
      dots: true,
      infinite: true,
      speed: 500,
      slidesToShow: 1,
      slidesToScroll: 1
    };
    return (
      <Slider {...settings}>
        <div>
          <h3>$</h3>
        </div>
        <div>
          <h3>$$</h3>
        </div>
        <div>
          <h3>$$$</h3>
        </div>
        <div>
          <h3>$$$$</h3>
        </div>
      </Slider>

    (
        'button',
        { onClick: () => fetch('/api/game') }
    )
    );
    
  }
}

const domContainer = document.querySelector('#price-slider');
ReactDOM.render((PriceSlider), domContainer);