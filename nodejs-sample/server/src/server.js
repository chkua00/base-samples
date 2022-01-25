const express = require('express');
const cors = require('cors');
const app = express();

const hostname = '127.0.0.1';
const port = 8080;

const corsOptions = {
  origin: 'http://localhost:3000',
  optionsSuccessStatus: 200
}

const fs = require('fs');
const csv = require('csvtojson');

const histFilePath = 'data/ES_1min_historical.csv';
const liveFilePath = 'data/ES_1min_live.csv';

app.use(cors(corsOptions));

app.get('/', (req, res) => {
  res.send('Hello world');
});

app.get('/historical', (req, res) => {
  csv()
  .fromFile(histFilePath)
  .then(data => {
    res.json(data);
  });
});

app.get('/live', (req, res) => {
  csv()
  .fromFile(liveFilePath)
  .then(data => {
    res.json(data);
  });
});

const server = app.listen(port, () => {
  const hostname = server.address().address;
  console.log(`Server running at http://${hostname}:${port}/`);
});
