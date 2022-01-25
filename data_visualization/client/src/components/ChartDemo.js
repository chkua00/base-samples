import React, { useState, useEffect } from 'react';
import { Chart } from 'primereact/chart';
import { WeatherService } from '../service/WeatherService';

export const ChartDemo = () => {

    const [items, setItems] = useState(null);

    useEffect(() => {
        const weatherService = new WeatherService();
        weatherService.getForecast().then(data => {
            console.log(data);
            let x = [];
            let y = [];
            for (let item of data) {
                x.push(item.latitude);
                y.push(item.longitude);
            }
            const lineData = {
                labels: x,
                datasets: [
                    {
                        label: 'Forecast',
                        data: y,
                        fill: true,
                        backgroundColor: '#00bb7e',
                        borderColor: '#00bb7e'
                    }
                ]
            }
            setItems(lineData);
        });
    }, []);

    return (
        <div className="p-grid p-fluid">
            <div className="p-col-12">
                <div className="card">
                    <h5 className="centerText">Weather Forecast</h5>
                    <Chart type="line" data={items} />
                </div>
            </div>
        </div>
    )
}
