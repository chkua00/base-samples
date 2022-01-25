import logo from './logo.svg';
import './App.css';
import HistoricalDataTable from './component/HistoricalDataTable';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <HistoricalDataTable />
      </header>
    </div>
  );
}

export default App;
