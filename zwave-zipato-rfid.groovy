/**
 *  Copyright 2017 SEAN BLANCHFIELD
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */

import physicalgraph.zwave.commands.usercodev1.*
import physicalgraph.zwave.commands.configurationv1.*
import physicalgraph.zwave.commands.manufacturerspecificv2.*
import physicalgraph.zwave.commands.switchbinaryv1.*
import physicalgraph.zwave.commands.wakeupv1.*
import physicalgraph.zwave.commands.versionv1.*
import physicalgraph.zwave.commands.alarmv2.*
import physicalgraph.zwave.commands.associationv2.*
import physicalgraph.zwave.commands.batteryv1.*

metadata {
	definition (name: "Z-Wave Zipato RFID Keypad", namespace: "seanblanchfield.com", author: "Sean Blanchfield") {
		capability "Actuator"
		capability "Sensor"
		capability "Battery"
        capability "Configuration"
        capability "Switch"
        capability "Refresh"
        
        command "associate1"
        command "disassociate1"
        command "associate2"
        command "disassociate2"
        command "associate3"
        command "disassociate3"
        command "associate4"
        command "disassociate4"
        command "associate5"
        command "disassociate5"
        command "associate6"
        command "disassociate6"
        command "associate7"
        command "disassociate7"
        command "associate8"
        command "disassociate8"
        command "associate9"
        command "disassociate9"
        
        attribute "rfid1", "enum", ["associated","unassociated"]
        attribute "rfid2", "enum", ["associated","unassociated"]
        attribute "rfid3", "enum", ["associated","unassociated"]
        attribute "rfid4", "enum", ["associated","unassociated"]
        attribute "rfid5", "enum", ["associated","unassociated"]
        attribute "rfid6", "enum", ["associated","unassociated"]
        attribute "rfid7", "enum", ["associated","unassociated"]
        attribute "rfid8", "enum", ["associated","unassociated"]
        attribute "rfid9", "enum", ["associated","unassociated"]
        
        fingerprint mfr: "0097", prod: "6131", model: "4501"
	}
	
	tiles(scale: 2) {
    	standardTile(name:"homeaway", attribute:"device.switch", width: 6, height: 6, canChangeIcon: false) {
            state "on", label: 'Away', action: "switch.off", icon: "st.nest.nest-away", backgroundColor: "#f44b42"
            state "off", label: 'Home', action: "switch.on", icon: "st.nest.nest-home", backgroundColor: "#79b821"
        }
        valueTile(name:"battery", attribute:"device.battery", inactiveLabel: false, decoration: "flat", width: 3, height: 2) {
			state "battery", label:'${currentValue}% battery', unit:""
		}
        standardTile("refresh", "command.refresh", inactiveLabel: false, decoration: "flat", width: 3, height: 2) {
            state "default", label:'', action:"refresh.refresh", icon:"st.secondary.refresh"
        }
        standardTile(name: "Help text", decoration: "flat", width: 6, height: 2, canChangeIcon: false) {
        	state "nop", label: 'To add tags & codes, press "home" on your device and enter your master code. Then press "home" again, use the code/tag, and then click "learn" on an unused slot below. To forget a code/tag, enter your master code and click "forget".'
        }
        
        standardTile(name: "rfid1", attribute:"device.rfid1", width: 2, height: 2, canChangeIcon: true) {
            state "unassociated", label: 'Learn', action: "associate1", icon: "st.presence.tile.presence-default", nextState: "associating", backgroundColor: "#ed961c"
            state "associating", label:'Learning', icon:"st.presence.tile.presence-default", backgroundColor:"#b4d1e8", nextState: "associated"
            state "associated", label: 'Forget', action: "disassociate1", icon: "st.presence.tile.presence-default", nextState: "disassociating", backgroundColor: "#1c92ed"
            state "disassociating", label:'Forgetting', icon:"st.presence.tile.presence-default", backgroundColor:"#e8dbb4", nextState: "unassociated"
        }
        standardTile(name: "rfid2", attribute:"device.rfid2", width: 2, height: 2, canChangeIcon: true) {
            state "unassociated", label: 'Learn', action: "associate2", icon: "st.presence.tile.presence-default", nextState: "associating", backgroundColor: "#ed961c"
            state "associating", label:'Learning', icon:"st.presence.tile.presence-default", backgroundColor:"#b4d1e8", nextState: "associated"
            state "associated", label: 'Forget', action: "disassociate2", icon: "st.presence.tile.presence-default", nextState: "disassociating", backgroundColor: "#1c92ed"
            state "disassociating", label:'Forgetting', icon:"st.presence.tile.presence-default", backgroundColor:"#e8dbb4", nextState: "unassociated"
        }
        standardTile(name: "rfid3", attribute:"device.rfid3", width: 2, height: 2, canChangeIcon: true) {
            state "unassociated", label: 'Learn', action: "associate3", icon: "st.presence.tile.presence-default", nextState: "associating", backgroundColor: "#ed961c"
            state "associating", label:'Learning', icon:"st.presence.tile.presence-default", backgroundColor:"#b4d1e8", nextState: "associated"
            state "associated", label: 'Forget', action: "disassociate3", icon: "st.presence.tile.presence-default", nextState: "disassociating", backgroundColor: "#1c92ed"
            state "disassociating", label:'Forgetting', icon:"st.presence.tile.presence-default", backgroundColor:"#e8dbb4", nextState: "unassociated"
        }
        standardTile(name: "rfid4", attribute:"device.rfid4", width: 2, height: 2, canChangeIcon: true) {
            state "unassociated", label: 'Learn', action: "associate4", icon: "st.presence.tile.presence-default", nextState: "associating", backgroundColor: "#ed961c"
            state "associating", label:'Learning', icon:"st.presence.tile.presence-default", backgroundColor:"#b4d1e8", nextState: "associated"
            state "associated", label: 'Forget', action: "disassociate4", icon: "st.presence.tile.presence-default", nextState: "disassociating", backgroundColor: "#1c92ed"
            state "disassociating", label:'Forgetting', icon:"st.presence.tile.presence-default", backgroundColor:"#e8dbb4", nextState: "unassociated"
        }
        standardTile(name: "rfid5", attribute:"device.rfid5", width: 2, height: 2, canChangeIcon: true) {
            state "unassociated", label: 'Learn', action: "associate5", icon: "st.presence.tile.presence-default", nextState: "associating", backgroundColor: "#ed961c"
            state "associating", label:'Learning', icon:"st.presence.tile.presence-default", backgroundColor:"#b4d1e8", nextState: "associated"
            state "associated", label: 'Forget', action: "disassociate5", icon: "st.presence.tile.presence-default", nextState: "disassociating", backgroundColor: "#1c92ed"
            state "disassociating", label:'Forgetting', icon:"st.presence.tile.presence-default", backgroundColor:"#e8dbb4", nextState: "unassociated"
        }
        standardTile(name: "rfid6", attribute:"device.rfid6", width: 2, height: 2, canChangeIcon: true) {
            state "unassociated", label: 'Learn', action: "associate6", icon: "st.presence.tile.presence-default", nextState: "associating", backgroundColor: "#ed961c"
            state "associating", label:'Learning', icon:"st.presence.tile.presence-default", backgroundColor:"#b4d1e8", nextState: "associated"
            state "associated", label: 'Forget', action: "disassociate6", icon: "st.presence.tile.presence-default", nextState: "disassociating", backgroundColor: "#1c92ed"
            state "disassociating", label:'Forgetting', icon:"st.presence.tile.presence-default", backgroundColor:"#e8dbb4", nextState: "unassociated"
        }
        standardTile(name: "rfid7", attribute:"device.rfid7", width: 2, height: 2, canChangeIcon: true) {
            state "unassociated", label: 'Learn', action: "associate7", icon: "st.presence.tile.presence-default", nextState: "associating", backgroundColor: "#ed961c"
            state "associating", label:'Learning', icon:"st.presence.tile.presence-default", backgroundColor:"#b4d1e8", nextState: "associated"
            state "associated", label: 'Forget', action: "disassociate7", icon: "st.presence.tile.presence-default", nextState: "disassociating", backgroundColor: "#1c92ed"
            state "disassociating", label:'Forgetting', icon:"st.presence.tile.presence-default", backgroundColor:"#e8dbb4", nextState: "unassociated"
        }
        standardTile(name: "rfid8", attribute:"device.rfid8", width: 2, height: 2, canChangeIcon: true) {
            state "unassociated", label: 'Learn', action: "associate8", icon: "st.presence.tile.presence-default", nextState: "associating", backgroundColor: "#ed961c"
            state "associating", label:'Learning', icon:"st.presence.tile.presence-default", backgroundColor:"#b4d1e8", nextState: "associated"
            state "associated", label: 'Forget', action: "disassociate8", icon: "st.presence.tile.presence-default", nextState: "disassociating", backgroundColor: "#1c92ed"
            state "disassociating", label:'Forgetting', icon:"st.presence.tile.presence-default", backgroundColor:"#e8dbb4", nextState: "unassociated"
        }
        standardTile(name: "rfid9", attribute:"device.rfid9", width: 2, height: 2, canChangeIcon: true) {
            state "unassociated", label: 'Learn', action: "associate9", icon: "st.presence.tile.presence-default", nextState: "associating", backgroundColor: "#ed961c"
            state "associating", label:'Learning', icon:"st.presence.tile.presence-default", backgroundColor:"#b4d1e8", nextState: "associated"
            state "associated", label: 'Forget', action: "disassociate9", icon: "st.presence.tile.presence-default", nextState: "disassociating", backgroundColor: "#1c92ed"
            state "disassociating", label:'Forgetting', icon:"st.presence.tile.presence-default", backgroundColor:"#e8dbb4", nextState: "unassociated"
        }
        
		main "homeaway"
        
		details(["homeaway", "battery", "refresh", "Help text", "rfid1", "rfid2", "rfid3", "rfid4", "rfid5", "rfid6", "rfid7", "rfid8", "rfid9"])
	}
    
    preferences {
    	section {
			input title: "Master Code", description: "You need to set up a master code to use to wake up the device so you can register codes and tags with it. The master code can be up to ten characters (1,2,3 or 4 only), and should be different from any regular codes you use. Once the master code is entered, the master code timeout prevents the device immediately going back to sleep after waking up. This gives you time to register a new code, while the device is still awake. ", displayDuringSetup: false, type: "paragraph", element: "paragraph"
            input name: "masterCode", type: "password", title: "Master Code", description: "MUST be different to any user codes.", displayDuringSetup: true
            input name: "masterCodeTimeout", type: "number", title: "Master Code Timeout", description: "seconds", displayDuringSetup: true
            input title: "Adding tags and codes", description: "To register a new code, press 'home' on your device and enter your master code. Immediately press 'home' again and either enter the code you want to add, or scan an RFID tag. Then press 'learn' on one of the empty slots in the main screen. You need to do this quickly, before the device goes back to sleep. To forget a code, enter your master code, and then click 'forget' on a used slot. If the device handler gets confused, wake it up with the master code and hit the 'refresh' button to reload configuration from the device.", displayDuringSetup: false, type: "paragraph", element: "paragraph"
        }
        section {
            input name: "wakeUpInterval", type: "number", title: "Wake up interval (minutes)", description: "Default: 240 minutes", range: "*..*", displayDuringSetup: false
            //input name: "beepsPerSecond", type: "number", title: "Beeps per second", description: "2", range: "1..10", displayDuringSetup: false
            //input name: "feedbackTime", type: "number", title: "Feedback period length", description: "Number of seconds to emit feedback for", range: "0..255", displayDuringSetup: false
            //input name: "feedbackTimeout", type: "number", title: "Timeout", description: "Number of seconds to wait for response from controller", range: "1..30", displayDuringSetup: false
            //input name: "setMode", type: "enum",  options: ["Normal", "Always On"], title: "Operating mode", description: "Always on will deplete battery", displayDuringSetup: false
            //input name: "factoryReset", type: "enum",  options: ["Continue without reset", "Perform factory reset"], title: "Factory Reset", description: "Will reset to factory defaults. All registered RFID tag info will be lost.", displayDuringSetup: false
            input name: "debugMode", type: "bool", title: "Debug mode", description: "Enabled detailed logging"
        }
    }
}

private info(def msg){
    log.info msg
}
private debug(def msg) {
	if (debugMode){
    	log.debug msg
    }
}

private echoStatus() {
	debug """
    ${device.displayName} woke up:
Manufacturer ${state.manufacturerName} (ID: ${state.manufacturerId}) product ID ${state.productId} type ${state.productTypeId}.
Command class version ${state.commandClassVersion} (requested version ${state.requestedCommandClass})
Z-wave library type ${state.zWaveLibraryType}, z-wave v${state.zWaveProtocolVersion}.${state.zWaveProtocolSubVersion} application v${state.applicationVersion}.${state.applicationSubVersion}.

Notification/acknowledgement status: ${state.notificationStatus}
Wake up interval is ${state.wakeUpInterval} seconds
Battery level is ${state.batteryLevel}%
${state.supportedUsers} supported users

${state.deviceFactoryDefaults}
Feedback time: ${state.deviceFeedbackTime}s / Timeout: ${state.deviceFeedbackTimeout}s / ${state.deviceBeepsPerSecond} beeps per sec
${state.deviceMode}
"""
}

def refresh() {
	// Empty the map of what users are registered. We will re-read this from the device shortly.
    // this map will be of the form userNumber -> code
    state.registeredUsers = [:]
    // Reset the UI state. This will be re-updated according to reports back from the device.
    for(def i=0; i<10; i++) {
	    sendEvent(name:"rfid$i", value: "unassociated")
    }
    
	def requests = []
    requests = requests.plus(delayBetween([
        zwave.userCodeV1.userCodeGet(userIdentifier: 1).format(),
        zwave.userCodeV1.userCodeGet(userIdentifier: 2).format(),
        zwave.userCodeV1.userCodeGet(userIdentifier: 3).format(),
        zwave.userCodeV1.userCodeGet(userIdentifier: 4).format(),
        zwave.userCodeV1.userCodeGet(userIdentifier: 5).format(),
        zwave.userCodeV1.userCodeGet(userIdentifier: 6).format(),
        zwave.userCodeV1.userCodeGet(userIdentifier: 7).format(),
        zwave.userCodeV1.userCodeGet(userIdentifier: 8).format(),
        zwave.userCodeV1.userCodeGet(userIdentifier: 9).format(),
    ], 500))
    
    if(debugMode){
        requests = requests.plus(delayBetween([
            zwave.wakeUpV1.wakeUpIntervalGet().format(),
            zwave.versionV1.versionCommandClassGet().format(),
            zwave.versionV1.versionGet().format(),
            zwave.switchBinaryV1.switchBinaryGet().format(),
            zwave.userCodeV1.usersNumberGet().format(),
            zwave.configurationV1.configurationGet(parameterNumber:0x01).format(),
            zwave.configurationV1.configurationGet(parameterNumber:0x02).format(),
            zwave.configurationV1.configurationGet(parameterNumber:0x03).format(),
            zwave.configurationV1.configurationGet(parameterNumber:0x04).format(),
            zwave.configurationV1.configurationGet(parameterNumber:0x05).format(),
            zwave.manufacturerSpecificV2.manufacturerSpecificGet().format()
        ], 500))
    }
    return requests
}

def configure() {
    def requests = []
    
    if(wakeUpInterval != null) {
    	requests << zwave.wakeUpV1.wakeUpIntervalSet(seconds:wakeUpInterval*60, nodeid:zwaveHubNodeId).format()
        requests << "delay 500"
    }
	
    if(feedbackTimeout != null){
	    requests << zwave.configurationV1.configurationSet(parameterNumber:0x03, size:1, scaledConfigurationValue:feedbackTimeout).format()
        requests << "delay 500"
    }
    return requests
}

def updated() {
    return response(configure())
}

def on() {
	if(device.currentState("switch").value == "off"){
    	info "Switching mode to away"
    	sendEvent(name:"switch", value: "on")
    }
}

def off() {
	if(device.currentState("switch").value == "on"){
    	info "Switching mode to home"
    	sendEvent(name:"switch", value: "off")
    }
}

def parse(String description) {
	def result = null
    def versions =  [ 0x70: 1, 0x63: 1, 0x72: 2, 0x25: 1, 0x84: 1, 0x86: 1, 0x71: 2, 0x85: 2, 0x80:1  ]
    def cmd = zwave.parse(description, versions)
    if (cmd) {
        result = zwaveEvent(cmd)
        //debug "Parsed event: ${description} / ${cmd}"
    } else {
        log.error "Non-parsed event: ${description}"
    }
    return result
}


def zwaveEvent(physicalgraph.zwave.commands.configurationv1.ConfigurationReport cmd) { 
	// Zipato COMMAND_CODE_CONFIGURATION_V1 0x70
    switch(cmd.parameterNumber) {
    	case 0x01:
        	state.deviceFactoryDefaults = "Device factory defaults have not been altered"
            if(cmd.scaledConfigurationValue != 0xFF) {
            	state.deviceFactoryDefaults = "Device is not set to factory defaults"
        	}
	        break;
       	case 0x02:
        	state.deviceFeedbackTime = cmd.scaledConfigurationValue
	        break;
        case 0x03:
        	state.deviceFeedbackTimeout = cmd.scaledConfigurationValue
	        break;
        case 0x04:
        	state.deviceBeepsPerSecond = cmd.scaledConfigurationValue
	        break;
       	case 0x05:
        	state.deviceMode = "Device is set to NORMAL (sleepy) mode"
            if(cmd.scaledConfigurationValue == 0x03) {
            	state.deviceMode = "Device is set to ALWAYS ON mode (risk of battery drain)"
        	}
	        break;
       	default:
        	log.warn "Received unexpected configuration value: $cmd"
    }
}

def zwaveEvent(physicalgraph.zwave.commands.manufacturerspecificv2.ManufacturerSpecificReport cmd) { 
	// COMMAND_CLASS_MANUFACTURER_SPECIFIC 0x72
    state.manufacturerName = cmd.manufacturerName
    state.manufacturerId = cmd.manufacturerId
    state.productId = cmd.productId
    state.productTypeId = cmd.productTypeId
    // This is the last command to be received, so echo current status
    echoStatus()
}

def zwaveEvent(physicalgraph.zwave.commands.switchbinaryv1.SwitchBinaryReport cmd) { 
	// COMMAND_CLASS_SWITCH_BINARY 0x25 
    state.notificationStatus = cmd.value
}

def zwaveEvent(physicalgraph.zwave.commands.wakeupv1.WakeUpIntervalReport cmd) { 
	// COMMAND_CLASS_WAKE_UP_NOTIFICATION 0x84
    state.wakeUpInterval = cmd.seconds
    return [response(zwave.batteryV1.batteryGet().format())]
}

def zwaveEvent(physicalgraph.zwave.commands.batteryv1.BatteryReport cmd) {
	// COMMAND_CLASS_BATTERY 0x80
    state.batteryLevel = cmd.batteryLevel
    sendEvent(name:"battery", value: state.batteryLevel)
}

def zwaveEvent(physicalgraph.zwave.commands.usercodev1.UsersNumberReport  cmd) {
    state.supportedUsers = cmd.supportedUsers
}

def zwaveEvent(physicalgraph.zwave.commands.versionv1.VersionCommandClassReport cmd) { 
	// COMMAND_CLASS_VERSION 0x86
    state.commandClassVersion = cmd.commandClassVersion
    state.requestedCommandClass = cmd.requestedCommandClass
}

def zwaveEvent(physicalgraph.zwave.commands.versionv1.VersionReport cmd) { 
	// COMMAND_CLASS_VERSION 0x86
    state.zWaveLibraryType = cmd.zWaveLibraryType
    state.zWaveProtocolVersion = cmd.zWaveProtocolVersion
    state.zWaveProtocolSubVersion = cmd.zWaveProtocolSubVersion
    state.applicationVersion = cmd.applicationVersion
 	state.applicationSubVersion = cmd.applicationSubVersion   
}

def zwaveEvent(physicalgraph.zwave.commands.wakeupv1.WakeUpNotification cmd)
{
	def result = []
    result << createEvent(name: "${device.displayName}", value: "awake")
    return result
}

private goToSleep(def cmds){
	def currentTime = new Date().getTime()
    def timeSinceMasterCode = 0
    if(state.lastMasterCode) {
    	timeSinceMasterCode = (currentTime - state.lastMasterCode) / 1000
    }
	if(timeSinceMasterCode > masterCodeTimeout){
    	cmds << response(zwave.wakeUpV1.wakeUpNoMoreInformation())
    }
}

def zwaveEvent(physicalgraph.zwave.commands.alarmv2.AlarmReport cmd) {
	// COMMAND_CLASS_ALARM_V2 0X71

	def result = []
	if (cmd.zwaveAlarmType == 6) {
		switch(cmd.zwaveAlarmEvent) {
			case 5:
            	// Recognised user pressed "Away"
				info "User set device to Away mode"
                result << createEvent(name:"switch", value: "on")
				break
			case 6:
            	// Recognised user pressed "Home"
				info "User set device to Home mode"
                result << createEvent(name:"switch", value: "off")
				break
			default:
				log.warn "Received unrecognised alarm status: $cmd"
				break
		}
	}
    goToSleep(result)
	return result
}

def zwaveEvent(physicalgraph.zwave.commands.usercodev1.UserCodeReport cmd) {
	// Zipato COMMAND_CLASS_USER_CODE_V1: 0X63
	def result = []
    def userNumber = cmd.userIdentifier
    
	if (cmd.userIdStatus == UserCodeReport.USER_ID_STATUS_AVAILABLE_NOT_SET && userNumber == 0 )
	{
    	// Turn the master code into a 10-element array
        def zeros = [0,0,0,0,0,0,0,0,0,0]
        def masterCodeArray = masterCode.getBytes()
        masterCodeArray = ([].add + masterCodeArray[0..< masterCodeArray.size()] + zeros[masterCodeArray.size()..< zeros.size()]).flatten() 
		
    	if (cmd.user == masterCodeArray) {
        	// The master code was entered. Avoid putting the device back to sleep so the user
            // has time to send commands.
            info "Master code was entered."
			state.lastMasterCode = new Date().getTime()
        }
        else {
            // Received unrecognised code. Store it in case user wants to associate it.
            info "Received unrecognised code."
            debug "Unrecognised code is ${cmd.user}"
            state.lastUnrecognisedCode = cmd.user
            result << createEvent(name:"unrecognisedCode", value: "code ${cmd.user}")
        }
	}
    else {
    	if (cmd.userIdStatus == UserCodeReport.USER_ID_STATUS_OCCUPIED) {
            info "Remembering user $userNumber is set to ${cmd.user}"
            state.registeredUsers[Integer.toString(userNumber)] = cmd.user
            sendEvent(name:"rfid$userNumber", value: "associated")
        }
        else if (cmd.userIdStatus == UserCodeReport.USER_ID_STATUS_AVAILABLE_NOT_SET){
            sendEvent(name:"rfid$userNumber", value: "unassociated")
            debug "Forgetting user $userNumber"
            state.registeredUsers[Integer.toString(userNumber)] = null
        }
        debug state.registeredUsers
    }
    goToSleep(result)
	return result
}

private associate(def userNumber){
    def requests = []
    if(state.lastUnrecognisedCode != null){
        
        info "Associating tag number $userNumber with code ${state.lastUnrecognisedCode}"
        
        // Unfortunately, the following line does not work due to an apparent bug in Smartthings.
        // If the 'code' parameter contains any bytes with a decimal value less than 10, ST converts those bytes to have the value of the
        // ASCII character corresponding to that decimal value.  For example, a byte with the value of 0 will be converted to 0x30 
        // (decimal 48), ASCII character '0'.  
        // This lead the device to store a corrupted code for the RFID tag, and prevents it from recognising that code.
        //requests << zwave.userCodeV1.userCodeSet(userIdentifier: userNumber, userIdStatus: UserCodeSet.USER_ID_STATUS_OCCUPIED, user: state.lastUnrecognisedCode).format()
        
        // The only alternative to the above problem is to manually construct the z-wave SET USER command.
        def cmd = [
        	0x63, // USER_CODE command class
            0x01, // USER_CODE SET command
            userNumber,
            UserCodeSet.USER_ID_STATUS_OCCUPIED]
        cmd += state.lastUnrecognisedCode
        cmd = cmd.collect { String.format("%02x", it).toUpperCase() }.join('')
        requests << cmd
        
        // Now request a UserCodeReport. If the device is awake, we will receive it, and update the UI/state accordingly.
        // If it never arrives, it means the device was asleep, and the UserCodeSet was not received either.
        requests << zwave.userCodeV1.userCodeGet(userIdentifier: userNumber).format()
        state.lastUnrecognisedCode = null
    }
    else {
    	info "Cannot associate tag number $userNumber because there is no recent code."
        // Hack to make sure the UI tile updates from its transitioning state ("associating") back to 
        // the tile state for "unassociated".
        // It appears that some ST platform optimsation prevents an event being fired if its value is equal
        // to the current value. This is a problem if you want to revert a UI tile from its transitioning state.
        // The trick below simply fires an event to update the attribute to a new value, so that the next event
        // (which updates it back to its original value) actually happens, and triggers the UI tile update.
        sendEvent(name:"rfid$userNumber", value: "transitioning")
        sendEvent(name:"rfid$userNumber", value: "unassociated")
    }
    return requests
}

private disassociate(def userNumber){
	def requests = []
    if(state.registeredUsers[Integer.toString(userNumber)] != null){
	    info "Disassociating tag number $userNumber"
        requests << zwave.userCodeV1.userCodeSet(userIdentifier: userNumber, userIdStatus:UserCodeSet.USER_ID_STATUS_AVAILABLE_NOT_SET).format()
        // Now set a userCodeGet. If the device is awake, it will respond with a UserCodeReport, and we will update UI and state then.
        // If doesn't respond, then it's not awake, and we won't update any UI/state.
        requests << zwave.userCodeV1.userCodeGet(userIdentifier: userNumber).format()
    }
    else {
    	log.warn "Disassociating failed because tag number $userNumber is not in use. ${state.registeredUsers}"
    }
    return requests
}

def associate1(){associate(1)}
def disassociate1(){disassociate(1)}

def associate2(){associate(2)}
def disassociate2(){disassociate(2)}

def associate3(){associate(3)}
def disassociate3(){disassociate(3)}

def associate4(){associate(4)}
def disassociate4(){disassociate(4)}

def associate5(){associate(5)}
def disassociate5(){disassociate(5)}

def associate6(){associate(6)}
def disassociate6(){disassociate(6)}

def associate7(){associate(7)}
def disassociate7(){disassociate(7)}

def associate8(){associate(8)}
def disassociate8(){disassociate(8)}

def associate9(){associate(9)}
def disassociate9(){disassociate(9)}
