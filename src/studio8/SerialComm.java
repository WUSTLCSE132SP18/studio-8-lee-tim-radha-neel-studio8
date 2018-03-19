package studio8;

import jssc.*;
import studio5.SerialComm;

public class SerialComm {

	SerialPort port;

	private boolean debug;  // Indicator of "debugging mode"
	
	// This function can be called to enable or disable "debugging mode"
	void setDebug(boolean mode) {
		debug = mode;
	}	
	

	// Constructor for the SerialComm class
	public SerialComm(String name) throws SerialPortException {
		port = new SerialPort(name);		
		port.openPort();
		port.setParams(SerialPort.BAUDRATE_9600,
			SerialPort.DATABITS_8,
			SerialPort.STOPBITS_1,
			SerialPort.PARITY_NONE);
		
		debug = true; // Default is to NOT be in debug mode
	}
		
	// TODO: Add writeByte() method from Studio 5
	public void writeByte(byte data) {
		try {
			port.writeByte(data);
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("<0x" + data + ">");
	}
	// TODO: Add available() method
	public boolean available() {
		try {
			if (port.getInputBufferBytesCount() > 0) {
				return true;
			}
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	// TODO: Add readByte() method	

	public byte readByte() throws SerialPortException {
		boolean debug = true;
		byte[] array = port.readBytes(1);
		if (debug == true) {
			String num = String.format("%02x", array[0]);
			System.out.print("[0x"+num+"]");
		}
		else {
			// do nothing
		}
		return array[0];
		}
	
	// TODO: Add a main() method
	public static void main(String [] args) {
		SerialComm object = null;
		try {
			object = new SerialComm("/dev/cu.usbserial-DN02BELC");
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			boolean value = object.available();
			if (value == true) {
				try {
					System.out.println(object.readByte());
				} catch (SerialPortException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}