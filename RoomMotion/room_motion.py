from __future__ import division
from blink1.blink1 import blink1
from blink1.blink1 import Blink1
from bluezero import tools
from bluezero import constants
from bluezero import adapter
from bluezero import advertisement
import picamera
import time
import requests
import json
import subprocess
import threading
import numpy as np

RUN_SECS = 45
STAY_RED_SECS = 10

def send_to_server(jdata):
    """
    Sends JSON to server to update a Room
    """
    resp = json.loads(jdata)
    url = 'http://localhost:8000/rooms/' + str(resp['id']) + '/'
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    print('Sending Updated Room:', jdata)
    try:
        req = requests.put(url, jdata, headers=headers)
        print('Recieved server response:', req.status_code, req.json(), '\n\n')
    except requests.exceptions.RequestException:
        print('\nERROR: Please Run the django server\n')

def create_room_json(nid, name, zone, avail, capacity):
    """
    Creates JSON Room Object
    """
    data = {}
    data['id'] = nid
    data['name'] = name
    data['zone'] = zone
    data['avail'] = avail
    data['capacity'] = capacity
    return json.dumps(data)

def start_advertise_bluetooth(url):
    print('Starting Bluetooth')
    subprocess.Popen(['/usr/local/bin/PyBeacon', '-u', 'https://ngrogan.com'])

def stop_advertise_bluetooth():
    print('Stopping Bluetooth')
    subprocess.Popen(['/usr/local/bin/PyBeacon', '-t'])

def motion_activated():
    """
    Called when motion is detected
    """
    print('\n===============\nMotion detected!\n===============\n')
    b1.fade_to_color(100, 'red')
    room_json = create_room_json(1, 'Lars Magnus', '1', True, 40)
    # Send to Server
    send_to_server(room_json)
    # Activate Bluetooth
    start_advertise_bluetooth('https://ngrogan.com')
    time.sleep(STAY_RED_SECS)
    stop_advertise_bluetooth()
    b1.fade_to_color(100, 'green')


class MyMotionDetector(object):

    motion_dtype = np.dtype([
        ('x', 'i1'),
        ('y', 'i1'),
        ('sad', 'u2'),
    ])

    def __init__(self, camera):
        width, height = camera.resolution
        self.cols = (width + 15) // 16
        self.cols += 1 # there's always an extra column
        self.rows = (height + 15) // 16

    def write(self, s):
        # Load the motion data from the string to a numpy array
        data = np.fromstring(s, dtype=self.motion_dtype)
        # Re-shape it and calculate the magnitude of each vector
        data = data.reshape((self.rows, self.cols))
        data = np.sqrt(
            np.square(data['x'].astype(np.float)) +
            np.square(data['y'].astype(np.float))
            ).clip(0, 255).astype(np.uint8)
        # If there're more than 10 vectors with a magnitude greater
        # than 60, then say we've detected motion
        if (data > 60).sum() > 10:
            motion_activated()
            return len(s)


with picamera.PiCamera() as camera:
    b1 = Blink1()
    b1.fade_to_color(100, 'green')
    camera.resolution = (640, 480)
    camera.framerate = 30
    camera.start_recording(
        # Throw away the video data, but make sure we're using H.264
        '/dev/null', format='h264',
        # Record motion data to our custom output object
        motion_output=MyMotionDetector(camera)
        )
    camera.wait_recording(RUN_SECS)
    camera.stop_recording()
