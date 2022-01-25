import React, { useState, useEffect } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { InputText } from 'primereact/inputtext';
import { WeatherService } from '../service/WeatherService';

export const TableDemo = () => {

    const [items, setItems] = useState(null);
    const [globalFilter, setGlobalFilter] = useState('');
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const weatherService = new WeatherService();
        weatherService.getForecast().then(data => { setItems(data); setLoading(false) });
    }, []);

    const tableHeader = (
        <div className="table-header">
            Weather Forecast
            <span className="p-input-icon-left">
                <i className="pi pi-search" />
                <InputText value={globalFilter} onChange={(e) => setGlobalFilter(e.target.value)} placeholder="Search" />
            </span>
        </div>
    );

    const bodyTemplate = (data, props) => {
        return (
            <>
                <span className="p-column-title">{props.header}</span>
                {data[props.field]}
            </>
        );
    };

    return (
        <div className="p-grid table-demo">
            <div className="p-col-12">
                <div className="card">
                    <DataTable value={items} scrollable scrollHeight="600px" className="p-datatable-gridlines p-datatable-striped p-datatable-sm p-datatable-customers" dataKey="id" rowHover
                        globalFilter={globalFilter} emptyMessage="No data found." loading={loading} header={tableHeader}>
                        <Column field="area" header="Area" sortable body={bodyTemplate}></Column>
                        <Column field="latitude" header="Latitude" sortable body={bodyTemplate}></Column>
                        <Column field="longitude" header="Longitude" sortable body={bodyTemplate}></Column>
                        <Column field="time" header="Time" sortable body={bodyTemplate}></Column>
                        <Column field="forecast" header="Forecast" sortable body={bodyTemplate}></Column>
                    </DataTable>
                </div>
            </div>
        </div>
    )
}
