# smartthings-zipato-rfid
Device handler for Z-Wave Zipato RFID tag reader: https://www.zipato.com/product/mini-keypad-rfid

This is a working device handler for the Zipato RFID Tag reader (also known as Wintop or Benext tag reader).

It permits 9 RFID tags or codes to be registered. To use it, you must add it as a custom device handler in the SmartThings IDE.

# Instructions for use:
Go into the settings for the device on your phone and set up a master code (up to ten characters, 1,2,3,4 only) and master code timeout (I suggest 300 seconds). Entering the master code on the device will temporarily (for the whatever number of seconds you have set in the timeout) prevent the device handler from putting the device back to sleep after it wakes up (i.e., it prevents it sending the wakeUpNoMoreInformation command).  This gives you time to do things like register a new code, while the device is still awake.

IMPORTANT: Your master code will stop working if you re-use it as a regular user code.

To register a new code, press 'home' and enter your master code. Then press 'home' again and either enter the code you want to save, or scan an RFID tag. Then press 'learn' on one of the empty slots. You need to do this before the device goes back to sleep. To forget a code, enter your master code, and then click 'forget' on a used slot.

Once set up, it behaves like a switch. 'Away' mode turns the switch on, and 'Home' turns it off. Use a regular SmartApp to automate it into your setup, e.g., the Lights & Switches -> Switch Changes Mode app.

# Use at your own risk
I welcome feedback, but I don't have time to maintain this software. It took a lot of back engineering work and blackbox testing to get this right. If you can improve it, please do. If you encounter problems, I can't help you. Use at your own risk.

# Known issues
The device handler has a fairly ugly hack where it manually constructs a z-wave command, because the setUserCode() function in the SmartThings platform doesn't deal well with binary user codes containing values lower than 10 (which a lot of RFID tags will contain). 

I have also been unable to successfully set certain configuration settings described in the user manual (https://www.zipato.com/wp-content/uploads/2015/10/wt-rfid-Zipato-Mini-Keypad-RFiD-Z-Wave-User-Manual-v1.4.pdf). These include configurationv1.configurationSet commands to configure:
- beeps per second
- feedback time (To configure the time the beep is automatically turned off in seconds.)
- feedback timeout (time device waits for WAKEUP_NO_MORE_INFORMATION before the error beep is automatically sounded.)
- operating mode (sleepy / always awake)
- factory reset

There's some commented out code in the device handler left over from my attempt to make these work. I don't think configuration of these parameters is necessary or important for regular usage of the device, but if anyone can get them working that would be fantastic.

