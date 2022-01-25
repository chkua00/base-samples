import axios from 'axios'

export class WeatherService {
    getForecast() {
        return axios.get('http://localhost:8080/weather/find-all')
            .then(res => res.data);
    }
}