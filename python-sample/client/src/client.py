#!/usr/bin/env python

##
# A simple websocket client that receive market data
#
import socketio
from lib.file_utils import convert_to_dict
from lib.data_handler import format_item


sio = socketio.Client()


@sio.event
def connect():
    print("connected to websocket server")
    # request for historical data after connection established.
    sio.emit("historical", {})


@sio.event
def disconnect():
    print("disconnected from websocket server")


##
# Handle historical batch data
#
@sio.on("historical")
def on_message(data):
    items = convert_to_dict(data.get("data"))
    for item in items:
        item = format_item(item)
        print(
            "{} {:.2f} {:.2f} {:.2f} {:.2f} {}".format(
                item.get("time"),
                item.get("open"),
                item.get("high"),
                item.get("low"),
                item.get("close"),
                item.get("volume"),
            )
        )

    # request for live data after finish processing historical data.
    sio.emit("live", {})


##
# Handle live stream data
#
@sio.on("live")
def on_message(item):
    item = format_item(item)
    print(
        "{} {:.2f} {:.2f} {:.2f} {:.2f} {}".format(
            item.get("time"),
            item.get("open"),
            item.get("high"),
            item.get("low"),
            item.get("close"),
            item.get("volume"),
        )
    )


sio.connect("http://localhost:5000")
sio.wait()
