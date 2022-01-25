##
# Format open, high, low, close data
#
def format_item(item):

    item["open"] = float(item.get("open"))
    item["high"] = float(item.get("high"))
    item["low"] = float(item.get("low"))
    item["close"] = float(item.get("close"))

    return item
