import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Top from './Top';
import Middle from './Middle';
import Bottom from './Bottom';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Top />
        <Middle />
        <Bottom />
      </div>
    );
  }
}

export default App;
