#!/usr/bin/env python

##
# A simple websocket server that broadcast market data
#
import eventlet
import socketio
import time
from lib.file_utils import read_csv_file, convert_to_json


##
# Create a Socket.IO server
#
sio = socketio.Server()
app = socketio.WSGIApp(sio)


##
# Handle connect event
#
@sio.event
def connect(sid, environ):
    print("[connect] ", sid)


##
# Handle disconnect event
#
@sio.event
def disconnect(sid):
    print("[disconnect] ", sid)


##
# Handle historical data request
#
@sio.on("historical")
def on_message(sid, data):

    print("[data] received historical data request")

    file = "./data/ES_1min_historical.csv"
    rows = read_csv_file(file)
    data = convert_to_json(rows)

    # send historical data in batch
    sio.emit("historical", {"data": data})


##
# Handle live data request
#
@sio.on("live")
def on_message(sid, data):

    print("[data] received live data request")

    file = "./data/ES_1min_live.csv"
    rows = read_csv_file(file)

    # send live data in stream
    for row in rows:
        sio.emit("live", row)
        sio.sleep(2)


if __name__ == "__main__":
    eventlet.wsgi.server(eventlet.listen(("", 5000)), app)
