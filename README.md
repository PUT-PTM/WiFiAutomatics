# WiFiAutomatics

<h2>Overview:</h2>
Presented project is an attempt to implement simple home automation.
It has capability of control two relays by android app within local WIFI connection or via Internet.

<h2>Description:</h2>
The base of my project is microcontroller STM32F407VG DISCOVERY and ESP8266 WIFI module.<br>
Whole project contains an Android application programmed in Java language and a program for STM32 in C language.<br>
Communication between ESP8266 and STM32 is accomplished with USART.<br>
STM32 parsing AT commands and committing appropriate actions.

<h2>Tools:</h2>

- Android Studio 2.3.3
- CoIDE 1.7.8

<h2>How to run:</h2>

<b>Connections:</b><br>
Relay IN1 -> STM32 PD12<br>
Relay IN2 -> STM32 PD13<br>
Relay VCC -> STM32 5V<br>
Relay GND -> STM32 GND<br>
<br>
ESP8266 Rx -> STM32 PC10<br>
ESP8266 Tx -> STM32 PC11<br>
ESP8266 CH_PD -> STM32 3V<br>
ESP8266 VCC -> STM32 3V<br>
ESP8266 GND -> STM32 GND<br>

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
