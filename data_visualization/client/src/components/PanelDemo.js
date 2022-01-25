import React from 'react';
import { Panel } from 'primereact/panel';


export const PanelDemo = () => {
    return (
        <div className="p-grid panel-demo">
            <div className="p-col-12">
                <div className="card">
                    <h5>Weather Forecast</h5>
                    <Panel header="2021-08-24 " toggleable>
                        <iframe width="800" height="400" src="https://data.gov.sg/dataset/weather-forecast/resource/571ef5fb-ed31-48b2-85c9-61677de42ca9/view/4c127d9a-cba6-445a-8fc1-978b565f9bf7" frameBorder="0"></iframe>
                    </Panel>
                </div>
            </div>
        </div>
    )
}
