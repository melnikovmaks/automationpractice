#!/bin/bash

docker pull selenoid/chrome
chmod +x selenoid_manager/cm
selenoid_manager/cm selenoid start
selenoid_manager/cm selenoid status
curl http://localhost:4444/status