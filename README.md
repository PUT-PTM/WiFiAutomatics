# WiFiAutomatics

<h2>Overview:</h2>
Presented project is an attempt to implement simple home automation.
It has capability of control two relays by android app within local WIFI connection or via Internet.

<h2>Description:</h2>
The base of my project is microcontroller STM32F407VG DISCOVERY and ESP8266 WIFI module.


<h2>Tools:</h2>

- Android Studio 2.3.3
- CoIDE 1.7.8

<h2>How to run:</h2>

<b>Connections:</b>
Relay IN1 -> STM32 PD12
Relay IN2 -> STM32 PD13
Relay VCC -> STM32 5V
Relay GND -> STM32 GND

ESP8266 Rx -> STM32 PC10
ESP8266 Tx -> STM32 PC11
ESP8266 CH_PD -> STM32 3V
ESP8266 VCC -> STM32 3V
ESP8266 GND -> STM32 GND

- Android: Plug your Android device to a USB port and click <i>Run 'app'</i> in Android Studio
- STM32: Plug your STM32 to USB port and click <i>Download Code To Flash</i> in CoIDE 1.7.8

<h2>How to compile:</h2> 

- Download & open project files in appropriate tool mentioned above

<h2>Future improvements:</h2>

- Add ability to change name of a relay buttons

<h2>License:</h2>

- MIT

<h2>Credits:</h2>

- Arkadiusz Kołodyński
<br>
The project was conducted during the Microprocessor Lab course held by the Institute of Control and Information Engineering, Poznan University of Technology.

<h2>Supervisor:</h2>

- Tomasz Mańkowski
