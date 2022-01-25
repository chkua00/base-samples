import React from 'react';
import axios from 'axios';

export default class HistoricalDataTable extends React.Component {

  state = {
    items: []
  }

  componentDidMount() {
    axios.get('http://localhost:8080/historical')
      .then(res => {
        console.log(res);
        const items = res.data;
        console.log(items);
        this.setState({ items });
      })
  }

  render() {
    return (
      <ul>
        {this.state.persons.map(item => <li>{item}</li>)}
      </ul>
    )
  }
}