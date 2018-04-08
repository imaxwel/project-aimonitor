package per.wph.common.bluetooth;

import per.wph.common.bluetooth.bluetooth.BluetoothService;
import per.wph.common.bluetooth.bluetooth.RemoteDeviceDiscovery;

import javax.bluetooth.RemoteDevice;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import java.io.*;
import java.util.Scanner;
import java.util.Set;

public class Application {
	
	private static final String BLUETOOTHADDRESS = "btspp://98D33210C9F7:1";
	public static void main(String[] args) throws IOException {
		StreamConnection streamConnection = (StreamConnection) Connector.open(BLUETOOTHADDRESS);
		OutputStream outputStream = streamConnection.openDataOutputStream();
		Scanner sc = new Scanner(System.in);
		//利用hasNextXXX()判断是否还有下一输入项
		while (sc.hasNext()) {
			String str = sc.next();
			outputStream.write(Byte.valueOf(str));
			System.out.println(str);
		}
	}

	private
	
}
