package per.wph.common.rxtx;

import gnu.io.SerialPort;
import per.wph.common.rxtx.exception.*;

import java.util.ArrayList;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-04-05 10:34
 * =============================================
 */
public class main {
    public static void main(String[] args) throws SerialPortParameterFailure, NoSuchPort, PortInUse, NotASerialPort, SerialPortOutputStreamCloseFailure, SendDataToSerialPortFailure {
        ArrayList<String> ports = SerialTool.findPort();
        for(String port : ports){
            System.out.println(port);
        }
        SerialPort serialPort = SerialTool.openPort(ports.get(0),9600);
        SerialTool.sendToPort(serialPort,new byte[]{1,5,6,5});
    }
}
